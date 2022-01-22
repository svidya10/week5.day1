package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass{

	@Test (invocationCount = 3, priority = 0, threadPoolSize = 2)
	public void createLead() {

		// Click Contact tab
		driver.findElement(By.linkText("Contacts")).click();

		// Create Contact
		driver.findElement(By.linkText("Create Contact")).click();

		// Enter first name
		WebElement firstname = driver.findElement(By.id("firstNameField"));
		firstname.sendKeys("Vidya");

		System.out.println(firstname.getAttribute("value"));

		// Enter last name
		WebElement lastname = driver.findElement(By.id("lastNameField"));
		lastname.sendKeys("Srinivasan");

		System.out.println(lastname.getAttribute("value"));

		// Click Create Contact Button
		driver.findElement(By.className("smallSubmit")).click();

		// Print First Name and Title
		String firstNameText = driver.findElement(By.id("viewContact_firstName_sp")).getText();
		System.out.println("First name string is : " + firstNameText);

		String title = driver.getTitle();
		System.out.println("Browser title is : " + title);

	}
}
