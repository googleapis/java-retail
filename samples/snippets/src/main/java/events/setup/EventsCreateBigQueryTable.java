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

package events.setup;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import static events.setup.EventsCreateGcsBucket.eventsCreateGcsBucketAndUploadJsonFiles;
import static events.setup.SetupCleanup.createBqDataset;
import static events.setup.SetupCleanup.createBqTable;
import static events.setup.SetupCleanup.uploadDataToBqTable;

public class EventsCreateBigQueryTable {

  public static void main(String[] args) throws IOException {

    eventsCreateGcsBucketAndUploadJsonFiles();

    String dataset = "user_events";

    String validEventsTable = "events";

    String invalidEventsTable = "events_some_invalid";

    String eventsSchemaFilePath = "src/main/resources/event_schema.json";

    String validEventsSourceFile = String.format(
        "gs://%s/user_events.json",
        EventsCreateGcsBucket.getBucketName());

    String invalidEventsSourceFile = String.format(
        "gs://%s/user_events_some_invalid.json",
        EventsCreateGcsBucket.getBucketName());

    BufferedReader bufferedReader = new BufferedReader(
        new FileReader(eventsSchemaFilePath));

    String jsonToString = bufferedReader.lines().collect(Collectors.joining());

    jsonToString = jsonToString.replace("\"fields\"", "\"subFields\"");

    Field[] fields = getGson().fromJson(jsonToString, Field[].class);

    Schema eventsSchema = Schema.of(fields);

    createBqDataset(dataset);

    createBqTable(dataset, validEventsTable, eventsSchema);

    uploadDataToBqTable(dataset, validEventsTable, validEventsSourceFile,
        eventsSchema);

    createBqTable(dataset, invalidEventsTable, eventsSchema);

    uploadDataToBqTable(dataset, invalidEventsTable, invalidEventsSourceFile,
        eventsSchema);
  }

  public static Gson getGson() {
    JsonDeserializer<LegacySQLTypeName> typeDeserializer = (jsonElement, type, deserializationContext) -> {
      return LegacySQLTypeName.valueOf(jsonElement.getAsString());
    };

    JsonDeserializer<FieldList> subFieldsDeserializer = (jsonElement, type, deserializationContext) -> {
      Field[] fields = deserializationContext.deserialize(
          jsonElement.getAsJsonArray(), Field[].class);
      return FieldList.of(fields);
    };

    return new GsonBuilder()
        .registerTypeAdapter(LegacySQLTypeName.class, typeDeserializer)
        .registerTypeAdapter(FieldList.class, subFieldsDeserializer)
        .create();
  }
}
