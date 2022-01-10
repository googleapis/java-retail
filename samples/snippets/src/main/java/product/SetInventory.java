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

import com.google.cloud.retail.v2.FulfillmentInfo;
import com.google.cloud.retail.v2.PriceInfo;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.Product.Availability;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.retail.v2.SetInventoryRequest;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;

import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static setup.SetupCleanup.createProduct;
import static setup.SetupCleanup.deleteProduct;
import static setup.SetupCleanup.getProduct;
import static setup.SetupCleanup.tryToDeleteProductIfExists;

public final class SetInventory {

  /**
   * This variable describes project number getting from environment variable.
   */
  private static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  /**
   * This variable describes defined product id for field setting.
   */
  private static final String PRODUCT_ID = "inventory_test_product_id";

  /**
   * This variable describes product name.
   */
  private static final String PRODUCT_NAME = String.format(
      "projects/%s/locations/global/catalogs/default_catalog/"
          + "branches/default_branch/products/%s", PROJECT_NUMBER, PRODUCT_ID);

  private SetInventory() {
  }

  /**
   * Get product service client.
   *
   * @return ProductServiceClient.
   * @throws IOException if endpoint is incorrect.
   */
  private static ProductServiceClient getProductServiceClient()
      throws IOException {
    return ProductServiceClient.create();
  }

  /**
   * Product inventory info.
   *
   * @param productName refers to product name.
   * @return Product.
   */
  public static Product getProductWithInventoryInfo(final String productName) {

    final float price = 15.0f;
    final float originalPrice = 20.0f;
    final float cost = 8.0f;

    PriceInfo priceInfo = PriceInfo.newBuilder()
        .setPrice(price)
        .setOriginalPrice(originalPrice)
        .setCost(cost)
        .setCurrencyCode("USD")
        .build();

    FulfillmentInfo fulfillmentInfo = FulfillmentInfo.newBuilder()
        .setType("pickup-in-store")
        .addAllPlaceIds(Arrays.asList("store1", "store2"))
        .build();

    return Product.newBuilder()
        .setName(productName)
        .setPriceInfo(priceInfo)
        .addFulfillmentInfo(fulfillmentInfo)
        .setAvailability(Availability.IN_STOCK)
        .build();
  }

  /**
   * Set inventory request.
   *
   * @param productName refers to product name.
   * @return SetInventoryRequest.
   */
  public static SetInventoryRequest getSetInventoryRequest(
      final String productName) {
    // The request timestamp
    Timestamp requestTime = Timestamp.newBuilder()
        .setSeconds(Instant.now().getEpochSecond())
        .setNanos(Instant.now().getNano()).build();

    FieldMask setMask = FieldMask.newBuilder()
        .addAllPaths(Arrays.asList("price_info", "availability",
            "fulfillment_info", "available_quantity"))
        .build();

    SetInventoryRequest setInventoryRequest = SetInventoryRequest.newBuilder()
        .setInventory(getProductWithInventoryInfo(productName))
        .setSetTime(requestTime)
        .setAllowMissing(true)
        .setSetMask(setMask)
        .build();

    System.out.printf("Set inventory request: %s%n", setInventoryRequest);

    return setInventoryRequest;
  }

  /**
   * Set inventory to product.
   *
   * @param productName refers to product name.
   * @throws IOException          from the called method.
   * @throws InterruptedException if interrupted while waiting.
   */
  public static void setInventory(final String productName)
      throws IOException, InterruptedException {
    SetInventoryRequest setInventoryRequest = getSetInventoryRequest(
        productName);

    getProductServiceClient().setInventoryAsync(setInventoryRequest);

    /*
    This is a long running operation and its result is not immediately
    present with get operations,thus we simulate wait with sleep method.
    */
    System.out.println("Set inventory, wait 30 seconds.");

    final int awaitDuration = 30;

    getProductServiceClient().awaitTermination(awaitDuration, TimeUnit.SECONDS);
  }

  /**
   * Executable tutorial class.
   *
   * @param args command line arguments.
   */
  public static void main(final String[] args)
      throws IOException, InterruptedException {
    tryToDeleteProductIfExists(PRODUCT_NAME);

    createProduct(PRODUCT_ID);

    setInventory(PRODUCT_NAME);

    getProduct(PRODUCT_NAME);

    deleteProduct(PRODUCT_NAME);
  }
}

// [END add_fulfillment_places]
