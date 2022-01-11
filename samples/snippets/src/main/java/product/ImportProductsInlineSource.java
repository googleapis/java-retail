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
 * [START retail_import_products_from_inline_source]
 * Import products into a catalog from inline source using Retail API
 */

package product;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.retail.v2.ColorInfo;
import com.google.cloud.retail.v2.FulfillmentInfo;
import com.google.cloud.retail.v2.ImportMetadata;
import com.google.cloud.retail.v2.ImportProductsRequest;
import com.google.cloud.retail.v2.ImportProductsResponse;
import com.google.cloud.retail.v2.PriceInfo;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.ProductInlineSource;
import com.google.cloud.retail.v2.ProductInputConfig;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.retail.v2.ProductServiceSettings;
import com.google.protobuf.FieldMask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ImportProductsInlineSource {

  /**
   * This variable describes project number getting from environment variable.
   */
  private static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  /**
   * This variable describes endpoint for send requests.
   */
  private static final String ENDPOINT = "retail.googleapis.com:443";

  /**
   * This variable describes default catalog name.
   */
  private static final String DEFAULT_CATALOG = String.format(
      "projects/%s/locations/global/catalogs/default_catalog/branches/default_branch",
      PROJECT_NUMBER);

  /**
   * This variable describes generated product id for field setting.
   */
  private static final String GENERATED_PRODUCT_ID = UUID.randomUUID()
      .toString();

  /**
   * Get product service client.
   *
   * @return ProductServiceClient.
   * @throws IOException if endpoint is incorrect.
   */
  private static ProductServiceClient getProductServiceClient()
      throws IOException {
    ProductServiceSettings productServiceSettings =
        ProductServiceSettings.newBuilder()
            .setEndpoint(ENDPOINT)
            .build();
    return ProductServiceClient.create(productServiceSettings);
  }

  /**
   * Prepare product to import as inline source.
   *
   * @return List of products.
   */
  public static List<Product> getProducts() {
    List<Product> products = new ArrayList<>();

    Product product1;
    Product product2;

    PriceInfo priceInfo1 = PriceInfo.newBuilder()
        .setPrice(16f)
        .setOriginalPrice(45.0f)
        .setCost(12.0f)
        .setCurrencyCode("USD")
        .build();

    ColorInfo colorInfo1 = ColorInfo.newBuilder()
        .addColorFamilies("Blue")
        .addAllColors(Arrays.asList("Light blue", "Blue", "Dark blue"))
        .build();

    FulfillmentInfo fulfillmentInfo1 = FulfillmentInfo.newBuilder()
        .setType("pickup-in-store")
        .addAllPlaceIds(Arrays.asList("store1", "store2"))
        .build();

    FieldMask fieldMask1 = FieldMask.newBuilder()
        .addAllPaths(
            Arrays.asList("title", "categories", "price_info", "color_info"))
        .build();

    // TO CHECK ERROR HANDLING COMMENT OUT THE PRODUCT TITLE HERE:
    product1 = Product.newBuilder()
        .setTitle("#IamRemarkable Pen")
        .setId(GENERATED_PRODUCT_ID)
        .addAllCategories(Collections.singletonList("Office"))
        .setUri(
            "https://shop.googlemerchandisestore.com/Google+Redesign/Office/IamRemarkable+Pen")
        .addBrands("#IamRemarkable")
        .setPriceInfo(priceInfo1)
        .setColorInfo(colorInfo1)
        .addFulfillmentInfo(fulfillmentInfo1)
        .setRetrievableFields(fieldMask1)
        .build();

    PriceInfo priceInfo2 = PriceInfo.newBuilder()
        .setPrice(35f)
        .setOriginalPrice(45.0f)
        .setCost(12.0f)
        .setCurrencyCode("USD")
        .build();

    ColorInfo colorInfo2 = ColorInfo.newBuilder()
        .addColorFamilies("Blue")
        .addAllColors(Collections.singletonList("Sky blue"))
        .build();

    FulfillmentInfo fulfillmentInfo2 = FulfillmentInfo.newBuilder()
        .setType("pickup-in-store")
        .addAllPlaceIds(Arrays.asList("store2", "store3"))
        .build();

    FieldMask fieldMask2 = FieldMask.newBuilder()
        .addAllPaths(
            Arrays.asList("title", "categories", "price_info", "color_info"))
        .build();

    product2 = Product.newBuilder()
        .setTitle("Android Embroidered Crewneck Sweater")
        .setId(GENERATED_PRODUCT_ID)
        .addCategories("Apparel")
        .setUri(
            "https://shop.googlemerchandisestore.com/Google+Redesign/Apparel/Android+Embroidered+Crewneck+Sweater")
        .addBrands("Android")
        .setPriceInfo(priceInfo2)
        .setColorInfo(colorInfo2)
        .addFulfillmentInfo(fulfillmentInfo2)
        .setRetrievableFields(fieldMask2)
        .build();

    products.add(product1);
    products.add(product2);

    return products;
  }

  /**
   * Get import products from inline source request.
   *
   * @param productsToImport List of products to import.
   * @return ImportProductsRequest.
   */
  public static ImportProductsRequest getImportProductsInlineRequest(
      final List<Product> productsToImport) {
    // TO CHECK ERROR HANDLING PASTE THE INVALID CATALOG NAME HERE:
    // default_catalog = "invalid_catalog_name"

    ProductInlineSource inlineSource = ProductInlineSource.newBuilder()
        .addAllProducts(productsToImport)
        .build();

    ProductInputConfig inputConfig = ProductInputConfig.newBuilder()
        .setProductInlineSource(inlineSource)
        .build();

    ImportProductsRequest importRequest = ImportProductsRequest.newBuilder()
        .setParent(DEFAULT_CATALOG)
        .setInputConfig(inputConfig)
        .build();

    System.out.printf("Import products from inline source request: %s%n",
        importRequest);

    return importRequest;
  }

  /**
   * Call the Retail API to import products.
   *
   * @throws IOException          from the called method.
   * @throws ExecutionException   when attempting to retrieve the result of a
   *                              task that aborted by throwing an exception.
   * @throws InterruptedException when a thread is waiting, sleeping, or
   *                              otherwise occupied, and the thread is
   *                              interrupted, either before or during the
   *                              activity.
   */
  public static void importProductsFromInlineSource()
      throws IOException, ExecutionException, InterruptedException {
    ImportProductsRequest importRequest = getImportProductsInlineRequest(
        getProducts());

    OperationFuture<ImportProductsResponse, ImportMetadata> importOperation =
        getProductServiceClient().importProductsAsync(importRequest);

    System.out.printf("The operation was started: %s%n",
        importOperation.getName());

    while (!importOperation.isDone()) {
      System.out.println("Please wait till operation is done.");

      getProductServiceClient().awaitTermination(5, TimeUnit.SECONDS);

      System.out.println("Import products operation is done.");

      System.out.printf("Number of successfully imported products: %s%n",
          importOperation.getMetadata().get().getSuccessCount());

      System.out.printf("Number of failures during the importing: %s%n",
          importOperation.getMetadata().get().getFailureCount());

      System.out.printf("Operation result: %s%n", importOperation.get());
    }
  }

  /**
   * Executable tutorial class.
   */
  public static void main(final String[] args)
      throws IOException, ExecutionException, InterruptedException {
    importProductsFromInlineSource();
  }
}

// [END retail_import_products_from_inline_source]
