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
 * [START retail_write_user_event]
 * Import user events into a catalog from inline source using Retail API
 */

package events;

import com.google.cloud.retail.v2.UserEvent;
import com.google.cloud.retail.v2.UserEventServiceClient;
import com.google.cloud.retail.v2.UserEventServiceSettings;
import com.google.cloud.retail.v2.WriteUserEventRequest;
import com.google.protobuf.Timestamp;

import java.io.IOException;
import java.time.Instant;
import java.util.concurrent.ExecutionException;

import static events.setup.SetupCleanup.purgeUserEvent;

public class WriteUserEvent {

  private static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  private static final String ENDPOINT = "retail.googleapis.com:443";

  // TO CHECK THE ERROR HANDLING TRY TO PASS INVALID CATALOG:
  // 'invalid_catalog' INSTEAD OF 'default_catalog'
  private static final String DEFAULT_CATALOG = String.format(
      "projects/%s/locations/global/catalogs/default_catalog",
      PROJECT_NUMBER);

  private static final String VISITOR_ID = "test_visitor_id";

  // get user events service client
  private static UserEventServiceClient getUserEventsServiceClient()
      throws IOException {
    UserEventServiceSettings userEventServiceSettings = UserEventServiceSettings.newBuilder()
        .setEndpoint(ENDPOINT)
        .build();
    return UserEventServiceClient.create(userEventServiceSettings);
  }

  // get user event
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

  // get write user event request
  public static WriteUserEventRequest getWriteEventRequest(
      UserEvent userEvent) {
    WriteUserEventRequest writeUserEventRequest = WriteUserEventRequest.newBuilder()
        .setUserEvent(userEvent)
        .setParent(DEFAULT_CATALOG)
        .build();

    System.out.printf("Write user event request: %s%n", writeUserEventRequest);

    return writeUserEventRequest;
  }

  // call the Retail API to write user event
  public static UserEvent writeUserEvent() throws IOException {
    WriteUserEventRequest writeUserEventRequest = getWriteEventRequest(
        getUserEvent());

    UserEvent userEvent = getUserEventsServiceClient().writeUserEvent(
        writeUserEventRequest);

    System.out.printf("Written user event: %s%n", userEvent);

    return userEvent;
  }

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    writeUserEvent();

    purgeUserEvent(VISITOR_ID);
  }
}

// [END retail_write_user_event]
