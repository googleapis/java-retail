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
 * [START retail_import_products_from_gcs]
 * Import products into a catalog from gcs using Retail API
 */

package product;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.retail.v2.GcsSource;
import com.google.cloud.retail.v2.ImportErrorsConfig;
import com.google.cloud.retail.v2.ImportMetadata;
import com.google.cloud.retail.v2.ImportProductsRequest;
import com.google.cloud.retail.v2.ImportProductsRequest.ReconciliationMode;
import com.google.cloud.retail.v2.ImportProductsResponse;
import com.google.cloud.retail.v2.ProductInputConfig;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.retail.v2.ProductServiceSettings;

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ImportProductsGcs {

  // Read the project number from the environment variable
  public static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  public static final String ENDPOINT = "retail.googleapis.com:443";

  // You can change the branch here. The "default_branch" is set to point to the branch "0"
  public static final String DEFAULT_CATALOG = String.format(
      "projects/%s/locations/global/catalogs/default_catalog/branches/default_branch",
      PROJECT_NUMBER);

  // Read bucket name from the environment variable
  public static final String GCS_BUCKET = String.format("gs://%s",
      System.getenv("BUCKET_NAME"));

  public static final String GCS_ERROR_BUCKET = String.format("%s/errors",
      GCS_BUCKET);

  public static final String GCS_PRODUCTS_OBJECT = "products.json";

  // TO CHECK ERROR HANDLING USE THE JSON WITH INVALID PRODUCT
  // GCS_PRODUCTS_OBJECT = "products_some_invalid.json"

  // get product service client
  private static ProductServiceClient getProductServiceClient()
      throws IOException {
    ProductServiceSettings productServiceSettings =
        ProductServiceSettings.newBuilder()
            .setEndpoint(ENDPOINT)
            .build();
    return ProductServiceClient.create(productServiceSettings);
  }

  // get import products from gcs request
  private static ImportProductsRequest getImportProductsGcsRequest(
      String gcsObjectName) {
    GcsSource gcsSource = GcsSource.newBuilder()
        .addAllInputUris(Collections.singleton(
            String.format("%s/%s", GCS_BUCKET, gcsObjectName)))
        .build();

    ProductInputConfig inputConfig = ProductInputConfig.newBuilder()
        .setGcsSource(gcsSource)
        .build();

    System.out.println("GRS source: " + gcsSource.getInputUrisList());

    ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder()
        .setGcsPrefix(GCS_ERROR_BUCKET)
        .build();

    ImportProductsRequest importRequest = ImportProductsRequest.newBuilder()
        .setParent(DEFAULT_CATALOG)
        .setReconciliationMode(ReconciliationMode.INCREMENTAL)
        .setInputConfig(inputConfig)
        .setErrorsConfig(errorsConfig)
        .build();

    System.out.println(
        "Import products from google cloud source request: " + importRequest);

    return importRequest;
  }

  // call the Retail API to import products
  public static void importProductsFromGcs()
      throws IOException, ExecutionException, InterruptedException {
    ImportProductsRequest importGcsRequest = getImportProductsGcsRequest(
        GCS_PRODUCTS_OBJECT);

    OperationFuture<ImportProductsResponse, ImportMetadata> gcsOperation =
        getProductServiceClient()
            .importProductsAsync(importGcsRequest);

    System.out.printf("The operation was started: %s%n",
        gcsOperation.getName());

    while (!gcsOperation.isDone()) {
      System.out.println("Please wait till operation is done");

      getProductServiceClient().awaitTermination(5, TimeUnit.SECONDS);

      System.out.println("Import products operation is done.");

      System.out.println(
          "Number of successfully imported products: "
              + gcsOperation.getMetadata().get()
              .getSuccessCount());
      System.out.println("Number of failures during the importing: "
          + gcsOperation.getMetadata().get().getFailureCount());
      System.out.println("Operation result: " + gcsOperation.get());

      // The imported products needs to be indexed in the catalog
      // before they become available for search.
      System.out.println(
          "Wait 2 -5 minutes till products become indexed in the catalog, "
              + "after that they will be available for search");
    }
  }

  // [END retail_import_products_from_gcs]

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    importProductsFromGcs();
  }
}
