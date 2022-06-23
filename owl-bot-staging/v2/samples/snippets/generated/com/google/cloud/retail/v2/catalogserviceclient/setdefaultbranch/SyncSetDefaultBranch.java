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

// [START retail_v2_generated_catalogserviceclient_setdefaultbranch_sync]
import com.google.cloud.retail.v2.BranchName;
import com.google.cloud.retail.v2.CatalogName;
import com.google.cloud.retail.v2.CatalogServiceClient;
import com.google.cloud.retail.v2.SetDefaultBranchRequest;
import com.google.protobuf.Empty;

public class SyncSetDefaultBranch {

  public static void main(String[] args) throws Exception {
    syncSetDefaultBranch();
  }

  public static void syncSetDefaultBranch() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
      SetDefaultBranchRequest request =
          SetDefaultBranchRequest.newBuilder()
              .setCatalog(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .setBranchId(
                  BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
              .setNote("note3387378")
              .setForce(true)
              .build();
      catalogServiceClient.setDefaultBranch(request);
    }
  }
}
// [END retail_v2_generated_catalogserviceclient_setdefaultbranch_sync]
