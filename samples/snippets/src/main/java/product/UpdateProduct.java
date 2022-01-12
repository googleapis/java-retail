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
 * [START retail_update_product]
 * Update product in a catalog using Retail API
 */

package product;

import com.google.cloud.retail.v2.PriceInfo;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.Product.Availability;
import com.google.cloud.retail.v2.Product.Type;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.retail.v2.UpdateProductRequest;

import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

import static setup.SetupCleanup.createProduct;
import static setup.SetupCleanup.deleteProduct;

public final class UpdateProduct {

  /**
   * This variable describes project number getting from environment variable.
   */
  private static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  /**
   * This variable describes a default branch name.
   */
  private static final String DEFAULT_BRANCH_NAME = String.format(
      "projects/%s/locations/global/catalogs/default_catalog/"
          + "branches/default_branch", PROJECT_NUMBER);

  /**
   * This variable describes generated product id for field setting.
   */
  private static final String GENERATED_PRODUCT_ID = UUID.randomUUID()
      .toString();

  private UpdateProduct() {
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
   * Generate product for update.
   *
   * @param productId id of product.
   * @return Product.
   */
  public static Product generateProductForUpdate(final String productId) {

    final float price = 12.0f;
    final float originalPrice = 25.5f;

    PriceInfo priceInfo = PriceInfo.newBuilder()
        .setPrice(price)
        .setOriginalPrice(originalPrice)
        .setCurrencyCode("EUR")
        .build();

    return Product.newBuilder()
        .setId(productId)
        .setName(
            String.format("%s/products/%s", DEFAULT_BRANCH_NAME, productId))
        .setTitle("Updated Nest Mini")
        .setType(Type.PRIMARY)
        .addAllCategories(
            Collections.singletonList("Updated Speakers and displays"))
        .addAllBrands(Collections.singletonList("Updated Google"))
        .setAvailability(Availability.OUT_OF_STOCK)
        .setPriceInfo(priceInfo)
        .build();
  }

  /**
   * Get update product request.
   *
   * @param productToUpdate product to update.
   * @return UpdateProductRequest.
   */
  public static UpdateProductRequest getUpdateProductRequest(
      final Product productToUpdate) {
    UpdateProductRequest updateProductRequest =
        UpdateProductRequest.newBuilder()
            .setProduct(productToUpdate)
            .setAllowMissing(true)
            .build();

    System.out.printf("Update product request: %s%n", updateProductRequest);

    return updateProductRequest;
  }

  /**
   * Call the Retail API to update product.
   *
   * @param originalProduct product to update.
   * @throws IOException from the called method.
   */
  public static void updateProduct(final Product originalProduct)
      throws IOException {
    Product updatedProduct = getProductServiceClient().updateProduct(
        getUpdateProductRequest(
            generateProductForUpdate(originalProduct.getId())));

    System.out.printf("Updated product: %s%n", updatedProduct);
  }

  /**
   * Executable tutorial class.
   *
   * @param args command line arguments.
   */
  public static void main(final String[] args) throws IOException {
    Product createdProduct = createProduct(GENERATED_PRODUCT_ID);

    updateProduct(createdProduct);

    deleteProduct(createdProduct.getName());
  }
}

// [END retail_update_product]
