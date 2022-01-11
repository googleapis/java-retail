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
 * [START retail_rejoin_user_event]
 * Import user events into a catalog from inline source using Retail API
 */

package events;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.retail.v2.RejoinUserEventsMetadata;
import com.google.cloud.retail.v2.RejoinUserEventsRequest;
import com.google.cloud.retail.v2.RejoinUserEventsRequest.UserEventRejoinScope;
import com.google.cloud.retail.v2.RejoinUserEventsResponse;
import com.google.cloud.retail.v2.UserEventServiceClient;
import com.google.cloud.retail.v2.UserEventServiceSettings;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static events.setup.SetupCleanup.purgeUserEvent;
import static events.setup.SetupCleanup.writeUserEvent;

public class RejoinUserEvent {

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

  // get rejoin user event request
  public static RejoinUserEventsRequest getRejoinUserEventRequest() {
    RejoinUserEventsRequest rejoinUserEventsRequest = RejoinUserEventsRequest.newBuilder()
        .setParent(DEFAULT_CATALOG)
        .setUserEventRejoinScope(UserEventRejoinScope.UNJOINED_EVENTS)
        .build();

    System.out.printf("Rejoin user events request: %s%n",
        rejoinUserEventsRequest);

    return rejoinUserEventsRequest;
  }

  // call the Retail API to rejoin user event
  public static void callRejoinUserEvents()
      throws IOException, ExecutionException, InterruptedException {
    OperationFuture<RejoinUserEventsResponse, RejoinUserEventsMetadata>
        rejoinOperation = getUserEventsServiceClient().rejoinUserEventsAsync(
        getRejoinUserEventRequest());

    System.out.printf("The rejoin operation was started: %s%n",
        rejoinOperation.getName());
  }

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    writeUserEvent(VISITOR_ID);

    callRejoinUserEvents();

    purgeUserEvent(VISITOR_ID);
  }
}

// [END retail_rejoin_user_event]
