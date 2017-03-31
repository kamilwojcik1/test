package Selenium.Simple2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends InitTest{
	
	protected static WebDriver driver;
	WebElement element;
	
	@Before
	public void init(){
		System.out.println("--------- wewnatrz init");
	}
	
	@Test
	public void valid_UserCredential() {
		
		driver = InitTest.getDriver();
		System.out.println("Starting test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.get("http://www.store.demoqa.com");
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		driver.findElement(By.id("log")).sendKeys("lasicmk2");
		driver.findElement(By.id("pwd")).sendKeys("qwe123");
		driver.findElement(By.id("login")).click();
		try {
			element = driver.findElement(By.xpath(".//*[@id='account_logout']/a"));
		} catch (Exception e) {
		}
		Assert.assertNotNull(element);
		driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
		
		
		System.out.println("Ending test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		
	}
	
	
	
	//@Ignore
		@Test
		public void inValid_UserCredential() {
			System.out.println("Starting test " + new Object() {
			}.getClass().getEnclosingMethod().getName());
			driver.get("http://www.store.demoqa.com");
			driver.findElement(By.xpath(".//*[@id='account']/a")).click();
			driver.findElement(By.id("log")).sendKeys("lasicmk2");
			driver.findElement(By.id("pwd")).sendKeys("qwe123111");
			driver.findElement(By.id("login")).click();
			try {
				element = driver.findElement(By.xpath(".//*[@id='account_logout']/a"));
			} catch (Exception e) {
			}
			Assert.assertNotNull(element);
			
			
			System.out.println("Ending test " + new Object() {
			}.getClass().getEnclosingMethod().getName());
		}

}
