// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/retail/v2/serving_config_service.proto

package com.google.cloud.retail.v2;

public final class ServingConfigServiceProto {
  private ServingConfigServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2_CreateServingConfigRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_CreateServingConfigRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2_UpdateServingConfigRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_UpdateServingConfigRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2_DeleteServingConfigRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_DeleteServingConfigRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2_GetServingConfigRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_GetServingConfigRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2_ListServingConfigsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_ListServingConfigsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2_ListServingConfigsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_ListServingConfigsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2_AddControlRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_AddControlRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2_RemoveControlRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_RemoveControlRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n3google/cloud/retail/v2/serving_config_" +
      "service.proto\022\026google.cloud.retail.v2\032\034g" +
      "oogle/api/annotations.proto\032\027google/api/" +
      "client.proto\032\037google/api/field_behavior." +
      "proto\032\031google/api/resource.proto\032+google" +
      "/cloud/retail/v2/serving_config.proto\032\033g" +
      "oogle/protobuf/empty.proto\032 google/proto" +
      "buf/field_mask.proto\"\267\001\n\032CreateServingCo" +
      "nfigRequest\0225\n\006parent\030\001 \001(\tB%\340A\002\372A\037\n\035ret" +
      "ail.googleapis.com/Catalog\022B\n\016serving_co" +
      "nfig\030\002 \001(\0132%.google.cloud.retail.v2.Serv" +
      "ingConfigB\003\340A\002\022\036\n\021serving_config_id\030\003 \001(" +
      "\tB\003\340A\002\"\221\001\n\032UpdateServingConfigRequest\022B\n" +
      "\016serving_config\030\001 \001(\0132%.google.cloud.ret" +
      "ail.v2.ServingConfigB\003\340A\002\022/\n\013update_mask" +
      "\030\002 \001(\0132\032.google.protobuf.FieldMask\"W\n\032De" +
      "leteServingConfigRequest\0229\n\004name\030\001 \001(\tB+" +
      "\340A\002\372A%\n#retail.googleapis.com/ServingCon" +
      "fig\"T\n\027GetServingConfigRequest\0229\n\004name\030\001" +
      " \001(\tB+\340A\002\372A%\n#retail.googleapis.com/Serv" +
      "ingConfig\"\203\001\n\031ListServingConfigsRequest\022" +
      "5\n\006parent\030\001 \001(\tB%\340A\002\372A\037\n\035retail.googleap" +
      "is.com/Catalog\022\026\n\tpage_size\030\002 \001(\005B\003\340A\001\022\027" +
      "\n\npage_token\030\003 \001(\tB\003\340A\001\"u\n\032ListServingCo" +
      "nfigsResponse\022>\n\017serving_configs\030\001 \003(\0132%" +
      ".google.cloud.retail.v2.ServingConfig\022\027\n" +
      "\017next_page_token\030\002 \001(\t\"q\n\021AddControlRequ" +
      "est\022C\n\016serving_config\030\001 \001(\tB+\340A\002\372A%\n#ret" +
      "ail.googleapis.com/ServingConfig\022\027\n\ncont" +
      "rol_id\030\002 \001(\tB\003\340A\002\"t\n\024RemoveControlReques" +
      "t\022C\n\016serving_config\030\001 \001(\tB+\340A\002\372A%\n#retai" +
      "l.googleapis.com/ServingConfig\022\027\n\ncontro" +
      "l_id\030\002 \001(\tB\003\340A\0022\262\014\n\024ServingConfigService" +
      "\022\361\001\n\023CreateServingConfig\0222.google.cloud." +
      "retail.v2.CreateServingConfigRequest\032%.g" +
      "oogle.cloud.retail.v2.ServingConfig\"\177\202\323\344" +
      "\223\002O\"=/v2/{parent=projects/*/locations/*/" +
      "catalogs/*}/servingConfigs:\016serving_conf" +
      "ig\332A\'parent,serving_config,serving_confi" +
      "g_id\022\257\001\n\023DeleteServingConfig\0222.google.cl" +
      "oud.retail.v2.DeleteServingConfigRequest" +
      "\032\026.google.protobuf.Empty\"L\202\323\344\223\002?*=/v2/{n" +
      "ame=projects/*/locations/*/catalogs/*/se" +
      "rvingConfigs/*}\332A\004name\022\364\001\n\023UpdateServing" +
      "Config\0222.google.cloud.retail.v2.UpdateSe" +
      "rvingConfigRequest\032%.google.cloud.retail" +
      ".v2.ServingConfig\"\201\001\202\323\344\223\002^2L/v2/{serving" +
      "_config.name=projects/*/locations/*/cata" +
      "logs/*/servingConfigs/*}:\016serving_config" +
      "\332A\032serving_config,update_mask\022\270\001\n\020GetSer" +
      "vingConfig\022/.google.cloud.retail.v2.GetS" +
      "ervingConfigRequest\032%.google.cloud.retai" +
      "l.v2.ServingConfig\"L\202\323\344\223\002?\022=/v2/{name=pr" +
      "ojects/*/locations/*/catalogs/*/servingC" +
      "onfigs/*}\332A\004name\022\313\001\n\022ListServingConfigs\022" +
      "1.google.cloud.retail.v2.ListServingConf" +
      "igsRequest\0322.google.cloud.retail.v2.List" +
      "ServingConfigsResponse\"N\202\323\344\223\002?\022=/v2/{par" +
      "ent=projects/*/locations/*/catalogs/*}/s" +
      "ervingConfigs\332A\006parent\022\316\001\n\nAddControl\022)." +
      "google.cloud.retail.v2.AddControlRequest" +
      "\032%.google.cloud.retail.v2.ServingConfig\"" +
      "n\202\323\344\223\002W\"R/v2/{serving_config=projects/*/" +
      "locations/*/catalogs/*/servingConfigs/*}" +
      ":addControl:\001*\332A\016serving_config\022\327\001\n\rRemo" +
      "veControl\022,.google.cloud.retail.v2.Remov" +
      "eControlRequest\032%.google.cloud.retail.v2" +
      ".ServingConfig\"q\202\323\344\223\002Z\"U/v2/{serving_con" +
      "fig=projects/*/locations/*/catalogs/*/se" +
      "rvingConfigs/*}:removeControl:\001*\332A\016servi" +
      "ng_config\032I\312A\025retail.googleapis.com\322A.ht" +
      "tps://www.googleapis.com/auth/cloud-plat" +
      "formB\316\001\n\032com.google.cloud.retail.v2B\031Ser" +
      "vingConfigServiceProtoP\001Z<google.golang." +
      "org/genproto/googleapis/cloud/retail/v2;" +
      "retail\242\002\006RETAIL\252\002\026Google.Cloud.Retail.V2" +
      "\312\002\026Google\\Cloud\\Retail\\V2\352\002\031Google::Clou" +
      "d::Retail::V2b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.api.AnnotationsProto.getDescriptor(),
          com.google.api.ClientProto.getDescriptor(),
          com.google.api.FieldBehaviorProto.getDescriptor(),
          com.google.api.ResourceProto.getDescriptor(),
          com.google.cloud.retail.v2.ServingConfigProto.getDescriptor(),
          com.google.protobuf.EmptyProto.getDescriptor(),
          com.google.protobuf.FieldMaskProto.getDescriptor(),
        });
    internal_static_google_cloud_retail_v2_CreateServingConfigRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_retail_v2_CreateServingConfigRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2_CreateServingConfigRequest_descriptor,
        new java.lang.String[] { "Parent", "ServingConfig", "ServingConfigId", });
    internal_static_google_cloud_retail_v2_UpdateServingConfigRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_retail_v2_UpdateServingConfigRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2_UpdateServingConfigRequest_descriptor,
        new java.lang.String[] { "ServingConfig", "UpdateMask", });
    internal_static_google_cloud_retail_v2_DeleteServingConfigRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_retail_v2_DeleteServingConfigRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2_DeleteServingConfigRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_google_cloud_retail_v2_GetServingConfigRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_google_cloud_retail_v2_GetServingConfigRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2_GetServingConfigRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_google_cloud_retail_v2_ListServingConfigsRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_google_cloud_retail_v2_ListServingConfigsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2_ListServingConfigsRequest_descriptor,
        new java.lang.String[] { "Parent", "PageSize", "PageToken", });
    internal_static_google_cloud_retail_v2_ListServingConfigsResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_google_cloud_retail_v2_ListServingConfigsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2_ListServingConfigsResponse_descriptor,
        new java.lang.String[] { "ServingConfigs", "NextPageToken", });
    internal_static_google_cloud_retail_v2_AddControlRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_google_cloud_retail_v2_AddControlRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2_AddControlRequest_descriptor,
        new java.lang.String[] { "ServingConfig", "ControlId", });
    internal_static_google_cloud_retail_v2_RemoveControlRequest_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_google_cloud_retail_v2_RemoveControlRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2_RemoveControlRequest_descriptor,
        new java.lang.String[] { "ServingConfig", "ControlId", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.ClientProto.defaultHost);
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.AnnotationsProto.http);
    registry.add(com.google.api.ClientProto.methodSignature);
    registry.add(com.google.api.ClientProto.oauthScopes);
    registry.add(com.google.api.ResourceProto.resourceReference);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.api.ClientProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
    com.google.cloud.retail.v2.ServingConfigProto.getDescriptor();
    com.google.protobuf.EmptyProto.getDescriptor();
    com.google.protobuf.FieldMaskProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
