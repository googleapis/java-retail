// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/retail/v2alpha/export_config.proto

package com.google.cloud.retail.v2alpha;

/**
 * <pre>
 * Output result.
 * </pre>
 *
 * Protobuf type {@code google.cloud.retail.v2alpha.OutputResult}
 */
public final class OutputResult extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:google.cloud.retail.v2alpha.OutputResult)
    OutputResultOrBuilder {
private static final long serialVersionUID = 0L;
  // Use OutputResult.newBuilder() to construct.
  private OutputResult(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private OutputResult() {
    bigqueryResult_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new OutputResult();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private OutputResult(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              bigqueryResult_ = new java.util.ArrayList<com.google.cloud.retail.v2alpha.BigQueryOutputResult>();
              mutable_bitField0_ |= 0x00000001;
            }
            bigqueryResult_.add(
                input.readMessage(com.google.cloud.retail.v2alpha.BigQueryOutputResult.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        bigqueryResult_ = java.util.Collections.unmodifiableList(bigqueryResult_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.google.cloud.retail.v2alpha.ExportConfigProto.internal_static_google_cloud_retail_v2alpha_OutputResult_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.cloud.retail.v2alpha.ExportConfigProto.internal_static_google_cloud_retail_v2alpha_OutputResult_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.cloud.retail.v2alpha.OutputResult.class, com.google.cloud.retail.v2alpha.OutputResult.Builder.class);
  }

  public static final int BIGQUERY_RESULT_FIELD_NUMBER = 1;
  private java.util.List<com.google.cloud.retail.v2alpha.BigQueryOutputResult> bigqueryResult_;
  /**
   * <pre>
   * Export result in BigQuery.
   * </pre>
   *
   * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
   */
  @java.lang.Override
  public java.util.List<com.google.cloud.retail.v2alpha.BigQueryOutputResult> getBigqueryResultList() {
    return bigqueryResult_;
  }
  /**
   * <pre>
   * Export result in BigQuery.
   * </pre>
   *
   * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.google.cloud.retail.v2alpha.BigQueryOutputResultOrBuilder> 
      getBigqueryResultOrBuilderList() {
    return bigqueryResult_;
  }
  /**
   * <pre>
   * Export result in BigQuery.
   * </pre>
   *
   * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
   */
  @java.lang.Override
  public int getBigqueryResultCount() {
    return bigqueryResult_.size();
  }
  /**
   * <pre>
   * Export result in BigQuery.
   * </pre>
   *
   * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
   */
  @java.lang.Override
  public com.google.cloud.retail.v2alpha.BigQueryOutputResult getBigqueryResult(int index) {
    return bigqueryResult_.get(index);
  }
  /**
   * <pre>
   * Export result in BigQuery.
   * </pre>
   *
   * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
   */
  @java.lang.Override
  public com.google.cloud.retail.v2alpha.BigQueryOutputResultOrBuilder getBigqueryResultOrBuilder(
      int index) {
    return bigqueryResult_.get(index);
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
    for (int i = 0; i < bigqueryResult_.size(); i++) {
      output.writeMessage(1, bigqueryResult_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < bigqueryResult_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, bigqueryResult_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.google.cloud.retail.v2alpha.OutputResult)) {
      return super.equals(obj);
    }
    com.google.cloud.retail.v2alpha.OutputResult other = (com.google.cloud.retail.v2alpha.OutputResult) obj;

    if (!getBigqueryResultList()
        .equals(other.getBigqueryResultList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getBigqueryResultCount() > 0) {
      hash = (37 * hash) + BIGQUERY_RESULT_FIELD_NUMBER;
      hash = (53 * hash) + getBigqueryResultList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.cloud.retail.v2alpha.OutputResult parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.cloud.retail.v2alpha.OutputResult parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.cloud.retail.v2alpha.OutputResult parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.cloud.retail.v2alpha.OutputResult parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.cloud.retail.v2alpha.OutputResult parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.cloud.retail.v2alpha.OutputResult parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.cloud.retail.v2alpha.OutputResult parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.cloud.retail.v2alpha.OutputResult parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.cloud.retail.v2alpha.OutputResult parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.google.cloud.retail.v2alpha.OutputResult parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.cloud.retail.v2alpha.OutputResult parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.cloud.retail.v2alpha.OutputResult parseFrom(
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
  public static Builder newBuilder(com.google.cloud.retail.v2alpha.OutputResult prototype) {
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
   * Output result.
   * </pre>
   *
   * Protobuf type {@code google.cloud.retail.v2alpha.OutputResult}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.cloud.retail.v2alpha.OutputResult)
      com.google.cloud.retail.v2alpha.OutputResultOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.cloud.retail.v2alpha.ExportConfigProto.internal_static_google_cloud_retail_v2alpha_OutputResult_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.cloud.retail.v2alpha.ExportConfigProto.internal_static_google_cloud_retail_v2alpha_OutputResult_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.cloud.retail.v2alpha.OutputResult.class, com.google.cloud.retail.v2alpha.OutputResult.Builder.class);
    }

    // Construct using com.google.cloud.retail.v2alpha.OutputResult.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getBigqueryResultFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (bigqueryResultBuilder_ == null) {
        bigqueryResult_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        bigqueryResultBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.cloud.retail.v2alpha.ExportConfigProto.internal_static_google_cloud_retail_v2alpha_OutputResult_descriptor;
    }

    @java.lang.Override
    public com.google.cloud.retail.v2alpha.OutputResult getDefaultInstanceForType() {
      return com.google.cloud.retail.v2alpha.OutputResult.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.cloud.retail.v2alpha.OutputResult build() {
      com.google.cloud.retail.v2alpha.OutputResult result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.cloud.retail.v2alpha.OutputResult buildPartial() {
      com.google.cloud.retail.v2alpha.OutputResult result = new com.google.cloud.retail.v2alpha.OutputResult(this);
      int from_bitField0_ = bitField0_;
      if (bigqueryResultBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          bigqueryResult_ = java.util.Collections.unmodifiableList(bigqueryResult_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.bigqueryResult_ = bigqueryResult_;
      } else {
        result.bigqueryResult_ = bigqueryResultBuilder_.build();
      }
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
      if (other instanceof com.google.cloud.retail.v2alpha.OutputResult) {
        return mergeFrom((com.google.cloud.retail.v2alpha.OutputResult)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.cloud.retail.v2alpha.OutputResult other) {
      if (other == com.google.cloud.retail.v2alpha.OutputResult.getDefaultInstance()) return this;
      if (bigqueryResultBuilder_ == null) {
        if (!other.bigqueryResult_.isEmpty()) {
          if (bigqueryResult_.isEmpty()) {
            bigqueryResult_ = other.bigqueryResult_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureBigqueryResultIsMutable();
            bigqueryResult_.addAll(other.bigqueryResult_);
          }
          onChanged();
        }
      } else {
        if (!other.bigqueryResult_.isEmpty()) {
          if (bigqueryResultBuilder_.isEmpty()) {
            bigqueryResultBuilder_.dispose();
            bigqueryResultBuilder_ = null;
            bigqueryResult_ = other.bigqueryResult_;
            bitField0_ = (bitField0_ & ~0x00000001);
            bigqueryResultBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getBigqueryResultFieldBuilder() : null;
          } else {
            bigqueryResultBuilder_.addAllMessages(other.bigqueryResult_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
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
      com.google.cloud.retail.v2alpha.OutputResult parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.cloud.retail.v2alpha.OutputResult) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.google.cloud.retail.v2alpha.BigQueryOutputResult> bigqueryResult_ =
      java.util.Collections.emptyList();
    private void ensureBigqueryResultIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        bigqueryResult_ = new java.util.ArrayList<com.google.cloud.retail.v2alpha.BigQueryOutputResult>(bigqueryResult_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.google.cloud.retail.v2alpha.BigQueryOutputResult, com.google.cloud.retail.v2alpha.BigQueryOutputResult.Builder, com.google.cloud.retail.v2alpha.BigQueryOutputResultOrBuilder> bigqueryResultBuilder_;

    /**
     * <pre>
     * Export result in BigQuery.
     * </pre>
     *
     * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
     */
    public java.util.List<com.google.cloud.retail.v2alpha.BigQueryOutputResult> getBigqueryResultList() {
      if (bigqueryResultBuilder_ == null) {
        return java.util.Collections.unmodifiableList(bigqueryResult_);
      } else {
        return bigqueryResultBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     * Export result in BigQuery.
     * </pre>
     *
     * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
     */
    public int getBigqueryResultCount() {
      if (bigqueryResultBuilder_ == null) {
        return bigqueryResult_.size();
      } else {
        return bigqueryResultBuilder_.getCount();
      }
    }
    /**
     * <pre>
     * Export result in BigQuery.
     * </pre>
     *
     * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
     */
    public com.google.cloud.retail.v2alpha.BigQueryOutputResult getBigqueryResult(int index) {
      if (bigqueryResultBuilder_ == null) {
        return bigqueryResult_.get(index);
      } else {
        return bigqueryResultBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     * Export result in BigQuery.
     * </pre>
     *
     * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
     */
    public Builder setBigqueryResult(
        int index, com.google.cloud.retail.v2alpha.BigQueryOutputResult value) {
      if (bigqueryResultBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBigqueryResultIsMutable();
        bigqueryResult_.set(index, value);
        onChanged();
      } else {
        bigqueryResultBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * Export result in BigQuery.
     * </pre>
     *
     * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
     */
    public Builder setBigqueryResult(
        int index, com.google.cloud.retail.v2alpha.BigQueryOutputResult.Builder builderForValue) {
      if (bigqueryResultBuilder_ == null) {
        ensureBigqueryResultIsMutable();
        bigqueryResult_.set(index, builderForValue.build());
        onChanged();
      } else {
        bigqueryResultBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * Export result in BigQuery.
     * </pre>
     *
     * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
     */
    public Builder addBigqueryResult(com.google.cloud.retail.v2alpha.BigQueryOutputResult value) {
      if (bigqueryResultBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBigqueryResultIsMutable();
        bigqueryResult_.add(value);
        onChanged();
      } else {
        bigqueryResultBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     * Export result in BigQuery.
     * </pre>
     *
     * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
     */
    public Builder addBigqueryResult(
        int index, com.google.cloud.retail.v2alpha.BigQueryOutputResult value) {
      if (bigqueryResultBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureBigqueryResultIsMutable();
        bigqueryResult_.add(index, value);
        onChanged();
      } else {
        bigqueryResultBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * Export result in BigQuery.
     * </pre>
     *
     * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
     */
    public Builder addBigqueryResult(
        com.google.cloud.retail.v2alpha.BigQueryOutputResult.Builder builderForValue) {
      if (bigqueryResultBuilder_ == null) {
        ensureBigqueryResultIsMutable();
        bigqueryResult_.add(builderForValue.build());
        onChanged();
      } else {
        bigqueryResultBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * Export result in BigQuery.
     * </pre>
     *
     * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
     */
    public Builder addBigqueryResult(
        int index, com.google.cloud.retail.v2alpha.BigQueryOutputResult.Builder builderForValue) {
      if (bigqueryResultBuilder_ == null) {
        ensureBigqueryResultIsMutable();
        bigqueryResult_.add(index, builderForValue.build());
        onChanged();
      } else {
        bigqueryResultBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * Export result in BigQuery.
     * </pre>
     *
     * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
     */
    public Builder addAllBigqueryResult(
        java.lang.Iterable<? extends com.google.cloud.retail.v2alpha.BigQueryOutputResult> values) {
      if (bigqueryResultBuilder_ == null) {
        ensureBigqueryResultIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, bigqueryResult_);
        onChanged();
      } else {
        bigqueryResultBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     * Export result in BigQuery.
     * </pre>
     *
     * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
     */
    public Builder clearBigqueryResult() {
      if (bigqueryResultBuilder_ == null) {
        bigqueryResult_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        bigqueryResultBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     * Export result in BigQuery.
     * </pre>
     *
     * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
     */
    public Builder removeBigqueryResult(int index) {
      if (bigqueryResultBuilder_ == null) {
        ensureBigqueryResultIsMutable();
        bigqueryResult_.remove(index);
        onChanged();
      } else {
        bigqueryResultBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     * Export result in BigQuery.
     * </pre>
     *
     * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
     */
    public com.google.cloud.retail.v2alpha.BigQueryOutputResult.Builder getBigqueryResultBuilder(
        int index) {
      return getBigqueryResultFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     * Export result in BigQuery.
     * </pre>
     *
     * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
     */
    public com.google.cloud.retail.v2alpha.BigQueryOutputResultOrBuilder getBigqueryResultOrBuilder(
        int index) {
      if (bigqueryResultBuilder_ == null) {
        return bigqueryResult_.get(index);  } else {
        return bigqueryResultBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     * Export result in BigQuery.
     * </pre>
     *
     * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
     */
    public java.util.List<? extends com.google.cloud.retail.v2alpha.BigQueryOutputResultOrBuilder> 
         getBigqueryResultOrBuilderList() {
      if (bigqueryResultBuilder_ != null) {
        return bigqueryResultBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(bigqueryResult_);
      }
    }
    /**
     * <pre>
     * Export result in BigQuery.
     * </pre>
     *
     * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
     */
    public com.google.cloud.retail.v2alpha.BigQueryOutputResult.Builder addBigqueryResultBuilder() {
      return getBigqueryResultFieldBuilder().addBuilder(
          com.google.cloud.retail.v2alpha.BigQueryOutputResult.getDefaultInstance());
    }
    /**
     * <pre>
     * Export result in BigQuery.
     * </pre>
     *
     * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
     */
    public com.google.cloud.retail.v2alpha.BigQueryOutputResult.Builder addBigqueryResultBuilder(
        int index) {
      return getBigqueryResultFieldBuilder().addBuilder(
          index, com.google.cloud.retail.v2alpha.BigQueryOutputResult.getDefaultInstance());
    }
    /**
     * <pre>
     * Export result in BigQuery.
     * </pre>
     *
     * <code>repeated .google.cloud.retail.v2alpha.BigQueryOutputResult bigquery_result = 1;</code>
     */
    public java.util.List<com.google.cloud.retail.v2alpha.BigQueryOutputResult.Builder> 
         getBigqueryResultBuilderList() {
      return getBigqueryResultFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.google.cloud.retail.v2alpha.BigQueryOutputResult, com.google.cloud.retail.v2alpha.BigQueryOutputResult.Builder, com.google.cloud.retail.v2alpha.BigQueryOutputResultOrBuilder> 
        getBigqueryResultFieldBuilder() {
      if (bigqueryResultBuilder_ == null) {
        bigqueryResultBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.google.cloud.retail.v2alpha.BigQueryOutputResult, com.google.cloud.retail.v2alpha.BigQueryOutputResult.Builder, com.google.cloud.retail.v2alpha.BigQueryOutputResultOrBuilder>(
                bigqueryResult_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        bigqueryResult_ = null;
      }
      return bigqueryResultBuilder_;
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


    // @@protoc_insertion_point(builder_scope:google.cloud.retail.v2alpha.OutputResult)
  }

  // @@protoc_insertion_point(class_scope:google.cloud.retail.v2alpha.OutputResult)
  private static final com.google.cloud.retail.v2alpha.OutputResult DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.cloud.retail.v2alpha.OutputResult();
  }

  public static com.google.cloud.retail.v2alpha.OutputResult getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<OutputResult>
      PARSER = new com.google.protobuf.AbstractParser<OutputResult>() {
    @java.lang.Override
    public OutputResult parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new OutputResult(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<OutputResult> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<OutputResult> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.cloud.retail.v2alpha.OutputResult getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

