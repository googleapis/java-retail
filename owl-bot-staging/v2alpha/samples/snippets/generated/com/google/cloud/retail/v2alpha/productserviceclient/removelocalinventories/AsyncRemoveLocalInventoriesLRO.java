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

package com.google.cloud.retail.v2alpha.samples;

// [START retail_v2alpha_generated_productserviceclient_removelocalinventories_lro_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.retail.v2alpha.ProductName;
import com.google.cloud.retail.v2alpha.ProductServiceClient;
import com.google.cloud.retail.v2alpha.RemoveLocalInventoriesMetadata;
import com.google.cloud.retail.v2alpha.RemoveLocalInventoriesRequest;
import com.google.cloud.retail.v2alpha.RemoveLocalInventoriesResponse;
import com.google.protobuf.Timestamp;
import java.util.ArrayList;

public class AsyncRemoveLocalInventoriesLRO {

  public static void main(String[] args) throws Exception {
    asyncRemoveLocalInventoriesLRO();
  }

  public static void asyncRemoveLocalInventoriesLRO() throws Exception {
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
      OperationFuture<RemoveLocalInventoriesResponse, RemoveLocalInventoriesMetadata> future =
          productServiceClient.removeLocalInventoriesOperationCallable().futureCall(request);
      // Do something.
      RemoveLocalInventoriesResponse response = future.get();
    }
  }
}
// [END retail_v2alpha_generated_productserviceclient_removelocalinventories_lro_async]
