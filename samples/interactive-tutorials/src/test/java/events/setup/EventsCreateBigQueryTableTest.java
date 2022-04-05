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

import static com.google.common.truth.Truth.assertThat;
import static events.setup.EventsCreateGcsBucket.createGcsBucketAndUploadData;
import static setup.SetupCleanup.createBqDataset;
import static setup.SetupCleanup.createBqTable;
import static setup.SetupCleanup.getGson;
import static setup.SetupCleanup.uploadDataToBqTable;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EventsCreateBigQueryTableTest {

  private ByteArrayOutputStream bout;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() throws IOException, InterruptedException, ExecutionException {
    String dataset = "user_events";
    String validEventsTable = "events";
    String invalidEventsTable = "events_some_invalid";
    String bucketName = "events_tests_bucket";
    String eventsSchemaFilePath = "src/main/resources/events_schema.json";
    String validEventsSourceFile = String.format("gs://%s/user_events.json", bucketName);
    String invalidEventsSourceFile =
        String.format("gs://%s/user_events_some_invalid.json", bucketName);

    BufferedReader bufferedReader = new BufferedReader(new FileReader(eventsSchemaFilePath));
    String jsonToString = bufferedReader.lines().collect(Collectors.joining());
    jsonToString = jsonToString.replace("\"fields\"", "\"subFields\"");
    Field[] fields = getGson().fromJson(jsonToString, Field[].class);
    Schema eventsSchema = Schema.of(fields);

    bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);

    createGcsBucketAndUploadData(bucketName);
    createBqDataset(dataset);
    createBqTable(dataset, validEventsTable, eventsSchema);
    uploadDataToBqTable(dataset, validEventsTable, validEventsSourceFile, eventsSchema);
    createBqTable(dataset, invalidEventsTable, eventsSchema);
    uploadDataToBqTable(dataset, invalidEventsTable, invalidEventsSourceFile, eventsSchema);
  }

  @Test
  public void testEventsCreateBigQueryTable() {
    String outputResult = bout.toString();

    assertThat(outputResult).contains("Json from GCS successfully loaded in a table 'events'.");
    assertThat(outputResult)
        .contains("Json from GCS successfully loaded in a table 'events_some_invalid'.");
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(originalPrintStream);
  }
}