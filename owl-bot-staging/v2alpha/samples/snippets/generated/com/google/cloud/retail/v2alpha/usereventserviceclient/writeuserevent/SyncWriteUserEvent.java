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

// [START retail_v2alpha_generated_usereventserviceclient_writeuserevent_sync]
import com.google.cloud.retail.v2alpha.UserEvent;
import com.google.cloud.retail.v2alpha.UserEventServiceClient;
import com.google.cloud.retail.v2alpha.WriteUserEventRequest;

public class SyncWriteUserEvent {

  public static void main(String[] args) throws Exception {
    syncWriteUserEvent();
  }

  public static void syncWriteUserEvent() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
      WriteUserEventRequest request =
          WriteUserEventRequest.newBuilder()
              .setParent("parent-995424086")
              .setUserEvent(UserEvent.newBuilder().build())
              .build();
      UserEvent response = userEventServiceClient.writeUserEvent(request);
    }
  }
}
// [END retail_v2alpha_generated_usereventserviceclient_writeuserevent_sync]
