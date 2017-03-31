package Selenium.Simple2;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.*;

/**
 * Unit test for simple App.
 */
// public class AppTest extends TestCase {
public class InitTest {

	protected static WebDriver driver;
	WebElement element;

	@Before
	public void setup() {
		
		System.out.println("--------- wewnatrz setup AT Before Class");

		System.setProperty("webdriver.gecko.driver", "C:\\work\\geckodriver.exe");

		final FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("xpinstall.signatures.required", false);
			
		//driver = new FirefoxDriver(firefoxProfile);
		// driver = new ChromeDriver();

		
		//driver.manage().window().maximize();
		// driver.get("https://www.google.pl");
		// driver.get("http://www.store.demoqa.com");
	}
	
	public static WebDriver getDriver(){
		
		System.setProperty("webdriver.gecko.driver", "C:\\work\\geckodriver.exe");

		final FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("xpinstall.signatures.required", false);
		driver = new FirefoxDriver(firefoxProfile);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		return driver;
	}

	/*
	 * @Test public void test(){ driver.get("https://www.google.pl"); }
	 */

	
	
	

	@AfterClass
	public static void cleanUp() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}

}
