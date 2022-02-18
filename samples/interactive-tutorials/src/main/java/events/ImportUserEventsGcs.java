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

  private static final String PROJECT_ID = System.getenv("PROJECT_ID");
  private static final String DEFAULT_CATALOG =
      String.format("projects/%s/locations/global/catalogs/default_catalog", PROJECT_ID);
  /*
  TO CHECK ERROR HANDLING PASTE THE INVALID CATALOG NAME HERE:
  DEFAULT_CATALOG = "invalid_catalog_name"
  */
  private static final String GCS_BUCKET =
      String.format("gs://%s", System.getenv("EVENTS_BUCKET_NAME"));
  private static final String GCS_ERRORS_BUCKET = String.format("%s/error", GCS_BUCKET);
  private static final String GCS_EVENTS_OBJECT = "user_events.json";
  /*
  TO CHECK ERROR HANDLING USE THE JSON WITH INVALID USER EVENT
  GCS_EVENTS_OBJECT = "user_events_some_invalid.json"
   */

  public static void main(String[] args) throws IOException, InterruptedException {
    importUserEventsFromGcs();
  }

  public static void importUserEventsFromGcs() throws IOException, InterruptedException {
    ImportUserEventsRequest importGcsRequest = getImportEventsGcsRequest(GCS_EVENTS_OBJECT);

    UserEventServiceClient serviceClient = UserEventServiceClient.create();

    String operationName =
        serviceClient.importUserEventsCallable().call(importGcsRequest).getName();

    System.out.printf("OperationName = %s\n", operationName);

    OperationsClient operationsClient = serviceClient.getOperationsClient();
    Operation operation = operationsClient.getOperation(operationName);

    while (!operation.getDone()) {
      // Keep polling the operation periodically until the import task is done.
      int awaitDuration = 30000;

      Thread.sleep(awaitDuration);

      operation = operationsClient.getOperation(operationName);
    }

    if (operation.hasMetadata()) {
      ImportMetadata metadata = operation.getMetadata().unpack(ImportMetadata.class);

      System.out.printf("Number of successfully imported events: %s\n", metadata.getSuccessCount());

      System.out.printf(
          "Number of failures during the importing: %s\n", metadata.getFailureCount());
    }

    if (operation.hasResponse()) {
      ImportUserEventsResponse response =
          operation.getResponse().unpack(ImportUserEventsResponse.class);

      System.out.printf("Operation result: %s%n", response);
    }
  }

  public static ImportUserEventsRequest getImportEventsGcsRequest(String gcsObjectName) {

    GcsSource gcsSource =
        GcsSource.newBuilder()
            .addInputUris(String.format("%s/%s", GCS_BUCKET, gcsObjectName))
            .build();

    UserEventInputConfig inputConfig =
        UserEventInputConfig.newBuilder().setGcsSource(gcsSource).build();

    ImportErrorsConfig errorsConfig =
        ImportErrorsConfig.newBuilder().setGcsPrefix(GCS_ERRORS_BUCKET).build();

    ImportUserEventsRequest importRequest =
        ImportUserEventsRequest.newBuilder()
            .setParent(DEFAULT_CATALOG)
            .setInputConfig(inputConfig)
            .setErrorsConfig(errorsConfig)
            .build();

    System.out.printf("Import user events from google cloud source request: %s%n", importRequest);

    return importRequest;
  }
}

// [END retail_import_user_events_from_gcs]
