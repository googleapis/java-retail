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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public final class UpdateUserEventsJson {

  /**
   * This variable describes file path.
   */
  private static final String FILE_PATH = "src/main/resources/user_events.json";

  /**
   * This variable describes invalid file path.
   */
  private static final String INVALID_FILE_PATH = "src/main/resources/"
      + "user_events_some_invalid.json";

  /**
   * This variable describes date format.
   */
  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
      "yyyy-MM-dd");

  /**
   * This variable describes yesterday date.
   */
  private static final Timestamp YESTERDAY_DATE = Timestamp.from(
      Instant.now().minus(1, ChronoUnit.DAYS));

  private UpdateUserEventsJson() {
  }

  /**
   * Update events timestamp.
   *
   * @param jsonFile path to the json file.
   * @throws IOException while runs readAllBytes() method.
   */
  public static void updateEventsTimestamp(final String jsonFile)
      throws IOException {

    String json = new String(Files.readAllBytes(Paths.get(jsonFile)));

    json = json.replaceAll(
        "(\"eventTime\"\\s*:\\s*\"(\\d{4}-\\d{2}-\\d{2}(T.*Z)?))",
        "\"eventTime\":\"" + DATE_FORMAT.format(YESTERDAY_DATE) + "");

    BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile));

    writer.write(json);

    writer.close();
  }

  /**
   * Executable class.
   *
   * @param args command line arguments.
   */
  public static void main(final String[] args) throws IOException {
    updateEventsTimestamp(FILE_PATH);

    updateEventsTimestamp(INVALID_FILE_PATH);
  }
}
