/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package product.setup;

import static setup.SetupCleanup.createBucket;
import static setup.SetupCleanup.uploadObject;

import com.google.cloud.ServiceOptions;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.time.Instant;

public class ProductsCreateGcsBucket {

  public static void main(String[] args) throws IOException {
    String projectId = ServiceOptions.getDefaultProjectId();

    Timestamp currentDate =
        Timestamp.newBuilder()
            .setSeconds(Instant.now().getEpochSecond())
            .setNanos(Instant.now().getNano())
            .build();

    String productsBucketName =
        String.format("%s_products_%s", projectId, currentDate.getSeconds());

    createGcsBucketAndUploadData(productsBucketName);
  }

  public static void createGcsBucketAndUploadData(String bucketName) throws IOException {
    createBucket(bucketName);
    System.out.printf("Products gcs bucket %s was created.%n", bucketName);

    uploadObject(bucketName, "products.json", "src/main/resources/products.json");
    System.out.printf("File 'products.json' was uploaded into bucket '%s'.%n", bucketName);

    uploadObject(
        bucketName, "products_some_invalid.json", "src/main/resources/products_some_invalid.json");
    System.out.printf(
        "File 'products_some_invalid.json' was uploaded into bucket '%s'.%n", bucketName);
  }
}
