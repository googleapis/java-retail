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

package search;

import static com.google.common.truth.Truth.assertThat;
import static search.SearchSimpleQuery.getSearchResponse;

import com.google.cloud.ServiceOptions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchWithQueryExpansionSpecTest {

  private ByteArrayOutputStream bout;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() throws IOException, InterruptedException, ExecutionException {
    String projectId = ServiceOptions.getDefaultProjectId();
    String defaultCatalogName =
        String.format("projects/%s/locations/global/catalogs/default_catalog", projectId);
    String defaultSearchPlacementName = defaultCatalogName + "/placements/default_search";
    bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);

    getSearchResponse(defaultSearchPlacementName);
  }

  @Test
  public void testOutput() {
    String got = bout.toString();

    assertThat(got).contains("Search request");
    assertThat(got).contains("Search response");
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(originalPrintStream);
  }
}
