package generalStore;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class SecondTest extends SetUp{

	@Test
	public void checkOutTest() throws InterruptedException 
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Praveen");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/text1")).click();

		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text=\'Austria\']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);

		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		WebDriverWait chckoutpage = new WebDriverWait(driver,Duration.ofSeconds(10));
		chckoutpage.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

		List <WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrices.size();

		double total =  0;
		for(int i=0; i<count; i++)
		{
			String productPrice= productPrices.get(i).getText();
			Double actualPrice	= Double.parseDouble(productPrice.substring(1));
			total = total + actualPrice;
		}

		String cartSum =	driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	
		
		Double cartSumtDouble = Double.parseDouble(cartSum.substring(1));
		Assert.assertEquals(total, cartSumtDouble);

		driver.findElement(By.className("android.widget.CheckBox")).click();
		Thread.sleep(2000);

		WebElement termsAndConditions = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));

		longPressAction(termsAndConditions);

		String cartAlert =	driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
		Assert.assertEquals(cartAlert, "Terms Of Conditions");

		driver.findElement(By.id("android:id/button1")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(10000);
		
		java.util.Set<String> contextStrings = driver.getContextHandles();
		
		for(String contextName: contextStrings)
		{
			System.out.println(contextName);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		driver.findElement(By.name("q")).sendKeys("Rahul shetty academy");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		
		
	}
}
