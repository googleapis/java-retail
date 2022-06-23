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

// [START retail_v2beta_generated_completionserviceclient_importcompletiondata_sync]
import com.google.cloud.retail.v2beta.CatalogName;
import com.google.cloud.retail.v2beta.CompletionDataInputConfig;
import com.google.cloud.retail.v2beta.CompletionServiceClient;
import com.google.cloud.retail.v2beta.ImportCompletionDataRequest;
import com.google.cloud.retail.v2beta.ImportCompletionDataResponse;

public class SyncImportCompletionData {

  public static void main(String[] args) throws Exception {
    syncImportCompletionData();
  }

  public static void syncImportCompletionData() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (CompletionServiceClient completionServiceClient = CompletionServiceClient.create()) {
      ImportCompletionDataRequest request =
          ImportCompletionDataRequest.newBuilder()
              .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .setInputConfig(CompletionDataInputConfig.newBuilder().build())
              .setNotificationPubsubTopic("notificationPubsubTopic-1361224991")
              .build();
      ImportCompletionDataResponse response =
          completionServiceClient.importCompletionDataAsync(request).get();
    }
  }
}
// [END retail_v2beta_generated_completionserviceclient_importcompletiondata_sync]
