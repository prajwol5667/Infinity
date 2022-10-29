package maven.selenium.test;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class trySuper6666 {

	public static void main(String[] args) throws InterruptedException{
		// declaration and instantiation of objects / variables
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\85516\\Downloads\\geckodriver-v0.32.0-win32\\geckodriver.exe"); //define which browswer driver we gonna use and gave path to that driver
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\85516\\Downloads\\geckodriver-v0.32.0-win64\\geckodriver.exe"); //define which browswer driver we gonna use and gave path to that driver
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.get("https://dev.super6666.com/en/");
		
		driver.findElement(By.xpath("//div[@class='Header_main__sSUvP']/button[1]")).click();
		
		//------Incorrect Username-------//
		WebElement username = driver.findElement(By.xpath("//div[@class='ContentTemplate_input-item__Om38a ']/input[@placeholder='Username']"));
		WebElement password = driver.findElement(By.xpath("//div[@class='ContentTemplate_input-item__Om38a ']/input[@placeholder='Password']"));
		WebElement captcha = driver.findElement(By.xpath("//div[@class='ContentTemplate_input-item__Om38a  relative']/input[@placeholder='Verification Code']"));
		WebElement loginBtn = driver.findElement(By.xpath("//div[@class='ContentTemplate_item__wOdKv pt-4']/button[@class='SubmitButton_submit__luKqw ']"));
		WebElement closeBtn = driver.findElement(By.xpath("//div[@class='AlertBoard_footer__bkwb7']/button[1]"));
		
		username.sendKeys("sak0044");
		password.sendKeys("123456");
		captcha.sendKeys("1111");
		loginBtn.click();
		Thread.sleep(2000);
		
		closeBtn.click();
		
		username.clear();
		password.clear();
		captcha.clear();
		//------------------------------//
		
		//------Incorrect Password-------//
		username.sendKeys("sak034");
		password.sendKeys("1234561");
		captcha.sendKeys("1111");
		loginBtn.click();
		Thread.sleep(2000);
		
		closeBtn.click();
		
		username.clear();
		password.clear();
		captcha.clear();
		//------------------------------//
		
		//------Incorrect Captcha-------//
		username.sendKeys("sak034");
		password.sendKeys("123456");
		captcha.sendKeys("1112");
		loginBtn.click();
		Thread.sleep(2000);
			
		closeBtn.click();
				
		username.clear();
		password.clear();
		captcha.clear();
		//------------------------------//

		//------Valid login-------//
		username.sendKeys("sak034");
		password.sendKeys("123456");
		captcha.sendKeys("1111");
		loginBtn.click();
		Thread.sleep(1000);
		//------------------------------//
		
		
		
		
//	System.out.println("Code run success");
		driver.close(); // browser closed 

	}
	

}
