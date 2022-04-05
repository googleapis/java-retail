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

package events;

import static com.google.common.truth.Truth.assertThat;
import static events.ImportUserEventsGcs.getImportEventsGcsRequest;
import static events.ImportUserEventsGcs.importUserEventsFromGcs;
import static events.setup.EventsCreateGcsBucket.createGcsBucketAndUploadData;

import com.google.cloud.ServiceOptions;
import com.google.cloud.retail.v2.ImportUserEventsRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ImportUserEventsGcsTest {

  private ByteArrayOutputStream bout;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() throws IOException, InterruptedException {
    String projectId = ServiceOptions.getDefaultProjectId();
    String defaultCatalog =
        String.format("projects/%s/locations/global/catalogs/default_catalog", projectId);
    String bucketName = "events_tests_bucket";
    String gcsBucket = String.format("gs://%s", bucketName);
    String gcsErrorsBucket = String.format("%s/error", gcsBucket);
    String gcsEventsObject = "user_events.json";

    bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);

    createGcsBucketAndUploadData(bucketName);
    ImportUserEventsRequest importEventsGcsRequest = getImportEventsGcsRequest(
        gcsEventsObject, gcsBucket, gcsErrorsBucket, defaultCatalog);
    importUserEventsFromGcs(importEventsGcsRequest);
  }

  @Test
  public void testImportUserEventsGcs() {
    String outputResult = bout.toString();

    assertThat(outputResult).contains("Import user events from google cloud source request");
    assertThat(outputResult).contains("Number of successfully imported events");
    assertThat(outputResult).contains("Number of failures during the importing");
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(originalPrintStream);
  }
}
