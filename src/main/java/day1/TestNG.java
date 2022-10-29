package maven.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNG {
	String URL = "https://dev.super6666.com/en/";
	String driverPath = "C:\\\\Users\\\\85516\\\\Downloads\\\\geckodriver-v0.32.0-win64\\\\geckodriver.exe";
	public WebDriver driver;
	
	
	
	@BeforeTest
	public void launchBroswer() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	@Test(priority = 1)
	public void loginHomepage() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='Header_main__sSUvP']/button[1]")).click();
		
		String expectedResult = "Facebooksss - log in or sign up";
		String actualResult = driver.getTitle();
		
		WebElement username = driver.findElement(By.xpath("//div[@class='ContentTemplate_input-item__Om38a ']/input[@placeholder='Username']"));
		WebElement password = driver.findElement(By.xpath("//div[@class='ContentTemplate_input-item__Om38a ']/input[@placeholder='Password']"));
		WebElement captcha = driver.findElement(By.xpath("//div[@class='ContentTemplate_input-item__Om38a  relative']/input[@placeholder='Verification Code']"));
		WebElement loginBtn = driver.findElement(By.xpath("//div[@class='ContentTemplate_item__wOdKv pt-4']/button[@class='SubmitButton_submit__luKqw ']"));
		
		username.sendKeys("sak0303232");
		password.sendKeys("123456");
		captcha.sendKeys("1111");
		loginBtn.click();
		
		
		Thread.sleep(5000);
		
		String result = driver.findElement(By.xpath("//div[@class='AlertBoard_bg__mCPnq AlertBoard_show__5duyM shadow-2xl']/div/div[@class='AlertBoard_content__A6ycP']")).getText();
		
		
		try { 
			Assert.assertEquals(result, "Wrong username/password, please re-enter.");
		 System.out.println("Test Success"); 
		 } catch (Exception e) {
		 System.out.println("Test Fail1"); 
		 }
		 
	}
	
	
	
	@AfterTest
	public void closeBrowser() {
	driver.close();
	}
}
