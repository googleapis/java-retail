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
 * [START retail_purge_user_event]
 * Import user events into a catalog from inline source using Retail API
 */

package events;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.retail.v2.PurgeMetadata;
import com.google.cloud.retail.v2.PurgeUserEventsRequest;
import com.google.cloud.retail.v2.PurgeUserEventsResponse;
import com.google.cloud.retail.v2.UserEventServiceClient;
import com.google.cloud.retail.v2.UserEventServiceSettings;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static events.setup.SetupCleanup.writeUserEvent;

public class PurgeUserEvent {

  private static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  private static final String ENDPOINT = "retail.googleapis.com:443";

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

  // get purge user event request
  private static PurgeUserEventsRequest getPurgeUserEventRequest() {
    PurgeUserEventsRequest purgeUserEventsRequest = PurgeUserEventsRequest.newBuilder()
        // TO CHECK ERROR HANDLING SET INVALID FILTER HERE:
        .setFilter(String.format("visitorId=\"%s\"", VISITOR_ID))
        .setParent(DEFAULT_CATALOG)
        .setForce(true)
        .build();

    System.out.printf("Purge user events request: %s%n",
        purgeUserEventsRequest);

    return purgeUserEventsRequest;
  }

  // call the Retail API to purge user event
  public static void callPurgeUserEvents()
      throws IOException, ExecutionException, InterruptedException {
    OperationFuture<PurgeUserEventsResponse, PurgeMetadata> purgeOperation
        = getUserEventsServiceClient().purgeUserEventsAsync(
        getPurgeUserEventRequest());

    System.out.printf("The purge operation was started: %s%n",
        purgeOperation.getName());
  }

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    writeUserEvent(VISITOR_ID);

    callPurgeUserEvents();
  }
}

// [END retail_purge_user_event]
