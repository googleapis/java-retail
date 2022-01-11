/*
 * Copyright 2022 2022 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * [START retail_remove_fulfillment_places]
 */

package product;

import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.retail.v2.ProductServiceSettings;
import com.google.cloud.retail.v2.RemoveFulfillmentPlacesRequest;
import com.google.protobuf.Timestamp;

import java.io.IOException;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static product.setup.SetupCleanup.createProduct;
import static product.setup.SetupCleanup.deleteProduct;
import static product.setup.SetupCleanup.getProduct;

public class RemoveFulfillmentPlaces {

  public static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  public static final String ENDPOINT = "retail.googleapis.com:443";

  public static final String PRODUCT_ID = "remove_fulfillment_test_product_id";

  public static final String PRODUCT_NAME = String.format(
      "projects/%s/locations/global/catalogs/default_catalog/branches/default_branch/products/%s",
      PROJECT_NUMBER, PRODUCT_ID);

  // The request timestamp
  private static final Timestamp requestTime = Timestamp.newBuilder()
      .setSeconds(Instant.now().getEpochSecond())
      .setNanos(Instant.now().getNano()).build();

  // get product service client
  private static ProductServiceClient getProductServiceClient()
      throws IOException {
    ProductServiceSettings productServiceSettings =
        ProductServiceSettings.newBuilder()
            .setEndpoint(ENDPOINT)
            .build();
    return ProductServiceClient.create(productServiceSettings);
  }

  // remove fulfillment request
  public static RemoveFulfillmentPlacesRequest getRemoveFulfillmentRequest(
      String productName) {
    RemoveFulfillmentPlacesRequest removeFulfillmentRequest =
        RemoveFulfillmentPlacesRequest.newBuilder()
            .setProduct(productName)
            .setType("pickup-in-store")
            .addPlaceIds("store0")
            .setRemoveTime(requestTime)
            .setAllowMissing(true)
            .build();

    System.out.println(
        "Remove fulfillment request " + removeFulfillmentRequest);

    return removeFulfillmentRequest;
  }

  // remove fulfillment places to product
  public static void removeFulfillmentPlaces(String productName)
      throws IOException, InterruptedException {
    RemoveFulfillmentPlacesRequest removeFulfillmentRequest =
        getRemoveFulfillmentRequest(productName);

    getProductServiceClient()
        .removeFulfillmentPlacesAsync(removeFulfillmentRequest);

    /*
    This is a long running operation and its result is not immediately
    present with get operations,thus we simulate wait with sleep method.
    */
    System.out.println("Remove fulfillment places, wait 30 seconds.");

    getProductServiceClient().awaitTermination(30, TimeUnit.SECONDS);
  }

  // [END retail_remove_fulfillment_places]

  public static void main(String[] args)
      throws IOException, InterruptedException {
    createProduct(PRODUCT_ID);

    getProductServiceClient().awaitTermination(30, TimeUnit.SECONDS);

    removeFulfillmentPlaces(PRODUCT_NAME);

    getProduct(PRODUCT_NAME);

    deleteProduct(PRODUCT_NAME);
  }
}
