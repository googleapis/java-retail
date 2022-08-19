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

// [START retail_v2alpha_generated_modelserviceclient_listmodels_paged_async]
import com.google.cloud.retail.v2alpha.CatalogName;
import com.google.cloud.retail.v2alpha.ListModelsRequest;
import com.google.cloud.retail.v2alpha.ListModelsResponse;
import com.google.cloud.retail.v2alpha.Model;
import com.google.cloud.retail.v2alpha.ModelServiceClient;
import com.google.common.base.Strings;

public class AsyncListModelsPaged {

  public static void main(String[] args) throws Exception {
    asyncListModelsPaged();
  }

  public static void asyncListModelsPaged() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
      ListModelsRequest request =
          ListModelsRequest.newBuilder()
              .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListModelsResponse response = modelServiceClient.listModelsCallable().call(request);
        for (Model element : response.getModelsList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END retail_v2alpha_generated_modelserviceclient_listmodels_paged_async]
