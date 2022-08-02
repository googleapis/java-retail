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
// source: google/cloud/retail/v2/catalog.proto

package com.google.cloud.retail.v2;

public final class CatalogProto {
  private CatalogProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2_ProductLevelConfig_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_ProductLevelConfig_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2_Catalog_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_Catalog_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n$google/cloud/retail/v2/catalog.proto\022\026"
          + "google.cloud.retail.v2\032\037google/api/field"
          + "_behavior.proto\032\031google/api/resource.pro"
          + "to\"^\n\022ProductLevelConfig\022\036\n\026ingestion_pr"
          + "oduct_type\030\001 \001(\t\022(\n merchant_center_prod"
          + "uct_id_field\030\002 \001(\t\"\354\001\n\007Catalog\022\024\n\004name\030\001"
          + " \001(\tB\006\340A\002\340A\005\022\034\n\014display_name\030\002 \001(\tB\006\340A\002\340"
          + "A\005\022M\n\024product_level_config\030\004 \001(\0132*.googl"
          + "e.cloud.retail.v2.ProductLevelConfigB\003\340A"
          + "\002:^\352A[\n\035retail.googleapis.com/Catalog\022:p"
          + "rojects/{project}/locations/{location}/c"
          + "atalogs/{catalog}B\301\001\n\032com.google.cloud.r"
          + "etail.v2B\014CatalogProtoP\001Z<google.golang."
          + "org/genproto/googleapis/cloud/retail/v2;"
          + "retail\242\002\006RETAIL\252\002\026Google.Cloud.Retail.V2"
          + "\312\002\026Google\\Cloud\\Retail\\V2\352\002\031Google::Clou"
          + "d::Retail::V2b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.FieldBehaviorProto.getDescriptor(),
              com.google.api.ResourceProto.getDescriptor(),
            });
    internal_static_google_cloud_retail_v2_ProductLevelConfig_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_retail_v2_ProductLevelConfig_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2_ProductLevelConfig_descriptor,
            new java.lang.String[] {
              "IngestionProductType", "MerchantCenterProductIdField",
            });
    internal_static_google_cloud_retail_v2_Catalog_descriptor =
        getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_retail_v2_Catalog_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2_Catalog_descriptor,
            new java.lang.String[] {
              "Name", "DisplayName", "ProductLevelConfig",
            });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.ResourceProto.resource);
    com.google.protobuf.Descriptors.FileDescriptor.internalUpdateFileDescriptor(
        descriptor, registry);
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
