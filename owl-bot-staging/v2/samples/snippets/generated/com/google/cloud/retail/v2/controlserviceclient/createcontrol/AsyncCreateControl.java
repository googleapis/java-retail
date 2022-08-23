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

// [START retail_v2_generated_controlserviceclient_createcontrol_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.retail.v2.CatalogName;
import com.google.cloud.retail.v2.Control;
import com.google.cloud.retail.v2.ControlServiceClient;
import com.google.cloud.retail.v2.CreateControlRequest;

public class AsyncCreateControl {

  public static void main(String[] args) throws Exception {
    asyncCreateControl();
  }

  public static void asyncCreateControl() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
      CreateControlRequest request =
          CreateControlRequest.newBuilder()
              .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .setControl(Control.newBuilder().build())
              .setControlId("controlId-395080872")
              .build();
      ApiFuture<Control> future = controlServiceClient.createControlCallable().futureCall(request);
      // Do something.
      Control response = future.get();
    }
  }
}
// [END retail_v2_generated_controlserviceclient_createcontrol_async]
