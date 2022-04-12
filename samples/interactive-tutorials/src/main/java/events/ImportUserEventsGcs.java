/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// [START retail_import_user_events_from_gcs]

/*
 * Import user events into a catalog from GCS using Retail API
 */

package events;

import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.ServiceOptions;
import com.google.cloud.retail.v2.GcsSource;
import com.google.cloud.retail.v2.ImportErrorsConfig;
import com.google.cloud.retail.v2.ImportMetadata;
import com.google.cloud.retail.v2.ImportUserEventsRequest;
import com.google.cloud.retail.v2.ImportUserEventsResponse;
import com.google.cloud.retail.v2.UserEventInputConfig;
import com.google.cloud.retail.v2.UserEventServiceClient;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import java.io.IOException;

public class ImportUserEventsGcs {

  public static void main(String[] args) throws IOException, InterruptedException {
    String projectId = ServiceOptions.getDefaultProjectId();
    String defaultCatalog =
        String.format("projects/%s/locations/global/catalogs/default_catalog", projectId);
    String bucketName = System.getenv("EVENTS_BUCKET_NAME");
    String gcsBucket = String.format("gs://%s", bucketName);
    String gcsErrorsBucket = String.format("%s/error", gcsBucket);
    String gcsUserEventsObject = "user_events.json";
    // TO CHECK ERROR HANDLING USE THE JSON WITH INVALID USER EVENT:
    // gcsEventsObject = "user_events_some_invalid.json"

    ImportUserEventsRequest importEventsGcsRequest =
        getImportEventsGcsRequest(gcsUserEventsObject, gcsBucket, gcsErrorsBucket, defaultCatalog);
    importUserEventsFromGcs(importEventsGcsRequest);
  }

  public static ImportUserEventsRequest getImportEventsGcsRequest(
      String gcsEventsObject, String gcsBucket, String gcsErrorsBucket, String defaultCatalog) {
    GcsSource gcsSource =
        GcsSource.newBuilder()
            .addInputUris(String.format("%s/%s", gcsBucket, gcsEventsObject))
            .build();

    UserEventInputConfig inputConfig =
        UserEventInputConfig.newBuilder().setGcsSource(gcsSource).build();

    System.out.println("GRS source: " + gcsSource.getInputUrisList());

    ImportErrorsConfig errorsConfig =
        ImportErrorsConfig.newBuilder().setGcsPrefix(gcsErrorsBucket).build();

    ImportUserEventsRequest importRequest =
        ImportUserEventsRequest.newBuilder()
            .setParent(defaultCatalog)
            .setInputConfig(inputConfig)
            .setErrorsConfig(errorsConfig)
            .build();

    System.out.printf("Import user events from google cloud source request: %s%n", importRequest);

    return importRequest;
  }

  public static void importUserEventsFromGcs(ImportUserEventsRequest importEventsGcsRequest)
      throws IOException, InterruptedException {
    try (UserEventServiceClient serviceClient = UserEventServiceClient.create()) {
      String operationName =
          serviceClient.importUserEventsCallable().call(importEventsGcsRequest).getName();

      System.out.println("The operation was started.");
      System.out.printf("OperationName = %s%n", operationName);

      OperationsClient operationsClient = serviceClient.getOperationsClient();
      Operation operation = operationsClient.getOperation(operationName);

      while (!operation.getDone()) {
        System.out.println("Please wait till operation is done.");
        Thread.sleep(30_000);
        operation = operationsClient.getOperation(operationName);
      }

      if (operation.hasMetadata()) {
        ImportMetadata metadata = operation.getMetadata().unpack(ImportMetadata.class);
        System.out.printf(
            "Number of successfully imported events: %s%n", metadata.getSuccessCount());
        System.out.printf(
            "Number of failures during the importing: %s%n", metadata.getFailureCount());
      } else {
        System.out.println("Metadata is empty.");
      }

      if (operation.hasResponse()) {
        ImportUserEventsResponse response =
            operation.getResponse().unpack(ImportUserEventsResponse.class);
        System.out.printf("Operation result: %s%n", response);
      } else {
        System.out.println("Operation result is empty.");
      }
    } catch (InvalidArgumentException e) {
      System.out.printf(
          "Given GCS input path was not found. %n%s%n"
              + "Please run CreateTestResources class to create resources.",
          e.getMessage());
    }
  }
}

// [END retail_import_user_events_from_gcs]
