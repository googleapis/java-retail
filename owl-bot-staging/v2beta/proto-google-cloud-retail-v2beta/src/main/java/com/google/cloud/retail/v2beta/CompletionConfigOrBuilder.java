// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/retail/v2beta/catalog.proto

package com.google.cloud.retail.v2beta;

public interface CompletionConfigOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.retail.v2beta.CompletionConfig)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Required. Immutable. Fully qualified name
   * `projects/&#42;&#47;locations/&#42;&#47;catalogs/&#42;&#47;completionConfig`
   * </pre>
   *
   * <code>string name = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.field_behavior) = IMMUTABLE];</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <pre>
   * Required. Immutable. Fully qualified name
   * `projects/&#42;&#47;locations/&#42;&#47;catalogs/&#42;&#47;completionConfig`
   * </pre>
   *
   * <code>string name = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.field_behavior) = IMMUTABLE];</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <pre>
   * Specifies the matching order for autocomplete suggestions, e.g., a query
   * consisting of 'sh' with 'out-of-order' specified would suggest "women's
   * shoes", whereas a query of 'red s' with 'exact-prefix' specified would
   * suggest "red shoes". Currently supported values:
   * * 'out-of-order'
   * * 'exact-prefix'
   * Default value: 'exact-prefix'.
   * </pre>
   *
   * <code>string matching_order = 2;</code>
   * @return The matchingOrder.
   */
  java.lang.String getMatchingOrder();
  /**
   * <pre>
   * Specifies the matching order for autocomplete suggestions, e.g., a query
   * consisting of 'sh' with 'out-of-order' specified would suggest "women's
   * shoes", whereas a query of 'red s' with 'exact-prefix' specified would
   * suggest "red shoes". Currently supported values:
   * * 'out-of-order'
   * * 'exact-prefix'
   * Default value: 'exact-prefix'.
   * </pre>
   *
   * <code>string matching_order = 2;</code>
   * @return The bytes for matchingOrder.
   */
  com.google.protobuf.ByteString
      getMatchingOrderBytes();

  /**
   * <pre>
   * The maximum number of autocomplete suggestions returned per term. The
   * maximum allowed max suggestions is 20. Default value is 20. If left unset
   * or set to 0, then will fallback to default value.
   * </pre>
   *
   * <code>int32 max_suggestions = 3;</code>
   * @return The maxSuggestions.
   */
  int getMaxSuggestions();

  /**
   * <pre>
   * The minimum number of characters needed to be typed in order to get
   * suggestions. Default value is 2. If left unset or set to 0, then will
   * fallback to default value.
   * </pre>
   *
   * <code>int32 min_prefix_length = 4;</code>
   * @return The minPrefixLength.
   */
  int getMinPrefixLength();

  /**
   * <pre>
   * If set to true, the auto learning function is enabled. Auto learning uses
   * user data to generate suggestions using ML techniques. Default value is
   * false. Only after enabling auto learning can users use `cloud-retail`
   * data in
   * [CompleteQueryRequest][google.cloud.retail.v2beta.CompleteQueryRequest].
   * </pre>
   *
   * <code>bool auto_learning = 11;</code>
   * @return The autoLearning.
   */
  boolean getAutoLearning();

  /**
   * <pre>
   * Output only. The input config for the import of the source data that
   * contains the autocomplete phrases uploaded by the customer.
   * </pre>
   *
   * <code>.google.cloud.retail.v2beta.CompletionDataInputConfig suggestions_input_config = 5 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return Whether the suggestionsInputConfig field is set.
   */
  boolean hasSuggestionsInputConfig();
  /**
   * <pre>
   * Output only. The input config for the import of the source data that
   * contains the autocomplete phrases uploaded by the customer.
   * </pre>
   *
   * <code>.google.cloud.retail.v2beta.CompletionDataInputConfig suggestions_input_config = 5 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return The suggestionsInputConfig.
   */
  com.google.cloud.retail.v2beta.CompletionDataInputConfig getSuggestionsInputConfig();
  /**
   * <pre>
   * Output only. The input config for the import of the source data that
   * contains the autocomplete phrases uploaded by the customer.
   * </pre>
   *
   * <code>.google.cloud.retail.v2beta.CompletionDataInputConfig suggestions_input_config = 5 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   */
  com.google.cloud.retail.v2beta.CompletionDataInputConfigOrBuilder getSuggestionsInputConfigOrBuilder();

  /**
   * <pre>
   * Output only. Name of the LRO corresponding to the latest suggestion terms
   * list import.
   * Can use [GetOperation][google.longrunning.Operations.GetOperation] API to
   * retrieve the latest state of the Long Running Operation.
   * </pre>
   *
   * <code>string last_suggestions_import_operation = 6 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return The lastSuggestionsImportOperation.
   */
  java.lang.String getLastSuggestionsImportOperation();
  /**
   * <pre>
   * Output only. Name of the LRO corresponding to the latest suggestion terms
   * list import.
   * Can use [GetOperation][google.longrunning.Operations.GetOperation] API to
   * retrieve the latest state of the Long Running Operation.
   * </pre>
   *
   * <code>string last_suggestions_import_operation = 6 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return The bytes for lastSuggestionsImportOperation.
   */
  com.google.protobuf.ByteString
      getLastSuggestionsImportOperationBytes();

  /**
   * <pre>
   * Output only. The input config for the import of the source data that
   * contains the / autocomplete denylist phrases uploaded by the customer.
   * </pre>
   *
   * <code>.google.cloud.retail.v2beta.CompletionDataInputConfig denylist_input_config = 7 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return Whether the denylistInputConfig field is set.
   */
  boolean hasDenylistInputConfig();
  /**
   * <pre>
   * Output only. The input config for the import of the source data that
   * contains the / autocomplete denylist phrases uploaded by the customer.
   * </pre>
   *
   * <code>.google.cloud.retail.v2beta.CompletionDataInputConfig denylist_input_config = 7 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return The denylistInputConfig.
   */
  com.google.cloud.retail.v2beta.CompletionDataInputConfig getDenylistInputConfig();
  /**
   * <pre>
   * Output only. The input config for the import of the source data that
   * contains the / autocomplete denylist phrases uploaded by the customer.
   * </pre>
   *
   * <code>.google.cloud.retail.v2beta.CompletionDataInputConfig denylist_input_config = 7 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   */
  com.google.cloud.retail.v2beta.CompletionDataInputConfigOrBuilder getDenylistInputConfigOrBuilder();

  /**
   * <pre>
   * Output only. LRO corresponding to the latest denylist import.
   * Can use [GetOperation][google.longrunning.Operations.GetOperation] API to
   * retrieve the latest state of the Long Running Operation.
   * </pre>
   *
   * <code>string last_denylist_import_operation = 8 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return The lastDenylistImportOperation.
   */
  java.lang.String getLastDenylistImportOperation();
  /**
   * <pre>
   * Output only. LRO corresponding to the latest denylist import.
   * Can use [GetOperation][google.longrunning.Operations.GetOperation] API to
   * retrieve the latest state of the Long Running Operation.
   * </pre>
   *
   * <code>string last_denylist_import_operation = 8 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return The bytes for lastDenylistImportOperation.
   */
  com.google.protobuf.ByteString
      getLastDenylistImportOperationBytes();

  /**
   * <pre>
   * Output only. The input config for the import of the source data that
   * contains the autocomplete allowlist phrases uploaded by the customer.
   * </pre>
   *
   * <code>.google.cloud.retail.v2beta.CompletionDataInputConfig allowlist_input_config = 9 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return Whether the allowlistInputConfig field is set.
   */
  boolean hasAllowlistInputConfig();
  /**
   * <pre>
   * Output only. The input config for the import of the source data that
   * contains the autocomplete allowlist phrases uploaded by the customer.
   * </pre>
   *
   * <code>.google.cloud.retail.v2beta.CompletionDataInputConfig allowlist_input_config = 9 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return The allowlistInputConfig.
   */
  com.google.cloud.retail.v2beta.CompletionDataInputConfig getAllowlistInputConfig();
  /**
   * <pre>
   * Output only. The input config for the import of the source data that
   * contains the autocomplete allowlist phrases uploaded by the customer.
   * </pre>
   *
   * <code>.google.cloud.retail.v2beta.CompletionDataInputConfig allowlist_input_config = 9 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   */
  com.google.cloud.retail.v2beta.CompletionDataInputConfigOrBuilder getAllowlistInputConfigOrBuilder();

  /**
   * <pre>
   * Output only. LRO corresponding to the latest allowlist import.
   * Can use [GetOperation][google.longrunning.Operations.GetOperation] API to
   * retrieve the latest state of the Long Running Operation.
   * </pre>
   *
   * <code>string last_allowlist_import_operation = 10 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return The lastAllowlistImportOperation.
   */
  java.lang.String getLastAllowlistImportOperation();
  /**
   * <pre>
   * Output only. LRO corresponding to the latest allowlist import.
   * Can use [GetOperation][google.longrunning.Operations.GetOperation] API to
   * retrieve the latest state of the Long Running Operation.
   * </pre>
   *
   * <code>string last_allowlist_import_operation = 10 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return The bytes for lastAllowlistImportOperation.
   */
  com.google.protobuf.ByteString
      getLastAllowlistImportOperationBytes();
}
