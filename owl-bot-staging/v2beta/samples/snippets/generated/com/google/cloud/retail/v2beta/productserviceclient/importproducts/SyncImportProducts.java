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

package com.google.cloud.retail.v2beta.samples;

// [START retail_v2beta_generated_productserviceclient_importproducts_sync]
import com.google.cloud.retail.v2beta.BranchName;
import com.google.cloud.retail.v2beta.ImportErrorsConfig;
import com.google.cloud.retail.v2beta.ImportProductsRequest;
import com.google.cloud.retail.v2beta.ImportProductsResponse;
import com.google.cloud.retail.v2beta.ProductInputConfig;
import com.google.cloud.retail.v2beta.ProductServiceClient;
import com.google.protobuf.FieldMask;

public class SyncImportProducts {

  public static void main(String[] args) throws Exception {
    syncImportProducts();
  }

  public static void syncImportProducts() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
      ImportProductsRequest request =
          ImportProductsRequest.newBuilder()
              .setParent(
                  BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
              .setRequestId("requestId693933066")
              .setInputConfig(ProductInputConfig.newBuilder().build())
              .setErrorsConfig(ImportErrorsConfig.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .setNotificationPubsubTopic("notificationPubsubTopic-1361224991")
              .build();
      ImportProductsResponse response = productServiceClient.importProductsAsync(request).get();
    }
  }
}
// [END retail_v2beta_generated_productserviceclient_importproducts_sync]
