package maven.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class openBrowser {

	public static void main(String[] args) {
		// declaration and instantiation of objects / variables
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\85516\\Downloads\\geckodriver-v0.32.0-win32\\geckodriver.exe"); //define which browswer driver we gonna use and gave path to that driver
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\85516\\Downloads\\geckodriver-v0.32.0-win64\\geckodriver.exe"); //define which browswer driver we gonna use and gave path to that driver
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("wow@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.name("login")).click();
		

//		String title = driver.getTitle();
//		System.out.println(title);
//		driver.close(); // browser closed 

	}

}
