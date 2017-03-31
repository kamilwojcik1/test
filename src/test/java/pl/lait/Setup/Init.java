package pl.lait.Setup;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Init {

	// static FirefoxDriver driver;
	static WebDriver driver;
	String folder = "allScreens";

	public static WebDriver getDriver() {

		if (driver == null) {
			System.out.println("obiekt DRIVERa == NULL - wykonuję new FirefoxDriver()");
			try {
				URL baseUrl = new URL("http://newtours.demoaut.com");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

			URL hubUrl = null;

			try {
				hubUrl = new URL("http://localhost:4444/wd/hub/");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			
			driver = new RemoteWebDriver(hubUrl, cap); 
		//	driver = new FirefoxDriver();
			driver.get("http://newtours.demoaut.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			return driver;
		} else {
			System.out.println("obiekt DRIVERa != null - wykonuję new FirefoxDriver()"); // "!="
																							// operator
																							// "różni
																							// się",
																							// "!"
																							// operator
																							// negacji
			return driver;
		}

	}

	public static void close() {
		driver.close();
		driver.quit();
		driver = null;
	}

	@After
	public void cleanUp() {

		close();
	}

	public void printScr(String folder) {
		/*
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Long milis = timestamp.getTime();
		File scrFile = driver.getScreenshotAs(OutputType.FILE);
		System.out.println("Generating screenshot " + milis);
		try {
			FileUtils.copyFile(scrFile, new File("target\\" + folder + "\\screenshot-" + milis + ".png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		
		*/
		}
	}

