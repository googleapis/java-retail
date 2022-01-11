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
 * [START add_fulfillment_places]
 */

package product;

import static product.setup.SetupCleanup.createProduct;
import static product.setup.SetupCleanup.deleteProduct;
import static product.setup.SetupCleanup.getProduct;

import com.google.cloud.retail.v2.AddFulfillmentPlacesRequest;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.retail.v2.ProductServiceSettings;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import lombok.experimental.UtilityClass;


@UtilityClass
public class AddFulfillmentPlaces {

  /**
   * This variable describes project number getting from environment variable.
   */
  private static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  /**
   * This variable describes endpoint for send requests.
   */
  private static final String ENDPOINT = "retail.googleapis.com:443";

  /**
   * This variable describes defined product id for field setting.
   */
  private static final String PRODUCT_ID = "add_fulfillment_test_product_id";

  /**
   * This variable describes default catalog name.
   */
  private static final String PRODUCT_NAME = String.format(
      "projects/%s/locations/global/catalogs/default_catalog/branches/default_branch/products/%s",
      PROJECT_NUMBER, PRODUCT_ID);

  /**
   * The time when the fulfillment updates are issued, used to prevent
   * out-of-order updates on fulfillment information.
   */
  private static final Timestamp requestTime = Timestamp.newBuilder()
      .setSeconds(Instant.now().getEpochSecond())
      .setNanos(Instant.now().getNano()).build();

  /**
   * Get product service client.
   *
   * @return ProductServiceClient.
   * @throws IOException if endpoint is incorrect.
   */
  private static ProductServiceClient getProductServiceClient()
      throws IOException {
    ProductServiceSettings productServiceSettings = ProductServiceSettings.newBuilder()
        .setEndpoint(ENDPOINT)
        .build();

    return ProductServiceClient.create(productServiceSettings);
  }

  /**
   * Add fulfillment request.
   *
   * @param productName refers to product name.
   * @return AddFulfillmentPlacesRequest.
   */
  public static AddFulfillmentPlacesRequest getAddFulfillmentRequest(
      final String productName) {
    AddFulfillmentPlacesRequest addfulfillmentPlacesRequest = AddFulfillmentPlacesRequest.newBuilder()
        .setProduct(productName)
        .setType("pickup-in-store")
        .addPlaceIds("store2, store3, store4")
        .setAddTime(requestTime)
        .setAllowMissing(true)
        .build();

    System.out.println(
        "Add fulfillment request " + addfulfillmentPlacesRequest);

    return addfulfillmentPlacesRequest;
  }

  /**
   * Add fulfillment places to product.
   *
   * @param productName refers to product name.
   * @throws IOException          from the called method.
   */
  public static void addFulfillmentPlaces(final String productName)
      throws IOException {
    AddFulfillmentPlacesRequest addFulfillmentRequest = getAddFulfillmentRequest(
        productName);

    getProductServiceClient().addFulfillmentPlacesAsync(addFulfillmentRequest);

    System.out.println("Add fulfillment places, wait 30 seconds: ");

    /*
    This is a long-running operation and its result is not immediately
    present with get operations,thus we simulate wait with sleep method.
    */
//    getProductServiceClient().awaitTermination(30, TimeUnit.SECONDS);
  }

  /**
   * Executable tutorial class.
   */
  public static void main(final String[] args)
      throws IOException, InterruptedException {
    createProduct(PRODUCT_ID);

    getProductServiceClient().awaitTermination(30, TimeUnit.SECONDS);

    addFulfillmentPlaces(PRODUCT_NAME);

    getProduct(PRODUCT_NAME);

//    deleteProduct(PRODUCT_NAME);
  }
}

// [END add_fulfillment_places]
