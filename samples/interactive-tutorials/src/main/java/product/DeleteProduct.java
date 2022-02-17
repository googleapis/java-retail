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

// [START retail_delete_product]

/*
 * Delete product from a catalog using Retail API
 */

package product;

import static setup.SetupCleanup.createProduct;
import static setup.SetupCleanup.deleteProduct;

import java.io.IOException;
import java.util.UUID;

public class DeleteProduct {

  private static final String GENERATED_PRODUCT_ID = UUID.randomUUID().toString();

  public static void main(String[] args) throws IOException {
    deleteProduct(createProduct(GENERATED_PRODUCT_ID).getName());
  }
}

// [END retail_delete_product]
