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

// [START retail_v2_generated_predictionserviceclient_predict_sync]
import com.google.cloud.retail.v2.PredictRequest;
import com.google.cloud.retail.v2.PredictResponse;
import com.google.cloud.retail.v2.PredictionServiceClient;
import com.google.cloud.retail.v2.UserEvent;
import com.google.protobuf.Value;
import java.util.HashMap;

public class SyncPredict {

  public static void main(String[] args) throws Exception {
    syncPredict();
  }

  public static void syncPredict() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
      PredictRequest request =
          PredictRequest.newBuilder()
              .setPlacement("placement1792938725")
              .setUserEvent(UserEvent.newBuilder().build())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setValidateOnly(true)
              .putAllParams(new HashMap<String, Value>())
              .putAllLabels(new HashMap<String, String>())
              .build();
      PredictResponse response = predictionServiceClient.predict(request);
    }
  }
}
// [END retail_v2_generated_predictionserviceclient_predict_sync]
