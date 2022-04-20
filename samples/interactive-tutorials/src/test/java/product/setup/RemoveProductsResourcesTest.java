package product.setup;

import static com.google.common.truth.Truth.assertThat;
import static product.setup.RemoveProductsResources.deleteAllProducts;
import static setup.SetupCleanup.deleteBucket;
import static setup.SetupCleanup.deleteDataset;

import com.google.cloud.ServiceOptions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RemoveProductsResourcesTest {

  private ByteArrayOutputStream bout;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() throws IOException, InterruptedException, ExecutionException {
    String projectId = ServiceOptions.getDefaultProjectId();
    String bucketName = "products_tests_bucket";
    String branchName =
        String.format(
            "projects/%s/locations/global/catalogs/default_catalog/branches/0", projectId);

    bout = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);

    deleteBucket(bucketName);
    deleteAllProducts(branchName);
    deleteDataset(projectId, "products");
  }

  @Test
  public void testRemoveProductsResources() {
    String outputResult = bout.toString();

    assertThat(outputResult).contains("Deleting products in process, please wait...");
    assertThat(outputResult).contains("products were deleted from");
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(originalPrintStream);
  }
}
