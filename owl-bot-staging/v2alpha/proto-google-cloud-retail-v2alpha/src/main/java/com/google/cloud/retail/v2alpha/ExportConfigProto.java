// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/retail/v2alpha/export_config.proto

package com.google.cloud.retail.v2alpha;

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
    internal_static_google_cloud_retail_v2alpha_ExportErrorsConfig_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2alpha_ExportErrorsConfig_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2alpha_ExportMetadata_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2alpha_ExportMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2alpha_ExportProductsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2alpha_ExportProductsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2alpha_ExportUserEventsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2alpha_ExportUserEventsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2alpha_OutputResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2alpha_OutputResult_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2alpha_BigQueryOutputResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2alpha_BigQueryOutputResult_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n/google/cloud/retail/v2alpha/export_con" +
      "fig.proto\022\033google.cloud.retail.v2alpha\032\037" +
      "google/protobuf/timestamp.proto\032\027google/" +
      "rpc/status.proto\"9\n\022ExportErrorsConfig\022\024" +
      "\n\ngcs_prefix\030\001 \001(\tH\000B\r\n\013destination\"r\n\016E" +
      "xportMetadata\022/\n\013create_time\030\001 \001(\0132\032.goo" +
      "gle.protobuf.Timestamp\022/\n\013update_time\030\002 " +
      "\001(\0132\032.google.protobuf.Timestamp\"\315\001\n\026Expo" +
      "rtProductsResponse\022)\n\rerror_samples\030\001 \003(" +
      "\0132\022.google.rpc.Status\022F\n\rerrors_config\030\002" +
      " \001(\0132/.google.cloud.retail.v2alpha.Expor" +
      "tErrorsConfig\022@\n\routput_result\030\003 \001(\0132).g" +
      "oogle.cloud.retail.v2alpha.OutputResult\"" +
      "\317\001\n\030ExportUserEventsResponse\022)\n\rerror_sa" +
      "mples\030\001 \003(\0132\022.google.rpc.Status\022F\n\rerror" +
      "s_config\030\002 \001(\0132/.google.cloud.retail.v2a" +
      "lpha.ExportErrorsConfig\022@\n\routput_result" +
      "\030\003 \001(\0132).google.cloud.retail.v2alpha.Out" +
      "putResult\"Z\n\014OutputResult\022J\n\017bigquery_re" +
      "sult\030\001 \003(\01321.google.cloud.retail.v2alpha" +
      ".BigQueryOutputResult\"<\n\024BigQueryOutputR" +
      "esult\022\022\n\ndataset_id\030\001 \001(\t\022\020\n\010table_id\030\002 " +
      "\001(\tB\337\001\n\037com.google.cloud.retail.v2alphaB" +
      "\021ExportConfigProtoP\001ZAgoogle.golang.org/" +
      "genproto/googleapis/cloud/retail/v2alpha" +
      ";retail\242\002\006RETAIL\252\002\033Google.Cloud.Retail.V" +
      "2Alpha\312\002\033Google\\Cloud\\Retail\\V2alpha\352\002\036G" +
      "oogle::Cloud::Retail::V2alphab\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
          com.google.rpc.StatusProto.getDescriptor(),
        });
    internal_static_google_cloud_retail_v2alpha_ExportErrorsConfig_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_retail_v2alpha_ExportErrorsConfig_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2alpha_ExportErrorsConfig_descriptor,
        new java.lang.String[] { "GcsPrefix", "Destination", });
    internal_static_google_cloud_retail_v2alpha_ExportMetadata_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_retail_v2alpha_ExportMetadata_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2alpha_ExportMetadata_descriptor,
        new java.lang.String[] { "CreateTime", "UpdateTime", });
    internal_static_google_cloud_retail_v2alpha_ExportProductsResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_retail_v2alpha_ExportProductsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2alpha_ExportProductsResponse_descriptor,
        new java.lang.String[] { "ErrorSamples", "ErrorsConfig", "OutputResult", });
    internal_static_google_cloud_retail_v2alpha_ExportUserEventsResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_google_cloud_retail_v2alpha_ExportUserEventsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2alpha_ExportUserEventsResponse_descriptor,
        new java.lang.String[] { "ErrorSamples", "ErrorsConfig", "OutputResult", });
    internal_static_google_cloud_retail_v2alpha_OutputResult_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_google_cloud_retail_v2alpha_OutputResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2alpha_OutputResult_descriptor,
        new java.lang.String[] { "BigqueryResult", });
    internal_static_google_cloud_retail_v2alpha_BigQueryOutputResult_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_google_cloud_retail_v2alpha_BigQueryOutputResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2alpha_BigQueryOutputResult_descriptor,
        new java.lang.String[] { "DatasetId", "TableId", });
    com.google.protobuf.TimestampProto.getDescriptor();
    com.google.rpc.StatusProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
