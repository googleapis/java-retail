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

/*
 * [START retail_search_product_with_facet_spec]
 */

package search;

import com.google.cloud.retail.v2.SearchRequest;
import com.google.cloud.retail.v2.SearchRequest.FacetSpec;
import com.google.cloud.retail.v2.SearchRequest.FacetSpec.FacetKey;
import com.google.cloud.retail.v2.SearchResponse;
import com.google.cloud.retail.v2.SearchServiceClient;
import java.io.IOException;
import java.util.UUID;

public final class SearchWithFacetSpec {

  /**
   * This variable describes project number getting from environment variable.
   */
  private static final String PROJECT_NUMBER = System.getenv(
      "PROJECT_NUMBER");

  /**
   * This variable describes default catalog name.
   */
  private static final String DEFAULT_CATALOG_NAME =
      String.format("projects/%s/locations/global/catalogs/default_catalog",
          PROJECT_NUMBER);

  /**
   * This variable describes default search placement name. Using for identify
   * the Serving Config name.
   */
  private static final String DEFAULT_SEARCH_PLACEMENT_NAME =
      DEFAULT_CATALOG_NAME + "/placements/default_search";

  /**
   * This variable describes a unique identifier to track visitors.
   */
  private static final String VISITOR_ID = UUID.randomUUID().toString();

  private SearchWithFacetSpec() {
  }

  /**
   * Get search service client.
   *
   * @return SearchServiceClient.
   * @throws IOException if endpoint is incorrect.
   */
  private static SearchServiceClient getSearchServiceClient()
      throws IOException {
    return SearchServiceClient.create();
  }

  /**
   * Get search service request.
   *
   * @param query         search keyword.
   * @param facetKeyParam Supported textual and numerical facet keys.
   * @return SearchRequest.
   */
  public static SearchRequest getSearchRequest(final String query,
      final String facetKeyParam) {

    final int pageSize = 10;

    FacetKey facetKey = FacetKey.newBuilder()
        .setKey(facetKeyParam)
        .build();

    FacetSpec facetSpec = FacetSpec.newBuilder()
        .setFacetKey(facetKey)
        .build();

    SearchRequest searchRequest = SearchRequest.newBuilder()
        .setPlacement(DEFAULT_SEARCH_PLACEMENT_NAME)
        .setQuery(query)
        .setVisitorId(VISITOR_ID)
        .addFacetSpecs(facetSpec)
        .setPageSize(pageSize)
        .build();

    System.out.println("Search request: " + searchRequest);

    return searchRequest;
  }

  /**
   * Call the retail search.
   *
   * @return SearchResponse.
   * @throws IOException if endpoint is not provided.
   */
  public static SearchResponse search() throws IOException {
    // TRY DIFFERENT CONDITIONS HERE:
    String facetKey = "colorFamilies";

    SearchRequest searchRequest = getSearchRequest("Tee", facetKey);

    SearchResponse searchResponse = getSearchServiceClient().search(
        searchRequest).getPage().getResponse();

    System.out.println("Search response: " + searchResponse);

    return searchResponse;
  }

  /**
   * Executable tutorial class.
   *
   * @param args command line arguments.
   * @throws IOException from the called method.
   */
  public static void main(final String[] args) throws IOException {
    search();
  }
}

// [END retail_search_product_with_facet_spec]
