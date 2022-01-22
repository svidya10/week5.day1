package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact extends BaseClass{

	@Test (priority = 3)
	public void mergeContact() throws InterruptedException {

		// Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();

		// Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		// Click on Widget of From Contact
		driver.findElement(By.xpath("(//span[text()='From Contact']/following::a)[1]")).click();

		Thread.sleep(3000);

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);

		driver.switchTo().window(windows.get(1));
		System.out.println(driver.getTitle());

		// Click on First Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]")).click();

		driver.switchTo().window(windows.get(0));

		// Click on Widget of To Contact
		driver.findElement(By.xpath("(//span[text()='To Contact']/following::a)[1]")).click();

		Thread.sleep(3000);

		windowHandles = driver.getWindowHandles();
		windows = new ArrayList<String>(windowHandles);

		driver.switchTo().window(windows.get(1));

		// Click on Second Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();

		driver.switchTo().window(windows.get(0));

		// Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		// Accept the Alert
		driver.switchTo().alert().accept();

		// Verify the title of the page
		System.out.println(driver.getTitle());
	}
}
