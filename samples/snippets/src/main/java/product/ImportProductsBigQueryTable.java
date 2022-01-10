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
 * [START retail_import_products_from_big_query]
 * Import products into a catalog from big query table using Retail API
 */

package product;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.retail.v2.BigQuerySource;
import com.google.cloud.retail.v2.ImportMetadata;
import com.google.cloud.retail.v2.ImportProductsRequest;
import com.google.cloud.retail.v2.ImportProductsRequest.ReconciliationMode;
import com.google.cloud.retail.v2.ImportProductsResponse;
import com.google.cloud.retail.v2.ProductInputConfig;
import com.google.cloud.retail.v2.ProductServiceClient;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public final class ImportProductsBigQueryTable {

  /**
   * This variable describes project number getting from environment variable.
   */
  private static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  /**
   * This variable describes project id getting from environment variable.
   */
  private static final String PROJECT_ID = System.getenv("PROJECT_ID");

  /**
   * This variable describes default catalog name.
   */
  private static final String DEFAULT_CATALOG = String.format(
      "projects/%s/locations/global/catalogs/default_catalog/"
          + "branches/default_branch", PROJECT_NUMBER);

  /**
   * This variable describes dataset id.
   */
  private static final String DATASET_ID = "products";

  /**
   * This variable describes table id.
   */
  private static final String TABLE_ID = "products";

  /**
   * This variable describes data schema.
   */
  private static final String DATA_SCHEMA = "product";

  /* TO CHECK ERROR HANDLING USE THE TABLE WITH INVALID PRODUCTS:
     TABLE_ID = "products_some_invalid"
  */

  private ImportProductsBigQueryTable() {
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
   * Get import products from big query request.
   *
   * @param reconciliationMode enum variable describes reconciliation.
   * @return ImportProductsRequest.
   */
  public static ImportProductsRequest getImportProductsBigQueryRequest(
      final ReconciliationMode reconciliationMode) {
      /* TO CHECK ERROR HANDLING PASTE THE INVALID CATALOG NAME HERE:
         DEFAULT_CATALOG = "invalid_catalog_name"
      */
    BigQuerySource bigQuerySource = BigQuerySource.newBuilder()
        .setProjectId(PROJECT_ID)
        .setDatasetId(DATASET_ID)
        .setTableId(TABLE_ID)
        .setDataSchema(DATA_SCHEMA)
        .build();

    ProductInputConfig inputConfig = ProductInputConfig.newBuilder()
        .setBigQuerySource(bigQuerySource)
        .build();

    ImportProductsRequest importRequest = ImportProductsRequest.newBuilder()
        .setParent(DEFAULT_CATALOG)
        .setReconciliationModeValue(reconciliationMode.getNumber())
        .setInputConfig(inputConfig)
        .build();

    System.out.printf("Import products from big query table request: %s%n",
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
  public static void importProductsFromBigQuery()
      throws IOException, ExecutionException, InterruptedException {
    // TRY THE FULL RECONCILIATION MODE HERE:
    ReconciliationMode reconciliationMode = ReconciliationMode.INCREMENTAL;

    ImportProductsRequest importBigQueryRequest =
        getImportProductsBigQueryRequest(reconciliationMode);

    OperationFuture<ImportProductsResponse, ImportMetadata> bigQueryOperation =
        getProductServiceClient().importProductsAsync(importBigQueryRequest);

    System.out.printf("The operation was started: %s%n",
        bigQueryOperation.getName());

    while (!bigQueryOperation.isDone()) {
      System.out.println("Please wait till operation is done.");

      final int awaitDuration = 5;

      getProductServiceClient().awaitTermination(
          awaitDuration, TimeUnit.SECONDS);

      System.out.println("Import products operation is done.");

      if (bigQueryOperation.getMetadata().get() != null) {
        System.out.printf("Number of successfully imported products: %s%n",
            bigQueryOperation.getMetadata().get().getSuccessCount());

        System.out.printf("Number of failures during the importing: %s%n",
            bigQueryOperation.getMetadata().get().getFailureCount());
      } else {
        System.out.println("Metadata in bigQuery operation is empty.");
      }
      if (bigQueryOperation.get() != null) {
        System.out.printf("Operation result: %s%n", bigQueryOperation.get());
      } else {
        System.out.println("Operation result is empty.");
      }
    }
  }

  /**
   * Executable tutorial class.
   *
   * @param args command line arguments.
   */
  public static void main(final String[] args)
      throws IOException, ExecutionException, InterruptedException {
    importProductsFromBigQuery();
  }
}

// [END retail_import_products_from_big_query]
