package cubepay.radiumonegoplus;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class FirstTest extends SetUp{

	

    @Test
    public void basicTest() {
        // Your test code here
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
       
        String preferencString = driver.findElement(By.id("android:id/alertTitle")).getText();
        
        Assert.assertEquals(preferencString, "WiFi settings");
        
        driver.findElement(By.id("android:id/edit")).sendKeys("PraveenWIFI");    
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
    }
}
