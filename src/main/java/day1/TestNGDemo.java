package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo {
	
	String URL = "https://www.facebook.com";
	String DriverPath = "C:\\Users\\levi\\Downloads\\geckodriver.exe";
	public WebDriver driver;
	
	@BeforeTest
	public void launchBrowswer() {
		//opening the browswer
		System.setProperty("webdriver.gecko.driver", DriverPath);
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(URL);
		
	}
	
	@Test
	public void verifyHomepageTitle() {
		String expectedResult = "Facebook - log in or sign up";
		String actualResult = driver.getTitle();
		try {
			Assert.assertEquals(actualResult, expectedResult);
			System.out.println("Test case passed");
		} catch (Exception e) {
			System.out.println("Test case Failed");
		}
	}
	
	@Test
	public void getURL() {
		String expectedResult = "www.facebok.om";
		String actualResult = driver.getCurrentUrl();
		try {
			Assert.assertEquals(expectedResult, actualResult);
			System.out.println("Test case passed");
		} catch (Exception e) {
			System.out.println("Test case failed");
		}
	}
	
	@AfterTest
	public void closeBrowswer() {
		driver.close();
	}

}
