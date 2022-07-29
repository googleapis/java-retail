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

// [START retail_v2beta_generated_catalogserviceclient_listcatalogs_locationname_sync]
import com.google.cloud.retail.v2beta.Catalog;
import com.google.cloud.retail.v2beta.CatalogServiceClient;
import com.google.cloud.retail.v2beta.LocationName;

public class SyncListCatalogsLocationname {

  public static void main(String[] args) throws Exception {
    syncListCatalogsLocationname();
  }

  public static void syncListCatalogsLocationname() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      for (Catalog element : catalogServiceClient.listCatalogs(parent).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END retail_v2beta_generated_catalogserviceclient_listcatalogs_locationname_sync]
