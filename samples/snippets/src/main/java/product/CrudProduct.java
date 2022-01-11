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

import com.google.cloud.retail.v2.CreateProductRequest;
import com.google.cloud.retail.v2.DeleteProductRequest;
import com.google.cloud.retail.v2.GetProductRequest;
import com.google.cloud.retail.v2.PriceInfo;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.Product.Availability;
import com.google.cloud.retail.v2.Product.Type;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.retail.v2.ProductServiceSettings;
import com.google.cloud.retail.v2.UpdateProductRequest;

import java.io.IOException;
import java.util.Collections;

public class CrudProduct {

  public static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  public static final String ENDPOINT = "retail.googleapis.com:443";

  public static final String PRODUCT_ID = "crud_product_id";

  public static final String DEFAULT_BRANCH_NAME = String.format(
      "projects/%s/locations/global/catalogs/default_catalog/branches/default_branch",
      PROJECT_NUMBER);

  public static final String PRODUCT_NAME = String.format("%s/products/%s",
      DEFAULT_BRANCH_NAME, PRODUCT_ID);

  // Get product service client
  private static ProductServiceClient getProductServiceClient()
      throws IOException {
    ProductServiceSettings productServiceSettings =
        ProductServiceSettings.newBuilder()
            .setEndpoint(ENDPOINT)
            .build();
    return ProductServiceClient.create(productServiceSettings);
  }

  // Generate product for create
  public static Product generateProduct() {
    PriceInfo priceInfo = PriceInfo.newBuilder()
        .setPrice(30.0f)
        .setOriginalPrice(35.5f)
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

  // Generate product for update
  public static Product generateProductForUpdate() {
    PriceInfo priceInfo = PriceInfo.newBuilder()
        .setPrice(20.0f)
        .setOriginalPrice(25.5f)
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

  // Create product
  public static Product createProduct() throws IOException {
    CreateProductRequest createProductRequest = CreateProductRequest.newBuilder()
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

  // Get product
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

  // Update product
  public static Product updateProduct() throws IOException {
    UpdateProductRequest updateProductRequest = UpdateProductRequest.newBuilder()
        .setProduct(generateProductForUpdate())
        .setAllowMissing(true)
        .build();

    System.out.printf("Update product request: %s%n", updateProductRequest);

    Product updatedProduct = getProductServiceClient().updateProduct(
        updateProductRequest);

    System.out.printf("Updated product: %s%n", updatedProduct);

    return updatedProduct;
  }

  // Delete product
  public static void deleteProduct() throws IOException {
    DeleteProductRequest deleteProductRequest = DeleteProductRequest.newBuilder()
        .setName(PRODUCT_NAME)
        .build();

    System.out.printf("Delete product request: %s%n", deleteProductRequest);

    getProductServiceClient().deleteProduct(deleteProductRequest);

    System.out.printf("Deleting product: %s%n", PRODUCT_NAME);

    System.out.println("Product was deleted.");
  }

// [END retail_crud_product]

  public static void main(String[] args) throws IOException {
    createProduct();

    getProduct();

    updateProduct();

    deleteProduct();
  }
}
