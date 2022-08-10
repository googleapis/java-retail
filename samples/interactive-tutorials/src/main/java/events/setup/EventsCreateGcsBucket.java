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

import java.io.IOException;
import java.time.Instant;

public class EventsCreateGcsBucket {
  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String eventsBucketName =
        String.format("your-bucket-prefix_%s", Instant.now().getEpochSecond());
    createGcsBucketAndUploadData(eventsBucketName);
  }

  public static void createGcsBucketAndUploadData(String bucketName) throws IOException {
    createBucket(bucketName);
    System.out.printf("Events gcs bucket %s was created.%n", bucketName);

    uploadObject(bucketName, "user_events.json", "src/main/resources/user_events.json");
    System.out.printf("File 'user_events.json' was uploaded into bucket '%s'.%n", bucketName);

    uploadObject(
        bucketName,
        "user_events_some_invalid.json",
        "src/main/resources/user_events_some_invalid.json");
    System.out.printf(
        "File 'user_events_some_invalid.json' was uploaded into bucket '%s'.%n", bucketName);
  }
}
