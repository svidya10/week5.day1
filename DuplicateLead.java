package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead extends BaseClass {

	@Test (enabled=false)
	public void duplicateLead() throws InterruptedException {

		// Click Leads Link
		driver.findElement(By.linkText("Leads")).click();

		// Click Find Leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Click on Email
		driver.findElement(By.xpath("//ul[@class='x-tab-strip x-tab-strip-top']/li[3]")).click();

		// Enter Email
		driver.findElement(By.name("emailAddress")).sendKeys(("abc@gmail.com"));

		// Click find leads button
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();

		Thread.sleep(1000);

		// Capture name of First Resulting lead
		String leadName = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a"))
				.getText();
		System.out.println("Lead name is : " + leadName);

		// Click First Resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();

		// Click Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();

		// Verify the title as 'Duplicate Lead'
		if (driver.getTitle().contains("Duplicate Lead"))
			System.out.println("Duplicate Lead Page Title confirmed");
		else
			System.out.println("Duplicate Lead Page Title not confirmed");

		// Click Create Lead
		driver.findElement(By.className("smallSubmit")).click();

		// Confirm the duplicated lead name is same as captured name
		if (driver.findElement(By.id("viewLead_firstName_sp")).getText().equalsIgnoreCase(leadName))
			System.out.println("Duplicated Lead Name = Captured Name");
		else
			System.out.println("Duplicated Lead Name != Captured Name");

	}

}
