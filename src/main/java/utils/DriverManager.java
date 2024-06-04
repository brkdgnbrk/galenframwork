package utils;

import config.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

	private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

	private DriverManager() {
		throw new UnsupportedOperationException("Cannot instantiate utility class");
	}

	public synchronized static WebDriver getDriver() {
		if (!ConfigurationManager.getProperty("browser").isEmpty()) {
			return getDriver(ConfigurationManager.getProperty("browser"));
		}
		return getDriver(System.getProperty("browser", "chrome"));
	}

	public synchronized static WebDriver getDriver(String browserType) {
		if (DRIVER_THREAD_LOCAL.get() == null) {
			WebDriver driver;
			driver = switch (browserType.toLowerCase()) {
				case "firefox" -> new FirefoxDriver();
				case "edge" -> new EdgeDriver();
				default -> new ChromeDriver();
			};

			driver.manage().window().maximize();
			driver.get(ConfigurationManager.getProperty("baseURL"));
			DRIVER_THREAD_LOCAL.set(driver);
		}
		return DRIVER_THREAD_LOCAL.get();
	}

	public static void closeDriver() {
		if (DRIVER_THREAD_LOCAL.get() != null) {
			DRIVER_THREAD_LOCAL.get().quit();
			DRIVER_THREAD_LOCAL.remove();
		}
	}

}