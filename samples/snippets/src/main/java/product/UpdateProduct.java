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
 * [START retail_update_product]
 * Update product in a catalog using Retail API
 */

package product;

import com.google.cloud.retail.v2.PriceInfo;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.Product.Availability;
import com.google.cloud.retail.v2.Product.Type;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.retail.v2.ProductServiceSettings;
import com.google.cloud.retail.v2.UpdateProductRequest;

import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

import static product.setup.SetupCleanup.createProduct;
import static product.setup.SetupCleanup.deleteProduct;

public class UpdateProduct {

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

  // generate product for update
  public static Product generateProductForUpdate(String productId) {
    PriceInfo priceInfo = PriceInfo.newBuilder()
        .setPrice(12.0f)
        .setOriginalPrice(25.5f)
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

  // get update product request
  public static UpdateProductRequest getUpdateProductRequest(
      Product productToUpdate) {
    UpdateProductRequest updateProductRequest = UpdateProductRequest.newBuilder()
        .setProduct(productToUpdate)
        .setAllowMissing(true)
        .build();

    System.out.printf("Update product request: %s%n", updateProductRequest);

    return updateProductRequest;
  }

  // call the Retail API to update product
  public static Product updateProduct(Product originalProduct)
      throws IOException {
    Product updatedProduct = getProductServiceClient().updateProduct(
        getUpdateProductRequest(
            generateProductForUpdate(originalProduct.getId())));

    System.out.printf("Updated product: %s%n", updatedProduct);

    return updatedProduct;
  }

  // [END retail_update_product]

  public static void main(String[] args) throws IOException {
    Product createdProduct = createProduct(GENERATED_PRODUCT_ID);

    updateProduct(createdProduct);

    deleteProduct(createdProduct.getName());
  }

}
