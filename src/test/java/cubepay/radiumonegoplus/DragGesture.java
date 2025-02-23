package cubepay.radiumonegoplus;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class DragGesture extends SetUp {

	@Test
	public void dragGesture() throws InterruptedException 
	{

		driver.findElement(AppiumBy.accessibilityId("Views")).click();	
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();;
		WebElement circleElement = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
	
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) circleElement).getId(),
		    "endX", 630,
		    "endY", 540
		));
		
		Thread.sleep(5000);

		String dragElement = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(dragElement, "Dropped!");
;	}
}
