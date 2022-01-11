/*
 * Copyright 2022 Google Inc.
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

import lombok.Getter;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;

import static events.setup.SetupCleanup.createBucket;
import static events.setup.SetupCleanup.uploadObject;

public class EventsCreateGcsBucket {

  private static final String PROJECT_ID = System.getenv("PROJECT_ID");

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
      "yyyy-MM-dd_HH-mm-ss");

  private static final Timestamp timestamp = Timestamp.from(Instant.now());

  @Getter
  private static final String bucketName = String.format("%s_events_%s",
      PROJECT_ID, dateFormat.format(timestamp));

  public static void main(String[] args) throws IOException {
    eventsCreateGcsBucketAndUploadJsonFiles();
  }

  public static void eventsCreateGcsBucketAndUploadJsonFiles()
      throws IOException {

    createBucket(bucketName);

    uploadObject(bucketName, "user_events.json",
        "src/main/resources/user_events.json");

    uploadObject(bucketName, "user_events_some_invalid.json",
        "src/main/resources/user_events_some_invalid.json");
  }
}
