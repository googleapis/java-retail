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
 * [START retail_remove_fulfillment_places]
 */

package product;

import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.retail.v2.RemoveFulfillmentPlacesRequest;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static setup.SetupCleanup.createProduct;
import static setup.SetupCleanup.deleteProduct;
import static setup.SetupCleanup.getProduct;
import static setup.SetupCleanup.tryToDeleteProductIfExists;

public class RemoveFulfillmentPlaces {

  private static final String PROJECT_ID = System.getenv("PROJECT_ID");
  private static final String PRODUCT_ID = UUID.randomUUID().toString();
  private static final String PRODUCT_NAME = String.format(
      "projects/%s/locations/global/catalogs/default_catalog/"
          + "branches/default_branch/products/%s", PROJECT_ID, PRODUCT_ID);
  private static final Timestamp REQUEST_TIME = Timestamp.newBuilder()
      .setSeconds(Instant.now().getEpochSecond())
      .setNanos(Instant.now().getNano()).build();

  public static void main(String[] args) throws IOException, InterruptedException {
    tryToDeleteProductIfExists(PRODUCT_NAME);
    createProduct(PRODUCT_ID);
    ProductServiceClient.create().awaitTermination(30, TimeUnit.SECONDS);
    removeFulfillmentPlaces(PRODUCT_NAME);
    getProduct(PRODUCT_NAME);
    deleteProduct(PRODUCT_NAME);
  }

  public static void removeFulfillmentPlaces(String productName)
      throws IOException, InterruptedException {
    RemoveFulfillmentPlacesRequest removeFulfillmentRequest =
        getRemoveFulfillmentRequest(productName);
    ProductServiceClient.create()
        .removeFulfillmentPlacesAsync(removeFulfillmentRequest);
    /*
    This is a long running operation and its result is not immediately
    present with get operations,thus we simulate wait with sleep method.
    */
    System.out.println("Remove fulfillment places, wait 30 seconds.");

    ProductServiceClient.create().awaitTermination(30, TimeUnit.SECONDS);
  }

  public static RemoveFulfillmentPlacesRequest getRemoveFulfillmentRequest(
      String productName) {
    RemoveFulfillmentPlacesRequest removeFulfillmentRequest =
        RemoveFulfillmentPlacesRequest.newBuilder()
            .setProduct(productName)
            .setType("pickup-in-store")
            .addPlaceIds("store0")
            .setRemoveTime(REQUEST_TIME)
            .setAllowMissing(true)
            .build();
    System.out.println(
        "Remove fulfillment request " + removeFulfillmentRequest);

    return removeFulfillmentRequest;
  }
}

// [END retail_remove_fulfillment_places]
