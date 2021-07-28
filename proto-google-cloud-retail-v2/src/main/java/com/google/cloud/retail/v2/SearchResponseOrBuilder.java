/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/retail/v2/search_service.proto

package com.google.cloud.retail.v2;

public interface SearchResponseOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.retail.v2.SearchResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * A list of matched items. The order represents the ranking.
   * </pre>
   *
   * <code>repeated .google.cloud.retail.v2.SearchResponse.SearchResult results = 1;</code>
   */
  java.util.List<com.google.cloud.retail.v2.SearchResponse.SearchResult> getResultsList();
  /**
   *
   *
   * <pre>
   * A list of matched items. The order represents the ranking.
   * </pre>
   *
   * <code>repeated .google.cloud.retail.v2.SearchResponse.SearchResult results = 1;</code>
   */
  com.google.cloud.retail.v2.SearchResponse.SearchResult getResults(int index);
  /**
   *
   *
   * <pre>
   * A list of matched items. The order represents the ranking.
   * </pre>
   *
   * <code>repeated .google.cloud.retail.v2.SearchResponse.SearchResult results = 1;</code>
   */
  int getResultsCount();
  /**
   *
   *
   * <pre>
   * A list of matched items. The order represents the ranking.
   * </pre>
   *
   * <code>repeated .google.cloud.retail.v2.SearchResponse.SearchResult results = 1;</code>
   */
  java.util.List<? extends com.google.cloud.retail.v2.SearchResponse.SearchResultOrBuilder>
      getResultsOrBuilderList();
  /**
   *
   *
   * <pre>
   * A list of matched items. The order represents the ranking.
   * </pre>
   *
   * <code>repeated .google.cloud.retail.v2.SearchResponse.SearchResult results = 1;</code>
   */
  com.google.cloud.retail.v2.SearchResponse.SearchResultOrBuilder getResultsOrBuilder(int index);

  /**
   *
   *
   * <pre>
   * Results of facets requested by user.
   * </pre>
   *
   * <code>repeated .google.cloud.retail.v2.SearchResponse.Facet facets = 2;</code>
   */
  java.util.List<com.google.cloud.retail.v2.SearchResponse.Facet> getFacetsList();
  /**
   *
   *
   * <pre>
   * Results of facets requested by user.
   * </pre>
   *
   * <code>repeated .google.cloud.retail.v2.SearchResponse.Facet facets = 2;</code>
   */
  com.google.cloud.retail.v2.SearchResponse.Facet getFacets(int index);
  /**
   *
   *
   * <pre>
   * Results of facets requested by user.
   * </pre>
   *
   * <code>repeated .google.cloud.retail.v2.SearchResponse.Facet facets = 2;</code>
   */
  int getFacetsCount();
  /**
   *
   *
   * <pre>
   * Results of facets requested by user.
   * </pre>
   *
   * <code>repeated .google.cloud.retail.v2.SearchResponse.Facet facets = 2;</code>
   */
  java.util.List<? extends com.google.cloud.retail.v2.SearchResponse.FacetOrBuilder>
      getFacetsOrBuilderList();
  /**
   *
   *
   * <pre>
   * Results of facets requested by user.
   * </pre>
   *
   * <code>repeated .google.cloud.retail.v2.SearchResponse.Facet facets = 2;</code>
   */
  com.google.cloud.retail.v2.SearchResponse.FacetOrBuilder getFacetsOrBuilder(int index);

  /**
   *
   *
   * <pre>
   * The estimated total count of matched items irrespective of pagination. The
   * count of [results][google.cloud.retail.v2.SearchResponse.results] returned
   * by pagination may be less than the
   * [total_size][google.cloud.retail.v2.SearchResponse.total_size] that
   * matches.
   * </pre>
   *
   * <code>int32 total_size = 3;</code>
   *
   * @return The totalSize.
   */
  int getTotalSize();

  /**
   *
   *
   * <pre>
   * If spell correction applies, the corrected query. Otherwise, empty.
   * </pre>
   *
   * <code>string corrected_query = 4;</code>
   *
   * @return The correctedQuery.
   */
  java.lang.String getCorrectedQuery();
  /**
   *
   *
   * <pre>
   * If spell correction applies, the corrected query. Otherwise, empty.
   * </pre>
   *
   * <code>string corrected_query = 4;</code>
   *
   * @return The bytes for correctedQuery.
   */
  com.google.protobuf.ByteString getCorrectedQueryBytes();

  /**
   *
   *
   * <pre>
   * A unique search token. This should be included in the
   * [UserEvent][google.cloud.retail.v2.UserEvent] logs resulting from this
   * search, which enables accurate attribution of search model performance.
   * </pre>
   *
   * <code>string attribution_token = 5;</code>
   *
   * @return The attributionToken.
   */
  java.lang.String getAttributionToken();
  /**
   *
   *
   * <pre>
   * A unique search token. This should be included in the
   * [UserEvent][google.cloud.retail.v2.UserEvent] logs resulting from this
   * search, which enables accurate attribution of search model performance.
   * </pre>
   *
   * <code>string attribution_token = 5;</code>
   *
   * @return The bytes for attributionToken.
   */
  com.google.protobuf.ByteString getAttributionTokenBytes();

  /**
   *
   *
   * <pre>
   * A token that can be sent as
   * [SearchRequest.page_token][google.cloud.retail.v2.SearchRequest.page_token]
   * to retrieve the next page. If this field is omitted, there are no
   * subsequent pages.
   * </pre>
   *
   * <code>string next_page_token = 6;</code>
   *
   * @return The nextPageToken.
   */
  java.lang.String getNextPageToken();
  /**
   *
   *
   * <pre>
   * A token that can be sent as
   * [SearchRequest.page_token][google.cloud.retail.v2.SearchRequest.page_token]
   * to retrieve the next page. If this field is omitted, there are no
   * subsequent pages.
   * </pre>
   *
   * <code>string next_page_token = 6;</code>
   *
   * @return The bytes for nextPageToken.
   */
  com.google.protobuf.ByteString getNextPageTokenBytes();

  /**
   *
   *
   * <pre>
   * Query expansion information for the returned results.
   * </pre>
   *
   * <code>.google.cloud.retail.v2.SearchResponse.QueryExpansionInfo query_expansion_info = 7;
   * </code>
   *
   * @return Whether the queryExpansionInfo field is set.
   */
  boolean hasQueryExpansionInfo();
  /**
   *
   *
   * <pre>
   * Query expansion information for the returned results.
   * </pre>
   *
   * <code>.google.cloud.retail.v2.SearchResponse.QueryExpansionInfo query_expansion_info = 7;
   * </code>
   *
   * @return The queryExpansionInfo.
   */
  com.google.cloud.retail.v2.SearchResponse.QueryExpansionInfo getQueryExpansionInfo();
  /**
   *
   *
   * <pre>
   * Query expansion information for the returned results.
   * </pre>
   *
   * <code>.google.cloud.retail.v2.SearchResponse.QueryExpansionInfo query_expansion_info = 7;
   * </code>
   */
  com.google.cloud.retail.v2.SearchResponse.QueryExpansionInfoOrBuilder
      getQueryExpansionInfoOrBuilder();

  /**
   *
   *
   * <pre>
   * The URI of a customer-defined redirect page. If redirect action is
   * triggered, no search will be performed, and only
   * [redirect_uri][google.cloud.retail.v2.SearchResponse.redirect_uri] and
   * [attribution_token][google.cloud.retail.v2.SearchResponse.attribution_token]
   * will be set in the response.
   * </pre>
   *
   * <code>string redirect_uri = 10;</code>
   *
   * @return The redirectUri.
   */
  java.lang.String getRedirectUri();
  /**
   *
   *
   * <pre>
   * The URI of a customer-defined redirect page. If redirect action is
   * triggered, no search will be performed, and only
   * [redirect_uri][google.cloud.retail.v2.SearchResponse.redirect_uri] and
   * [attribution_token][google.cloud.retail.v2.SearchResponse.attribution_token]
   * will be set in the response.
   * </pre>
   *
   * <code>string redirect_uri = 10;</code>
   *
   * @return The bytes for redirectUri.
   */
  com.google.protobuf.ByteString getRedirectUriBytes();
}
