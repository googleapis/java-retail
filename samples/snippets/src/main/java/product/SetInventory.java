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
import com.google.cloud.retail.v2.ProductServiceSettings;
import com.google.cloud.retail.v2.SetInventoryRequest;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;

import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static product.setup.SetupCleanup.createProduct;
import static product.setup.SetupCleanup.deleteProduct;
import static product.setup.SetupCleanup.getProduct;

public class SetInventory {

  public static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  public static final String ENDPOINT = "retail.googleapis.com:443";

  private static final String PRODUCT_ID = "inventory_test_product_id";

  public static final String PRODUCT_NAME = String.format(
      "projects/%s/locations/global/catalogs/default_catalog/branches/default_branch/products/%s",
      PROJECT_NUMBER, PRODUCT_ID);

  // get product service client
  private static ProductServiceClient getProductServiceClient()
      throws IOException {
    ProductServiceSettings productServiceSettings =
        ProductServiceSettings.newBuilder()
            .setEndpoint(ENDPOINT)
            .build();
    return ProductServiceClient.create(productServiceSettings);
  }

  // product inventory info
  public static Product getProductWithInventoryInfo(String productName) {
    PriceInfo priceInfo = PriceInfo.newBuilder()
        .setPrice(15.0f)
        .setOriginalPrice(20.0f)
        .setCost(8.0f)
        .setCurrencyCode("USD")
        .build();

    FulfillmentInfo fulfillmentInfo = FulfillmentInfo.newBuilder()
        .setType("pickup-in-store")
        .addAllPlaceIds(Arrays.asList("store1", "store2"))
        .build();

    return Product.newBuilder()
        .setName(PRODUCT_NAME)
        .setPriceInfo(priceInfo)
        .addFulfillmentInfo(fulfillmentInfo)
        .setAvailability(Availability.IN_STOCK)
        .build();
  }

  // set inventory request
  public static SetInventoryRequest getSetInventoryRequest(String productName) {
    // The request timestamp
    Timestamp requestTime = Timestamp.newBuilder()
        .setSeconds(Instant.now().getEpochSecond())
        .setNanos(Instant.now().getNano()).build();

    FieldMask setMask = FieldMask.newBuilder()
        .addAllPaths(Arrays.asList("price_info", "availability",
            "fulfillment_info", "available_quantity"))
        .build();

    SetInventoryRequest setInventoryRequest = SetInventoryRequest.newBuilder()
        .setInventory(getProductWithInventoryInfo(PRODUCT_NAME))
        .setSetTime(requestTime)
        .setAllowMissing(true)
        .setSetMask(setMask)
        .build();

    System.out.printf("Set inventory request: %s%n", setInventoryRequest);

    return setInventoryRequest;
  }

  // set inventory to product
  public static void setInventory(String productName)
      throws IOException, InterruptedException {
    SetInventoryRequest setInventoryRequest = getSetInventoryRequest(
        productName);

    getProductServiceClient().setInventoryAsync(setInventoryRequest);

    /*
    This is a long running operation and its result is not immediately
    present with get operations,thus we simulate wait with sleep method.
    */
    System.out.println("Set inventory, wait 30 seconds.");

    getProductServiceClient().awaitTermination(30, TimeUnit.SECONDS);
  }

  // [END add_fulfillment_places]

  public static void main(String[] args)
      throws IOException, InterruptedException {
    createProduct(PRODUCT_ID);

    setInventory(PRODUCT_NAME);

    getProduct(PRODUCT_NAME);

    deleteProduct(PRODUCT_NAME);
  }
}
