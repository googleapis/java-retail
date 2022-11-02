// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/retail/v2alpha/catalog_service.proto

package com.google.cloud.retail.v2alpha;

/**
 * <pre>
 * Request message to set a specified branch as new default_branch.
 * </pre>
 *
 * Protobuf type {@code google.cloud.retail.v2alpha.SetDefaultBranchRequest}
 */
public final class SetDefaultBranchRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:google.cloud.retail.v2alpha.SetDefaultBranchRequest)
    SetDefaultBranchRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SetDefaultBranchRequest.newBuilder() to construct.
  private SetDefaultBranchRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SetDefaultBranchRequest() {
    catalog_ = "";
    branchId_ = "";
    note_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SetDefaultBranchRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.google.cloud.retail.v2alpha.CatalogServiceProto.internal_static_google_cloud_retail_v2alpha_SetDefaultBranchRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.cloud.retail.v2alpha.CatalogServiceProto.internal_static_google_cloud_retail_v2alpha_SetDefaultBranchRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.cloud.retail.v2alpha.SetDefaultBranchRequest.class, com.google.cloud.retail.v2alpha.SetDefaultBranchRequest.Builder.class);
  }

  public static final int CATALOG_FIELD_NUMBER = 1;
  private volatile java.lang.Object catalog_;
  /**
   * <pre>
   * Full resource name of the catalog, such as
   * `projects/&#42;&#47;locations/global/catalogs/default_catalog`.
   * </pre>
   *
   * <code>string catalog = 1 [(.google.api.resource_reference) = { ... }</code>
   * @return The catalog.
   */
  @java.lang.Override
  public java.lang.String getCatalog() {
    java.lang.Object ref = catalog_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      catalog_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * Full resource name of the catalog, such as
   * `projects/&#42;&#47;locations/global/catalogs/default_catalog`.
   * </pre>
   *
   * <code>string catalog = 1 [(.google.api.resource_reference) = { ... }</code>
   * @return The bytes for catalog.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getCatalogBytes() {
    java.lang.Object ref = catalog_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      catalog_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int BRANCH_ID_FIELD_NUMBER = 2;
  private volatile java.lang.Object branchId_;
  /**
   * <pre>
   * The final component of the resource name of a branch.
   * This field must be one of "0", "1" or "2". Otherwise, an INVALID_ARGUMENT
   * error is returned.
   * If there are no sufficient active products in the targeted branch and
   * [force][google.cloud.retail.v2alpha.SetDefaultBranchRequest.force] is not
   * set, a FAILED_PRECONDITION error is returned.
   * </pre>
   *
   * <code>string branch_id = 2 [(.google.api.resource_reference) = { ... }</code>
   * @return The branchId.
   */
  @java.lang.Override
  public java.lang.String getBranchId() {
    java.lang.Object ref = branchId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      branchId_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * The final component of the resource name of a branch.
   * This field must be one of "0", "1" or "2". Otherwise, an INVALID_ARGUMENT
   * error is returned.
   * If there are no sufficient active products in the targeted branch and
   * [force][google.cloud.retail.v2alpha.SetDefaultBranchRequest.force] is not
   * set, a FAILED_PRECONDITION error is returned.
   * </pre>
   *
   * <code>string branch_id = 2 [(.google.api.resource_reference) = { ... }</code>
   * @return The bytes for branchId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getBranchIdBytes() {
    java.lang.Object ref = branchId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      branchId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NOTE_FIELD_NUMBER = 3;
  private volatile java.lang.Object note_;
  /**
   * <pre>
   * Some note on this request, this can be retrieved by
   * [CatalogService.GetDefaultBranch][google.cloud.retail.v2alpha.CatalogService.GetDefaultBranch]
   * before next valid default branch set occurs.
   * This field must be a UTF-8 encoded string with a length limit of 1,000
   * characters. Otherwise, an INVALID_ARGUMENT error is returned.
   * </pre>
   *
   * <code>string note = 3;</code>
   * @return The note.
   */
  @java.lang.Override
  public java.lang.String getNote() {
    java.lang.Object ref = note_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      note_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * Some note on this request, this can be retrieved by
   * [CatalogService.GetDefaultBranch][google.cloud.retail.v2alpha.CatalogService.GetDefaultBranch]
   * before next valid default branch set occurs.
   * This field must be a UTF-8 encoded string with a length limit of 1,000
   * characters. Otherwise, an INVALID_ARGUMENT error is returned.
   * </pre>
   *
   * <code>string note = 3;</code>
   * @return The bytes for note.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getNoteBytes() {
    java.lang.Object ref = note_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      note_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int FORCE_FIELD_NUMBER = 4;
  private boolean force_;
  /**
   * <pre>
   * If set to true, it permits switching to a branch with
   * [branch_id][google.cloud.retail.v2alpha.SetDefaultBranchRequest.branch_id]
   * even if it has no sufficient active products.
   * </pre>
   *
   * <code>bool force = 4;</code>
   * @return The force.
   */
  @java.lang.Override
  public boolean getForce() {
    return force_;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(catalog_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, catalog_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(branchId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, branchId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(note_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, note_);
    }
    if (force_ != false) {
      output.writeBool(4, force_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(catalog_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, catalog_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(branchId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, branchId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(note_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, note_);
    }
    if (force_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(4, force_);
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
    if (!(obj instanceof com.google.cloud.retail.v2alpha.SetDefaultBranchRequest)) {
      return super.equals(obj);
    }
    com.google.cloud.retail.v2alpha.SetDefaultBranchRequest other = (com.google.cloud.retail.v2alpha.SetDefaultBranchRequest) obj;

    if (!getCatalog()
        .equals(other.getCatalog())) return false;
    if (!getBranchId()
        .equals(other.getBranchId())) return false;
    if (!getNote()
        .equals(other.getNote())) return false;
    if (getForce()
        != other.getForce()) return false;
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
    hash = (37 * hash) + CATALOG_FIELD_NUMBER;
    hash = (53 * hash) + getCatalog().hashCode();
    hash = (37 * hash) + BRANCH_ID_FIELD_NUMBER;
    hash = (53 * hash) + getBranchId().hashCode();
    hash = (37 * hash) + NOTE_FIELD_NUMBER;
    hash = (53 * hash) + getNote().hashCode();
    hash = (37 * hash) + FORCE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getForce());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.cloud.retail.v2alpha.SetDefaultBranchRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.cloud.retail.v2alpha.SetDefaultBranchRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.cloud.retail.v2alpha.SetDefaultBranchRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.cloud.retail.v2alpha.SetDefaultBranchRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.cloud.retail.v2alpha.SetDefaultBranchRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.cloud.retail.v2alpha.SetDefaultBranchRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.cloud.retail.v2alpha.SetDefaultBranchRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.cloud.retail.v2alpha.SetDefaultBranchRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.cloud.retail.v2alpha.SetDefaultBranchRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.google.cloud.retail.v2alpha.SetDefaultBranchRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.cloud.retail.v2alpha.SetDefaultBranchRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.cloud.retail.v2alpha.SetDefaultBranchRequest parseFrom(
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
  public static Builder newBuilder(com.google.cloud.retail.v2alpha.SetDefaultBranchRequest prototype) {
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
   * Request message to set a specified branch as new default_branch.
   * </pre>
   *
   * Protobuf type {@code google.cloud.retail.v2alpha.SetDefaultBranchRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.cloud.retail.v2alpha.SetDefaultBranchRequest)
      com.google.cloud.retail.v2alpha.SetDefaultBranchRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.cloud.retail.v2alpha.CatalogServiceProto.internal_static_google_cloud_retail_v2alpha_SetDefaultBranchRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.cloud.retail.v2alpha.CatalogServiceProto.internal_static_google_cloud_retail_v2alpha_SetDefaultBranchRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.cloud.retail.v2alpha.SetDefaultBranchRequest.class, com.google.cloud.retail.v2alpha.SetDefaultBranchRequest.Builder.class);
    }

    // Construct using com.google.cloud.retail.v2alpha.SetDefaultBranchRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      catalog_ = "";

      branchId_ = "";

      note_ = "";

      force_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.cloud.retail.v2alpha.CatalogServiceProto.internal_static_google_cloud_retail_v2alpha_SetDefaultBranchRequest_descriptor;
    }

    @java.lang.Override
    public com.google.cloud.retail.v2alpha.SetDefaultBranchRequest getDefaultInstanceForType() {
      return com.google.cloud.retail.v2alpha.SetDefaultBranchRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.cloud.retail.v2alpha.SetDefaultBranchRequest build() {
      com.google.cloud.retail.v2alpha.SetDefaultBranchRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.cloud.retail.v2alpha.SetDefaultBranchRequest buildPartial() {
      com.google.cloud.retail.v2alpha.SetDefaultBranchRequest result = new com.google.cloud.retail.v2alpha.SetDefaultBranchRequest(this);
      result.catalog_ = catalog_;
      result.branchId_ = branchId_;
      result.note_ = note_;
      result.force_ = force_;
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
      if (other instanceof com.google.cloud.retail.v2alpha.SetDefaultBranchRequest) {
        return mergeFrom((com.google.cloud.retail.v2alpha.SetDefaultBranchRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.cloud.retail.v2alpha.SetDefaultBranchRequest other) {
      if (other == com.google.cloud.retail.v2alpha.SetDefaultBranchRequest.getDefaultInstance()) return this;
      if (!other.getCatalog().isEmpty()) {
        catalog_ = other.catalog_;
        onChanged();
      }
      if (!other.getBranchId().isEmpty()) {
        branchId_ = other.branchId_;
        onChanged();
      }
      if (!other.getNote().isEmpty()) {
        note_ = other.note_;
        onChanged();
      }
      if (other.getForce() != false) {
        setForce(other.getForce());
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
              catalog_ = input.readStringRequireUtf8();

              break;
            } // case 10
            case 18: {
              branchId_ = input.readStringRequireUtf8();

              break;
            } // case 18
            case 26: {
              note_ = input.readStringRequireUtf8();

              break;
            } // case 26
            case 32: {
              force_ = input.readBool();

              break;
            } // case 32
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

    private java.lang.Object catalog_ = "";
    /**
     * <pre>
     * Full resource name of the catalog, such as
     * `projects/&#42;&#47;locations/global/catalogs/default_catalog`.
     * </pre>
     *
     * <code>string catalog = 1 [(.google.api.resource_reference) = { ... }</code>
     * @return The catalog.
     */
    public java.lang.String getCatalog() {
      java.lang.Object ref = catalog_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        catalog_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * Full resource name of the catalog, such as
     * `projects/&#42;&#47;locations/global/catalogs/default_catalog`.
     * </pre>
     *
     * <code>string catalog = 1 [(.google.api.resource_reference) = { ... }</code>
     * @return The bytes for catalog.
     */
    public com.google.protobuf.ByteString
        getCatalogBytes() {
      java.lang.Object ref = catalog_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        catalog_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * Full resource name of the catalog, such as
     * `projects/&#42;&#47;locations/global/catalogs/default_catalog`.
     * </pre>
     *
     * <code>string catalog = 1 [(.google.api.resource_reference) = { ... }</code>
     * @param value The catalog to set.
     * @return This builder for chaining.
     */
    public Builder setCatalog(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      catalog_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Full resource name of the catalog, such as
     * `projects/&#42;&#47;locations/global/catalogs/default_catalog`.
     * </pre>
     *
     * <code>string catalog = 1 [(.google.api.resource_reference) = { ... }</code>
     * @return This builder for chaining.
     */
    public Builder clearCatalog() {
      
      catalog_ = getDefaultInstance().getCatalog();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Full resource name of the catalog, such as
     * `projects/&#42;&#47;locations/global/catalogs/default_catalog`.
     * </pre>
     *
     * <code>string catalog = 1 [(.google.api.resource_reference) = { ... }</code>
     * @param value The bytes for catalog to set.
     * @return This builder for chaining.
     */
    public Builder setCatalogBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      catalog_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object branchId_ = "";
    /**
     * <pre>
     * The final component of the resource name of a branch.
     * This field must be one of "0", "1" or "2". Otherwise, an INVALID_ARGUMENT
     * error is returned.
     * If there are no sufficient active products in the targeted branch and
     * [force][google.cloud.retail.v2alpha.SetDefaultBranchRequest.force] is not
     * set, a FAILED_PRECONDITION error is returned.
     * </pre>
     *
     * <code>string branch_id = 2 [(.google.api.resource_reference) = { ... }</code>
     * @return The branchId.
     */
    public java.lang.String getBranchId() {
      java.lang.Object ref = branchId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        branchId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * The final component of the resource name of a branch.
     * This field must be one of "0", "1" or "2". Otherwise, an INVALID_ARGUMENT
     * error is returned.
     * If there are no sufficient active products in the targeted branch and
     * [force][google.cloud.retail.v2alpha.SetDefaultBranchRequest.force] is not
     * set, a FAILED_PRECONDITION error is returned.
     * </pre>
     *
     * <code>string branch_id = 2 [(.google.api.resource_reference) = { ... }</code>
     * @return The bytes for branchId.
     */
    public com.google.protobuf.ByteString
        getBranchIdBytes() {
      java.lang.Object ref = branchId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        branchId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * The final component of the resource name of a branch.
     * This field must be one of "0", "1" or "2". Otherwise, an INVALID_ARGUMENT
     * error is returned.
     * If there are no sufficient active products in the targeted branch and
     * [force][google.cloud.retail.v2alpha.SetDefaultBranchRequest.force] is not
     * set, a FAILED_PRECONDITION error is returned.
     * </pre>
     *
     * <code>string branch_id = 2 [(.google.api.resource_reference) = { ... }</code>
     * @param value The branchId to set.
     * @return This builder for chaining.
     */
    public Builder setBranchId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      branchId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The final component of the resource name of a branch.
     * This field must be one of "0", "1" or "2". Otherwise, an INVALID_ARGUMENT
     * error is returned.
     * If there are no sufficient active products in the targeted branch and
     * [force][google.cloud.retail.v2alpha.SetDefaultBranchRequest.force] is not
     * set, a FAILED_PRECONDITION error is returned.
     * </pre>
     *
     * <code>string branch_id = 2 [(.google.api.resource_reference) = { ... }</code>
     * @return This builder for chaining.
     */
    public Builder clearBranchId() {
      
      branchId_ = getDefaultInstance().getBranchId();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The final component of the resource name of a branch.
     * This field must be one of "0", "1" or "2". Otherwise, an INVALID_ARGUMENT
     * error is returned.
     * If there are no sufficient active products in the targeted branch and
     * [force][google.cloud.retail.v2alpha.SetDefaultBranchRequest.force] is not
     * set, a FAILED_PRECONDITION error is returned.
     * </pre>
     *
     * <code>string branch_id = 2 [(.google.api.resource_reference) = { ... }</code>
     * @param value The bytes for branchId to set.
     * @return This builder for chaining.
     */
    public Builder setBranchIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      branchId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object note_ = "";
    /**
     * <pre>
     * Some note on this request, this can be retrieved by
     * [CatalogService.GetDefaultBranch][google.cloud.retail.v2alpha.CatalogService.GetDefaultBranch]
     * before next valid default branch set occurs.
     * This field must be a UTF-8 encoded string with a length limit of 1,000
     * characters. Otherwise, an INVALID_ARGUMENT error is returned.
     * </pre>
     *
     * <code>string note = 3;</code>
     * @return The note.
     */
    public java.lang.String getNote() {
      java.lang.Object ref = note_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        note_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * Some note on this request, this can be retrieved by
     * [CatalogService.GetDefaultBranch][google.cloud.retail.v2alpha.CatalogService.GetDefaultBranch]
     * before next valid default branch set occurs.
     * This field must be a UTF-8 encoded string with a length limit of 1,000
     * characters. Otherwise, an INVALID_ARGUMENT error is returned.
     * </pre>
     *
     * <code>string note = 3;</code>
     * @return The bytes for note.
     */
    public com.google.protobuf.ByteString
        getNoteBytes() {
      java.lang.Object ref = note_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        note_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * Some note on this request, this can be retrieved by
     * [CatalogService.GetDefaultBranch][google.cloud.retail.v2alpha.CatalogService.GetDefaultBranch]
     * before next valid default branch set occurs.
     * This field must be a UTF-8 encoded string with a length limit of 1,000
     * characters. Otherwise, an INVALID_ARGUMENT error is returned.
     * </pre>
     *
     * <code>string note = 3;</code>
     * @param value The note to set.
     * @return This builder for chaining.
     */
    public Builder setNote(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      note_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Some note on this request, this can be retrieved by
     * [CatalogService.GetDefaultBranch][google.cloud.retail.v2alpha.CatalogService.GetDefaultBranch]
     * before next valid default branch set occurs.
     * This field must be a UTF-8 encoded string with a length limit of 1,000
     * characters. Otherwise, an INVALID_ARGUMENT error is returned.
     * </pre>
     *
     * <code>string note = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearNote() {
      
      note_ = getDefaultInstance().getNote();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Some note on this request, this can be retrieved by
     * [CatalogService.GetDefaultBranch][google.cloud.retail.v2alpha.CatalogService.GetDefaultBranch]
     * before next valid default branch set occurs.
     * This field must be a UTF-8 encoded string with a length limit of 1,000
     * characters. Otherwise, an INVALID_ARGUMENT error is returned.
     * </pre>
     *
     * <code>string note = 3;</code>
     * @param value The bytes for note to set.
     * @return This builder for chaining.
     */
    public Builder setNoteBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      note_ = value;
      onChanged();
      return this;
    }

    private boolean force_ ;
    /**
     * <pre>
     * If set to true, it permits switching to a branch with
     * [branch_id][google.cloud.retail.v2alpha.SetDefaultBranchRequest.branch_id]
     * even if it has no sufficient active products.
     * </pre>
     *
     * <code>bool force = 4;</code>
     * @return The force.
     */
    @java.lang.Override
    public boolean getForce() {
      return force_;
    }
    /**
     * <pre>
     * If set to true, it permits switching to a branch with
     * [branch_id][google.cloud.retail.v2alpha.SetDefaultBranchRequest.branch_id]
     * even if it has no sufficient active products.
     * </pre>
     *
     * <code>bool force = 4;</code>
     * @param value The force to set.
     * @return This builder for chaining.
     */
    public Builder setForce(boolean value) {
      
      force_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * If set to true, it permits switching to a branch with
     * [branch_id][google.cloud.retail.v2alpha.SetDefaultBranchRequest.branch_id]
     * even if it has no sufficient active products.
     * </pre>
     *
     * <code>bool force = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearForce() {
      
      force_ = false;
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


    // @@protoc_insertion_point(builder_scope:google.cloud.retail.v2alpha.SetDefaultBranchRequest)
  }

  // @@protoc_insertion_point(class_scope:google.cloud.retail.v2alpha.SetDefaultBranchRequest)
  private static final com.google.cloud.retail.v2alpha.SetDefaultBranchRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.cloud.retail.v2alpha.SetDefaultBranchRequest();
  }

  public static com.google.cloud.retail.v2alpha.SetDefaultBranchRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SetDefaultBranchRequest>
      PARSER = new com.google.protobuf.AbstractParser<SetDefaultBranchRequest>() {
    @java.lang.Override
    public SetDefaultBranchRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<SetDefaultBranchRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SetDefaultBranchRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.cloud.retail.v2alpha.SetDefaultBranchRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

