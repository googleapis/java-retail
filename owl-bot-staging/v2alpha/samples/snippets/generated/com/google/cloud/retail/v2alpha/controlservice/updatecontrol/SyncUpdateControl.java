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

// [START retail_v2alpha_generated_ControlService_UpdateControl_sync]
import com.google.cloud.retail.v2alpha.Control;
import com.google.cloud.retail.v2alpha.ControlServiceClient;
import com.google.cloud.retail.v2alpha.UpdateControlRequest;
import com.google.protobuf.FieldMask;

public class SyncUpdateControl {

  public static void main(String[] args) throws Exception {
    syncUpdateControl();
  }

  public static void syncUpdateControl() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ControlServiceClient controlServiceClient = ControlServiceClient.create()) {
      UpdateControlRequest request =
          UpdateControlRequest.newBuilder()
              .setControl(Control.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      Control response = controlServiceClient.updateControl(request);
    }
  }
}
// [END retail_v2alpha_generated_ControlService_UpdateControl_sync]
