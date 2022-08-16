package day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class openBrowswer {

	public static void main(String[] args) {
		// declaration and instantiation of objects / variables
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\levi\\Downloads\\geckodriver.exe"); //define which browswer driver we gonna use and gave path to that driver
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		String title = driver.getTitle();
		System.out.println(title);
		driver.close(); // browswer closed 
	}

}
