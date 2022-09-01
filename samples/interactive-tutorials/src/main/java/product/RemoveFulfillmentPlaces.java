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

/*
 * [START retail_remove_fulfillment_places]
 */

package product;

import static setup.SetupCleanup.createProduct;
import static setup.SetupCleanup.deleteProduct;
import static setup.SetupCleanup.getProduct;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.ServiceOptions;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.retail.v2.RemoveFulfillmentPlacesMetadata;
import com.google.cloud.retail.v2.RemoveFulfillmentPlacesRequest;
import com.google.cloud.retail.v2.RemoveFulfillmentPlacesResponse;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RemoveFulfillmentPlaces {

  public static void main(String[] args) throws IOException, InterruptedException {
    String projectId = ServiceOptions.getDefaultProjectId();
    String generatedProductId = UUID.randomUUID().toString();
    String productName =
        String.format(
            "projects/%s/locations/global/catalogs/default_catalog/branches/0/products/%s",
            projectId, generatedProductId);

    createProduct(generatedProductId);
    removeFulfillmentPlaces(productName, "store0");
    getProduct(productName);
    deleteProduct(productName);
  }

  // remove fulfillment places to product
  public static void removeFulfillmentPlaces(String productName, String storeId)
      throws IOException, InterruptedException {
    Timestamp currentDate =
        Timestamp.newBuilder()
            .setSeconds(Instant.now().getEpochSecond())
            .setNanos(Instant.now().getNano())
            .build();

    System.out.printf("Remove fulfilment places with current date: %s", currentDate);
    RemoveFulfillmentPlacesRequest removeFulfillmentRequest =
        RemoveFulfillmentPlacesRequest.newBuilder()
            .setProduct(productName)
            .setType("pickup-in-store")
            .addPlaceIds(storeId)
            .setRemoveTime(currentDate)
            .setAllowMissing(true)
            .build();
    System.out.println("Remove fulfillment request " + removeFulfillmentRequest);

    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (ProductServiceClient serviceClient = ProductServiceClient.create()) {
      OperationFuture<RemoveFulfillmentPlacesResponse, RemoveFulfillmentPlacesMetadata> response =
              serviceClient.removeFulfillmentPlacesAsync(removeFulfillmentRequest);
      // This is a long-running operation and its result is not immediately
      // present with get operations,thus we simulate wait with sleep method.
      System.out.println("Waiting for operation to finish...");
      while (!response.isDone()) {}
    }
  }
}

// [END retail_remove_fulfillment_places]
