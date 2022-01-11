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

package product;

import static product.setup.SetupCleanup.deleteProduct;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.StreamGobbler;

public class AddFulfillmentPlacesTest {

  private final String projectNumber = System.getenv("PROJECT_NUMBER");

  private final String productName = String.format(
      "projects/%s/locations/global/catalogs/default_catalog/branches/default_branch/products/add_fulfillment_test_product_id",
      projectNumber);

  private String output;

  @Before
  public void setUp()
      throws IOException, InterruptedException, ExecutionException {

    Process exec = Runtime.getRuntime()
        .exec(
            "mvn compile exec:java -Dexec.mainClass=product.AddFulfillmentPlaces");

    StreamGobbler streamGobbler = new StreamGobbler(exec.getInputStream());

    Future<String> stringFuture = Executors.newSingleThreadExecutor()
        .submit(streamGobbler);

    output = stringFuture.get();
  }

  @Test
  public void testAddFulfillment() {
    Assert.assertTrue(output.matches("(?s)^(.*Product is created.*)$"));

    Assert.assertTrue(output.matches("(?s)^(.*Add fulfillment request.*)$"));

    Assert.assertTrue(output.matches("(?s)^(.*Add fulfillment places.*)$"));

    Assert.assertTrue(output.matches(
        "(?s)^(.*Get product response.*?fulfillment_info.*type: \"pickup-in-store\".*?place_ids: \"store0\".*)$"));

    Assert.assertTrue(output.matches(
        "(?s)^(.*Get product response.*?fulfillment_info.*type: \"pickup-in-store\".*?place_ids: \"store1\".*)$"));
  }

  @After
  public void after() throws IOException {
    deleteProduct(productName);
  }
}
