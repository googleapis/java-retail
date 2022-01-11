/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package product.setup;

import com.google.api.gax.paging.Page;
import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetListOption;
import com.google.cloud.bigquery.BigQuery.TableListOption;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.FormatOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.LoadJobConfiguration;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.retail.v2.CreateProductRequest;
import com.google.cloud.retail.v2.DeleteProductRequest;
import com.google.cloud.retail.v2.FulfillmentInfo;
import com.google.cloud.retail.v2.GetProductRequest;
import com.google.cloud.retail.v2.PriceInfo;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.Product.Availability;
import com.google.cloud.retail.v2.Product.Type;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.retail.v2.ProductServiceSettings;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static com.google.cloud.storage.StorageClass.STANDARD;

public class SetupCleanup {

  public static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");
  public static final String PROJECT_ID = System.getenv("PROJECT_ID");
  public static final String ENDPOINT = "retail.googleapis.com:443";
  public static final String DEFAULT_BRANCH_NAME = String.format(
      "projects/%s/locations/global/catalogs/default_catalog/branches/default_branch",
      PROJECT_NUMBER);

  public static final Storage storage = StorageOptions.newBuilder()
      .setProjectId(PROJECT_NUMBER)
      .build().getService();

  private static ProductServiceClient getProductServiceClient()
      throws IOException {
    ProductServiceSettings productServiceSettings = ProductServiceSettings.newBuilder()
        .setEndpoint(ENDPOINT)
        .build();
    return ProductServiceClient.create(productServiceSettings);
  }

  public static Product generateProduct() {
    PriceInfo priceInfo = PriceInfo.newBuilder()
        .setPrice(30.0f)
        .setOriginalPrice(35.5f)
        .setCurrencyCode("USD")
        .build();

    FulfillmentInfo fulfillmentInfo = FulfillmentInfo.newBuilder()
        .setType("pickup-in-store")
        .addAllPlaceIds(Arrays.asList("store0", "store1"))
        .build();

    return Product.newBuilder()
        .setTitle("Nest Mini")
        .setType(Type.PRIMARY)
        .addCategories("Speakers and displays")
        .addBrands("Google")
        .setPriceInfo(priceInfo)
        .addFulfillmentInfo(fulfillmentInfo)
        .setAvailability(Availability.IN_STOCK)
        .build();
  }

  public static Product createProduct(String productId) throws IOException {
    CreateProductRequest createProductRequest = CreateProductRequest.newBuilder()
        .setProduct(generateProduct())
        .setProductId(productId)
        .setParent(DEFAULT_BRANCH_NAME)
        .build();

    Product product = getProductServiceClient().createProduct(
        createProductRequest);

    System.out.println("Product is created: " + product);

    return product;
  }

  public static void deleteProduct(String productName) throws IOException {
    DeleteProductRequest deleteProductRequest = DeleteProductRequest.newBuilder()
        .setName(productName)
        .build();

    getProductServiceClient().deleteProduct(deleteProductRequest);

    System.out.printf("Product %s was deleted.%n", productName);
  }

  public static Product getProduct(String productName) throws IOException {
    Product product = Product.newBuilder()
        .build();

    GetProductRequest getProductRequest = GetProductRequest.newBuilder()
        .setName(productName)
        .build();

    try {
      product = getProductServiceClient().getProduct(getProductRequest);

      System.out.println("Get product response: " + product);

      return product;
    } catch (NotFoundException e) {
      System.out.printf("Product %s not found", productName);
      return product;
    }
  }

  public static void createBucket(String bucketName) {
    Storage storage = StorageOptions.newBuilder()
        .setProjectId(PROJECT_ID)
        .build().getService();

    Bucket bucket = storage.create(
        BucketInfo.newBuilder(bucketName)
            .setStorageClass(STANDARD)
            .setLocation("US")
            .build());

    System.out.println(
        "Created bucket "
            + bucket.getName()
            + " in "
            + bucket.getLocation()
            + " with storage class "
            + bucket.getStorageClass());
  }

