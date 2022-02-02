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

// [START retail_search_for_products_with_query_parameter]

/*
 * Call Retail API to search for a products in a catalog
 * using only search query.
 */

package search;

import com.google.cloud.retail.v2.SearchRequest;
import com.google.cloud.retail.v2.SearchResponse;
import com.google.cloud.retail.v2.SearchServiceClient;
import java.io.IOException;
import java.util.UUID;

public class SearchSimpleQuery {

  public static void main(String[] args) throws IOException {

    String projectNumber = System.getenv("PROJECT_NUMBER");

    String defaultCatalogName =
        String.format("projects/%s/locations/global/catalogs/default_catalog",
            projectNumber);

    String defaultSearchPlacementName =
        defaultCatalogName + "/placements/default_search";

    search(defaultSearchPlacementName);
  }

  /**
   * Call the retail search.
   *
   * @return SearchResponse.
   * @throws IOException if endpoint is not provided.
   */
  public static SearchResponse search(String defaultSearchPlacementName)
      throws IOException {
    // TRY DIFFERENT QUERY PHRASES HERE:
    String queryPhrase = "Hoodie";

    SearchRequest searchRequest =
        getSearchRequest(queryPhrase, defaultSearchPlacementName);

    SearchResponse searchResponse =
        SearchServiceClient.create()
            .search(searchRequest)
            .getPage()
            .getResponse();

    System.out.println("Search response: " + searchResponse);

    return searchResponse;
  }

  /**
   * Get search service request.
   *
   * @param query search keyword.
   * @return SearchRequest.
   */
  public static SearchRequest getSearchRequest(String query,
      String defaultSearchPlacementName) {
    int pageSize = 10;

    String visitorId = UUID.randomUUID().toString();

    SearchRequest searchRequest =
        SearchRequest.newBuilder()
            .setPlacement(defaultSearchPlacementName)
            .setQuery(query)
            .setVisitorId(visitorId)
            .setPageSize(pageSize)
            .build();

    System.out.println("Search request: " + searchRequest);

    return searchRequest;
  }
}

// [END retail_search_for_products_with_query_parameter]
