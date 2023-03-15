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
// source: google/cloud/retail/v2alpha/control_service.proto

package com.google.cloud.retail.v2alpha;

public final class ControlServiceProto {
  private ControlServiceProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2alpha_CreateControlRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2alpha_CreateControlRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2alpha_UpdateControlRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2alpha_UpdateControlRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2alpha_DeleteControlRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2alpha_DeleteControlRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2alpha_GetControlRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2alpha_GetControlRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2alpha_ListControlsRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2alpha_ListControlsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2alpha_ListControlsResponse_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2alpha_ListControlsResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n1google/cloud/retail/v2alpha/control_se"
          + "rvice.proto\022\033google.cloud.retail.v2alpha"
          + "\032\034google/api/annotations.proto\032\027google/a"
          + "pi/client.proto\032\037google/api/field_behavi"
          + "or.proto\032\031google/api/resource.proto\032)goo"
          + "gle/cloud/retail/v2alpha/control.proto\032\033"
          + "google/protobuf/empty.proto\032 google/prot"
          + "obuf/field_mask.proto\"\242\001\n\024CreateControlR"
          + "equest\0225\n\006parent\030\001 \001(\tB%\340A\002\372A\037\n\035retail.g"
          + "oogleapis.com/Catalog\022:\n\007control\030\002 \001(\0132$"
          + ".google.cloud.retail.v2alpha.ControlB\003\340A"
          + "\002\022\027\n\ncontrol_id\030\003 \001(\tB\003\340A\002\"\203\001\n\024UpdateCon"
          + "trolRequest\022:\n\007control\030\001 \001(\0132$.google.cl"
          + "oud.retail.v2alpha.ControlB\003\340A\002\022/\n\013updat"
          + "e_mask\030\002 \001(\0132\032.google.protobuf.FieldMask"
          + "\"K\n\024DeleteControlRequest\0223\n\004name\030\001 \001(\tB%"
          + "\340A\002\372A\037\n\035retail.googleapis.com/Control\"H\n"
          + "\021GetControlRequest\0223\n\004name\030\001 \001(\tB%\340A\002\372A\037"
          + "\n\035retail.googleapis.com/Control\"\222\001\n\023List"
          + "ControlsRequest\0225\n\006parent\030\001 \001(\tB%\340A\002\372A\037\n"
          + "\035retail.googleapis.com/Catalog\022\026\n\tpage_s"
          + "ize\030\002 \001(\005B\003\340A\001\022\027\n\npage_token\030\003 \001(\tB\003\340A\001\022"
          + "\023\n\006filter\030\004 \001(\tB\003\340A\001\"g\n\024ListControlsResp"
          + "onse\0226\n\010controls\030\001 \003(\0132$.google.cloud.re"
          + "tail.v2alpha.Control\022\027\n\017next_page_token\030"
          + "\002 \001(\t2\252\010\n\016ControlService\022\323\001\n\rCreateContr"
          + "ol\0221.google.cloud.retail.v2alpha.CreateC"
          + "ontrolRequest\032$.google.cloud.retail.v2al"
          + "pha.Control\"i\202\323\344\223\002G\"</v2alpha/{parent=pr"
          + "ojects/*/locations/*/catalogs/*}/control"
          + "s:\007control\332A\031parent,control,control_id\022\247"
          + "\001\n\rDeleteControl\0221.google.cloud.retail.v"
          + "2alpha.DeleteControlRequest\032\026.google.pro"
          + "tobuf.Empty\"K\202\323\344\223\002>*</v2alpha/{name=proj"
          + "ects/*/locations/*/catalogs/*/controls/*"
          + "}\332A\004name\022\325\001\n\rUpdateControl\0221.google.clou"
          + "d.retail.v2alpha.UpdateControlRequest\032$."
          + "google.cloud.retail.v2alpha.Control\"k\202\323\344"
          + "\223\002O2D/v2alpha/{control.name=projects/*/l"
          + "ocations/*/catalogs/*/controls/*}:\007contr"
          + "ol\332A\023control,update_mask\022\257\001\n\nGetControl\022"
          + "..google.cloud.retail.v2alpha.GetControl"
          + "Request\032$.google.cloud.retail.v2alpha.Co"
          + "ntrol\"K\202\323\344\223\002>\022</v2alpha/{name=projects/*"
          + "/locations/*/catalogs/*/controls/*}\332A\004na"
          + "me\022\302\001\n\014ListControls\0220.google.cloud.retai"
          + "l.v2alpha.ListControlsRequest\0321.google.c"
          + "loud.retail.v2alpha.ListControlsResponse"
          + "\"M\202\323\344\223\002>\022</v2alpha/{parent=projects/*/lo"
          + "cations/*/catalogs/*}/controls\332A\006parent\032"
          + "I\312A\025retail.googleapis.com\322A.https://www."
          + "googleapis.com/auth/cloud-platformB\327\001\n\037c"
          + "om.google.cloud.retail.v2alphaB\023ControlS"
          + "erviceProtoP\001Z7cloud.google.com/go/retai"
          + "l/apiv2alpha/retailpb;retailpb\242\002\006RETAIL\252"
          + "\002\033Google.Cloud.Retail.V2Alpha\312\002\033Google\\C"
          + "loud\\Retail\\V2alpha\352\002\036Google::Cloud::Ret"
          + "ail::V2alphab\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.AnnotationsProto.getDescriptor(),
              com.google.api.ClientProto.getDescriptor(),
              com.google.api.FieldBehaviorProto.getDescriptor(),
              com.google.api.ResourceProto.getDescriptor(),
              com.google.cloud.retail.v2alpha.ControlProto.getDescriptor(),
              com.google.protobuf.EmptyProto.getDescriptor(),
              com.google.protobuf.FieldMaskProto.getDescriptor(),
            });
    internal_static_google_cloud_retail_v2alpha_CreateControlRequest_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_retail_v2alpha_CreateControlRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2alpha_CreateControlRequest_descriptor,
            new java.lang.String[] {
              "Parent", "Control", "ControlId",
            });
    internal_static_google_cloud_retail_v2alpha_UpdateControlRequest_descriptor =
        getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_retail_v2alpha_UpdateControlRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2alpha_UpdateControlRequest_descriptor,
            new java.lang.String[] {
              "Control", "UpdateMask",
            });
    internal_static_google_cloud_retail_v2alpha_DeleteControlRequest_descriptor =
        getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_retail_v2alpha_DeleteControlRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2alpha_DeleteControlRequest_descriptor,
            new java.lang.String[] {
              "Name",
            });
    internal_static_google_cloud_retail_v2alpha_GetControlRequest_descriptor =
        getDescriptor().getMessageTypes().get(3);
    internal_static_google_cloud_retail_v2alpha_GetControlRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2alpha_GetControlRequest_descriptor,
            new java.lang.String[] {
              "Name",
            });
    internal_static_google_cloud_retail_v2alpha_ListControlsRequest_descriptor =
        getDescriptor().getMessageTypes().get(4);
    internal_static_google_cloud_retail_v2alpha_ListControlsRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2alpha_ListControlsRequest_descriptor,
            new java.lang.String[] {
              "Parent", "PageSize", "PageToken", "Filter",
            });
    internal_static_google_cloud_retail_v2alpha_ListControlsResponse_descriptor =
        getDescriptor().getMessageTypes().get(5);
    internal_static_google_cloud_retail_v2alpha_ListControlsResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2alpha_ListControlsResponse_descriptor,
            new java.lang.String[] {
              "Controls", "NextPageToken",
            });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.ClientProto.defaultHost);
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.AnnotationsProto.http);
    registry.add(com.google.api.ClientProto.methodSignature);
    registry.add(com.google.api.ClientProto.oauthScopes);
    registry.add(com.google.api.ResourceProto.resourceReference);
    com.google.protobuf.Descriptors.FileDescriptor.internalUpdateFileDescriptor(
        descriptor, registry);
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.api.ClientProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
    com.google.cloud.retail.v2alpha.ControlProto.getDescriptor();
    com.google.protobuf.EmptyProto.getDescriptor();
    com.google.protobuf.FieldMaskProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
