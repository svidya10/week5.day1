package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateIncident extends BaseClass2 {
	@Test(enabled = true, invocationCount = 1 )
	public void updateIncident() throws InterruptedException {
	
		//Search the same incident number in the next search screen as below
		driver.findElement(By.xpath(
				"//span[text()='Press Enter from within the input to submit the search.']/following-sibling::input"))
				.sendKeys("INC0000020");
		driver.findElement(By.xpath(
				"//span[text()='Press Enter from within the input to submit the search.']/following-sibling::input"))
				.sendKeys(Keys.ENTER);
		
		// click incident
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='INC0000020']")).click();

		// Update Incident Urgency and State
		WebElement dd1 = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
		Select dropdown1 = new Select(dd1);
		dropdown1.selectByVisibleText("1 - High");

		WebElement dd2 = driver.findElement(By.xpath("//select[@id='incident.state']"));
		Select dropdown2 = new Select(dd2);
		dropdown2.selectByVisibleText("In Progress");

		// Click Update Button
		driver.findElement(By.xpath("//button[@id='sysverb_update_bottom']")).click();

	}
}
