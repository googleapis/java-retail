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
import com.google.cloud.retail.v2.ProductServiceSettings;

import java.io.IOException;
import java.util.UUID;

import static product.setup.SetupCleanup.createProduct;

public class DeleteProduct {

  public static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  public static final String ENDPOINT = "retail.googleapis.com:443";

  private static final String GENERATED_PRODUCT_ID = UUID.randomUUID()
      .toString();

  // Get product service client
  private static ProductServiceClient getProductServiceClient()
      throws IOException {
    ProductServiceSettings productServiceSettings =
        ProductServiceSettings.newBuilder()
            .setEndpoint(ENDPOINT)
            .build();
    return ProductServiceClient.create(productServiceSettings);
  }

  // Get delete product request
  public static DeleteProductRequest getDeleteProductRequest(
      String productName) {
    DeleteProductRequest deleteProductRequest = DeleteProductRequest.newBuilder()
        .setName(productName)
        .build();

    System.out.printf("Delete product request: %s%n", deleteProductRequest);

    return deleteProductRequest;
  }

  // Call the Retail API to delete product
  public static void deleteProduct(String productName) throws IOException {
    DeleteProductRequest deleteProductRequest = getDeleteProductRequest(
        productName);

    getProductServiceClient().deleteProduct(deleteProductRequest);

    System.out.printf("Deleting product: %s%n", productName);

    System.out.println("Product was deleted.");
  }

  // [END retail_delete_product]

  // Delete created product
  public static void main(String[] args) throws IOException {
    deleteProduct(createProduct(GENERATED_PRODUCT_ID).getName());
  }
}
