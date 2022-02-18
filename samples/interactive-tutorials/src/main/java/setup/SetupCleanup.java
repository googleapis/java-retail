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

package setup;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.ProductDetail;
import com.google.cloud.retail.v2.PurgeMetadata;
import com.google.cloud.retail.v2.PurgeUserEventsRequest;
import com.google.cloud.retail.v2.PurgeUserEventsResponse;
import com.google.cloud.retail.v2.UserEvent;
import com.google.cloud.retail.v2.UserEventServiceClient;
import com.google.cloud.retail.v2.WriteUserEventRequest;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.time.Instant;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

public class SetupCleanup {

  private static final String PROJECT_ID = System.getenv("PROJECT_ID");
  private static final String DEFAULT_CATALOG =
      String.format("projects/%s/locations/global/catalogs/default_catalog", PROJECT_ID);

  public static UserEvent getUserEvent(String visitorId) {
    int value = 3;

    Timestamp timestamp = Timestamp.newBuilder().setSeconds(Instant.now().getEpochSecond()).build();

    Product product = Product.newBuilder().setId("test_id").build();

    ProductDetail productDetail =
        ProductDetail.newBuilder()
            .setProduct(product)
            .setQuantity(Int32Value.newBuilder().setValue(value).build())
            .build();

    UserEvent userEvent =
        UserEvent.newBuilder()
            .setEventType("detail-page-view")
            .setVisitorId(visitorId)
            .setEventTime(timestamp)
            .addAllProductDetails(Collections.singletonList(productDetail))
            .build();
    System.out.println(userEvent);

    return userEvent;
  }

  public static UserEvent writeUserEvent(String visitorId) throws IOException {
    WriteUserEventRequest writeUserEventRequest =
        WriteUserEventRequest.newBuilder()
            .setUserEvent(getUserEvent(visitorId))
            .setParent(DEFAULT_CATALOG)
            .build();

    UserEvent userEvent = UserEventServiceClient.create().writeUserEvent(writeUserEventRequest);
    System.out.printf("The user event is written. %n%s%n", userEvent);

    return userEvent;
  }

  public static void purgeUserEvent(String visitorId)
      throws IOException, ExecutionException, InterruptedException {
    PurgeUserEventsRequest purgeUserEventsRequest =
        PurgeUserEventsRequest.newBuilder()
            .setFilter(String.format("visitorId=\"%s\"", visitorId))
            .setParent(DEFAULT_CATALOG)
            .setForce(true)
            .build();

    OperationFuture<PurgeUserEventsResponse, PurgeMetadata> purgeOperation =
        UserEventServiceClient.create().purgeUserEventsAsync(purgeUserEventsRequest);

    System.out.printf("The purge operation was started: %s%n", purgeOperation.getName());
  }
}
