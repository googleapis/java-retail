/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package events.setup;

import static setup.SetupCleanup.createBucket;
import static setup.SetupCleanup.uploadObject;

import com.google.cloud.ServiceOptions;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.time.Instant;

public class EventsCreateGcsBucket {

  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();

  private static final Timestamp CURRENT_DATE =
      Timestamp.newBuilder()
          .setSeconds(Instant.now().getEpochSecond())
          .setNanos(Instant.now().getNano())
          .build();

  private static final String BUCKET_NAME =
      String.format("%s_events_%s", PROJECT_ID, CURRENT_DATE.getSeconds());

  public static void main(String... args) throws IOException {
    createBucket(BUCKET_NAME);
    System.out.printf("Events gcs bucket %s was created.", BUCKET_NAME);

    uploadObject(BUCKET_NAME, "user_events.json", "src/main/resources/user_events.json");
    System.out.printf("File 'user_events.json' was uploaded into bucket '%s'.", BUCKET_NAME);

    uploadObject(
        BUCKET_NAME,
        "user_events_some_invalid.json",
        "src/main/resources/user_events_some_invalid.json");
    System.out.printf(
        "File 'user_events_some_invalid.json' was uploaded into bucket '%s'.", BUCKET_NAME);
  }

  public static String getBucketName() {
    return BUCKET_NAME;
  }
}
