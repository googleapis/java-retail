// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/retail/v2beta/control.proto

package com.google.cloud.retail.v2beta;

public final class ControlProto {
  private ControlProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2beta_Control_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2beta_Control_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n(google/cloud/retail/v2beta/control.pro" +
      "to\022\032google.cloud.retail.v2beta\032\037google/a" +
      "pi/field_behavior.proto\032\031google/api/reso" +
      "urce.proto\032\'google/cloud/retail/v2beta/c" +
      "ommon.proto\032/google/cloud/retail/v2beta/" +
      "search_service.proto\"\201\004\n\007Control\022M\n\nface" +
      "t_spec\030\003 \001(\01323.google.cloud.retail.v2bet" +
      "a.SearchRequest.FacetSpecB\002\030\001H\000\0220\n\004rule\030" +
      "\004 \001(\0132 .google.cloud.retail.v2beta.RuleH" +
      "\000\022\021\n\004name\030\001 \001(\tB\003\340A\005\022\031\n\014display_name\030\002 \001" +
      "(\tB\003\340A\002\022*\n\035associated_serving_config_ids" +
      "\030\005 \003(\tB\003\340A\003\022H\n\016solution_types\030\006 \003(\0162(.go" +
      "ogle.cloud.retail.v2beta.SolutionTypeB\006\340" +
      "A\002\340A\005\022S\n\030search_solution_use_case\030\007 \003(\0162" +
      "1.google.cloud.retail.v2beta.SearchSolut" +
      "ionUseCase:q\352An\n\035retail.googleapis.com/C" +
      "ontrol\022Mprojects/{project}/locations/{lo" +
      "cation}/catalogs/{catalog}/controls/{con" +
      "trol}B\t\n\007controlB\313\001\n\036com.google.cloud.re" +
      "tail.v2betaB\014ControlProtoP\001Z6cloud.googl" +
      "e.com/go/retail/apiv2beta/retailpb;retai" +
      "lpb\242\002\006RETAIL\252\002\032Google.Cloud.Retail.V2Bet" +
      "a\312\002\032Google\\Cloud\\Retail\\V2beta\352\002\035Google:" +
      ":Cloud::Retail::V2betab\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.api.FieldBehaviorProto.getDescriptor(),
          com.google.api.ResourceProto.getDescriptor(),
          com.google.cloud.retail.v2beta.CommonProto.getDescriptor(),
          com.google.cloud.retail.v2beta.SearchServiceProto.getDescriptor(),
        });
    internal_static_google_cloud_retail_v2beta_Control_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_retail_v2beta_Control_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2beta_Control_descriptor,
        new java.lang.String[] { "FacetSpec", "Rule", "Name", "DisplayName", "AssociatedServingConfigIds", "SolutionTypes", "SearchSolutionUseCase", "Control", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.ResourceProto.resource);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
    com.google.cloud.retail.v2beta.CommonProto.getDescriptor();
    com.google.cloud.retail.v2beta.SearchServiceProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}