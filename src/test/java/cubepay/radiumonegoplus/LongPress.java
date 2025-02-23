package cubepay.radiumonegoplus;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumBy;

public class LongPress extends SetUp{


	@Test
	public void longPressGesture() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement keyElement =	driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		longPressAction(keyElement);
		
		String viewsElement	= driver.findElement(By.id("android:id/title")).getText();
		
		Assert.assertEquals(viewsElement, "Sample menu");
		
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());

		
	}
	
}
