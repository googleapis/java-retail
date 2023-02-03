// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/retail/v2beta/export_config.proto

package com.google.cloud.retail.v2beta;

public final class ExportConfigProto {
  private ExportConfigProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2beta_ExportErrorsConfig_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2beta_ExportErrorsConfig_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2beta_ExportMetadata_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2beta_ExportMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2beta_ExportProductsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2beta_ExportProductsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2beta_ExportUserEventsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2beta_ExportUserEventsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2beta_OutputResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2beta_OutputResult_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2beta_BigQueryOutputResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2beta_BigQueryOutputResult_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2beta_GcsOutputResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2beta_GcsOutputResult_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n.google/cloud/retail/v2beta/export_conf" +
      "ig.proto\022\032google.cloud.retail.v2beta\032\037go" +
      "ogle/api/field_behavior.proto\032\031google/ap" +
      "i/resource.proto\032\037google/protobuf/timest" +
      "amp.proto\032\027google/rpc/status.proto\"9\n\022Ex" +
      "portErrorsConfig\022\024\n\ngcs_prefix\030\001 \001(\tH\000B\r" +
      "\n\013destination\"r\n\016ExportMetadata\022/\n\013creat" +
      "e_time\030\001 \001(\0132\032.google.protobuf.Timestamp" +
      "\022/\n\013update_time\030\002 \001(\0132\032.google.protobuf." +
      "Timestamp\"\313\001\n\026ExportProductsResponse\022)\n\r" +
      "error_samples\030\001 \003(\0132\022.google.rpc.Status\022" +
      "E\n\rerrors_config\030\002 \001(\0132..google.cloud.re" +
      "tail.v2beta.ExportErrorsConfig\022?\n\routput" +
      "_result\030\003 \001(\0132(.google.cloud.retail.v2be" +
      "ta.OutputResult\"\315\001\n\030ExportUserEventsResp" +
      "onse\022)\n\rerror_samples\030\001 \003(\0132\022.google.rpc" +
      ".Status\022E\n\rerrors_config\030\002 \001(\0132..google." +
      "cloud.retail.v2beta.ExportErrorsConfig\022?" +
      "\n\routput_result\030\003 \001(\0132(.google.cloud.ret" +
      "ail.v2beta.OutputResult\"\232\001\n\014OutputResult" +
      "\022I\n\017bigquery_result\030\001 \003(\01320.google.cloud" +
      ".retail.v2beta.BigQueryOutputResult\022?\n\ng" +
      "cs_result\030\002 \003(\0132+.google.cloud.retail.v2" +
      "beta.GcsOutputResult\"<\n\024BigQueryOutputRe" +
      "sult\022\022\n\ndataset_id\030\001 \001(\t\022\020\n\010table_id\030\002 \001" +
      "(\t\"%\n\017GcsOutputResult\022\022\n\noutput_uri\030\001 \001(" +
      "\tB\320\001\n\036com.google.cloud.retail.v2betaB\021Ex" +
      "portConfigProtoP\001Z6cloud.google.com/go/r" +
      "etail/apiv2beta/retailpb;retailpb\242\002\006RETA" +
      "IL\252\002\032Google.Cloud.Retail.V2Beta\312\002\032Google" +
      "\\Cloud\\Retail\\V2beta\352\002\035Google::Cloud::Re" +
      "tail::V2betab\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.api.FieldBehaviorProto.getDescriptor(),
          com.google.api.ResourceProto.getDescriptor(),
          com.google.protobuf.TimestampProto.getDescriptor(),
          com.google.rpc.StatusProto.getDescriptor(),
        });
    internal_static_google_cloud_retail_v2beta_ExportErrorsConfig_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_retail_v2beta_ExportErrorsConfig_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2beta_ExportErrorsConfig_descriptor,
        new java.lang.String[] { "GcsPrefix", "Destination", });
    internal_static_google_cloud_retail_v2beta_ExportMetadata_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_retail_v2beta_ExportMetadata_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2beta_ExportMetadata_descriptor,
        new java.lang.String[] { "CreateTime", "UpdateTime", });
    internal_static_google_cloud_retail_v2beta_ExportProductsResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_retail_v2beta_ExportProductsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2beta_ExportProductsResponse_descriptor,
        new java.lang.String[] { "ErrorSamples", "ErrorsConfig", "OutputResult", });
    internal_static_google_cloud_retail_v2beta_ExportUserEventsResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_google_cloud_retail_v2beta_ExportUserEventsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2beta_ExportUserEventsResponse_descriptor,
        new java.lang.String[] { "ErrorSamples", "ErrorsConfig", "OutputResult", });
    internal_static_google_cloud_retail_v2beta_OutputResult_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_google_cloud_retail_v2beta_OutputResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2beta_OutputResult_descriptor,
        new java.lang.String[] { "BigqueryResult", "GcsResult", });
    internal_static_google_cloud_retail_v2beta_BigQueryOutputResult_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_google_cloud_retail_v2beta_BigQueryOutputResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2beta_BigQueryOutputResult_descriptor,
        new java.lang.String[] { "DatasetId", "TableId", });
    internal_static_google_cloud_retail_v2beta_GcsOutputResult_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_google_cloud_retail_v2beta_GcsOutputResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2beta_GcsOutputResult_descriptor,
        new java.lang.String[] { "OutputUri", });
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
    com.google.protobuf.TimestampProto.getDescriptor();
    com.google.rpc.StatusProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}