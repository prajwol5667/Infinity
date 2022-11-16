package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNG{
	
	@FindBy(xpath="//div[@class='Header_main__sSUvP']/button[1]")
	private WebElement loginForm;
	
	@FindBy(xpath="//div[@class='ContentTemplate_input-item__Om38a ']/input[@placeholder='Username']")
	private WebElement username;
	
	@FindBy(xpath="//div[@class='ContentTemplate_input-item__Om38a ']/input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy(xpath="//div[@class='ContentTemplate_input-item__Om38a  relative']/input[@placeholder='Verification Code']")
	private WebElement captcha;
	
	@FindBy(xpath="//button[@class='SubmitButton_submit__luKqw ']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[3][@class='AlertBoard_footer__bkwb7']/button")
	private WebElement closeForm;
	
	@FindBy(xpath="//div[@class='Modal_modal-content__8qOX9']/button[1]")
	private WebElement crossForm;
	
	
	
	public TestNG() throws Exception{
		
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		PageFactory.initElements(driver, this);
		
	}
	
	String URL = "https://dev.super6666.com/en/";
	String driverPath = "C:\\\\Users\\\\85516\\\\Downloads\\\\geckodriver-v0.32.0-win64\\\\geckodriver.exe";
	public WebDriver driver;
	
	
	@BeforeTest
	public void launchBroswer() {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	@Test(priority = 1)
	public void Invalidusername() throws InterruptedException{
		loginForm.click();
		username.sendKeys("sak1ab71");
		password.sendKeys("123456");
		captcha.sendKeys("1111");
		loginBtn.click();

		Thread.sleep(1000);
		String result = driver.findElement(By.xpath("//div[2][@class='AlertBoard_content__A6ycP']")).getText();
		try { 
			Assert.assertEquals(result, "Wrong username/password, please re-enter.");
			System.out.println("Test Success");
		} catch (Exception e) {
			System.out.println("Test Fail");
		}
		closeForm.click();
		crossForm.click();
	}
	@Test(priority = 2)
	public void InvalidPass() throws InterruptedException {
		loginForm.click();
		username.sendKeys("sakks1");
		password.sendKeys("32131311");
		captcha.sendKeys("1111");
		loginBtn.click();
		
		Thread.sleep(1000);
		String result = driver.findElement(By.xpath("//div[2][@class='AlertBoard_content__A6ycP']")).getText();
		try {
			Assert.assertEquals(result, "Wrong username/password, please re-enter.");
			System.out.println("Test Success");
		} catch (Exception e) {
			System.out.println("Test Fail");
		}
		closeForm.click();
		crossForm.click();

	}
	@Test(priority = 3)
	public void ThreetimePass() throws InterruptedException {
		loginForm.click();
		username.sendKeys("sak014");
		password.sendKeys("32131311");
		captcha.sendKeys("1111");
		loginBtn.click();
		
		Thread.sleep(1000);
		String result = driver.findElement(By.xpath("//div[2][@class='AlertBoard_content__A6ycP']")).getText();
		
		try {
			Assert.assertEquals(result, "Wrong password for more than 3 times, please contact Customer Service");
			System.out.println("Test Success");
		} catch (Exception e) {
			System.out.println("Test Fail");
		}
		closeForm.click();
		crossForm.click();

	}
	
	@Test(priority = 4)
	public void InvalidCaptcha() throws InterruptedException {
		loginForm.click();
		username.sendKeys("sak014");
		password.sendKeys("123456");
		captcha.sendKeys("1112");
		loginBtn.click();
		
		Thread.sleep(1000);
		String result = driver.findElement(By.xpath("//div[2][@class='AlertBoard_content__A6ycP']")).getText();
		try {
			Assert.assertEquals(result, "Wrong verification code, please fill in again");
			System.out.println("Test Success");
		} catch (Exception e) {
			System.out.println("Test Fail"); 
		}
		closeForm.click();
		crossForm.click();

	}
	@Test(priority = 5)
	public void specialusername() throws InterruptedException {
		loginForm.click();
		username.sendKeys("sak032@");
		password.sendKeys("123456@");
		captcha.sendKeys("1112");
		loginBtn.click();
		
		Thread.sleep(1000);
		String result = driver.findElement(By.xpath("//div[2][@class='ContentTemplate_item__wOdKv']/div[@class='ContentTemplate_error-message__bMRT3']")).getText();
		try {
			Assert.assertEquals(result, "Please enter 6-12 characters (a-z 0-9). special characters are not allowed");
			System.out.println("Test Success"); 
		} catch (Exception e) {
			System.out.println("Test Fail"); 
		}
		crossForm.click();
	}
	@Test(priority = 6)
	public void ValidLogin() throws InterruptedException {
		loginForm.click();
		username.sendKeys("prajwol10");
		password.sendKeys("prajwol2");
		captcha.sendKeys("1111");
		loginBtn.click();
		
		Thread.sleep(1000);
		String result = driver.findElement(By.xpath("//div[@class='AlertBoard_wrapper__GmyUN']/div[2][@class='AlertBoard_content__A6ycP']")).getText();
		try {
			Assert.assertEquals(result, "login success");
			System.out.println("Test Success"); 
		} catch (Exception e) {
			System.out.println("Test Fail"); 
		}
		closeForm.click();
	}
	
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
