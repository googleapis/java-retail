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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ProductsCreateGcsBucketTest {

  private ByteArrayOutputStream bout;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() throws IOException, InterruptedException, ExecutionException {

    String bucketName = "products_tests_bucket";

    bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);

    createGcsBucketAndUploadData(bucketName);
  }

  @Test
  public void testProductsCreateGcsBucket() {
    String outputResult = bout.toString();

    assertThat(outputResult).contains("Products gcs bucket products_tests_bucket was created.");
    assertThat(outputResult)
        .contains("File 'products.json' was uploaded into bucket 'products_tests_bucket'.");
    assertThat(outputResult)
        .contains(
            "File 'products_some_invalid.json' was uploaded into bucket 'products_tests_bucket'.");
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(originalPrintStream);
  }
}
