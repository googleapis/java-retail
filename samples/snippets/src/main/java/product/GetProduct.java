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
 * [START retail_get_product]
 * Get product from a catalog using Retail API
 */

package product;

import com.google.cloud.retail.v2.GetProductRequest;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.ProductServiceClient;

import java.io.IOException;
import java.util.UUID;

import static setup.SetupCleanup.createProduct;
import static setup.SetupCleanup.deleteProduct;

public final class GetProduct {

  /**
   * This variable describes project number getting from environment variable.
   */
  private static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  /**
   * This variable describes generated product id for field setting.
   */
  private static final String GENERATED_PRODUCT_ID = UUID.randomUUID()
      .toString();

  private GetProduct() {
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
   * Get product request.
   *
   * @param productName refers to product name.
   * @return GetProductRequest.
   */
  public static GetProductRequest getProductRequest(final String productName) {
    GetProductRequest getProductRequest = GetProductRequest.newBuilder()
        .setName(productName)
        .build();
    System.out.printf("Get product request: %s%n", getProductRequest);

    return getProductRequest;
  }

  /**
   * Call the Retail API to get product.
   *
   * @param productName refers to product name.
   * @return Product.
   * @throws IOException from the called method.
   */
  public static Product getProduct(final String productName)
      throws IOException {
    GetProductRequest getRequest = getProductRequest(productName);

    Product getProductResponse = getProductServiceClient().getProduct(
        getRequest);

    System.out.printf("Get product response: %s%n", getProductResponse);

    return getProductResponse;
  }

  /**
   * Executable tutorial class.
   *
   * @param args command line arguments.
   */
  public static void main(final String[] args) throws IOException {
    Product createdProduct = createProduct(GENERATED_PRODUCT_ID);

    Product product = getProduct(createdProduct.getName());

    deleteProduct(product.getName());
  }
}

// [END retail_get_product]
