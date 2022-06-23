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

// [START retail_v2_generated_catalogserviceclient_getdefaultbranch_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.retail.v2.CatalogName;
import com.google.cloud.retail.v2.CatalogServiceClient;
import com.google.cloud.retail.v2.GetDefaultBranchRequest;
import com.google.cloud.retail.v2.GetDefaultBranchResponse;

public class AsyncGetDefaultBranch {

  public static void main(String[] args) throws Exception {
    asyncGetDefaultBranch();
  }

  public static void asyncGetDefaultBranch() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
      GetDefaultBranchRequest request =
          GetDefaultBranchRequest.newBuilder()
              .setCatalog(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .build();
      ApiFuture<GetDefaultBranchResponse> future =
          catalogServiceClient.getDefaultBranchCallable().futureCall(request);
      // Do something.
      GetDefaultBranchResponse response = future.get();
    }
  }
}
// [END retail_v2_generated_catalogserviceclient_getdefaultbranch_async]
