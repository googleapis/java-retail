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

// [START retail_v2alpha_generated_modelserviceclient_deletemodel_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.retail.v2alpha.DeleteModelRequest;
import com.google.cloud.retail.v2alpha.ModelName;
import com.google.cloud.retail.v2alpha.ModelServiceClient;
import com.google.protobuf.Empty;

public class AsyncDeleteModel {

  public static void main(String[] args) throws Exception {
    asyncDeleteModel();
  }

  public static void asyncDeleteModel() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (ModelServiceClient modelServiceClient = ModelServiceClient.create()) {
      DeleteModelRequest request =
          DeleteModelRequest.newBuilder()
              .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[MODEL]").toString())
              .build();
      ApiFuture<Empty> future = modelServiceClient.deleteModelCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END retail_v2alpha_generated_modelserviceclient_deletemodel_async]
