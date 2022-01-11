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
import com.google.cloud.retail.v2.ProductServiceSettings;

import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

import static product.setup.SetupCleanup.deleteProduct;

public class CreateProduct {

  public static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  public static final String ENDPOINT = "retail.googleapis.com:443";

  public static final String DEFAULT_BRANCH_NAME = String.format(
      "projects/%s/locations/global/catalogs/default_catalog/branches/default_branch",
      PROJECT_NUMBER);

  private static final String GENERATED_PRODUCT_ID = UUID.randomUUID()
      .toString();

  // get product service client
  private static ProductServiceClient getProductServiceClient()
      throws IOException {
    ProductServiceSettings productServiceSettings =
        ProductServiceSettings.newBuilder()
            .setEndpoint(ENDPOINT)
            .build();
    return ProductServiceClient.create(productServiceSettings);
  }

  // generate product to create
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

  // get create product request
  public static CreateProductRequest getCreateProductRequest(
          Product productToCreate, String productId) {
    CreateProductRequest createProductRequest = CreateProductRequest.newBuilder()
        .setProduct(productToCreate)
        .setProductId(productId)
        .setParent(DEFAULT_BRANCH_NAME)
        .build();

    System.out.printf("Create product request: %s%n", createProductRequest);

    return createProductRequest;
  }

  // call the Retail API to create product
  public static Product createProduct(String productId) throws IOException {
    CreateProductRequest createProductRequest = getCreateProductRequest(
        generateProduct(), productId);

    Product productCreated = getProductServiceClient().createProduct(
        createProductRequest);

    System.out.printf("Created product: %s%n", productCreated);

    return productCreated;
  }

  // [END retail_create_product]

  public static void main(String[] args) throws IOException {
    Product createdProduct = createProduct(GENERATED_PRODUCT_ID);

    deleteProduct(createdProduct.getName());
  }
}
