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
 * [START retail_write_user_event]
 * Import user events into a catalog from inline source using Retail API
 */

package events;

import com.google.cloud.retail.v2.UserEvent;
import com.google.cloud.retail.v2.UserEventServiceClient;
import com.google.cloud.retail.v2.WriteUserEventRequest;
import com.google.protobuf.Timestamp;

import java.io.IOException;
import java.time.Instant;
import java.util.concurrent.ExecutionException;

import static setup.SetupCleanup.purgeUserEvent;

public final class WriteUserEvent {

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
  // TO CHECK THE ERROR HANDLING TRY TO PASS INVALID CATALOG:
  // 'invalid_catalog' INSTEAD OF 'default_catalog'

  /**
   * This variable describes visitor identifier.
   */
  private static final String VISITOR_ID = "test_visitor_id";

  private WriteUserEvent() {
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
   * Get user event.
   *
   * @return UserEvent.
   */
  public static UserEvent getUserEvent() {
    Instant time = Instant.now();

    Timestamp timestamp = Timestamp.newBuilder()
        .setSeconds(time.getEpochSecond())
        .build();

    UserEvent userEvent = UserEvent.newBuilder()
        .setEventType("home-page-view")
        .setVisitorId(VISITOR_ID)
        .setEventTime(timestamp)
        .build();

    System.out.println(userEvent);

    return userEvent;
  }

  /**
   * Get write user event request.
   *
   * @param userEvent user event.
   * @return WriteUserEventRequest.
   */
  public static WriteUserEventRequest getWriteEventRequest(
      final UserEvent userEvent) {
    WriteUserEventRequest writeUserEventRequest =
        WriteUserEventRequest.newBuilder()
            .setUserEvent(userEvent)
            .setParent(DEFAULT_CATALOG)
            .build();

    System.out.printf("Write user event request: %s%n", writeUserEventRequest);

    return writeUserEventRequest;
  }

  /**
   * Call the Retail API to write user event.
   *
   * @throws IOException from the called method.
   */
  public static void writeUserEvent() throws IOException {
    WriteUserEventRequest writeUserEventRequest = getWriteEventRequest(
        getUserEvent());

    UserEvent userEvent = getUserEventsServiceClient().writeUserEvent(
        writeUserEventRequest);

    System.out.printf("Written user event: %s%n", userEvent);

  }

  /**
   * Executable tutorial class.
   *
   * @param args command line arguments.
   */
  public static void main(final String[] args)
      throws IOException, ExecutionException, InterruptedException {
    writeUserEvent();

    purgeUserEvent(VISITOR_ID);
  }
}

// [END retail_write_user_event]
