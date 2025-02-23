package generalStore;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.modules.thread.thread;
import org.testng.Assert;
import org.testng.annotations.Test;

import cubepay.radiumonegoplus.FormPage;
import cubepay.radiumonegoplus.ProductCatalogue;
import io.appium.java_client.AppiumBy;

public class FirstTest extends SetUp{

	 
	@Test
	 public void fillForm() throws InterruptedException
	 {
		formPage.setNameField("Praveen");
		formPage.selectSex("male");
		Thread.sleep(3000);
		formPage.selectCountry("Argentina");
		Thread.sleep(2000);

		formPage.buttonClick();
		Thread.sleep(3000);
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.clickToCart();
		Thread.sleep(3000);

	//	String AlertHome = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
	//	Assert.assertEquals(AlertHome, "Please enter your name");
				
	//	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
	
//		int numberofitems = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
//		
//		for(int i =0; i<numberofitems; i++)
//		{
//			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();	
//			
//			if(productName.equalsIgnoreCase("Jordan 6 Rings"))
//			{
//				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
//			}
//		}
//		Thread.sleep(2000);
		
//		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		WebDriverWait chckoutpage = new WebDriverWait(driver,Duration.ofSeconds(5));
		chckoutpage.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		String checkOutCart = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(checkOutCart, "Jordan 6 Rings");
	 
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_back")).click();
		
	 
	 }
	
}
