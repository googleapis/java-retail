// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/retail/v2beta/catalog_service.proto

package com.google.cloud.retail.v2beta;

/**
 * <pre>
 * Request for
 * [CatalogService.RemoveCatalogAttribute][google.cloud.retail.v2beta.CatalogService.RemoveCatalogAttribute]
 * method.
 * </pre>
 *
 * Protobuf type {@code google.cloud.retail.v2beta.RemoveCatalogAttributeRequest}
 */
public final class RemoveCatalogAttributeRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:google.cloud.retail.v2beta.RemoveCatalogAttributeRequest)
    RemoveCatalogAttributeRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RemoveCatalogAttributeRequest.newBuilder() to construct.
  private RemoveCatalogAttributeRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RemoveCatalogAttributeRequest() {
    attributesConfig_ = "";
    key_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RemoveCatalogAttributeRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.google.cloud.retail.v2beta.CatalogServiceProto.internal_static_google_cloud_retail_v2beta_RemoveCatalogAttributeRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.cloud.retail.v2beta.CatalogServiceProto.internal_static_google_cloud_retail_v2beta_RemoveCatalogAttributeRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest.class, com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest.Builder.class);
  }

  public static final int ATTRIBUTES_CONFIG_FIELD_NUMBER = 1;
  private volatile java.lang.Object attributesConfig_;
  /**
   * <pre>
   * Required. Full AttributesConfig resource name. Format:
   * `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/attributesConfig`
   * </pre>
   *
   * <code>string attributes_config = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }</code>
   * @return The attributesConfig.
   */
  @java.lang.Override
  public java.lang.String getAttributesConfig() {
    java.lang.Object ref = attributesConfig_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      attributesConfig_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * Required. Full AttributesConfig resource name. Format:
   * `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/attributesConfig`
   * </pre>
   *
   * <code>string attributes_config = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }</code>
   * @return The bytes for attributesConfig.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getAttributesConfigBytes() {
    java.lang.Object ref = attributesConfig_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      attributesConfig_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int KEY_FIELD_NUMBER = 2;
  private volatile java.lang.Object key_;
  /**
   * <pre>
   * Required. The attribute name key of the
   * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to remove.
   * </pre>
   *
   * <code>string key = 2 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The key.
   */
  @java.lang.Override
  public java.lang.String getKey() {
    java.lang.Object ref = key_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      key_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * Required. The attribute name key of the
   * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to remove.
   * </pre>
   *
   * <code>string key = 2 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The bytes for key.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getKeyBytes() {
    java.lang.Object ref = key_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      key_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(attributesConfig_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, attributesConfig_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(key_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, key_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(attributesConfig_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, attributesConfig_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(key_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, key_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest)) {
      return super.equals(obj);
    }
    com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest other = (com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest) obj;

    if (!getAttributesConfig()
        .equals(other.getAttributesConfig())) return false;
    if (!getKey()
        .equals(other.getKey())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ATTRIBUTES_CONFIG_FIELD_NUMBER;
    hash = (53 * hash) + getAttributesConfig().hashCode();
    hash = (37 * hash) + KEY_FIELD_NUMBER;
    hash = (53 * hash) + getKey().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Request for
   * [CatalogService.RemoveCatalogAttribute][google.cloud.retail.v2beta.CatalogService.RemoveCatalogAttribute]
   * method.
   * </pre>
   *
   * Protobuf type {@code google.cloud.retail.v2beta.RemoveCatalogAttributeRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.cloud.retail.v2beta.RemoveCatalogAttributeRequest)
      com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.cloud.retail.v2beta.CatalogServiceProto.internal_static_google_cloud_retail_v2beta_RemoveCatalogAttributeRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.cloud.retail.v2beta.CatalogServiceProto.internal_static_google_cloud_retail_v2beta_RemoveCatalogAttributeRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest.class, com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest.Builder.class);
    }

    // Construct using com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      attributesConfig_ = "";

      key_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.cloud.retail.v2beta.CatalogServiceProto.internal_static_google_cloud_retail_v2beta_RemoveCatalogAttributeRequest_descriptor;
    }

    @java.lang.Override
    public com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest getDefaultInstanceForType() {
      return com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest build() {
      com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest buildPartial() {
      com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest result = new com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest(this);
      result.attributesConfig_ = attributesConfig_;
      result.key_ = key_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest) {
        return mergeFrom((com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest other) {
      if (other == com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest.getDefaultInstance()) return this;
      if (!other.getAttributesConfig().isEmpty()) {
        attributesConfig_ = other.attributesConfig_;
        onChanged();
      }
      if (!other.getKey().isEmpty()) {
        key_ = other.key_;
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              attributesConfig_ = input.readStringRequireUtf8();

              break;
            } // case 10
            case 18: {
              key_ = input.readStringRequireUtf8();

              break;
            } // case 18
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }

    private java.lang.Object attributesConfig_ = "";
    /**
     * <pre>
     * Required. Full AttributesConfig resource name. Format:
     * `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/attributesConfig`
     * </pre>
     *
     * <code>string attributes_config = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }</code>
     * @return The attributesConfig.
     */
    public java.lang.String getAttributesConfig() {
      java.lang.Object ref = attributesConfig_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        attributesConfig_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * Required. Full AttributesConfig resource name. Format:
     * `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/attributesConfig`
     * </pre>
     *
     * <code>string attributes_config = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }</code>
     * @return The bytes for attributesConfig.
     */
    public com.google.protobuf.ByteString
        getAttributesConfigBytes() {
      java.lang.Object ref = attributesConfig_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        attributesConfig_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * Required. Full AttributesConfig resource name. Format:
     * `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/attributesConfig`
     * </pre>
     *
     * <code>string attributes_config = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }</code>
     * @param value The attributesConfig to set.
     * @return This builder for chaining.
     */
    public Builder setAttributesConfig(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      attributesConfig_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Required. Full AttributesConfig resource name. Format:
     * `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/attributesConfig`
     * </pre>
     *
     * <code>string attributes_config = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }</code>
     * @return This builder for chaining.
     */
    public Builder clearAttributesConfig() {
      
      attributesConfig_ = getDefaultInstance().getAttributesConfig();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Required. Full AttributesConfig resource name. Format:
     * `projects/{project_number}/locations/{location_id}/catalogs/{catalog_id}/attributesConfig`
     * </pre>
     *
     * <code>string attributes_config = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }</code>
     * @param value The bytes for attributesConfig to set.
     * @return This builder for chaining.
     */
    public Builder setAttributesConfigBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      attributesConfig_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object key_ = "";
    /**
     * <pre>
     * Required. The attribute name key of the
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to remove.
     * </pre>
     *
     * <code>string key = 2 [(.google.api.field_behavior) = REQUIRED];</code>
     * @return The key.
     */
    public java.lang.String getKey() {
      java.lang.Object ref = key_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        key_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * Required. The attribute name key of the
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to remove.
     * </pre>
     *
     * <code>string key = 2 [(.google.api.field_behavior) = REQUIRED];</code>
     * @return The bytes for key.
     */
    public com.google.protobuf.ByteString
        getKeyBytes() {
      java.lang.Object ref = key_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        key_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * Required. The attribute name key of the
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to remove.
     * </pre>
     *
     * <code>string key = 2 [(.google.api.field_behavior) = REQUIRED];</code>
     * @param value The key to set.
     * @return This builder for chaining.
     */
    public Builder setKey(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      key_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Required. The attribute name key of the
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to remove.
     * </pre>
     *
     * <code>string key = 2 [(.google.api.field_behavior) = REQUIRED];</code>
     * @return This builder for chaining.
     */
    public Builder clearKey() {
      
      key_ = getDefaultInstance().getKey();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Required. The attribute name key of the
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to remove.
     * </pre>
     *
     * <code>string key = 2 [(.google.api.field_behavior) = REQUIRED];</code>
     * @param value The bytes for key to set.
     * @return This builder for chaining.
     */
    public Builder setKeyBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      key_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:google.cloud.retail.v2beta.RemoveCatalogAttributeRequest)
  }

  // @@protoc_insertion_point(class_scope:google.cloud.retail.v2beta.RemoveCatalogAttributeRequest)
  private static final com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest();
  }

  public static com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RemoveCatalogAttributeRequest>
      PARSER = new com.google.protobuf.AbstractParser<RemoveCatalogAttributeRequest>() {
    @java.lang.Override
    public RemoveCatalogAttributeRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<RemoveCatalogAttributeRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RemoveCatalogAttributeRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

