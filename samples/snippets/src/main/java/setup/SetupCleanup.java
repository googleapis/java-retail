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

package setup;

import com.google.api.gax.longrunning.OperationFuture;
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
import com.google.cloud.retail.v2.ProductDetail;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.retail.v2.PurgeMetadata;
import com.google.cloud.retail.v2.PurgeUserEventsRequest;
import com.google.cloud.retail.v2.PurgeUserEventsResponse;
import com.google.cloud.retail.v2.UserEvent;
import com.google.cloud.retail.v2.UserEventServiceClient;
import com.google.cloud.retail.v2.WriteUserEventRequest;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

import static com.google.cloud.storage.StorageClass.STANDARD;

public final class SetupCleanup {

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
      "projects/%s/locations/global/catalogs/default_catalog",
      PROJECT_NUMBER);

  /**
   * This variable describes default branch name.
   */
  public static final String DEFAULT_BRANCH_NAME = String.format(
      "projects/%s/locations/global/catalogs/default_catalog/"
          + "branches/default_branch", PROJECT_NUMBER);

  /**
   * This variable describes Storage.
   */
  private static final Storage STORAGE = StorageOptions.newBuilder()
      .setProjectId(PROJECT_NUMBER)
      .build().getService();

  private SetupCleanup() {
  }

  /**
   * Get product service client.
   *
   * @return UserEventServiceClient
   * @throws IOException if endpoint is incorrect.
   */
  private static ProductServiceClient getProductServiceClient()
      throws IOException {
    return ProductServiceClient.create();
  }

  /**
   * Get user event service client.
   *
   * @return UserEventServiceClient
   * @throws IOException if endpoint is incorrect.
   */
  private static UserEventServiceClient getUserEventsServiceClient()
      throws IOException {
    return UserEventServiceClient.create();
  }

  /**
   * Generate product.
   *
   * @return Product.
   */
  public static Product generateProduct() {

    final float price = 30.0f;
    final float originalPrice = 35.5f;

    PriceInfo priceInfo = PriceInfo.newBuilder()
        .setPrice(price)
        .setOriginalPrice(originalPrice)
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

  /**
   * Create product.
   *
   * @param productId id of product.
   * @return Product.
   * @throws IOException if endpoint is incorrect.
   */
  public static Product createProduct(final String productId)
      throws IOException {
    CreateProductRequest createProductRequest =
        CreateProductRequest.newBuilder()
            .setProduct(generateProduct())
            .setProductId(productId)
            .setParent(DEFAULT_BRANCH_NAME)
            .build();

    Product product = getProductServiceClient().createProduct(
        createProductRequest);

    System.out.println("Product is created: " + product);

    return product;
  }

  /**
   * Get product.
   *
   * @param productName name of product to get.
   * @return Product.
   * @throws IOException if endpoint is incorrect.
   */
  public static Product getProduct(final String productName)
      throws IOException {
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

  /**
   * Delete product.
   *
   * @param productName name of product to delete.
   * @throws IOException if endpoint is incorrect.
   */
  public static void deleteProduct(final String productName)
      throws IOException {
    DeleteProductRequest deleteProductRequest =
        DeleteProductRequest.newBuilder()
            .setName(productName)
            .build();

    getProductServiceClient().deleteProduct(deleteProductRequest);

    System.out.printf("Product %s was deleted.%n", productName);
  }

  /**
   * Try to delete product if exists.
   *
   * @param productName name of product to delete.
   */
  public static void tryToDeleteProductIfExists(final String productName) {

    GetProductRequest getProductRequest = GetProductRequest.newBuilder()
        .setName(productName)
        .build();

    try {
      Product product = getProductServiceClient().getProduct(getProductRequest);

      getProductServiceClient().deleteProduct(product.getName());
    } catch (NotFoundException | IOException e) {
      System.out.printf("Product %s is not found.%n", productName);
    }
  }

  /**
   * Get user event.
   *
   * @param visitorId visitor id.
   * @return UserEvent.
   */
  public static UserEvent getUserEvent(final String visitorId) {
    final int value = 3;

    Instant time = Instant.now();

    Timestamp timestamp = Timestamp.newBuilder()
        .setSeconds(time.getEpochSecond())
        .build();

    Product product = Product.newBuilder()
        .setId("test_id")
        .build();

    ProductDetail productDetail = ProductDetail.newBuilder()
        .setProduct(product)
        .setQuantity(Int32Value.newBuilder().setValue(value).build())
        .build();

    UserEvent userEvent = UserEvent.newBuilder()
        .setEventType("detail-page-view")
        .setVisitorId(visitorId)
        .setEventTime(timestamp)
        .addAllProductDetails(Collections.singletonList(productDetail))
        .build();

    System.out.println(userEvent);

    return userEvent;
  }

  /**
   * Write user event.
   *
   * @param visitorId visitor id.
   * @return UserEvent.
   * @throws IOException if endpoint is incorrect.
   */
  public static UserEvent writeUserEvent(final String visitorId)
      throws IOException {
    WriteUserEventRequest writeUserEventRequest =
        WriteUserEventRequest.newBuilder()
            .setUserEvent(getUserEvent(visitorId))
            .setParent(DEFAULT_CATALOG)
            .build();

    UserEvent userEvent = getUserEventsServiceClient().writeUserEvent(
        writeUserEventRequest);

    System.out.printf("The user event is written. %n%s%n", userEvent);

    return userEvent;
  }

  /**
   * Purge user event.
   *
   * @param visitorId visitor id.
   * @throws IOException          from the called method.
   * @throws ExecutionException   when attempting to retrieve the result of a
   *                              task that aborted by throwing an exception.
   * @throws InterruptedException when a thread is waiting, sleeping, or
   *                              otherwise occupied, and the thread is
   *                              interrupted, either before or during the
   *                              activity.
   */
  public static void purgeUserEvent(final String visitorId)
      throws IOException, ExecutionException, InterruptedException {
    PurgeUserEventsRequest purgeUserEventsRequest =
        PurgeUserEventsRequest.newBuilder()
            .setFilter(String.format("visitorId=\"%s\"", visitorId))
            .setParent(DEFAULT_CATALOG)
            .setForce(true)
            .build();

    OperationFuture<PurgeUserEventsResponse, PurgeMetadata> purgeOperation
        = getUserEventsServiceClient().purgeUserEventsAsync(
        purgeUserEventsRequest);

    System.out.printf("The purge operation was started: %s%n",
        purgeOperation.getName());
  }

  /**
   * Create bucket.
   *
   * @param bucketName name of bucket.
   */
  public static void createBucket(final String bucketName) {
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

  /**
   * List of buckets.
   *
   * @return Page<Bucket>.
   */
  public static Page<Bucket> listBuckets() {
    Page<Bucket> bucketList = STORAGE.list();

    for (Bucket bucket : bucketList.iterateAll()) {
      System.out.println(bucket.getName());
    }

    return bucketList;
  }

  /**
   * Upload object.
   *
   * @param bucketName name of bucket.
   * @param objectName name of object to upload.
   * @param filePath   path to the file.
   * @throws IOException while runs readAllBytes() method.
   */
  public static void uploadObject(final String bucketName,
      final String objectName, final String filePath) throws IOException {
    Storage storage = StorageOptions.newBuilder().setProjectId(PROJECT_NUMBER)
        .build().getService();

    BlobId blobId = BlobId.of(bucketName, objectName);

    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();

    storage.create(blobInfo, Files.readAllBytes(Paths.get(filePath)));

    System.out.println(
        "File " + filePath + " uploaded to bucket " + bucketName + " as "
            + objectName);
  }

  /**
   * Create BQ dataset.
   *
   * @param datasetName name of dataset.
   */
  public static void createBqDataset(final String datasetName) {
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

  /**
   * List of BQ datasets.
   */
  public static void listBqDatasets() {
    try {
      final int pageSize = 100;

      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      Page<Dataset> datasets = bigquery.listDatasets(PROJECT_ID,
          DatasetListOption.pageSize(pageSize));
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

  /**
   * Create BQ table.
   *
   * @param datasetName name of dataset.
   * @param tableName   name of table.
   * @param schema      table schema.
   */
  public static void createBqTable(final String datasetName,
      final String tableName, final Schema schema) {
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

  /**
   * List of BQ tables.
   *
   * @param datasetName name of dataset.
   * @return Page<! - - Table-->
   */
  public static Page<Table> listBqTables(final String datasetName) {
    Page<Table> tables = null;

    try {
      final int pageSize = 100;

      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      DatasetId datasetId = DatasetId.of(PROJECT_ID, datasetName);
      tables = bigquery.listTables(datasetId,
          TableListOption.pageSize(pageSize));
      tables.iterateAll().forEach(
          table -> System.out.print(table.getTableId().getTable() + "\n"));

      System.out.println("Tables listed successfully.");
    } catch (BigQueryException e) {
      System.out.println("Tables were not listed. Error occurred: " + e);
    }

    return tables;
  }

  /**
   * Upload data to BQ table.
   *
   * @param datasetName name of dataset.
   * @param tableName   name of table.
   * @param sourceUri   source URI.
   * @param schema      table schema.
   */
  public static void uploadDataToBqTable(final String datasetName,
      final String tableName, final String sourceUri, final Schema schema) {
    try {
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      TableId tableId = TableId.of(datasetName, tableName);
      LoadJobConfiguration loadConfig =
          LoadJobConfiguration.newBuilder(tableId, sourceUri)
              .setFormatOptions(FormatOptions.json())
              .setSchema(schema)
              .build();

      Job job = bigquery.create(JobInfo.of(loadConfig));
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
