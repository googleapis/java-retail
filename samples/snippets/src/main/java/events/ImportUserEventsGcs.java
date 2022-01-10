/*
 * Copyright 2022 Google Inc.
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

/*
 * [START retail_import_user_events_from_gcs]
 * Import user events into a catalog from GCS using Retail API
 */

package events;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.retail.v2.GcsSource;
import com.google.cloud.retail.v2.ImportErrorsConfig;
import com.google.cloud.retail.v2.ImportMetadata;
import com.google.cloud.retail.v2.ImportUserEventsRequest;
import com.google.cloud.retail.v2.ImportUserEventsResponse;
import com.google.cloud.retail.v2.UserEventInputConfig;
import com.google.cloud.retail.v2.UserEventServiceClient;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public final class ImportUserEventsGcs {

  /**
   * This variable describes project number getting from environment variable.
   */
  private static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  /**
   * This variable describes default catalog name.
   */
  private static final String DEFAULT_CATALOG = String.format(
      "projects/%s/locations/global/catalogs/default_catalog",
      PROJECT_NUMBER);

  /**
   * This variable describes GCS bucket from the environment variable.
   */
  private static final String GCS_BUCKET = String.format("gs://%s",
      System.getenv("EVENTS_BUCKET_NAME"));

  /**
   * This variable describes GCS errors bucket from the environment variable.
   */
  private static final String GCS_ERRORS_BUCKET = String.format("%s/error",
      GCS_BUCKET);

  /**
   * This variable describes GCS events object from the environment variable.
   */
  private static final String GCS_EVENTS_OBJECT = "user_events.json";

  /*
  TO CHECK ERROR HANDLING USE THE JSON WITH INVALID USER EVENT
  GCS_EVENTS_OBJECT = "user_events_some_invalid.json"
   */

  private ImportUserEventsGcs() {
  }

  /**
   * Get user event service client.
   *
   * @return UserEventServiceClient.
   * @throws IOException if endpoint is incorrect.
   */
  private static UserEventServiceClient getUserEventsServiceClient()
      throws IOException {
    return UserEventServiceClient.create();
  }

  /**
   * Get import user events from gcs request.
   *
   * @param gcsObjectName GCS object name for import.
   * @return ImportUserEventsRequest.
   */
  public static ImportUserEventsRequest getImportEventsGcsRequest(
      final String gcsObjectName) {
    // TO CHECK ERROR HANDLING PASTE THE INVALID CATALOG NAME HERE:
    // DEFAULT_CATALOG = "invalid_catalog_name"

    GcsSource gcsSource = GcsSource.newBuilder()
        .addInputUris(String.format("%s/%s", GCS_BUCKET, gcsObjectName))
        .build();

    UserEventInputConfig inputConfig = UserEventInputConfig.newBuilder()
        .setGcsSource(gcsSource)
        .build();

    ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder()
        .setGcsPrefix(GCS_ERRORS_BUCKET)
        .build();

    ImportUserEventsRequest importRequest = ImportUserEventsRequest.newBuilder()
        .setParent(DEFAULT_CATALOG)
        .setInputConfig(inputConfig)
        .setErrorsConfig(errorsConfig)
        .build();

    System.out.printf(
        "Import user events from google cloud source request: %s%n",
        importRequest);

    return importRequest;
  }

  /**
   * Call the Retail API to import user events.
   *
   * @throws IOException          from the called method.
   * @throws ExecutionException   when attempting to retrieve the result of a
   *                              task that aborted by throwing an exception.
   * @throws InterruptedException when a thread is waiting, sleeping, or
   *                              otherwise occupied, and the thread is
   *                              interrupted, either before or during the
   *                              activity.
   */
  public static void importUserEventsFromGcs()
      throws IOException, ExecutionException, InterruptedException {
    ImportUserEventsRequest importGcsRequest = getImportEventsGcsRequest(
        GCS_EVENTS_OBJECT);

    OperationFuture<ImportUserEventsResponse, ImportMetadata> gcsOperation
        = getUserEventsServiceClient().importUserEventsAsync(importGcsRequest);

    System.out.printf("The operation was started: %s%n",
        gcsOperation.getName());

    while (!gcsOperation.isDone()) {
      final int awaitDuration = 30;

      System.out.println("Please wait till operation is done.");

      getUserEventsServiceClient().awaitTermination(
          awaitDuration, TimeUnit.SECONDS);

      System.out.println("Import user events operation is done.");

      if (gcsOperation.getMetadata().get() != null) {
        System.out.printf("Number of successfully imported events: %s%n",
            gcsOperation.getMetadata().get().getSuccessCount());

        System.out.printf("Number of failures during the importing: %s%n",
            gcsOperation.getMetadata().get().getFailureCount());
      } else {
        System.out.println("Metadata in bigQuery operation is empty.");
      }
      if (gcsOperation.get() != null) {
        System.out.printf("Operation result: %s%n", gcsOperation.get());
      } else {
        System.out.println("Operation result is empty.");
      }
    }
  }

  /**
   * Executable tutorial class.
   *
   * @param args command line arguments.
   */
  public static void main(final String[] args)
      throws IOException, ExecutionException, InterruptedException {
    importUserEventsFromGcs();
  }
}

// [END retail_import_user_events_from_gcs]
