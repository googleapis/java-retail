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
// source: google/cloud/retail/v2alpha/control.proto

package com.google.cloud.retail.v2alpha;

public final class ControlProto {
  private ControlProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2alpha_Control_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2alpha_Control_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n)google/cloud/retail/v2alpha/control.pr"
          + "oto\022\033google.cloud.retail.v2alpha\032\037google"
          + "/api/field_behavior.proto\032\031google/api/re"
          + "source.proto\032(google/cloud/retail/v2alph"
          + "a/common.proto\0320google/cloud/retail/v2al"
          + "pha/search_service.proto\"\206\004\n\007Control\022J\n\n"
          + "facet_spec\030\003 \001(\01324.google.cloud.retail.v"
          + "2alpha.SearchRequest.FacetSpecH\000\0221\n\004rule"
          + "\030\004 \001(\0132!.google.cloud.retail.v2alpha.Rul"
          + "eH\000\022\021\n\004name\030\001 \001(\tB\003\340A\005\022\031\n\014display_name\030\002"
          + " \001(\tB\003\340A\002\022*\n\035associated_serving_config_i"
          + "ds\030\005 \003(\tB\003\340A\003\022I\n\016solution_types\030\006 \003(\0162)."
          + "google.cloud.retail.v2alpha.SolutionType"
          + "B\006\340A\002\340A\005\022Y\n\030search_solution_use_case\030\007 \003"
          + "(\01622.google.cloud.retail.v2alpha.SearchS"
          + "olutionUseCaseB\003\340A\002:q\352An\n\035retail.googlea"
          + "pis.com/Control\022Mprojects/{project}/loca"
          + "tions/{location}/catalogs/{catalog}/cont"
          + "rols/{control}B\t\n\007controlB\332\001\n\037com.google"
          + ".cloud.retail.v2alphaB\014ControlProtoP\001ZAg"
          + "oogle.golang.org/genproto/googleapis/clo"
          + "ud/retail/v2alpha;retail\242\002\006RETAIL\252\002\033Goog"
          + "le.Cloud.Retail.V2Alpha\312\002\033Google\\Cloud\\R"
          + "etail\\V2alpha\352\002\036Google::Cloud::Retail::V"
          + "2alphab\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.FieldBehaviorProto.getDescriptor(),
              com.google.api.ResourceProto.getDescriptor(),
              com.google.cloud.retail.v2alpha.CommonProto.getDescriptor(),
              com.google.cloud.retail.v2alpha.SearchServiceProto.getDescriptor(),
            });
    internal_static_google_cloud_retail_v2alpha_Control_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_retail_v2alpha_Control_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2alpha_Control_descriptor,
            new java.lang.String[] {
              "FacetSpec",
              "Rule",
              "Name",
              "DisplayName",
              "AssociatedServingConfigIds",
              "SolutionTypes",
              "SearchSolutionUseCase",
              "Control",
            });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.ResourceProto.resource);
    com.google.protobuf.Descriptors.FileDescriptor.internalUpdateFileDescriptor(
        descriptor, registry);
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
    com.google.cloud.retail.v2alpha.CommonProto.getDescriptor();
    com.google.cloud.retail.v2alpha.SearchServiceProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
