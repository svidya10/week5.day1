package week5.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.testng.annotations.Test;

public class DeleteIncident extends BaseClass2 {
	// Setup
	@Test(enabled = true)
	public void deleteIncident() throws InterruptedException {

		// Search for the existing incident and navigate into the incident
		driver.findElement(By.xpath(
				"//span[text()='Press Enter from within the input to submit the search.']/following-sibling::input"))
				.sendKeys("INC0000006");
		driver.findElement(By.xpath(
				"//span[text()='Press Enter from within the input to submit the search.']/following-sibling::input"))
				.sendKeys(Keys.ENTER);
		
		// click incident
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='INC0000006']")).click();

		// Delete the incident

		driver.findElement(By.xpath("//button[@id='sysverb_delete_bottom']")).click();

		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();

		// Search for the existing incident and navigate into the incident
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(
				"//span[text()='Press Enter from within the input to submit the search.']/following-sibling::input"))
				.sendKeys("INC0000006");
		driver.findElement(By.xpath(
				"//span[text()='Press Enter from within the input to submit the search.']/following-sibling::input"))
				.sendKeys(Keys.ENTER);

		if(driver.findElement(By.xpath("//td[text()='No records to display']")).getText().contains("No records to display"))
			System.out.println("Delete successful");
		else
			System.out.println("Delete Unsuccessful");
			

	}

}