  public static Page<Bucket> listBuckets() {
    Page<Bucket> bucketList = storage.list();

    for (Bucket bucket : bucketList.iterateAll()) {
      System.out.println(bucket.getName());
    }

    return bucketList;
  }

  public static void uploadObject(String bucketName, String objectName,
      String filePath) throws IOException {
    Storage storage = StorageOptions.newBuilder().setProjectId(PROJECT_NUMBER)
        .build().getService();

    BlobId blobId = BlobId.of(bucketName, objectName);

    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();

    storage.create(blobInfo, Files.readAllBytes(Paths.get(filePath)));

    System.out.println(
        "File " + filePath + " uploaded to bucket " + bucketName + " as "
            + objectName);
  }

  public static void createBqDataset(String datasetName) {
    try {
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      DatasetInfo datasetInfo = DatasetInfo.newBuilder(datasetName).build();

      Dataset newDataset = bigquery.create(datasetInfo);

      String newDatasetName = newDataset.getDatasetId().getDataset();

      System.out.println(newDatasetName + " created successfully");
    } catch (BigQueryException e) {
      System.out.printf("Dataset '%s' already exists.%n", datasetName);
    }
  }

  public static void listBqDatasets() {
    try {
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      Page<Dataset> datasets = bigquery.listDatasets(PROJECT_ID,
                                                     DatasetListOption.pageSize(100));
      if (datasets == null) {
        System.out.println("Dataset does not contain any models");
        return;
      }
      datasets
          .iterateAll()
          .forEach(
              dataset -> System.out.printf("Success! Dataset ID: %s ",
                  dataset.getDatasetId()));
    } catch (BigQueryException e) {
      System.out.println(
          "Project does not contain any datasets. " + e);
    }
  }

  public static void createBqTable(String datasetName,
      String tableName, Schema schema) {
    try {
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      TableId tableId = TableId.of(datasetName, tableName);
      TableDefinition tableDefinition = StandardTableDefinition.of(schema);
      TableInfo tableInfo = TableInfo.newBuilder(tableId, tableDefinition)
          .build();

      bigquery.create(tableInfo);
      System.out.printf("Table '%s' created successfully.%n", tableName);
    } catch (BigQueryException e) {
      System.out.printf("Table '%s' already exists.%n", tableName);
    }
  }

  public static Page<Table> listBqTables(String datasetName) {
    Page<Table> tables = null;

    try {
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      DatasetId datasetId = DatasetId.of(PROJECT_ID, datasetName);
      tables = bigquery.listTables(datasetId,
          TableListOption.pageSize(100));
      tables.iterateAll().forEach(
          table -> System.out.print(table.getTableId().getTable() + "\n"));

      System.out.println("Tables listed successfully.");
    } catch (BigQueryException e) {
      System.out.println("Tables were not listed. Error occurred: " + e);
    }

    return tables;
  }

  public static void uploadDataToBqTable(String datasetName, String tableName,
      String sourceUri, Schema schema) {
    try {
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      TableId tableId = TableId.of(datasetName, tableName);
      LoadJobConfiguration loadConfig =
          LoadJobConfiguration.newBuilder(tableId, sourceUri)
              .setFormatOptions(FormatOptions.json())
              .setSchema(schema)
              .build();

      // Load data from a GCS JSON file into the table
      Job job = bigquery.create(JobInfo.of(loadConfig));
      // Blocks until this load table job completes its execution,
      // either failing or succeeding.
      job = job.waitFor();
      if (job.isDone()) {
        System.out.printf(
            "Json from GCS successfully loaded in a table '%s'.%n",
            tableName);
      } else {
        System.out.println(
            "BigQuery was unable to load into the table due to an error:"
                + job.getStatus().getError());
      }
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Column not added during load append \n" + e);
    }
  }
}
