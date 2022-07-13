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
 * [START retail_add_fulfillment_places]
 */

package product;

import static setup.SetupCleanup.createProduct;
import static setup.SetupCleanup.deleteProduct;
import static setup.SetupCleanup.getProduct;

import com.google.cloud.ServiceOptions;
import com.google.cloud.retail.v2.AddFulfillmentPlacesRequest;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.time.Instant;
import java.util.UUID;

public class AddFulfillmentPlaces {

  public static void main(String[] args) throws IOException, InterruptedException {
    String generatedProductId = UUID.randomUUID().toString();
    Product product = createProduct(generatedProductId);
    Timestamp currentDate =
            Timestamp.newBuilder()
                    .setSeconds(Instant.now().getEpochSecond())
                    .setNanos(Instant.now().getNano())
                    .build();
    System.out.printf("Add fulfilment places with current date: %s", currentDate);
    addFulfillmentPlaces(product.getName(), currentDate, "store2");
    getProduct(product.getName());
    deleteProduct(product.getName());
  }

  public static void addFulfillmentPlaces(String productName, Timestamp timestamp, String placeId)
      throws IOException, InterruptedException {
    AddFulfillmentPlacesRequest addFulfillmentRequest =
        getAddFulfillmentRequest(productName, timestamp, placeId);
    try (ProductServiceClient serviceClient = ProductServiceClient.create()) {
      serviceClient.addFulfillmentPlacesAsync(addFulfillmentRequest);
      /*
      This is a long-running operation and its result is not immediately
      present with get operations,thus we simulate wait with sleep method.
      */
      System.out.println("Add fulfillment places, wait 90 seconds: ");
      Thread.sleep(90_000);
    }
  }

  public static AddFulfillmentPlacesRequest getAddFulfillmentRequest(
      String productName, Timestamp timestamp, String placeId) {
    AddFulfillmentPlacesRequest addfulfillmentPlacesRequest =
        AddFulfillmentPlacesRequest.newBuilder()
            .setProduct(productName)
            .setType("pickup-in-store")
            .addPlaceIds(placeId)
            .setAddTime(timestamp)
            .setAllowMissing(true)
            .build();
    System.out.println("Add fulfillment request " + addfulfillmentPlacesRequest);

    return addfulfillmentPlacesRequest;
  }
}

// [END retail_add_fulfillment_places]
