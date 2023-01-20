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
// source: google/cloud/retail/v2alpha/user_event_service.proto

package com.google.cloud.retail.v2alpha;

public final class UserEventServiceProto {
  private UserEventServiceProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2alpha_WriteUserEventRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2alpha_WriteUserEventRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2alpha_CollectUserEventRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2alpha_CollectUserEventRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2alpha_RejoinUserEventsRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2alpha_RejoinUserEventsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2alpha_RejoinUserEventsResponse_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2alpha_RejoinUserEventsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2alpha_RejoinUserEventsMetadata_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2alpha_RejoinUserEventsMetadata_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n4google/cloud/retail/v2alpha/user_event"
          + "_service.proto\022\033google.cloud.retail.v2al"
          + "pha\032\034google/api/annotations.proto\032\027googl"
          + "e/api/client.proto\032\037google/api/field_beh"
          + "avior.proto\032\031google/api/httpbody.proto\032\031"
          + "google/api/resource.proto\032/google/cloud/"
          + "retail/v2alpha/import_config.proto\032.goog"
          + "le/cloud/retail/v2alpha/purge_config.pro"
          + "to\032,google/cloud/retail/v2alpha/user_eve"
          + "nt.proto\032#google/longrunning/operations."
          + "proto\"\202\001\n\025WriteUserEventRequest\022\023\n\006paren"
          + "t\030\001 \001(\tB\003\340A\002\022?\n\nuser_event\030\002 \001(\0132&.googl"
          + "e.cloud.retail.v2alpha.UserEventB\003\340A\002\022\023\n"
          + "\013write_async\030\003 \001(\010\"\237\001\n\027CollectUserEventR"
          + "equest\022\027\n\rprebuilt_rule\030\006 \001(\tH\000\022\023\n\006paren"
          + "t\030\001 \001(\tB\003\340A\002\022\027\n\nuser_event\030\002 \001(\tB\003\340A\002\022\013\n"
          + "\003uri\030\003 \001(\t\022\013\n\003ets\030\004 \001(\003\022\020\n\010raw_json\030\005 \001("
          + "\tB\021\n\017conversion_rule\"\203\002\n\027RejoinUserEvent"
          + "sRequest\022\023\n\006parent\030\001 \001(\tB\003\340A\002\022j\n\027user_ev"
          + "ent_rejoin_scope\030\002 \001(\0162I.google.cloud.re"
          + "tail.v2alpha.RejoinUserEventsRequest.Use"
          + "rEventRejoinScope\"g\n\024UserEventRejoinScop"
          + "e\022\'\n#USER_EVENT_REJOIN_SCOPE_UNSPECIFIED"
          + "\020\000\022\021\n\rJOINED_EVENTS\020\001\022\023\n\017UNJOINED_EVENTS"
          + "\020\002\">\n\030RejoinUserEventsResponse\022\"\n\032rejoin"
          + "ed_user_events_count\030\001 \001(\003\"\032\n\030RejoinUser"
          + "EventsMetadata2\212\n\n\020UserEventService\022\306\001\n\016"
          + "WriteUserEvent\0222.google.cloud.retail.v2a"
          + "lpha.WriteUserEventRequest\032&.google.clou"
          + "d.retail.v2alpha.UserEvent\"X\202\323\344\223\002R\"D/v2a"
          + "lpha/{parent=projects/*/locations/*/cata"
          + "logs/*}/userEvents:write:\nuser_event\022\256\001\n"
          + "\020CollectUserEvent\0224.google.cloud.retail."
          + "v2alpha.CollectUserEventRequest\032\024.google"
          + ".api.HttpBody\"N\202\323\344\223\002H\022F/v2alpha/{parent="
          + "projects/*/locations/*/catalogs/*}/userE"
          + "vents:collect\022\232\002\n\017PurgeUserEvents\0223.goog"
          + "le.cloud.retail.v2alpha.PurgeUserEventsR"
          + "equest\032\035.google.longrunning.Operation\"\262\001"
          + "\202\323\344\223\002I\"D/v2alpha/{parent=projects/*/loca"
          + "tions/*/catalogs/*}/userEvents:purge:\001*\312"
          + "A`\n3google.cloud.retail.v2alpha.PurgeUse"
          + "rEventsResponse\022)google.cloud.retail.v2a"
          + "lpha.PurgeMetadata\022\237\002\n\020ImportUserEvents\022"
          + "4.google.cloud.retail.v2alpha.ImportUser"
          + "EventsRequest\032\035.google.longrunning.Opera"
          + "tion\"\265\001\202\323\344\223\002J\"E/v2alpha/{parent=projects"
          + "/*/locations/*/catalogs/*}/userEvents:im"
          + "port:\001*\312Ab\n4google.cloud.retail.v2alpha."
          + "ImportUserEventsResponse\022*google.cloud.r"
          + "etail.v2alpha.ImportMetadata\022\361\001\n\020RejoinU"
          + "serEvents\0224.google.cloud.retail.v2alpha."
          + "RejoinUserEventsRequest\032\035.google.longrun"
          + "ning.Operation\"\207\001\202\323\344\223\002J\"E/v2alpha/{paren"
          + "t=projects/*/locations/*/catalogs/*}/use"
          + "rEvents:rejoin:\001*\312A4\n\030RejoinUserEventsRe"
          + "sponse\022\030RejoinUserEventsMetadata\032I\312A\025ret"
          + "ail.googleapis.com\322A.https://www.googlea"
          + "pis.com/auth/cloud-platformB\343\001\n\037com.goog"
          + "le.cloud.retail.v2alphaB\025UserEventServic"
          + "eProtoP\001ZAgoogle.golang.org/genproto/goo"
          + "gleapis/cloud/retail/v2alpha;retail\242\002\006RE"
          + "TAIL\252\002\033Google.Cloud.Retail.V2Alpha\312\002\033Goo"
          + "gle\\Cloud\\Retail\\V2alpha\352\002\036Google::Cloud"
          + "::Retail::V2alphab\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.AnnotationsProto.getDescriptor(),
              com.google.api.ClientProto.getDescriptor(),
              com.google.api.FieldBehaviorProto.getDescriptor(),
              com.google.api.HttpBodyProto.getDescriptor(),
              com.google.api.ResourceProto.getDescriptor(),
              com.google.cloud.retail.v2alpha.ImportConfigProto.getDescriptor(),
              com.google.cloud.retail.v2alpha.PurgeConfigProto.getDescriptor(),
              com.google.cloud.retail.v2alpha.UserEventProto.getDescriptor(),
              com.google.longrunning.OperationsProto.getDescriptor(),
            });
    internal_static_google_cloud_retail_v2alpha_WriteUserEventRequest_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_retail_v2alpha_WriteUserEventRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2alpha_WriteUserEventRequest_descriptor,
            new java.lang.String[] {
              "Parent", "UserEvent", "WriteAsync",
            });
    internal_static_google_cloud_retail_v2alpha_CollectUserEventRequest_descriptor =
        getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_retail_v2alpha_CollectUserEventRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2alpha_CollectUserEventRequest_descriptor,
            new java.lang.String[] {
              "PrebuiltRule", "Parent", "UserEvent", "Uri", "Ets", "RawJson", "ConversionRule",
            });
    internal_static_google_cloud_retail_v2alpha_RejoinUserEventsRequest_descriptor =
        getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_retail_v2alpha_RejoinUserEventsRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2alpha_RejoinUserEventsRequest_descriptor,
            new java.lang.String[] {
              "Parent", "UserEventRejoinScope",
            });
    internal_static_google_cloud_retail_v2alpha_RejoinUserEventsResponse_descriptor =
        getDescriptor().getMessageTypes().get(3);
    internal_static_google_cloud_retail_v2alpha_RejoinUserEventsResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2alpha_RejoinUserEventsResponse_descriptor,
            new java.lang.String[] {
              "RejoinedUserEventsCount",
            });
    internal_static_google_cloud_retail_v2alpha_RejoinUserEventsMetadata_descriptor =
        getDescriptor().getMessageTypes().get(4);
    internal_static_google_cloud_retail_v2alpha_RejoinUserEventsMetadata_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2alpha_RejoinUserEventsMetadata_descriptor,
            new java.lang.String[] {});
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.ClientProto.defaultHost);
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.AnnotationsProto.http);
    registry.add(com.google.api.ClientProto.oauthScopes);
    registry.add(com.google.longrunning.OperationsProto.operationInfo);
    com.google.protobuf.Descriptors.FileDescriptor.internalUpdateFileDescriptor(
        descriptor, registry);
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.api.ClientProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.HttpBodyProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
    com.google.cloud.retail.v2alpha.ImportConfigProto.getDescriptor();
    com.google.cloud.retail.v2alpha.PurgeConfigProto.getDescriptor();
    com.google.cloud.retail.v2alpha.UserEventProto.getDescriptor();
    com.google.longrunning.OperationsProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
