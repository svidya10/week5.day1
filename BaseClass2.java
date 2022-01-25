package week5.day1;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass2 {
	ChromeDriver driver;
	
	//@Parameters ({"url", "userName" , "password"})
  
	@BeforeMethod()
  public void preCondition() throws InterruptedException {
		// Setup
				WebDriverManager.chromedriver().setup();

				// Step1: Load ServiceNow application URL
				driver = new ChromeDriver();
				driver.get("https://dev66648.service-now.com/login.do?");

				// Maximize
				driver.manage().window().maximize();

				// Step2: Enter username (Check for frame before entering the username)
				driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");

				// Step3: Enter password
				driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Janu1012$");

				// Step4: Click Login
				driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();

				// Step5: Search “incident “ Filter Navigator
				driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");

				Thread.sleep(5000);

				driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);

				Thread.sleep(5000);
				
				// Step6: Click “All”

				driver.switchTo().frame("gsft_main");
				driver.findElement(By.xpath("//span[@id='incident_breadcrumb']/a[1]")).click();
				
				Thread.sleep(3000);
  }

  @AfterMethod
  public void postCondition() {
		// Close browser
		//driver.close();

  }

}
