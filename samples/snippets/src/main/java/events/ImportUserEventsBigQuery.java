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
import com.google.cloud.retail.v2.UserEventServiceSettings;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ImportUserEventsBigQuery {

  private static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  private static final String PROJECT_ID = System.getenv("PROJECT_ID");

  private static final String ENDPOINT = "retail.googleapis.com:443";

  private static final String DEFAULT_CATALOG = String.format(
      "projects/%s/locations/global/catalogs/default_catalog",
      PROJECT_NUMBER);

  private static final String DATASET_ID = "user_events";

  private static final String TABLE_ID = "events";

  private static final String DATA_SCHEMA = "user_event";

/*
  TO CHECK ERROR HANDLING USE THE TABLE OF INVALID USER EVENTS:
  TABLE_ID = "events_some_invalid"
 */

  // get user events service client
  private static UserEventServiceClient getUserEventsServiceClient()
      throws IOException {
    UserEventServiceSettings userEventServiceSettings = UserEventServiceSettings.newBuilder()
        .setEndpoint(ENDPOINT)
        .build();
    return UserEventServiceClient.create(userEventServiceSettings);
  }

  // get import user events from big query request
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

  // call the Retail API to import user events
  public static void importUserEventsFromBigQuery()
      throws IOException, ExecutionException, InterruptedException {
    ImportUserEventsRequest importBigQueryRequest = getImportEventsBigQueryRequest();

    OperationFuture<ImportUserEventsResponse, ImportMetadata> bigQueryOperation
        = getUserEventsServiceClient().importUserEventsAsync(
        importBigQueryRequest);

    System.out.printf("The operation was started: %s%n",
        bigQueryOperation.getName());

    while (!bigQueryOperation.isDone()) {
      System.out.println("Please wait till operation is done.");

      getUserEventsServiceClient().awaitTermination(30, TimeUnit.SECONDS);

      System.out.println("Import user events operation is done.");

      System.out.printf("Number of successfully imported events: %s%n",
          bigQueryOperation.getMetadata().get().getSuccessCount());

      System.out.printf("Number of failures during the importing: %s%n",
          bigQueryOperation.getMetadata().get().getFailureCount());

      System.out.printf("Operation result: %s%n", bigQueryOperation.get());
    }
  }

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    importUserEventsFromBigQuery();
  }
}

// [END retail_import_user_events_from_big_query]
