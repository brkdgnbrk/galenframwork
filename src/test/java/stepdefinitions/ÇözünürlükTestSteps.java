package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

import static com.galenframework.api.Galen.checkLayout;

public class ÇözünürlükTestSteps extends BaseStep {
    private WebDriver driver;

    @When("Sayfa yüklenir")
    public void sayfa_yüklenir() {
        driver.get("https://posbeta.narpos.com.tr/#/login");
    }

    private void checkPageLayout(String specPath, Dimension dimension) {
        checkLayout(driver, specPath, dimension, Arrays.asList("mobile", "tablet", "desktop"));
    }

    private void checkLayout(WebDriver driver, String specPath, Dimension dimension, List<String> devices) {
        if (driver != null && dimension != null && devices != null) {
            driver.manage().window().setSize(dimension);
            try {
                checkLayout(driver, specPath, dimension, List.of(devices.toArray(new String[0])));
                System.out.println("Layout test passed for device: " + devices.get(0));
            } catch (Exception e) {
                System.out.println("Layout test failed for device: " + devices.get(0));
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Driver, dimension or devices list cannot be null");
        }
    }

    private Dimension parseDimension(String size) {
        String[] parts = size.split("x");
        return new Dimension(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }




    @Then("Sayfanın responsivliği kontrol edilir {}")
    public void sayfanın_responsivliği_kontrol_edilir(String deviceSize) {
        Dimension dimension = parseDimension(deviceSize);
        checkPageLayout("src/test/resources/testdata/login.gspec", dimension);
        driver.quit();
    }

    @Given("Kullanıcı {} cihazını kullanarak web sitesini ziyaret eder")
    public void kullanıcı_cihazını_kullanarak_web_sitesini_ziyaret_eder(String deviceName) {
        driver = new ChromeDriver();
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
        driver.manage().window().setSize(dimension);


    }
}
