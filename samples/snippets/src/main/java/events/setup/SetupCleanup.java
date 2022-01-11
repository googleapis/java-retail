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

package events.setup;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.Page;
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
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.ProductDetail;
import com.google.cloud.retail.v2.PurgeMetadata;
import com.google.cloud.retail.v2.PurgeUserEventsRequest;
import com.google.cloud.retail.v2.PurgeUserEventsResponse;
import com.google.cloud.retail.v2.UserEvent;
import com.google.cloud.retail.v2.UserEventServiceClient;
import com.google.cloud.retail.v2.UserEventServiceSettings;
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
import java.util.Collections;
import java.util.concurrent.ExecutionException;

import static com.google.cloud.storage.StorageClass.STANDARD;

public class SetupCleanup {

  private static final String PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");

  private static final String PROJECT_ID = System.getenv("PROJECT_ID");

  private static final String ENDPOINT = "retail.googleapis.com:443";

  private static final String DEFAULT_CATALOG = String.format(
      "projects/%s/locations/global/catalogs/default_catalog",
      PROJECT_NUMBER);

  private static final Storage storage = StorageOptions.newBuilder()
      .setProjectId(PROJECT_NUMBER)
      .build().getService();

  // get user events service client
  private static UserEventServiceClient getUserEventsServiceClient()
      throws IOException {
    UserEventServiceSettings userEventServiceSettings = UserEventServiceSettings.newBuilder()
        .setEndpoint(ENDPOINT)
        .build();
    return UserEventServiceClient.create(userEventServiceSettings);
  }

  // get user event
  public static UserEvent getUserEvent(String visitorId) {
    Instant time = Instant.now();

    Timestamp timestamp = Timestamp.newBuilder()
        .setSeconds(time.getEpochSecond())
        .build();

    Product product = Product.newBuilder()
        .setId("test_id")
        .build();

    ProductDetail productDetail = ProductDetail.newBuilder()
        .setProduct(product)
        .setQuantity(Int32Value.newBuilder().setValue(3).build())
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

  // write user event
  public static UserEvent writeUserEvent(String visitorId) throws IOException {
    WriteUserEventRequest writeUserEventRequest = WriteUserEventRequest.newBuilder()
        .setUserEvent(getUserEvent(visitorId))
        .setParent(DEFAULT_CATALOG)
        .build();

    UserEvent userEvent = getUserEventsServiceClient().writeUserEvent(
        writeUserEventRequest);

    System.out.printf("The user event is written. %n%s%n", userEvent);

    return userEvent;
  }

  // purge user event
  public static void purgeUserEvent(String visitorId)
      throws IOException, ExecutionException, InterruptedException {
    PurgeUserEventsRequest purgeUserEventsRequest = PurgeUserEventsRequest.newBuilder()
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
