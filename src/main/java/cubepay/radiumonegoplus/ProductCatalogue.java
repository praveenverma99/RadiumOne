package cubepay.radiumonegoplus;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import actions.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends AndroidActions{

	AndroidDriver driver;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	public List<WebElement> addToCart;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement cartButtonElement;
	
	public ProductCatalogue(AndroidDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	public void addItemToCartByIndex(int index)
	{
		addToCart.get(index).click();		
	}
	
	public CartPage clickToCart() throws InterruptedException
	{
		cartButtonElement.click();
		Thread.sleep(3000);
		return new CartPage(driver);
	}
}



