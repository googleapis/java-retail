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

package product.setup;

import static com.google.common.truth.Truth.assertThat;
import static product.setup.ProductsCreateGcsBucket.createGcsBucketAndUploadData;
import static setup.SetupCleanup.createBqDataset;
import static setup.SetupCleanup.createBqTable;
import static setup.SetupCleanup.getGson;
import static setup.SetupCleanup.uploadDataToBqTable;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProductsCreateBigqueryTableTest {

  private ByteArrayOutputStream bout;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() throws IOException, InterruptedException, ExecutionException {
    String dataset = "products";
    String validProductsTable = "products";
    String invalidProductsTable = "products_some_invalid";
    String bucketName = "products_tests_bucket";
    String productSchemaFilePath = "src/main/resources/product_schema.json";
    String validProductsSourceFile =
        String.format("gs://%s/products.json", bucketName);
    String invalidProductsSourceFile =
        String.format(
            "gs://%s/products_some_invalid.json", bucketName);

    BufferedReader bufferedReader = new BufferedReader(new FileReader(productSchemaFilePath));
    String jsonToString = bufferedReader.lines().collect(Collectors.joining());
    jsonToString = jsonToString.replace("\"fields\"", "\"subFields\"");
    Field[] fields = getGson().fromJson(jsonToString, Field[].class);
    Schema productSchema = Schema.of(fields);

    bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);

    createGcsBucketAndUploadData(bucketName);
    createBqDataset(dataset);
    createBqTable(dataset, validProductsTable, productSchema);
    uploadDataToBqTable(dataset, validProductsTable, validProductsSourceFile, productSchema);
    createBqTable(dataset, invalidProductsTable, productSchema);
    uploadDataToBqTable(dataset, invalidProductsTable, invalidProductsSourceFile, productSchema);
  }

  @Test
  public void testProductsCreateBigQueryTable() {
    String outputResult = bout.toString();

    assertThat(outputResult).contains("Json from GCS successfully loaded in a table 'products'.");
    assertThat(outputResult).contains("Json from GCS successfully loaded in a table 'products_some_invalid'.");
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(originalPrintStream);
  }
}
