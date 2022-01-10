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
 * [START retail_create_product]
 * Create product in a catalog using Retail API
 */

package product;

import com.google.cloud.retail.v2.CreateProductRequest;
import com.google.cloud.retail.v2.PriceInfo;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.Product.Availability;
import com.google.cloud.retail.v2.Product.Type;
import com.google.cloud.retail.v2.ProductServiceClient;

import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

import static setup.SetupCleanup.deleteProduct;

public final class CreateProduct {

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

  private CreateProduct() {
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
   * Generate product to create.
   *
   * @return generated Product.
   */
  public static Product generateProduct() {

    final float originalPrice = 35.5f;
    final float price = 30.0f;

    PriceInfo priceInfo = PriceInfo.newBuilder()
        .setPrice(price)
        .setOriginalPrice(originalPrice)
        .setCurrencyCode("USD")
        .build();

    return Product.newBuilder()
        .setTitle("Nest Mini")
        .setType(Type.PRIMARY)
        .addAllCategories(Collections.singletonList("Speakers and displays"))
        .addBrands("Google")
        .setPriceInfo(priceInfo)
        .setAvailability(Availability.IN_STOCK)
        .build();
  }

  /**
   * Get create product request.
   *
   * @param productToCreate product object for create.
   * @param productId       id of product.
   * @return CreateProductRequest.
   */
  public static CreateProductRequest getCreateProductRequest(
      final Product productToCreate, final String productId) {
    CreateProductRequest createProductRequest =
        CreateProductRequest.newBuilder()
            .setProduct(productToCreate)
            .setProductId(productId)
            .setParent(DEFAULT_BRANCH_NAME)
            .build();

    System.out.printf("Create product request: %s%n", createProductRequest);

    return createProductRequest;
  }

  /**
   * Call the Retail API to create product.
   *
   * @param productId id of product.
   * @return Product
   * @throws IOException from the called method.
   */
  public static Product createProduct(final String productId)
      throws IOException {
    CreateProductRequest createProductRequest = getCreateProductRequest(
        generateProduct(), productId);

    Product productCreated = getProductServiceClient().createProduct(
        createProductRequest);

    System.out.printf("Created product: %s%n", productCreated);

    return productCreated;
  }

  /**
   * Executable tutorial class.
   *
   * @param args command line arguments.
   */
  public static void main(final String[] args) throws IOException {
    Product createdProduct = createProduct(GENERATED_PRODUCT_ID);

    deleteProduct(createdProduct.getName());
  }
}

// [END retail_create_product]
