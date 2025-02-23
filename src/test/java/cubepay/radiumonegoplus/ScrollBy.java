package cubepay.radiumonegoplus;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollBy extends SetUp {

	
	@Test
	public void scrollTest() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		Thread.sleep(3000);
		
		ScrollAction();
		
	}
}
