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
 * [START retail_search_for_products_with_page_size]
 * Call Retail API to search for a products in a catalog,
 * limit the number of the products per page and go to the next page using "next_page_token"
 * or jump to chosen page using "offset".
 */

package search;

import com.google.cloud.retail.v2.SearchRequest;
import com.google.cloud.retail.v2.SearchResponse;
import com.google.cloud.retail.v2.SearchServiceClient;
import com.google.cloud.retail.v2.SearchServiceSettings;

import java.io.IOException;
import java.util.UUID;

public class SearchWithPagination {

  private static final String YOUR_PROJECT_NUMBER = System.getenv("PROJECT_NUMBER");
  private static final String ENDPOINT = "retail.googleapis.com:443";
  private static final String DEFAULT_CATALOG_NAME =
      String.format("projects/%s/locations/global/catalogs/default_catalog", YOUR_PROJECT_NUMBER);
  private static final String DEFAULT_SEARCH_PLACEMENT_NAME =
      DEFAULT_CATALOG_NAME + "/placements/default_search";
  private static final String VISITOR_ID = UUID.randomUUID().toString();

  // get search service client
  private static SearchServiceClient getSearchServiceClient() throws IOException {
    SearchServiceSettings settings = SearchServiceSettings.newBuilder()
        .setEndpoint(ENDPOINT)
        .build();
    return SearchServiceClient.create(settings);
  }

  // get search service request
  public static SearchRequest getSearchRequest(String query, int pageSize,
      int offset, String pageToken) {

    SearchRequest searchRequest = SearchRequest.newBuilder()
        .setPlacement(DEFAULT_SEARCH_PLACEMENT_NAME)
        .setVisitorId(VISITOR_ID) // A unique identifier to track visitors
        .setQuery(query)
        .setPageSize(pageSize)
        .setOffset(offset)
        .setPageToken(pageToken)
        .build();

    System.out.println("Search request: " + searchRequest);

    return searchRequest;
  }

  // call the Retail Search
  public static SearchResponse search() throws IOException, InterruptedException {
    // TRY DIFFERENT PAGINATION PARAMETERS HERE:
    int pageSize = 6;
    int offset = 0;
    String pageToken = "";

    SearchRequest searchRequestFirstPage = getSearchRequest("Hoodie", pageSize, offset, pageToken);

    SearchResponse searchResponseFirstPage = getSearchServiceClient().search(searchRequestFirstPage)
        .getPage().getResponse();

    System.out.println("Search response: " + searchResponseFirstPage);

    // PASTE CALL WITH NEXT PAGE TOKEN HERE:

    // PASTE CALL WITH OFFSET HERE:

    return searchResponseFirstPage;
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    search();
  }
}

// [END retail_search_for_products_with_page_size]