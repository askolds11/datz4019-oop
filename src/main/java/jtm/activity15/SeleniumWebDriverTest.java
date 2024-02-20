package jtm.activity15;

import static jtm.TestUtils.timeout;
import static jtm.TestUtils.webPort;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import jtm.testsuite.JTMTest;

/*-
 * This test is open sourced intentionally. You can use it as a template for
 * automated Web GUI test in your teamwork project.
 * This is Selenium WebDriver test and you can generate code for it with Selenium IDE.
 * For more info look at:
 *   — https://www.seleniumhq.org/docs/02_selenium_ide.jsp
 *   — https://www.seleniumhq.org/docs/03_webdriver.jsp
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//If you use this class as a template, simply remove 'extends JTMTest' part and replace references to
//timeout variables to your own values
public class SeleniumWebDriverTest extends JTMTest {
	private static WebDriver driver;
	private static String baseUrl;

	@BeforeClass
	public static void setUp() {
		// Run web server if not started already
		try {
			URL status = new URL("http://localhost:" + webPort + "/");
			status.getContent();
		} catch (Exception e) {
			try {
				JettyApplication.main(new String[] { "" });
				sleep(); // wait little bit
				logger.info("Web application started");
			} catch (Exception e1) {
				Assert.fail(e1.toString());
			}
		}
		// If you didn't update the Path system variable to add the full
		// directory path to the executable as above mentioned then do this
		// directly through code:
		// Firefox driver:
		System.setProperty("webdriver.gecko.driver", "lib/geckodriver");
		// If necessary, set path to firefox executable e.g.:
		// System.setProperty("webdriver.firefox.bin", "/usr/bin/firefox");
		// Chromium driver:
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
		// Use either Firefox or Chromium driver:
		driver = new FirefoxDriver();
		// driver = new ChromeDriver();
		// URL to the tested web application
		baseUrl = "http://localhost:" + webPort + "/";
		// Default timeout
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test
	public void test01Insert() {
		driver.get(baseUrl + "/");
		driver.findElement(By.linkText("Insert teacher")).click();
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys("Name");
		driver.findElement(By.name("surname")).clear();
		driver.findElement(By.name("surname")).sendKeys("Surname");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		sleep();
		driver.findElement(By.linkText("Back")).click();
	}

	@Test
	public void test02Search() {
		driver.get(baseUrl + "/");
		driver.findElement(By.linkText("Find teacher")).click();
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys("Name");
		driver.findElement(By.name("surname")).clear();
		driver.findElement(By.name("surname")).sendKeys("Surname");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		sleep();
		driver.findElement(By.linkText("Back")).click();
	}

	@Test
	public void test03Delete() {
		driver.get(baseUrl + "/");
		driver.findElement(By.linkText("Delete teacher")).click();
		driver.findElement(By.name("id")).clear();
		driver.findElement(By.name("id")).sendKeys("12");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		sleep();
		driver.findElement(By.linkText("Back")).click();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		if (driver != null)
			driver.quit();
	}

	private static void sleep() {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
