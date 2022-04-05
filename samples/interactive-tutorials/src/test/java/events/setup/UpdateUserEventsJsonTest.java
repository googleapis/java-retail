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
import static events.setup.UpdateUserEventsJson.updateEventsTimestamp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UpdateUserEventsJsonTest {

  private ByteArrayOutputStream bout;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() throws IOException, InterruptedException, ExecutionException {
    String filePath = "src/test/java/resources/user_events.json";
    String invalidFilePath = "src/test/java/resources/user_events_some_invalid.json";
    bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);

    updateEventsTimestamp(filePath);
    updateEventsTimestamp(invalidFilePath);
  }

  @Test
  public void testUpdateUserEventsJson() {
    String outputResult = bout.toString();

    assertThat(outputResult).contains("User events file 'src/test/java/resources/user_events.json' updated.");
    assertThat(outputResult).contains("User events file 'src/test/java/resources/user_events_some_invalid.json' updated.");
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(originalPrintStream);
  }
}
