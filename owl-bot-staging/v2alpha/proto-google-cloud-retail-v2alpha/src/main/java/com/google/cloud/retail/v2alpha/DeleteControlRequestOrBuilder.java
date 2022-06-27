// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/retail/v2alpha/control_service.proto

package com.google.cloud.retail.v2alpha;

public interface DeleteControlRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.retail.v2alpha.DeleteControlRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Required. The resource name of the Control to delete. Format:
   * projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/controls/{control_id}
   * </pre>
   *
   * <code>string name = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <pre>
   * Required. The resource name of the Control to delete. Format:
   * projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/controls/{control_id}
   * </pre>
   *
   * <code>string name = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();
}
