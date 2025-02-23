package generalStore;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends MobileSetUp{

	
	@Test
	public void ChromeBrowserTest() throws InterruptedException
	{
		driver.get("https://google.com");
		Thread.sleep(10000);

		driver.findElement(By.name("q")).sendKeys("Rahul shetty academy");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
	}
}
