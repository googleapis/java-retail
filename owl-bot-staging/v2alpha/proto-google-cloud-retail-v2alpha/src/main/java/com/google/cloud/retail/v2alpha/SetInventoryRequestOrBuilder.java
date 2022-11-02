// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/retail/v2alpha/product_service.proto

package com.google.cloud.retail.v2alpha;

public interface SetInventoryRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.retail.v2alpha.SetInventoryRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Required. The inventory information to update. The allowable fields to
   * update are:
   * * [Product.price_info][google.cloud.retail.v2alpha.Product.price_info]
   * * [Product.availability][google.cloud.retail.v2alpha.Product.availability]
   * * [Product.available_quantity][google.cloud.retail.v2alpha.Product.available_quantity]
   * * [Product.fulfillment_info][google.cloud.retail.v2alpha.Product.fulfillment_info]
   * The updated inventory fields must be specified in
   * [SetInventoryRequest.set_mask][google.cloud.retail.v2alpha.SetInventoryRequest.set_mask].
   * If
   * [SetInventoryRequest.inventory.name][google.cloud.retail.v2alpha.Product.name]
   * is empty or invalid, an INVALID_ARGUMENT error is returned.
   * If the caller does not have permission to update the
   * [Product][google.cloud.retail.v2alpha.Product] named in
   * [Product.name][google.cloud.retail.v2alpha.Product.name], regardless of
   * whether or not it exists, a PERMISSION_DENIED error is returned.
   * If the [Product][google.cloud.retail.v2alpha.Product] to update does not
   * have existing inventory information, the provided inventory information
   * will be inserted.
   * If the [Product][google.cloud.retail.v2alpha.Product] to update has
   * existing inventory information, the provided inventory information will be
   * merged while respecting the last update time for each inventory field,
   * using the provided or default value for
   * [SetInventoryRequest.set_time][google.cloud.retail.v2alpha.SetInventoryRequest.set_time].
   * The caller can replace place IDs for a subset of fulfillment types in the
   * following ways:
   * * Adds "fulfillment_info" in
   * [SetInventoryRequest.set_mask][google.cloud.retail.v2alpha.SetInventoryRequest.set_mask]
   * * Specifies only the desired fulfillment types and corresponding place IDs
   * to update in
   * [SetInventoryRequest.inventory.fulfillment_info][google.cloud.retail.v2alpha.Product.fulfillment_info]
   * The caller can clear all place IDs from a subset of fulfillment types in
   * the following ways:
   * * Adds "fulfillment_info" in
   * [SetInventoryRequest.set_mask][google.cloud.retail.v2alpha.SetInventoryRequest.set_mask]
   * * Specifies only the desired fulfillment types to clear in
   * [SetInventoryRequest.inventory.fulfillment_info][google.cloud.retail.v2alpha.Product.fulfillment_info]
   * * Checks that only the desired fulfillment info types have empty
   * [SetInventoryRequest.inventory.fulfillment_info.place_ids][google.cloud.retail.v2alpha.FulfillmentInfo.place_ids]
   * The last update time is recorded for the following inventory fields:
   * * [Product.price_info][google.cloud.retail.v2alpha.Product.price_info]
   * * [Product.availability][google.cloud.retail.v2alpha.Product.availability]
   * * [Product.available_quantity][google.cloud.retail.v2alpha.Product.available_quantity]
   * * [Product.fulfillment_info][google.cloud.retail.v2alpha.Product.fulfillment_info]
   * If a full overwrite of inventory information while ignoring timestamps is
   * needed,
   * [ProductService.UpdateProduct][google.cloud.retail.v2alpha.ProductService.UpdateProduct]
   * should be invoked instead.
   * </pre>
   *
   * <code>.google.cloud.retail.v2alpha.Product inventory = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return Whether the inventory field is set.
   */
  boolean hasInventory();
  /**
   * <pre>
   * Required. The inventory information to update. The allowable fields to
   * update are:
   * * [Product.price_info][google.cloud.retail.v2alpha.Product.price_info]
   * * [Product.availability][google.cloud.retail.v2alpha.Product.availability]
   * * [Product.available_quantity][google.cloud.retail.v2alpha.Product.available_quantity]
   * * [Product.fulfillment_info][google.cloud.retail.v2alpha.Product.fulfillment_info]
   * The updated inventory fields must be specified in
   * [SetInventoryRequest.set_mask][google.cloud.retail.v2alpha.SetInventoryRequest.set_mask].
   * If
   * [SetInventoryRequest.inventory.name][google.cloud.retail.v2alpha.Product.name]
   * is empty or invalid, an INVALID_ARGUMENT error is returned.
   * If the caller does not have permission to update the
   * [Product][google.cloud.retail.v2alpha.Product] named in
   * [Product.name][google.cloud.retail.v2alpha.Product.name], regardless of
   * whether or not it exists, a PERMISSION_DENIED error is returned.
   * If the [Product][google.cloud.retail.v2alpha.Product] to update does not
   * have existing inventory information, the provided inventory information
   * will be inserted.
   * If the [Product][google.cloud.retail.v2alpha.Product] to update has
   * existing inventory information, the provided inventory information will be
   * merged while respecting the last update time for each inventory field,
   * using the provided or default value for
   * [SetInventoryRequest.set_time][google.cloud.retail.v2alpha.SetInventoryRequest.set_time].
   * The caller can replace place IDs for a subset of fulfillment types in the
   * following ways:
   * * Adds "fulfillment_info" in
   * [SetInventoryRequest.set_mask][google.cloud.retail.v2alpha.SetInventoryRequest.set_mask]
   * * Specifies only the desired fulfillment types and corresponding place IDs
   * to update in
   * [SetInventoryRequest.inventory.fulfillment_info][google.cloud.retail.v2alpha.Product.fulfillment_info]
   * The caller can clear all place IDs from a subset of fulfillment types in
   * the following ways:
   * * Adds "fulfillment_info" in
   * [SetInventoryRequest.set_mask][google.cloud.retail.v2alpha.SetInventoryRequest.set_mask]
   * * Specifies only the desired fulfillment types to clear in
   * [SetInventoryRequest.inventory.fulfillment_info][google.cloud.retail.v2alpha.Product.fulfillment_info]
   * * Checks that only the desired fulfillment info types have empty
   * [SetInventoryRequest.inventory.fulfillment_info.place_ids][google.cloud.retail.v2alpha.FulfillmentInfo.place_ids]
   * The last update time is recorded for the following inventory fields:
   * * [Product.price_info][google.cloud.retail.v2alpha.Product.price_info]
   * * [Product.availability][google.cloud.retail.v2alpha.Product.availability]
   * * [Product.available_quantity][google.cloud.retail.v2alpha.Product.available_quantity]
   * * [Product.fulfillment_info][google.cloud.retail.v2alpha.Product.fulfillment_info]
   * If a full overwrite of inventory information while ignoring timestamps is
   * needed,
   * [ProductService.UpdateProduct][google.cloud.retail.v2alpha.ProductService.UpdateProduct]
   * should be invoked instead.
   * </pre>
   *
   * <code>.google.cloud.retail.v2alpha.Product inventory = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The inventory.
   */
  com.google.cloud.retail.v2alpha.Product getInventory();
  /**
   * <pre>
   * Required. The inventory information to update. The allowable fields to
   * update are:
   * * [Product.price_info][google.cloud.retail.v2alpha.Product.price_info]
   * * [Product.availability][google.cloud.retail.v2alpha.Product.availability]
   * * [Product.available_quantity][google.cloud.retail.v2alpha.Product.available_quantity]
   * * [Product.fulfillment_info][google.cloud.retail.v2alpha.Product.fulfillment_info]
   * The updated inventory fields must be specified in
   * [SetInventoryRequest.set_mask][google.cloud.retail.v2alpha.SetInventoryRequest.set_mask].
   * If
   * [SetInventoryRequest.inventory.name][google.cloud.retail.v2alpha.Product.name]
   * is empty or invalid, an INVALID_ARGUMENT error is returned.
   * If the caller does not have permission to update the
   * [Product][google.cloud.retail.v2alpha.Product] named in
   * [Product.name][google.cloud.retail.v2alpha.Product.name], regardless of
   * whether or not it exists, a PERMISSION_DENIED error is returned.
   * If the [Product][google.cloud.retail.v2alpha.Product] to update does not
   * have existing inventory information, the provided inventory information
   * will be inserted.
   * If the [Product][google.cloud.retail.v2alpha.Product] to update has
   * existing inventory information, the provided inventory information will be
   * merged while respecting the last update time for each inventory field,
   * using the provided or default value for
   * [SetInventoryRequest.set_time][google.cloud.retail.v2alpha.SetInventoryRequest.set_time].
   * The caller can replace place IDs for a subset of fulfillment types in the
   * following ways:
   * * Adds "fulfillment_info" in
   * [SetInventoryRequest.set_mask][google.cloud.retail.v2alpha.SetInventoryRequest.set_mask]
   * * Specifies only the desired fulfillment types and corresponding place IDs
   * to update in
   * [SetInventoryRequest.inventory.fulfillment_info][google.cloud.retail.v2alpha.Product.fulfillment_info]
   * The caller can clear all place IDs from a subset of fulfillment types in
   * the following ways:
   * * Adds "fulfillment_info" in
   * [SetInventoryRequest.set_mask][google.cloud.retail.v2alpha.SetInventoryRequest.set_mask]
   * * Specifies only the desired fulfillment types to clear in
   * [SetInventoryRequest.inventory.fulfillment_info][google.cloud.retail.v2alpha.Product.fulfillment_info]
   * * Checks that only the desired fulfillment info types have empty
   * [SetInventoryRequest.inventory.fulfillment_info.place_ids][google.cloud.retail.v2alpha.FulfillmentInfo.place_ids]
   * The last update time is recorded for the following inventory fields:
   * * [Product.price_info][google.cloud.retail.v2alpha.Product.price_info]
   * * [Product.availability][google.cloud.retail.v2alpha.Product.availability]
   * * [Product.available_quantity][google.cloud.retail.v2alpha.Product.available_quantity]
   * * [Product.fulfillment_info][google.cloud.retail.v2alpha.Product.fulfillment_info]
   * If a full overwrite of inventory information while ignoring timestamps is
   * needed,
   * [ProductService.UpdateProduct][google.cloud.retail.v2alpha.ProductService.UpdateProduct]
   * should be invoked instead.
   * </pre>
   *
   * <code>.google.cloud.retail.v2alpha.Product inventory = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  com.google.cloud.retail.v2alpha.ProductOrBuilder getInventoryOrBuilder();

  /**
   * <pre>
   * Indicates which inventory fields in the provided
   * [Product][google.cloud.retail.v2alpha.Product] to update.
   * At least one field must be provided.
   * If an unsupported or unknown field is provided, an INVALID_ARGUMENT error
   * is returned and the entire update will be ignored.
   * </pre>
   *
   * <code>.google.protobuf.FieldMask set_mask = 2;</code>
   * @return Whether the setMask field is set.
   */
  boolean hasSetMask();
  /**
   * <pre>
   * Indicates which inventory fields in the provided
   * [Product][google.cloud.retail.v2alpha.Product] to update.
   * At least one field must be provided.
   * If an unsupported or unknown field is provided, an INVALID_ARGUMENT error
   * is returned and the entire update will be ignored.
   * </pre>
   *
   * <code>.google.protobuf.FieldMask set_mask = 2;</code>
   * @return The setMask.
   */
  com.google.protobuf.FieldMask getSetMask();
  /**
   * <pre>
   * Indicates which inventory fields in the provided
   * [Product][google.cloud.retail.v2alpha.Product] to update.
   * At least one field must be provided.
   * If an unsupported or unknown field is provided, an INVALID_ARGUMENT error
   * is returned and the entire update will be ignored.
   * </pre>
   *
   * <code>.google.protobuf.FieldMask set_mask = 2;</code>
   */
  com.google.protobuf.FieldMaskOrBuilder getSetMaskOrBuilder();

  /**
   * <pre>
   * The time when the request is issued, used to prevent
   * out-of-order updates on inventory fields with the last update time
   * recorded. If not provided, the internal system time will be used.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp set_time = 3;</code>
   * @return Whether the setTime field is set.
   */
  boolean hasSetTime();
  /**
   * <pre>
   * The time when the request is issued, used to prevent
   * out-of-order updates on inventory fields with the last update time
   * recorded. If not provided, the internal system time will be used.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp set_time = 3;</code>
   * @return The setTime.
   */
  com.google.protobuf.Timestamp getSetTime();
  /**
   * <pre>
   * The time when the request is issued, used to prevent
   * out-of-order updates on inventory fields with the last update time
   * recorded. If not provided, the internal system time will be used.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp set_time = 3;</code>
   */
  com.google.protobuf.TimestampOrBuilder getSetTimeOrBuilder();

  /**
   * <pre>
   * If set to true, and the [Product][google.cloud.retail.v2alpha.Product] with
   * name [Product.name][google.cloud.retail.v2alpha.Product.name] is not found,
   * the inventory update will still be processed and retained for at most 1 day
   * until the [Product][google.cloud.retail.v2alpha.Product] is created. If set
   * to false, a NOT_FOUND error is returned if the
   * [Product][google.cloud.retail.v2alpha.Product] is not found.
   * </pre>
   *
   * <code>bool allow_missing = 4;</code>
   * @return The allowMissing.
   */
  boolean getAllowMissing();
}
