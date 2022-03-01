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

// [START retail_write_user_event]

/*
 * Write user events into a catalog from inline source using Retail API
 */

package events;

import static setup.SetupCleanup.purgeUserEvent;

import com.google.cloud.retail.v2.UserEvent;
import com.google.cloud.retail.v2.UserEventServiceClient;
import com.google.cloud.retail.v2.WriteUserEventRequest;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.time.Instant;
import java.util.concurrent.ExecutionException;

public class WriteUserEvent {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    String projectId = System.getenv("PROJECT_ID");
    String defaultCatalog = String.format("projects/%s/locations/global/catalogs/default_catalog", projectId);
    String visitorId = "test_visitor_id";

    writeUserEvent(defaultCatalog, visitorId);
    purgeUserEvent(visitorId);
  }

  public static void writeUserEvent(String defaultCatalog, String visitorId) throws IOException {
    WriteUserEventRequest writeUserEventRequest = getWriteEventRequest(getUserEvent(visitorId), defaultCatalog);

    try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
      UserEvent userEvent = userEventServiceClient.writeUserEvent(writeUserEventRequest);

      System.out.printf("Written user event: %s%n", userEvent);
    }
  }

  public static WriteUserEventRequest getWriteEventRequest(UserEvent userEvent, String defaultCatalog) {
    WriteUserEventRequest writeUserEventRequest =
        WriteUserEventRequest.newBuilder()
            .setUserEvent(userEvent)
            .setParent(defaultCatalog)
            .build();

    System.out.printf("Write user event request: %s%n", writeUserEventRequest);

    return writeUserEventRequest;
  }

  public static UserEvent getUserEvent(String visitorId) {
    Instant time = Instant.now();

    Timestamp timestamp = Timestamp.newBuilder().setSeconds(time.getEpochSecond()).build();

    UserEvent userEvent =
        UserEvent.newBuilder()
            .setEventType("home-page-view")
            .setVisitorId(visitorId)
            .setEventTime(timestamp)
            .build();

    System.out.println(userEvent);

    return userEvent;
  }
}

// [END retail_write_user_event]
