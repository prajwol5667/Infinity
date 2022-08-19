package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class assertion {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\levi\\Downloads\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		String title = driver.getTitle(); // getting the title of the facebook 
		try {
			Assert.assertEquals("Facebook - log in or sign up", title);  // User of assertion 
			System.out.println("Test is passed");
		} catch (Exception e) {
			System.out.println("Test is failed");
		}
		
		driver.close();
		
		
	}

}
