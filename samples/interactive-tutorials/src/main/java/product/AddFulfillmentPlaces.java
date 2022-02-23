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
 * [START retail_add_fulfillment_places]
 */

package product;

import static setup.SetupCleanup.createProduct;
import static setup.SetupCleanup.deleteProduct;
import static setup.SetupCleanup.getProduct;

import com.google.cloud.retail.v2.AddFulfillmentPlacesRequest;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class AddFulfillmentPlaces {

  public static void main(String[] args) throws IOException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = System.getenv("PROJECT_ID");
    String generatedProductId = UUID.randomUUID().toString();
    String productName =
        String.format(
            "projects/%s/locations/global/catalogs/default_catalog/branches/"
                + "default_branch/products/%s",
            projectId, generatedProductId);
    Timestamp currentDate =
        Timestamp.newBuilder()
            .setSeconds(Instant.now().getEpochSecond())
            .setNanos(Instant.now().getNano())
            .build();
    /*
     * The time when the fulfillment updates are issued. If set with outdated time
     * (yesterday), the fulfillment information will not updated.
     */
    Timestamp outdatedDate =
        Timestamp.newBuilder()
            .setSeconds(Instant.now().minus(1, ChronoUnit.DAYS).getEpochSecond())
            .setNanos(Instant.now().getNano())
            .build();

    createProduct(generatedProductId);
    System.out.printf("Add fulfilment places with current date: %s", currentDate);
    addFulfillmentPlaces(productName, currentDate, "store2");
    getProduct(productName);
    System.out.printf("Add outdated fulfilment places: %s", outdatedDate);
    addFulfillmentPlaces(productName, outdatedDate, "store3");
    getProduct(productName);
    deleteProduct(productName);
  }

  public static void addFulfillmentPlaces(String productName, Timestamp timestamp, String placeId)
      throws IOException, InterruptedException {
    AddFulfillmentPlacesRequest addFulfillmentRequest =
        getAddFulfillmentRequest(productName, timestamp, placeId);
    ProductServiceClient.create().addFulfillmentPlacesAsync(addFulfillmentRequest);
    System.out.println("Add fulfillment places, wait 30 seconds: ");

    /*
    This is a long-running operation and its result is not immediately
    present with get operations,thus we simulate wait with sleep method.
    */
    ProductServiceClient.create().awaitTermination(30, TimeUnit.SECONDS);
  }

  public static AddFulfillmentPlacesRequest getAddFulfillmentRequest(
      String productName, Timestamp timestamp, String placeId) {
    AddFulfillmentPlacesRequest addfulfillmentPlacesRequest =
        AddFulfillmentPlacesRequest.newBuilder()
            .setProduct(productName)
            .setType("pickup-in-store")
            .addPlaceIds(placeId)
            .setAddTime(timestamp)
            .setAllowMissing(true)
            .build();
    System.out.println("Add fulfillment request " + addfulfillmentPlacesRequest);

    return addfulfillmentPlacesRequest;
  }
}

// [END retail_add_fulfillment_places]
