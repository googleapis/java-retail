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

package com.google.cloud.retail.v2.samples;

// [START retail_v2_generated_productserviceclient_removelocalinventories_sync]
import com.google.cloud.retail.v2.ProductName;
import com.google.cloud.retail.v2.ProductServiceClient;
import com.google.cloud.retail.v2.RemoveLocalInventoriesRequest;
import com.google.cloud.retail.v2.RemoveLocalInventoriesResponse;
import com.google.protobuf.Timestamp;
import java.util.ArrayList;

public class SyncRemoveLocalInventories {

  public static void main(String[] args) throws Exception {
    syncRemoveLocalInventories();
  }

  public static void syncRemoveLocalInventories() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
      RemoveLocalInventoriesRequest request =
          RemoveLocalInventoriesRequest.newBuilder()
              .setProduct(
                  ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
                      .toString())
              .addAllPlaceIds(new ArrayList<String>())
              .setRemoveTime(Timestamp.newBuilder().build())
              .setAllowMissing(true)
              .build();
      RemoveLocalInventoriesResponse response =
          productServiceClient.removeLocalInventoriesAsync(request).get();
    }
  }
}
// [END retail_v2_generated_productserviceclient_removelocalinventories_sync]
