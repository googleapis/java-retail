// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/retail/v2alpha/model_service.proto

package com.google.cloud.retail.v2alpha;

public interface PauseModelRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.retail.v2alpha.PauseModelRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Required. The name of the model to pause.
   * Format:
   * projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/models/{model_id}
   * </pre>
   *
   * <code>string name = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <pre>
   * Required. The name of the model to pause.
   * Format:
   * projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/models/{model_id}
   * </pre>
   *
   * <code>string name = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();
}
