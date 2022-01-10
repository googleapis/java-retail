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

/*
 * [START retail_import_user_events_from_inline_source]
 * Import user events into a catalog from inline source using Retail API
 */

package events;

import com.google.cloud.retail.v2.ImportMetadata;
import com.google.cloud.retail.v2.ImportUserEventsRequest;
import com.google.cloud.retail.v2.ImportUserEventsResponse;
import com.google.cloud.retail.v2.UserEvent;
import com.google.cloud.retail.v2.UserEventInlineSource;
import com.google.cloud.retail.v2.UserEventInputConfig;
import com.google.cloud.retail.v2.UserEventServiceClient;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Timestamp;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public final class ImportUserEventsInline {

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

  private ImportUserEventsInline() {
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
   * Get user events for import.
   *
   * @return List<UserEvent>.
   */
  public static List<UserEvent> getUserEvents() {
    List<UserEvent> userEvents = new ArrayList<>();

    final int userEventsNumber = 3;

    for (int i = 0; i < userEventsNumber; i++) {
      Instant time = Instant.now();

      Timestamp timestamp = Timestamp.newBuilder()
          .setSeconds(time.getEpochSecond())
          .build();

      UserEvent userEvent = UserEvent.newBuilder()
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

  /**
   * Get import user events from inline source request.
   *
   * @param userEventsToImport list of user events to import.
   * @return ImportUserEventsRequest.
   */
  public static ImportUserEventsRequest getImportEventsInlineSourceRequest(
      final List<UserEvent> userEventsToImport) {
    UserEventInlineSource inlineSource = UserEventInlineSource.newBuilder()
        .addAllUserEvents(userEventsToImport)
        .build();

    UserEventInputConfig inputConfig = UserEventInputConfig.newBuilder()
        .setUserEventInlineSource(inlineSource)
        .build();

    ImportUserEventsRequest importRequest = ImportUserEventsRequest.newBuilder()
        .setParent(DEFAULT_CATALOG)
        .setInputConfig(inputConfig)
        .build();

    System.out.printf("Import user events from inline source request: %s%n",
        importRequest);

    return importRequest;
  }

  /**
   * Call the Retail API to import user events.
   *
   * @throws IOException          from the called method.
   * @throws InterruptedException when a thread is waiting, sleeping, or
   *                              otherwise occupied, and the thread is
   *                              interrupted, either before or during the
   *                              activity.
   */
  public static void importUserEventsFromInlineSource()
      throws IOException, InterruptedException {

    ImportUserEventsRequest importInlineRequest =
        getImportEventsInlineSourceRequest(
            getUserEvents());

    UserEventServiceClient serviceClient = getUserEventsServiceClient();

    String operationName = serviceClient
        .importUserEventsCallable()
        .call(importInlineRequest)
        .getName();

    System.out.printf("OperationName = %s\n", operationName);

    OperationsClient operationsClient = serviceClient.getOperationsClient();

    Operation operation = operationsClient.getOperation(operationName);

    while (!operation.getDone()) {
      // Polling operation delay until the import task is done.
      final int awaitDuration = 30;

      getUserEventsServiceClient().awaitTermination(awaitDuration,
          TimeUnit.SECONDS);

      operation = operationsClient.getOperation(operationName);
    }

    if (operation.hasMetadata()) {
      ImportMetadata metadata = operation.getMetadata()
          .unpack(ImportMetadata.class);

      System.out.printf("Number of successfully imported events: %s\n",
          metadata.getSuccessCount());

      System.out.printf("Number of failures during the importing: %s\n",
          metadata.getFailureCount());
    }

    if (operation.hasResponse()) {
      ImportUserEventsResponse response = operation.getResponse()
          .unpack(ImportUserEventsResponse.class);

      System.out.printf("Operation result: %s%n", response);
    }
  }

  /**
   * Executable tutorial class.
   *
   * @param args command line arguments.
   */
  public static void main(final String[] args)
      throws IOException, ExecutionException, InterruptedException {
    importUserEventsFromInlineSource();
  }
}

// [END retail_import_user_events_from_inline_source]
