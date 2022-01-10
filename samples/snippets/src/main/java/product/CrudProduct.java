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
 * [START retail_crud_product]
 * Create product in a catalog using Retail API
 */

package product;

import static setup.SetupCleanup.tryToDeleteProductIfExists;

import com.google.cloud.retail.v2.CreateProductRequest;
import com.google.cloud.retail.v2.DeleteProductRequest;
import com.google.cloud.retail.v2.GetProductRequest;
import com.google.cloud.retail.v2.PriceInfo;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.Product.Availability;
import com.google.cloud.retail.v2.Product.Type;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.retail.v2.UpdateProductRequest;

import java.io.IOException;
import java.util.Collections;

public final class CrudProduct {

  /**
   * This variable describes project number getting from environment variable.
   */
  private static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  /**
   * This variable describes defined product id for field setting.
   */
  private static final String PRODUCT_ID = "crud_product_id";

  /**
   * This variable describes default branch name.
   */
  private static final String DEFAULT_BRANCH_NAME = String.format(
      "projects/%s/locations/global/catalogs/default_catalog/"
          + "branches/default_branch", PROJECT_NUMBER);

  /**
   * This variable describes product name.
   */
  private static final String PRODUCT_NAME = String.format("%s/products/%s",
      DEFAULT_BRANCH_NAME, PRODUCT_ID);

  private CrudProduct() {
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
   * Generate product for create.
   *
   * @return Product.
   */
  public static Product generateProduct() {

    final float price = 30.0f;
    final float originalPrice = 35.5f;

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
   * Generate product for update.
   *
   * @return Product.
   */
  public static Product generateProductForUpdate() {

    final float price = 20.0f;
    final float originalPrice = 25.5f;

    PriceInfo priceInfo = PriceInfo.newBuilder()
        .setPrice(price)
        .setOriginalPrice(originalPrice)
        .setCurrencyCode("EUR")
        .build();

    return Product.newBuilder()
        .setId(PRODUCT_ID)
        .setName(PRODUCT_NAME)
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
   * Create product.
   *
   * @return Product.
   * @throws IOException from the called method.
   */
  public static Product createProduct() throws IOException {
    CreateProductRequest createProductRequest =
        CreateProductRequest.newBuilder()
            .setProduct(generateProduct())
            .setProductId(PRODUCT_ID)
            .setParent(DEFAULT_BRANCH_NAME)
            .build();

    System.out.printf("Create product request: %s%n", createProductRequest);

    Product productCreated = getProductServiceClient().createProduct(
        createProductRequest);

    System.out.printf("Created product: %s%n", productCreated);

    return productCreated;
  }

  /**
   * Get product.
   *
   * @return Product.
   * @throws IOException from the called method.
   */
  public static Product getProduct() throws IOException {
    GetProductRequest getProductRequest = GetProductRequest.newBuilder()
        .setName(PRODUCT_NAME)
        .build();

    System.out.printf("Get product request: %s%n", getProductRequest);

    Product getProductResponse = getProductServiceClient().getProduct(
        getProductRequest);

    System.out.printf("Get product response: %s%n", getProductResponse);

    return getProductResponse;
  }

  /**
   * Update product.
   *
   * @return Product.
   * @throws IOException from the called method.
   */
  public static Product updateProduct() throws IOException {
    UpdateProductRequest updateProductRequest =
        UpdateProductRequest.newBuilder()
            .setProduct(generateProductForUpdate())
            .setAllowMissing(true)
            .build();

    System.out.printf("Update product request: %s%n", updateProductRequest);

    Product updatedProduct = getProductServiceClient().updateProduct(
        updateProductRequest);

    System.out.printf("Updated product: %s%n", updatedProduct);

    return updatedProduct;
  }

  /**
   * Delete product.
   *
   * @throws IOException from the called method.
   */
  public static void deleteProduct() throws IOException {
    DeleteProductRequest deleteProductRequest =
        DeleteProductRequest.newBuilder()
            .setName(PRODUCT_NAME)
            .build();

    System.out.printf("Delete product request: %s%n", deleteProductRequest);

    getProductServiceClient().deleteProduct(deleteProductRequest);

    System.out.printf("Deleting product: %s%n", PRODUCT_NAME);

    System.out.println("Product was deleted.");
  }

  /**
   * Executable tutorial class.
   *
   * @param args command line arguments.
   */
  public static void main(final String[] args) throws IOException {
    tryToDeleteProductIfExists(PRODUCT_NAME);

    createProduct();

    getProduct();

    updateProduct();

    deleteProduct();
  }
}

// [END retail_crud_product]
