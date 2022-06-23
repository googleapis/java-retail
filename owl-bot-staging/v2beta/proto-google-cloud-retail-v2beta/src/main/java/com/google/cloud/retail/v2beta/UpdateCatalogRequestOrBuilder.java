// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/retail/v2beta/catalog_service.proto

package com.google.cloud.retail.v2beta;

public interface UpdateCatalogRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.retail.v2beta.UpdateCatalogRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Required. The [Catalog][google.cloud.retail.v2beta.Catalog] to update.
   * If the caller does not have permission to update the
   * [Catalog][google.cloud.retail.v2beta.Catalog], regardless of whether or not
   * it exists, a PERMISSION_DENIED error is returned.
   * If the [Catalog][google.cloud.retail.v2beta.Catalog] to update does not
   * exist, a NOT_FOUND error is returned.
   * </pre>
   *
   * <code>.google.cloud.retail.v2beta.Catalog catalog = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return Whether the catalog field is set.
   */
  boolean hasCatalog();
  /**
   * <pre>
   * Required. The [Catalog][google.cloud.retail.v2beta.Catalog] to update.
   * If the caller does not have permission to update the
   * [Catalog][google.cloud.retail.v2beta.Catalog], regardless of whether or not
   * it exists, a PERMISSION_DENIED error is returned.
   * If the [Catalog][google.cloud.retail.v2beta.Catalog] to update does not
   * exist, a NOT_FOUND error is returned.
   * </pre>
   *
   * <code>.google.cloud.retail.v2beta.Catalog catalog = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The catalog.
   */
  com.google.cloud.retail.v2beta.Catalog getCatalog();
  /**
   * <pre>
   * Required. The [Catalog][google.cloud.retail.v2beta.Catalog] to update.
   * If the caller does not have permission to update the
   * [Catalog][google.cloud.retail.v2beta.Catalog], regardless of whether or not
   * it exists, a PERMISSION_DENIED error is returned.
   * If the [Catalog][google.cloud.retail.v2beta.Catalog] to update does not
   * exist, a NOT_FOUND error is returned.
   * </pre>
   *
   * <code>.google.cloud.retail.v2beta.Catalog catalog = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  com.google.cloud.retail.v2beta.CatalogOrBuilder getCatalogOrBuilder();

  /**
   * <pre>
   * Indicates which fields in the provided
   * [Catalog][google.cloud.retail.v2beta.Catalog] to update.
   * If an unsupported or unknown field is provided, an INVALID_ARGUMENT error
   * is returned.
   * </pre>
   *
   * <code>.google.protobuf.FieldMask update_mask = 2;</code>
   * @return Whether the updateMask field is set.
   */
  boolean hasUpdateMask();
  /**
   * <pre>
   * Indicates which fields in the provided
   * [Catalog][google.cloud.retail.v2beta.Catalog] to update.
   * If an unsupported or unknown field is provided, an INVALID_ARGUMENT error
   * is returned.
   * </pre>
   *
   * <code>.google.protobuf.FieldMask update_mask = 2;</code>
   * @return The updateMask.
   */
  com.google.protobuf.FieldMask getUpdateMask();
  /**
   * <pre>
   * Indicates which fields in the provided
   * [Catalog][google.cloud.retail.v2beta.Catalog] to update.
   * If an unsupported or unknown field is provided, an INVALID_ARGUMENT error
   * is returned.
   * </pre>
   *
   * <code>.google.protobuf.FieldMask update_mask = 2;</code>
   */
  com.google.protobuf.FieldMaskOrBuilder getUpdateMaskOrBuilder();
}
