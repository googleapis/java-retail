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
 * Import user events into a catalog from inline source using Retail API
 */

package events;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.retail.v2.RejoinUserEventsMetadata;
import com.google.cloud.retail.v2.RejoinUserEventsRequest;
import com.google.cloud.retail.v2.RejoinUserEventsRequest.UserEventRejoinScope;
import com.google.cloud.retail.v2.RejoinUserEventsResponse;
import com.google.cloud.retail.v2.UserEventServiceClient;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static setup.SetupCleanup.purgeUserEvent;
import static setup.SetupCleanup.writeUserEvent;

public class RejoinUserEvent {

  private static final String PROJECT_ID = System.getenv("PROJECT_ID");
  private static final String DEFAULT_CATALOG = String.format(
      "projects/%s/locations/global/catalogs/default_catalog",
      PROJECT_ID);
  // TO CHECK THE ERROR HANDLING TRY TO PASS INVALID CATALOG:
  // 'invalid_catalog' INSTEAD OF 'default_catalog'
  private static final String VISITOR_ID = "test_visitor_id";

  public static void main(final String[] args)
      throws IOException, ExecutionException, InterruptedException {
    writeUserEvent(VISITOR_ID);
    callRejoinUserEvents();
    purgeUserEvent(VISITOR_ID);
  }

  public static void callRejoinUserEvents()
      throws IOException, ExecutionException, InterruptedException {
    OperationFuture<RejoinUserEventsResponse, RejoinUserEventsMetadata>
        rejoinOperation = UserEventServiceClient.create().rejoinUserEventsAsync(
        getRejoinUserEventRequest());

    System.out.printf("The rejoin operation was started: %s%n",
        rejoinOperation.getName());
  }

  public static RejoinUserEventsRequest getRejoinUserEventRequest() {
    RejoinUserEventsRequest rejoinUserEventsRequest =
        RejoinUserEventsRequest.newBuilder()
            .setParent(DEFAULT_CATALOG)
            .setUserEventRejoinScope(UserEventRejoinScope.UNJOINED_EVENTS)
            .build();

    System.out.printf("Rejoin user events request: %s%n",
        rejoinUserEventsRequest);

    return rejoinUserEventsRequest;
  }
}

// [END retail_rejoin_user_event]
