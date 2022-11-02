// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/retail/v2/catalog.proto

package com.google.cloud.retail.v2;

public interface CatalogAttributeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.retail.v2.CatalogAttribute)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Required. Attribute name.
   * For example: `color`, `brands`, `attributes.custom_attribute`, such as
   * `attributes.xyz`.
   * To be indexable, the attribute name can contain only alpha-numeric
   * characters and underscores. For example, an attribute named
   * `attributes.abc_xyz` can be indexed, but an attribute named
   * `attributes.abc-xyz` cannot be indexed.
   * </pre>
   *
   * <code>string key = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The key.
   */
  java.lang.String getKey();
  /**
   * <pre>
   * Required. Attribute name.
   * For example: `color`, `brands`, `attributes.custom_attribute`, such as
   * `attributes.xyz`.
   * To be indexable, the attribute name can contain only alpha-numeric
   * characters and underscores. For example, an attribute named
   * `attributes.abc_xyz` can be indexed, but an attribute named
   * `attributes.abc-xyz` cannot be indexed.
   * </pre>
   *
   * <code>string key = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The bytes for key.
   */
  com.google.protobuf.ByteString
      getKeyBytes();

  /**
   * <pre>
   * Output only. Indicates whether this attribute has been used by any
   * products. `True` if at least one [Product][google.cloud.retail.v2.Product]
   * is using this attribute in
   * [Product.attributes][google.cloud.retail.v2.Product.attributes]. Otherwise,
   * this field is `False`.
   * [CatalogAttribute][google.cloud.retail.v2.CatalogAttribute] can be
   * pre-loaded by using
   * [CatalogService.AddCatalogAttribute][google.cloud.retail.v2.CatalogService.AddCatalogAttribute],
   * [CatalogService.ImportCatalogAttributes][], or
   * [CatalogService.UpdateAttributesConfig][google.cloud.retail.v2.CatalogService.UpdateAttributesConfig]
   * APIs. This field is `False` for pre-loaded
   * [CatalogAttribute][google.cloud.retail.v2.CatalogAttribute]s.
   * Only pre-loaded
   * [CatalogAttribute][google.cloud.retail.v2.CatalogAttribute]s that are
   * neither in use by products nor predefined can be deleted.
   * [CatalogAttribute][google.cloud.retail.v2.CatalogAttribute]s that are
   * either in use by products or are predefined cannot be deleted; however,
   * their configuration properties will reset to default values upon removal
   * request.
   * After catalog changes, it takes about 10 minutes for this field to update.
   * </pre>
   *
   * <code>bool in_use = 9 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return The inUse.
   */
  boolean getInUse();

  /**
   * <pre>
   * Output only. The type of this attribute. This is derived from the attribute
   * in [Product.attributes][google.cloud.retail.v2.Product.attributes].
   * </pre>
   *
   * <code>.google.cloud.retail.v2.CatalogAttribute.AttributeType type = 10 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return The enum numeric value on the wire for type.
   */
  int getTypeValue();
  /**
   * <pre>
   * Output only. The type of this attribute. This is derived from the attribute
   * in [Product.attributes][google.cloud.retail.v2.Product.attributes].
   * </pre>
   *
   * <code>.google.cloud.retail.v2.CatalogAttribute.AttributeType type = 10 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return The type.
   */
  com.google.cloud.retail.v2.CatalogAttribute.AttributeType getType();

  /**
   * <pre>
   * When
   * [AttributesConfig.attribute_config_level][google.cloud.retail.v2.AttributesConfig.attribute_config_level]
   * is CATALOG_LEVEL_ATTRIBUTE_CONFIG, if INDEXABLE_ENABLED attribute values
   * are indexed so that it can be filtered, faceted, or boosted in
   * [SearchService.Search][google.cloud.retail.v2.SearchService.Search].
   * </pre>
   *
   * <code>.google.cloud.retail.v2.CatalogAttribute.IndexableOption indexable_option = 5;</code>
   * @return The enum numeric value on the wire for indexableOption.
   */
  int getIndexableOptionValue();
  /**
   * <pre>
   * When
   * [AttributesConfig.attribute_config_level][google.cloud.retail.v2.AttributesConfig.attribute_config_level]
   * is CATALOG_LEVEL_ATTRIBUTE_CONFIG, if INDEXABLE_ENABLED attribute values
   * are indexed so that it can be filtered, faceted, or boosted in
   * [SearchService.Search][google.cloud.retail.v2.SearchService.Search].
   * </pre>
   *
   * <code>.google.cloud.retail.v2.CatalogAttribute.IndexableOption indexable_option = 5;</code>
   * @return The indexableOption.
   */
  com.google.cloud.retail.v2.CatalogAttribute.IndexableOption getIndexableOption();

  /**
   * <pre>
   * If DYNAMIC_FACETABLE_ENABLED, attribute values are available for dynamic
   * facet. Could only be DYNAMIC_FACETABLE_DISABLED if
   * [CatalogAttribute.indexable_option][google.cloud.retail.v2.CatalogAttribute.indexable_option]
   * is INDEXABLE_DISABLED. Otherwise, an INVALID_ARGUMENT error is returned.
   * </pre>
   *
   * <code>.google.cloud.retail.v2.CatalogAttribute.DynamicFacetableOption dynamic_facetable_option = 6;</code>
   * @return The enum numeric value on the wire for dynamicFacetableOption.
   */
  int getDynamicFacetableOptionValue();
  /**
   * <pre>
   * If DYNAMIC_FACETABLE_ENABLED, attribute values are available for dynamic
   * facet. Could only be DYNAMIC_FACETABLE_DISABLED if
   * [CatalogAttribute.indexable_option][google.cloud.retail.v2.CatalogAttribute.indexable_option]
   * is INDEXABLE_DISABLED. Otherwise, an INVALID_ARGUMENT error is returned.
   * </pre>
   *
   * <code>.google.cloud.retail.v2.CatalogAttribute.DynamicFacetableOption dynamic_facetable_option = 6;</code>
   * @return The dynamicFacetableOption.
   */
  com.google.cloud.retail.v2.CatalogAttribute.DynamicFacetableOption getDynamicFacetableOption();

  /**
   * <pre>
   * When
   * [AttributesConfig.attribute_config_level][google.cloud.retail.v2.AttributesConfig.attribute_config_level]
   * is CATALOG_LEVEL_ATTRIBUTE_CONFIG, if SEARCHABLE_ENABLED, attribute values
   * are searchable by text queries in
   * [SearchService.Search][google.cloud.retail.v2.SearchService.Search].
   * If SEARCHABLE_ENABLED but attribute type is numerical, attribute values
   * will not be searchable by text queries in
   * [SearchService.Search][google.cloud.retail.v2.SearchService.Search], as
   * there are no text values associated to numerical attributes.
   * </pre>
   *
   * <code>.google.cloud.retail.v2.CatalogAttribute.SearchableOption searchable_option = 7;</code>
   * @return The enum numeric value on the wire for searchableOption.
   */
  int getSearchableOptionValue();
  /**
   * <pre>
   * When
   * [AttributesConfig.attribute_config_level][google.cloud.retail.v2.AttributesConfig.attribute_config_level]
   * is CATALOG_LEVEL_ATTRIBUTE_CONFIG, if SEARCHABLE_ENABLED, attribute values
   * are searchable by text queries in
   * [SearchService.Search][google.cloud.retail.v2.SearchService.Search].
   * If SEARCHABLE_ENABLED but attribute type is numerical, attribute values
   * will not be searchable by text queries in
   * [SearchService.Search][google.cloud.retail.v2.SearchService.Search], as
   * there are no text values associated to numerical attributes.
   * </pre>
   *
   * <code>.google.cloud.retail.v2.CatalogAttribute.SearchableOption searchable_option = 7;</code>
   * @return The searchableOption.
   */
  com.google.cloud.retail.v2.CatalogAttribute.SearchableOption getSearchableOption();
}
