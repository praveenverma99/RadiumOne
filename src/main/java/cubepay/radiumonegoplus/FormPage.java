package cubepay.radiumonegoplus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import actions.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions{


	AndroidDriver driver;

	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameElement;


	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	private WebElement FemaleElement;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
	private WebElement maleElement;

	@AndroidFindBy(id = "android:id/text1")
	private WebElement countrySelection;

	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement shopButton;

	public void buttonClick()
	{
		shopButton.click();
	}
	
			
	public void selectCountry(String countryName)
	{
		countrySelection.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();

	}
	public void setNameField(String name)
	{
		nameElement.sendKeys(name);
		driver.hideKeyboard();
	}

	public void selectSex(String sex)
	{	
		if(sex.equalsIgnoreCase("Female"))
		{
			FemaleElement.click();
		}
		else {
			maleElement.click();
		}
	}

	public  ProductCatalogue  clickToCart()
	{
		shopButton.click();
		return	new ProductCatalogue(driver);
	}
	
}
