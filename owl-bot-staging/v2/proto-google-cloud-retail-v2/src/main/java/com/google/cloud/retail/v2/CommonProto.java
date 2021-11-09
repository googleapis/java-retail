// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/retail/v2/common.proto

package com.google.cloud.retail.v2;

public final class CommonProto {
  private CommonProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2_Audience_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_Audience_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2_ColorInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_ColorInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2_CustomAttribute_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_CustomAttribute_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2_FulfillmentInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_FulfillmentInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2_Image_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_Image_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2_Interval_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_Interval_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2_PriceInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_PriceInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2_PriceInfo_PriceRange_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_PriceInfo_PriceRange_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2_Rating_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_Rating_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2_UserInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_UserInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_cloud_retail_v2_Promotion_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_retail_v2_Promotion_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n#google/cloud/retail/v2/common.proto\022\026g" +
      "oogle.cloud.retail.v2\032\034google/api/annota" +
      "tions.proto\032\037google/api/field_behavior.p" +
      "roto\032\037google/protobuf/timestamp.proto\"/\n" +
      "\010Audience\022\017\n\007genders\030\001 \003(\t\022\022\n\nage_groups" +
      "\030\002 \003(\t\"3\n\tColorInfo\022\026\n\016color_families\030\001 " +
      "\003(\t\022\016\n\006colors\030\002 \003(\t\"~\n\017CustomAttribute\022\014" +
      "\n\004text\030\001 \003(\t\022\017\n\007numbers\030\002 \003(\001\022\027\n\nsearcha" +
      "ble\030\003 \001(\010H\000\210\001\001\022\026\n\tindexable\030\004 \001(\010H\001\210\001\001B\r" +
      "\n\013_searchableB\014\n\n_indexable\"2\n\017Fulfillme" +
      "ntInfo\022\014\n\004type\030\001 \001(\t\022\021\n\tplace_ids\030\002 \003(\t\"" +
      "8\n\005Image\022\020\n\003uri\030\001 \001(\tB\003\340A\002\022\016\n\006height\030\002 \001" +
      "(\005\022\r\n\005width\030\003 \001(\005\"x\n\010Interval\022\021\n\007minimum" +
      "\030\001 \001(\001H\000\022\033\n\021exclusive_minimum\030\002 \001(\001H\000\022\021\n" +
      "\007maximum\030\003 \001(\001H\001\022\033\n\021exclusive_maximum\030\004 " +
      "\001(\001H\001B\005\n\003minB\005\n\003max\"\211\003\n\tPriceInfo\022\025\n\rcur" +
      "rency_code\030\001 \001(\t\022\r\n\005price\030\002 \001(\002\022\026\n\016origi" +
      "nal_price\030\003 \001(\002\022\014\n\004cost\030\004 \001(\002\0228\n\024price_e" +
      "ffective_time\030\005 \001(\0132\032.google.protobuf.Ti" +
      "mestamp\0225\n\021price_expire_time\030\006 \001(\0132\032.goo" +
      "gle.protobuf.Timestamp\022F\n\013price_range\030\007 " +
      "\001(\0132,.google.cloud.retail.v2.PriceInfo.P" +
      "riceRangeB\003\340A\003\032w\n\nPriceRange\022/\n\005price\030\001 " +
      "\001(\0132 .google.cloud.retail.v2.Interval\0228\n" +
      "\016original_price\030\002 \001(\0132 .google.cloud.ret" +
      "ail.v2.Interval\"P\n\006Rating\022\024\n\014rating_coun" +
      "t\030\001 \001(\005\022\026\n\016average_rating\030\002 \001(\002\022\030\n\020ratin" +
      "g_histogram\030\003 \003(\005\"`\n\010UserInfo\022\017\n\007user_id" +
      "\030\001 \001(\t\022\022\n\nip_address\030\002 \001(\t\022\022\n\nuser_agent" +
      "\030\003 \001(\t\022\033\n\023direct_user_request\030\004 \001(\010\"!\n\tP" +
      "romotion\022\024\n\014promotion_id\030\001 \001(\tB\300\001\n\032com.g" +
      "oogle.cloud.retail.v2B\013CommonProtoP\001Z<go" +
      "ogle.golang.org/genproto/googleapis/clou" +
      "d/retail/v2;retail\242\002\006RETAIL\252\002\026Google.Clo" +
      "ud.Retail.V2\312\002\026Google\\Cloud\\Retail\\V2\352\002\031" +
      "Google::Cloud::Retail::V2b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.api.AnnotationsProto.getDescriptor(),
          com.google.api.FieldBehaviorProto.getDescriptor(),
          com.google.protobuf.TimestampProto.getDescriptor(),
        });
    internal_static_google_cloud_retail_v2_Audience_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_retail_v2_Audience_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2_Audience_descriptor,
        new java.lang.String[] { "Genders", "AgeGroups", });
    internal_static_google_cloud_retail_v2_ColorInfo_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_retail_v2_ColorInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2_ColorInfo_descriptor,
        new java.lang.String[] { "ColorFamilies", "Colors", });
    internal_static_google_cloud_retail_v2_CustomAttribute_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_retail_v2_CustomAttribute_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2_CustomAttribute_descriptor,
        new java.lang.String[] { "Text", "Numbers", "Searchable", "Indexable", "Searchable", "Indexable", });
    internal_static_google_cloud_retail_v2_FulfillmentInfo_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_google_cloud_retail_v2_FulfillmentInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2_FulfillmentInfo_descriptor,
        new java.lang.String[] { "Type", "PlaceIds", });
    internal_static_google_cloud_retail_v2_Image_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_google_cloud_retail_v2_Image_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2_Image_descriptor,
        new java.lang.String[] { "Uri", "Height", "Width", });
    internal_static_google_cloud_retail_v2_Interval_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_google_cloud_retail_v2_Interval_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2_Interval_descriptor,
        new java.lang.String[] { "Minimum", "ExclusiveMinimum", "Maximum", "ExclusiveMaximum", "Min", "Max", });
    internal_static_google_cloud_retail_v2_PriceInfo_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_google_cloud_retail_v2_PriceInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2_PriceInfo_descriptor,
        new java.lang.String[] { "CurrencyCode", "Price", "OriginalPrice", "Cost", "PriceEffectiveTime", "PriceExpireTime", "PriceRange", });
    internal_static_google_cloud_retail_v2_PriceInfo_PriceRange_descriptor =
      internal_static_google_cloud_retail_v2_PriceInfo_descriptor.getNestedTypes().get(0);
    internal_static_google_cloud_retail_v2_PriceInfo_PriceRange_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2_PriceInfo_PriceRange_descriptor,
        new java.lang.String[] { "Price", "OriginalPrice", });
    internal_static_google_cloud_retail_v2_Rating_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_google_cloud_retail_v2_Rating_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2_Rating_descriptor,
        new java.lang.String[] { "RatingCount", "AverageRating", "RatingHistogram", });
    internal_static_google_cloud_retail_v2_UserInfo_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_google_cloud_retail_v2_UserInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2_UserInfo_descriptor,
        new java.lang.String[] { "UserId", "IpAddress", "UserAgent", "DirectUserRequest", });
    internal_static_google_cloud_retail_v2_Promotion_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_google_cloud_retail_v2_Promotion_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_cloud_retail_v2_Promotion_descriptor,
        new java.lang.String[] { "PromotionId", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
