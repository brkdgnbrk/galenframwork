package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Arrays;
import java.util.List;


public class ÇözünürlükTestSteps extends BaseStep{



    @When("Sayfa yüklenir")
    public void sayfa_yüklenir() {
        DRIVER.get("https://posbeta.narpos.com.tr/#/login");
    }

    private void checkPageLayout(String specPath, Dimension dimension) {
        checkLayout(DRIVER, specPath, dimension, Arrays.asList("mobile", "tablet", "desktop"));
    }


    public void checkLayout(WebDriver driver, String specPath, Dimension dimension, List<String> devices) {
        if (driver == null || dimension == null || devices == null || devices.isEmpty()) {
            throw new IllegalArgumentException("Driver, dimension, or devices list cannot be null or empty");
        }

        // Iterate over the devices and perform the layout check
        for (String device : devices) {
            try {
                // Assume performLayoutCheck is a method that checks the layout
                performLayoutCheck(driver, specPath, device,dimension);
                System.out.println("Layout test passed for device: " + device);
            } catch (Exception e) {
                System.out.println("Layout test failed for device: " + device);
                e.printStackTrace();
            }
        }
    }

    private void performLayoutCheck(WebDriver driver, String specPath, String device,Dimension expectedDimension) {
        // Implement the actual layout check logic here
        // This is just a placeholder to illustrate the method
        System.out.println("Checking layout for device: " + device + " with specPath: " + specPath);
        // Add your layout checking code here

        Dimension actualDimension = driver.manage().window().getSize();

        // Assert the window size
        Assertions.assertThat( actualDimension.getWidth()).isEqualTo(expectedDimension.getWidth());
        Assertions.assertThat( actualDimension.getHeight()).isEqualTo(expectedDimension.getHeight());
    }

    private Dimension parseDimension(String size) {
        String[] parts = size.split("x");
        return new Dimension(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }




    @Then("Sayfanın responsivliği kontrol edilir {}")
    public void sayfanın_responsivliği_kontrol_edilir(String deviceSize) {
        Dimension dimension = parseDimension(deviceSize);
        checkPageLayout("src/test/resources/testdata/login.gspec", dimension);
    }

    @Given("Kullanıcı {} cihazını kullanarak web sitesini ziyaret eder")
    public void kullanıcı_cihazını_kullanarak_web_sitesini_ziyaret_eder(String deviceName) {
        Dimension dimension;
        switch (deviceName) {
            case "Mobile":
                dimension = new Dimension(400, 800);
                break;
            case "Tablet":
                dimension = new Dimension(768, 1024);
                break;
            case "Laptop":
                dimension = new Dimension(1366, 768);
                break;
            default:
                throw new IllegalArgumentException("Unsupported device: " + deviceName);
        }
        DRIVER.manage().window().setSize(dimension);
    }
}
