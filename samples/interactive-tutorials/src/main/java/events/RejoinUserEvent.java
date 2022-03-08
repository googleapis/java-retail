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

// [START retail_rejoin_user_event]

/*
 * Rejoin user events into a catalog from inline source using Retail API
 */

package events;

import static setup.SetupCleanup.purgeUserEvent;
import static setup.SetupCleanup.writeUserEvent;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.retail.v2.RejoinUserEventsMetadata;
import com.google.cloud.retail.v2.RejoinUserEventsRequest;
import com.google.cloud.retail.v2.RejoinUserEventsRequest.UserEventRejoinScope;
import com.google.cloud.retail.v2.RejoinUserEventsResponse;
import com.google.cloud.retail.v2.UserEventServiceClient;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class RejoinUserEvent {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    String projectId = System.getenv("PROJECT_ID");
    String defaultCatalog = String.format(
        "projects/%s/locations/global/catalogs/default_catalog", projectId);
    String visitorId = UUID.randomUUID().toString();

    writeUserEvent(visitorId);
    callRejoinUserEvents(defaultCatalog);
    purgeUserEvent(visitorId);
  }

  public static void callRejoinUserEvents(String defaultCatalog)
      throws IOException, ExecutionException, InterruptedException {
    RejoinUserEventsRequest rejoinUserEventsRequest =
        RejoinUserEventsRequest.newBuilder()
            .setParent(defaultCatalog)
            .setUserEventRejoinScope(UserEventRejoinScope.UNJOINED_EVENTS)
            .build();
    System.out.printf("Rejoin user events request: %s%n", rejoinUserEventsRequest);

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
      OperationFuture<RejoinUserEventsResponse, RejoinUserEventsMetadata> rejoinOperation =
          userEventServiceClient.rejoinUserEventsAsync(rejoinUserEventsRequest);

      System.out.printf("The rejoin operation was started: %s%n", rejoinOperation.getName());
    }
  }
}

// [END retail_rejoin_user_event]
