package day1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementDetection {

	public static void main(String[] args) throws InterruptedException {
		
		// declaration and initialitation of objects/ variable
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\levi\\Downloads\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		
		//Get the Webelement corresponding to the email or phone number textfield
		WebElement username=driver.findElement(By.xpath("//input[@name='email']"));
		
		//Get the webelement corresponding to the password textfield
		WebElement password=driver.findElement(By.xpath("//input[@name='pass']"));
		
		username.sendKeys("xyz@gmail.com");
		password.sendKeys("Prajwol2");
		System.out.println("Text field set");
		Thread.sleep(1000);
		//Deleting values in the textbox
		
		username.clear();
		password.clear();
		System.out.println("Text field cleared");
		Thread.sleep(1000);
		//Find the login button
		WebElement button=driver.findElement(By.xpath("//button[@name='login']"));
		
		//using click method to submit form
		username.sendKeys("xyz111@gmail.com");
		password.sendKeys("Prajwol2");
		button.click();
		System.out.println("login done with click");
		Thread.sleep(1000);
		driver.close();
		
	}

}
