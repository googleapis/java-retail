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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;

public final class EventsCreateGcsBucket {

  /**
   * This variable describes project id getting from environment variable.
   */
  private static final String PROJECT_ID = System.getenv("PROJECT_ID");

  /**
   * This variable describes date format in a certain pattern.
   */
  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
      "yyyy-MM-dd_HH-mm-ss");

  /**
   * This variable describes a defined timestamp with current date.
   */
  private static final Timestamp TIMESTAMP = Timestamp.from(Instant.now());

  /**
   * This variable describes bucket name in a certain format.
   */
  private static final String BUCKET_NAME = String.format("%s_events_%s",
      PROJECT_ID, DATE_FORMAT.format(TIMESTAMP));

  private EventsCreateGcsBucket() {
  }

  /**
   * Getter for bucket name constant variable.
   *
   * @return String.
   */
  public static String getBucketName() {
    return BUCKET_NAME;
  }

  /**
   * Create GCS bucket and upload json files.
   *
   * @throws IOException from the called method.
   */
  public static void eventsCreateGcsBucketAndUploadJsonFiles()
      throws IOException {

    createBucket(BUCKET_NAME);

    uploadObject(BUCKET_NAME, "user_events.json",
        "src/main/resources/user_events.json");

    uploadObject(BUCKET_NAME, "user_events_some_invalid.json",
        "src/main/resources/user_events_some_invalid.json");
  }

  /**
   * Executable class.
   *
   * @param args command line arguments.
   */
  public static void main(final String[] args) throws IOException {
    eventsCreateGcsBucketAndUploadJsonFiles();
  }
}
