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
 * [START retail_delete_product]
 * Delete product from a catalog using Retail API
 */

package product;

import com.google.cloud.retail.v2.DeleteProductRequest;
import com.google.cloud.retail.v2.ProductServiceClient;

import java.io.IOException;
import java.util.UUID;

import static setup.SetupCleanup.createProduct;

public final class DeleteProduct {

  /**
   * This variable describes project number getting from environment variable.
   */
  private static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  /**
   * This variable describes generated product id for field setting.
   */
  private static final String GENERATED_PRODUCT_ID = UUID.randomUUID()
      .toString();

  private DeleteProduct() {
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
   * Get delete product request.
   *
   * @param productName refers to product name.
   * @return DeleteProductRequest.
   */
  public static DeleteProductRequest getDeleteProductRequest(
      final String productName) {
    DeleteProductRequest deleteProductRequest =
        DeleteProductRequest.newBuilder()
            .setName(productName)
            .build();

    System.out.printf("Delete product request: %s%n", deleteProductRequest);

    return deleteProductRequest;
  }

  /**
   * Call the Retail API to delete product.
   *
   * @param productName refers to product name.
   * @throws IOException from the called method.
   */
  public static void deleteProduct(final String productName)
      throws IOException {
    DeleteProductRequest deleteProductRequest = getDeleteProductRequest(
        productName);

    getProductServiceClient().deleteProduct(deleteProductRequest);

    System.out.printf("Deleting product: %s%n", productName);

    System.out.println("Product was deleted.");
  }

  /**
   * Executable tutorial class.
   *
   * @param args command line arguments.
   */
  public static void main(final String[] args) throws IOException {
    deleteProduct(createProduct(GENERATED_PRODUCT_ID).getName());
  }
}

// [END retail_delete_product]
