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

// [START retail_v2alpha_generated_CompletionService_CompleteQuery_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.retail.v2alpha.CatalogName;
import com.google.cloud.retail.v2alpha.CompleteQueryRequest;
import com.google.cloud.retail.v2alpha.CompleteQueryResponse;
import com.google.cloud.retail.v2alpha.CompletionServiceClient;
import java.util.ArrayList;

public class AsyncCompleteQuery {

  public static void main(String[] args) throws Exception {
    asyncCompleteQuery();
  }

  public static void asyncCompleteQuery() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CompletionServiceClient completionServiceClient = CompletionServiceClient.create()) {
      CompleteQueryRequest request =
          CompleteQueryRequest.newBuilder()
              .setCatalog(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .setQuery("query107944136")
              .setVisitorId("visitorId1880545833")
              .addAllLanguageCodes(new ArrayList<String>())
              .setDeviceType("deviceType781190832")
              .setDataset("dataset1443214456")
              .setMaxSuggestions(618824852)
              .build();
      ApiFuture<CompleteQueryResponse> future =
          completionServiceClient.completeQueryCallable().futureCall(request);
      // Do something.
      CompleteQueryResponse response = future.get();
    }
  }
}
// [END retail_v2alpha_generated_CompletionService_CompleteQuery_async]
