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
// source: google/cloud/retail/v2beta/model_service.proto

package com.google.cloud.retail.v2beta;

public final class ModelServiceProto {
  private ModelServiceProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2beta_CreateModelRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2beta_CreateModelRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2beta_UpdateModelRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2beta_UpdateModelRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2beta_PauseModelRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2beta_PauseModelRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2beta_ResumeModelRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2beta_ResumeModelRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2beta_ListModelsRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2beta_ListModelsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2beta_DeleteModelRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2beta_DeleteModelRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2beta_ListModelsResponse_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2beta_ListModelsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2beta_TuneModelRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2beta_TuneModelRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2beta_CreateModelMetadata_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2beta_CreateModelMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2beta_TuneModelMetadata_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2beta_TuneModelMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_retail_v2beta_TuneModelResponse_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2beta_TuneModelResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n.google/cloud/retail/v2beta/model_servi"
          + "ce.proto\022\032google.cloud.retail.v2beta\032\034go"
          + "ogle/api/annotations.proto\032\027google/api/c"
          + "lient.proto\032\037google/api/field_behavior.p"
          + "roto\032\031google/api/resource.proto\032&google/"
          + "cloud/retail/v2beta/model.proto\032#google/"
          + "longrunning/operations.proto\032\033google/pro"
          + "tobuf/empty.proto\032 google/protobuf/field"
          + "_mask.proto\"\230\001\n\022CreateModelRequest\0225\n\006pa"
          + "rent\030\001 \001(\tB%\340A\002\372A\037\n\035retail.googleapis.co"
          + "m/Catalog\0225\n\005model\030\002 \001(\0132!.google.cloud."
          + "retail.v2beta.ModelB\003\340A\002\022\024\n\007dry_run\030\003 \001("
          + "\010B\003\340A\001\"\201\001\n\022UpdateModelRequest\0225\n\005model\030\001"
          + " \001(\0132!.google.cloud.retail.v2beta.ModelB"
          + "\003\340A\002\0224\n\013update_mask\030\002 \001(\0132\032.google.proto"
          + "buf.FieldMaskB\003\340A\001\"F\n\021PauseModelRequest\022"
          + "1\n\004name\030\001 \001(\tB#\340A\002\372A\035\n\033retail.googleapis"
          + ".com/Model\"\'\n\022ResumeModelRequest\022\021\n\004name"
          + "\030\001 \001(\tB\003\340A\002\"{\n\021ListModelsRequest\0225\n\006pare"
          + "nt\030\001 \001(\tB%\340A\002\372A\037\n\035retail.googleapis.com/"
          + "Catalog\022\026\n\tpage_size\030\002 \001(\005B\003\340A\001\022\027\n\npage_"
          + "token\030\003 \001(\tB\003\340A\001\"G\n\022DeleteModelRequest\0221"
          + "\n\004name\030\001 \001(\tB#\340A\002\372A\035\n\033retail.googleapis."
          + "com/Model\"`\n\022ListModelsResponse\0221\n\006model"
          + "s\030\001 \003(\0132!.google.cloud.retail.v2beta.Mod"
          + "el\022\027\n\017next_page_token\030\002 \001(\t\"E\n\020TuneModel"
          + "Request\0221\n\004name\030\001 \001(\tB#\340A\002\372A\035\n\033retail.go"
          + "ogleapis.com/Model\"$\n\023CreateModelMetadat"
          + "a\022\r\n\005model\030\001 \001(\t\"\"\n\021TuneModelMetadata\022\r\n"
          + "\005model\030\001 \001(\t\"\023\n\021TuneModelResponse2\202\014\n\014Mo"
          + "delService\022\213\002\n\013CreateModel\022..google.clou"
          + "d.retail.v2beta.CreateModelRequest\032\035.goo"
          + "gle.longrunning.Operation\"\254\001\202\323\344\223\002B\"9/v2b"
          + "eta/{parent=projects/*/locations/*/catal"
          + "ogs/*}/models:\005model\332A\014parent,model\312AR\n "
          + "google.cloud.retail.v2beta.Model\022.google"
          + ".cloud.retail.v2beta.CreateModelMetadata"
          + "\022\261\001\n\nPauseModel\022-.google.cloud.retail.v2"
          + "beta.PauseModelRequest\032!.google.cloud.re"
          + "tail.v2beta.Model\"Q\202\323\344\223\002D\"?/v2beta/{name"
          + "=projects/*/locations/*/catalogs/*/model"
          + "s/*}:pause:\001*\332A\004name\022\264\001\n\013ResumeModel\022..g"
          + "oogle.cloud.retail.v2beta.ResumeModelReq"
          + "uest\032!.google.cloud.retail.v2beta.Model\""
          + "R\202\323\344\223\002E\"@/v2beta/{name=projects/*/locati"
          + "ons/*/catalogs/*/models/*}:resume:\001*\332A\004n"
          + "ame\022\237\001\n\013DeleteModel\022..google.cloud.retai"
          + "l.v2beta.DeleteModelRequest\032\026.google.pro"
          + "tobuf.Empty\"H\202\323\344\223\002;*9/v2beta/{name=proje"
          + "cts/*/locations/*/catalogs/*/models/*}\332A"
          + "\004name\022\267\001\n\nListModels\022-.google.cloud.reta"
          + "il.v2beta.ListModelsRequest\032..google.clo"
          + "ud.retail.v2beta.ListModelsResponse\"J\202\323\344"
          + "\223\002;\0229/v2beta/{parent=projects/*/location"
          + "s/*/catalogs/*}/models\332A\006parent\022\304\001\n\013Upda"
          + "teModel\022..google.cloud.retail.v2beta.Upd"
          + "ateModelRequest\032!.google.cloud.retail.v2"
          + "beta.Model\"b\202\323\344\223\002H2?/v2beta/{model.name="
          + "projects/*/locations/*/catalogs/*/models"
          + "/*}:\005model\332A\021model,update_mask\022\212\002\n\tTuneM"
          + "odel\022,.google.cloud.retail.v2beta.TuneMo"
          + "delRequest\032\035.google.longrunning.Operatio"
          + "n\"\257\001\202\323\344\223\002C\">/v2beta/{name=projects/*/loc"
          + "ations/*/catalogs/*/models/*}:tune:\001*\332A\004"
          + "name\312A\\\n,google.cloud.retail.v2beta.Tune"
          + "ModelResponse\022,google.cloud.retail.v2bet"
          + "a.TuneModelMetadata\032I\312A\025retail.googleapi"
          + "s.com\322A.https://www.googleapis.com/auth/"
          + "cloud-platformB\320\001\n\036com.google.cloud.reta"
          + "il.v2betaB\021ModelServiceProtoP\001Z6cloud.go"
          + "ogle.com/go/retail/apiv2beta/retailpb;re"
          + "tailpb\242\002\006RETAIL\252\002\032Google.Cloud.Retail.V2"
          + "Beta\312\002\032Google\\Cloud\\Retail\\V2beta\352\002\035Goog"
          + "le::Cloud::Retail::V2betab\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.AnnotationsProto.getDescriptor(),
              com.google.api.ClientProto.getDescriptor(),
              com.google.api.FieldBehaviorProto.getDescriptor(),
              com.google.api.ResourceProto.getDescriptor(),
              com.google.cloud.retail.v2beta.ModelProto.getDescriptor(),
              com.google.longrunning.OperationsProto.getDescriptor(),
              com.google.protobuf.EmptyProto.getDescriptor(),
              com.google.protobuf.FieldMaskProto.getDescriptor(),
            });
    internal_static_google_cloud_retail_v2beta_CreateModelRequest_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_retail_v2beta_CreateModelRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2beta_CreateModelRequest_descriptor,
            new java.lang.String[] {
              "Parent", "Model", "DryRun",
            });
    internal_static_google_cloud_retail_v2beta_UpdateModelRequest_descriptor =
        getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_retail_v2beta_UpdateModelRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2beta_UpdateModelRequest_descriptor,
            new java.lang.String[] {
              "Model", "UpdateMask",
            });
    internal_static_google_cloud_retail_v2beta_PauseModelRequest_descriptor =
        getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_retail_v2beta_PauseModelRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2beta_PauseModelRequest_descriptor,
            new java.lang.String[] {
              "Name",
            });
    internal_static_google_cloud_retail_v2beta_ResumeModelRequest_descriptor =
        getDescriptor().getMessageTypes().get(3);
    internal_static_google_cloud_retail_v2beta_ResumeModelRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2beta_ResumeModelRequest_descriptor,
            new java.lang.String[] {
              "Name",
            });
    internal_static_google_cloud_retail_v2beta_ListModelsRequest_descriptor =
        getDescriptor().getMessageTypes().get(4);
    internal_static_google_cloud_retail_v2beta_ListModelsRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2beta_ListModelsRequest_descriptor,
            new java.lang.String[] {
              "Parent", "PageSize", "PageToken",
            });
    internal_static_google_cloud_retail_v2beta_DeleteModelRequest_descriptor =
        getDescriptor().getMessageTypes().get(5);
    internal_static_google_cloud_retail_v2beta_DeleteModelRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2beta_DeleteModelRequest_descriptor,
            new java.lang.String[] {
              "Name",
            });
    internal_static_google_cloud_retail_v2beta_ListModelsResponse_descriptor =
        getDescriptor().getMessageTypes().get(6);
    internal_static_google_cloud_retail_v2beta_ListModelsResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2beta_ListModelsResponse_descriptor,
            new java.lang.String[] {
              "Models", "NextPageToken",
            });
    internal_static_google_cloud_retail_v2beta_TuneModelRequest_descriptor =
        getDescriptor().getMessageTypes().get(7);
    internal_static_google_cloud_retail_v2beta_TuneModelRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2beta_TuneModelRequest_descriptor,
            new java.lang.String[] {
              "Name",
            });
    internal_static_google_cloud_retail_v2beta_CreateModelMetadata_descriptor =
        getDescriptor().getMessageTypes().get(8);
    internal_static_google_cloud_retail_v2beta_CreateModelMetadata_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2beta_CreateModelMetadata_descriptor,
            new java.lang.String[] {
              "Model",
            });
    internal_static_google_cloud_retail_v2beta_TuneModelMetadata_descriptor =
        getDescriptor().getMessageTypes().get(9);
    internal_static_google_cloud_retail_v2beta_TuneModelMetadata_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2beta_TuneModelMetadata_descriptor,
            new java.lang.String[] {
              "Model",
            });
    internal_static_google_cloud_retail_v2beta_TuneModelResponse_descriptor =
        getDescriptor().getMessageTypes().get(10);
    internal_static_google_cloud_retail_v2beta_TuneModelResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_retail_v2beta_TuneModelResponse_descriptor,
            new java.lang.String[] {});
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.ClientProto.defaultHost);
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.AnnotationsProto.http);
    registry.add(com.google.api.ClientProto.methodSignature);
    registry.add(com.google.api.ClientProto.oauthScopes);
    registry.add(com.google.api.ResourceProto.resourceReference);
    registry.add(com.google.longrunning.OperationsProto.operationInfo);
    com.google.protobuf.Descriptors.FileDescriptor.internalUpdateFileDescriptor(
        descriptor, registry);
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.api.ClientProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
    com.google.cloud.retail.v2beta.ModelProto.getDescriptor();
    com.google.longrunning.OperationsProto.getDescriptor();
    com.google.protobuf.EmptyProto.getDescriptor();
    com.google.protobuf.FieldMaskProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
