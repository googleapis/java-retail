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

// [START retail_import_user_events_from_inline_source]

/*
 * Import user events into a catalog from inline source using Retail API
 */

package events;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.retail.v2.ImportMetadata;
import com.google.cloud.retail.v2.ImportUserEventsRequest;
import com.google.cloud.retail.v2.ImportUserEventsResponse;
import com.google.cloud.retail.v2.UserEvent;
import com.google.cloud.retail.v2.UserEventInlineSource;
import com.google.cloud.retail.v2.UserEventInputConfig;
import com.google.cloud.retail.v2.UserEventServiceClient;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ImportUserEventsInline {

  private static final String PROJECT_ID = System.getenv("PROJECT_ID");
  private static final String DEFAULT_CATALOG =
      String.format("projects/%s/locations/global/catalogs/default_catalog", PROJECT_ID);

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    importUserEventsFromInlineSource();
  }

  public static void importUserEventsFromInlineSource()
      throws IOException, ExecutionException, InterruptedException {

    int awaitDuration = 30;

    ImportUserEventsRequest importInlineRequest =
        getImportEventsInlineSourceRequest(getUserEvents());

    OperationFuture<ImportUserEventsResponse, ImportMetadata> importOperation =
        UserEventServiceClient.create().importUserEventsAsync(importInlineRequest);

    System.out.printf("The operation was started: %s%n", importOperation.getName());

    System.out.println("Please wait till operation is done.");

    UserEventServiceClient.create().awaitTermination(awaitDuration, TimeUnit.SECONDS);

    System.out.println("Import user events operation is done.");

    if (importOperation.getMetadata().get() != null) {
      System.out.printf(
          "Number of successfully imported events: %s%n",
          importOperation.getMetadata().get().getSuccessCount());

      System.out.printf(
          "Number of failures during the importing: %s%n",
          importOperation.getMetadata().get().getFailureCount());
    } else {
      System.out.println("Metadata in bigQuery operation is empty.");
    }
    if (importOperation.get() != null) {
      System.out.printf("Operation result: %s%n", importOperation.get());
    } else {
      System.out.println("Operation result is empty.");
    }
  }

  public static ImportUserEventsRequest getImportEventsInlineSourceRequest(
      List<UserEvent> userEventsToImport) {
    UserEventInlineSource inlineSource =
        UserEventInlineSource.newBuilder().addAllUserEvents(userEventsToImport).build();

    UserEventInputConfig inputConfig =
        UserEventInputConfig.newBuilder().setUserEventInlineSource(inlineSource).build();

    ImportUserEventsRequest importRequest =
        ImportUserEventsRequest.newBuilder()
            .setParent(DEFAULT_CATALOG)
            .setInputConfig(inputConfig)
            .build();

    System.out.printf("Import user events from inline source request: %s%n", importRequest);

    return importRequest;
  }

  public static List<UserEvent> getUserEvents() {
    List<UserEvent> userEvents = new ArrayList<>();

    int userEventsNumber = 3;

    for (int i = 0; i < userEventsNumber; i++) {
      Instant time = Instant.now();

      Timestamp timestamp = Timestamp.newBuilder().setSeconds(time.getEpochSecond()).build();

      UserEvent userEvent =
          UserEvent.newBuilder()
              .setEventType("home-page-view")
              .setVisitorId("test_visitor_id")
              .setEventTime(timestamp)
              .build();

      userEvents.add(userEvent);

      System.out.printf("User Event: %s%n", i);
      System.out.println(userEvent);
    }

    return userEvents;
  }
}

// [END retail_import_user_events_from_inline_source]
