package cubepay.radiumonegoplus;

import org.openqa.selenium.support.PageFactory;

import actions.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions{
	AndroidDriver driver;

	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	}

