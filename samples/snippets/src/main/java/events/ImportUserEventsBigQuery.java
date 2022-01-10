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
 * [START retail_import_user_events_from_big_query]
 * Import user events into a catalog from GCS using Retail API
 */


package events;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.retail.v2.BigQuerySource;
import com.google.cloud.retail.v2.ImportMetadata;
import com.google.cloud.retail.v2.ImportUserEventsRequest;
import com.google.cloud.retail.v2.ImportUserEventsResponse;
import com.google.cloud.retail.v2.UserEventInputConfig;
import com.google.cloud.retail.v2.UserEventServiceClient;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public final class ImportUserEventsBigQuery {

  /**
   * This variable describes project number getting from environment variable.
   */
  private static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  /**
   * This variable describes project id getting from environment variable.
   */
  private static final String PROJECT_ID = System.getenv("PROJECT_ID");

  /**
   * This variable describes default catalog name.
   */
  private static final String DEFAULT_CATALOG = String.format(
      "projects/%s/locations/global/catalogs/default_catalog",
      PROJECT_NUMBER);

  /**
   * This variable describes dataset id.
   */
  private static final String DATASET_ID = "user_events";

  /**
   * This variable describes table id.
   */
  private static final String TABLE_ID = "events";

  /**
   * This variable describes data schema.
   */
  private static final String DATA_SCHEMA = "user_event";

/*
  TO CHECK ERROR HANDLING USE THE TABLE OF INVALID USER EVENTS:
  TABLE_ID = "events_some_invalid"
 */

  private ImportUserEventsBigQuery() {
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
   * Get import user events from big query request.
   *
   * @return ImportUserEventsRequest.
   */
  public static ImportUserEventsRequest getImportEventsBigQueryRequest() {
    // TO CHECK ERROR HANDLING PASTE THE INVALID CATALOG NAME HERE:
    // DEFAULT_CATALOG = "invalid_catalog_name"

    BigQuerySource bigQuerySource = BigQuerySource.newBuilder()
        .setProjectId(PROJECT_ID)
        .setDatasetId(DATASET_ID)
        .setTableId(TABLE_ID)
        .setDataSchema(DATA_SCHEMA)
        .build();

    UserEventInputConfig inputConfig = UserEventInputConfig.newBuilder()
        .setBigQuerySource(bigQuerySource)
        .build();

    ImportUserEventsRequest importRequest = ImportUserEventsRequest.newBuilder()
        .setParent(DEFAULT_CATALOG)
        .setInputConfig(inputConfig)
        .build();

    System.out.printf("Import user events from BigQuery source request: %s%n",
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
  public static void importUserEventsFromBigQuery()
      throws IOException, ExecutionException, InterruptedException {
    ImportUserEventsRequest importBigQueryRequest =
        getImportEventsBigQueryRequest();

    OperationFuture<ImportUserEventsResponse, ImportMetadata> bigQueryOperation
        = getUserEventsServiceClient().importUserEventsAsync(
        importBigQueryRequest);

    System.out.printf("The operation was started: %s%n",
        bigQueryOperation.getName());

    while (!bigQueryOperation.isDone()) {
      final int awaitDuration = 30;

      System.out.println("Please wait till operation is done.");

      getUserEventsServiceClient().awaitTermination(
          awaitDuration, TimeUnit.SECONDS);

      System.out.println("Import user events operation is done.");

      if (bigQueryOperation.getMetadata().get() != null) {
        System.out.printf("Number of successfully imported events: %s%n",
            bigQueryOperation.getMetadata().get().getSuccessCount());

        System.out.printf("Number of failures during the importing: %s%n",
            bigQueryOperation.getMetadata().get().getFailureCount());
      } else {
        System.out.println("Metadata in bigQuery operation is empty.");
      }
      if (bigQueryOperation.get() != null) {
        System.out.printf("Operation result: %s%n", bigQueryOperation.get());
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
    importUserEventsFromBigQuery();
  }
}

// [END retail_import_user_events_from_big_query]
