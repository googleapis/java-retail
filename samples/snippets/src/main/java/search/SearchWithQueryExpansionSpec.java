/*
 * Copyright 2021 Google Inc. All Rights Reserved.
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
 *
 * [START retail_search_for_products_with_query_expansion_specification]
 * Call Retail API to search for a products in a catalog,
 * enabling the query expansion feature to let the Google Retail Search
 * build an automatic query expansion.
 */

package search;

import com.google.cloud.retail.v2.SearchRequest;
import com.google.cloud.retail.v2.SearchRequest.QueryExpansionSpec;
import com.google.cloud.retail.v2.SearchRequest.QueryExpansionSpec.Condition;
import com.google.cloud.retail.v2.SearchResponse;
import com.google.cloud.retail.v2.SearchServiceClient;
import com.google.cloud.retail.v2.SearchServiceSettings;

import java.io.IOException;
import java.util.UUID;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SearchWithQueryExpansionSpec {

  /**
   * This variable describes project number getting from environment variable.
   */
  private static final String YOUR_PROJECT_NUMBER = System.getenv(
      "PROJECT_NUMBER");

  /**
   * This variable describes endpoint for send requests.
   */
  private static final String ENDPOINT = "retail.googleapis.com:443";

  /**
   * This variable describes default catalog name.
   */
  private static final String DEFAULT_CATALOG_NAME =
      String.format("projects/%s/locations/global/catalogs/default_catalog",
          YOUR_PROJECT_NUMBER);

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

  /**
   * Get search service client.
   *
   * @return SearchServiceClient.
   * @throws IOException if endpoint is incorrect.
   */
  private static SearchServiceClient getSearchServiceClient()
      throws IOException {
    SearchServiceSettings settings = SearchServiceSettings.newBuilder()
        .setEndpoint(ENDPOINT)
        .build();
    return SearchServiceClient.create(settings);
  }

  /**
   * Get search service request.
   *
   * @param query     search keyword.
   * @param condition provides search clarification.
   * @return SearchRequest.
   */
  public static SearchRequest getSearchRequest(final String query,
      final Condition condition) {

    int pageSize = 10;

    QueryExpansionSpec queryExpansionSpec = QueryExpansionSpec.newBuilder()
        .setCondition(condition)
        .build();

    SearchRequest searchRequest = SearchRequest.newBuilder()
        .setPlacement(DEFAULT_SEARCH_PLACEMENT_NAME)
        .setQuery(query)
        .setVisitorId(VISITOR_ID)
        .setQueryExpansionSpec(queryExpansionSpec)
        .setPageSize(pageSize)
        .build();

    System.out.println("Search request: " + searchRequest);

    return searchRequest;
  }

  /**
   * Call the retail search.
   *
   * @return SearchResponse.
   * @throws IOException if endpoint is not provided in getSearchServiceClient().
   */
  public static SearchResponse search() throws IOException {
    // TRY DIFFERENT QUERY EXPANSION CONDITION HERE:
    Condition condition = Condition.AUTO;

    SearchRequest searchRequest = getSearchRequest("Google Youth Hero Tee Grey",
        condition);

    SearchResponse searchResponse = getSearchServiceClient().search(
        searchRequest).getPage().getResponse();

    System.out.println("Search response: " + searchResponse);

    return searchResponse;
  }

  /**
   * Executable tutorial class.
   *
   * @throws IOException from the called method.
   */
  public static void main(final String[] args) throws IOException {
    search();
  }
}

// [END retail_search_for_products_with_query_expansion_specification]
