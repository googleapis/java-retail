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

package events;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.StreamGobbler;

public class PurgeUserEventTest {

  private String output;

  @Before
  public void setUp()
      throws IOException, InterruptedException, ExecutionException {

    Process exec = Runtime.getRuntime()
        .exec(
            "mvn compile exec:java -Dexec.mainClass=events.PurgeUserEvent");

    StreamGobbler streamGobbler = new StreamGobbler(exec.getInputStream());

    Future<String> stringFuture = Executors.newSingleThreadExecutor()
        .submit(streamGobbler);

    output = stringFuture.get();
  }

  @Test
  public void testPurgeUserEvent() {
    Assert.assertTrue(output.matches("(?s)^(.*The user event is written.*)$"));

    Assert.assertTrue(output.matches(
        "(?s)^(.*Purge user events request.*?parent: \"projects/.*?/locations/global/catalogs/default_catalog.*)$"));

    Assert.assertTrue(output.matches(
        "(?s)^(.*Purge user events request.*?filter: \"visitorId=.*?test_visitor_id.*?\".*)$"));

    Assert.assertTrue(output.matches(
        "(?s)^(.*Purge user events request.*?parent: \"projects/.*?/locations/global/catalogs/default_catalog.*)$"));

    Assert.assertTrue(
        output.matches("(?s)^(.*Purge user events request.*?force: true.*)$"));

    Assert.assertTrue(output.matches(
        "(?s)^(.*The purge operation was started.*?projects/.*?/locations/global/catalogs/default_catalog/operations/purge-user-events.*)$"));
  }
}
