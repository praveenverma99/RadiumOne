package cubepay.radiumonegoplus;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellanousAction extends SetUp {

	@Test
	public void action() throws InterruptedException 
	{
		Activity activity = new Activity(null, "  mCurrentFocus=Window{5dcbfb4 u0 com.android.launcher3/com.android.launcher3.Launcher}");
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();;
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
	//	DeviceRotation landscape = new DeviceRotation(0,0,90);
	//	driver.rotate(landscape);
	//	Thread.sleep(2000);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		driver.setClipboardText("Praveen Wifi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

		
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

		
		
	}
	
}
