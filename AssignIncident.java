package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.testng.annotations.Test;



public class AssignIncident extends BaseClass2 {
	@Test(enabled = true)
	public void assignIncident() throws InterruptedException {
		
		driver.findElement(By.xpath("(//div[text()='Open'])[1]")).click();
		
		driver.switchTo().frame("gsft_main");
		
		Thread.sleep(3000);
		
		//Search the same incident number in the next search screen as below
		driver.findElement(By.xpath("(//label[text()='Search'])[2]/following-sibling::input")).sendKeys("INC0000002");
		driver.findElement(By.xpath("(//label[text()='Search'])[2]/following-sibling::input")).sendKeys(Keys.ENTER);
		
		// click incident
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='INC0000002']")).click();
		
		// Assign the incident to  Software group

		driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']")).click();
		
		Thread.sleep(3000);

		//// Switch to child frame
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);

		driver.switchTo().window(windows.get(1));
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//label[text()='Search']/following-sibling::input")).sendKeys("Software");

		driver.findElement(By.xpath("//label[text()='Search']/following-sibling::input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		

		driver.findElement(By.xpath("//table[@id='sys_user_group_table']//tr[1]/td[3]/a")).click();

		//// Switch to parent frame
		windowHandles = driver.getWindowHandles();
		windows = new ArrayList<String>(windowHandles);

		driver.switchTo().window(windows.get(0));

		Thread.sleep(3000);
		System.out.println(driver.getTitle());

		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("Description");
		
		driver.findElement(By.xpath("//button[@id='sysverb_update_bottom']")).click();
		
		//Verify the Assignment group and Assigned for the incident
		String assignedGroup = driver.findElement(By.xpath("//table[@id='incident_table']//tr[1]/td[10]")).getText();
		System.out.println(assignedGroup);

		if (assignedGroup.equals("Software") == true) {
			System.out.println("Software present in Assignment Group");
		} else {
			System.out.println("Software not present in Assignment Group");
		}	
	}
}
