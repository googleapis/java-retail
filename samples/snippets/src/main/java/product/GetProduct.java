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
 * [START retail_get_product]
 * Get product from a catalog using Retail API
 */

package product;

import com.google.cloud.retail.v2.GetProductRequest;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.retail.v2.ProductServiceSettings;

import java.io.IOException;
import java.util.UUID;

import static product.setup.SetupCleanup.createProduct;
import static product.setup.SetupCleanup.deleteProduct;

public class GetProduct {

  public static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  public static final String ENDPOINT = "retail.googleapis.com:443";

  private static final String PRODUCT_ID = UUID.randomUUID().toString();

  // Get product service client
  private static ProductServiceClient getProductServiceClient()
      throws IOException {
    ProductServiceSettings productServiceSettings =
        ProductServiceSettings.newBuilder()
            .setEndpoint(ENDPOINT)
            .build();
    return ProductServiceClient.create(productServiceSettings);
  }

  // Get product request
  public static GetProductRequest getProductRequest(String productName) {
    GetProductRequest getProductRequest = GetProductRequest.newBuilder()
        .setName(productName)
        .build();
    System.out.printf("Get product request: %s%n", getProductRequest);

    return getProductRequest;
  }

  // Call the Retail API to get product
  public static Product getProduct(String productName) throws IOException {
    GetProductRequest getRequest = getProductRequest(productName);

    Product getProductResponse = getProductServiceClient().getProduct(
        getRequest);

    System.out.printf("Get product response: %s%n", getProductResponse);

    return getProductResponse;
  }

  // [END retail_get_product]

  public static void main(String[] args) throws IOException {
    Product createdProduct = createProduct(PRODUCT_ID);

    Product product = getProduct(createdProduct.getName());

    deleteProduct(product.getName());
  }
}
