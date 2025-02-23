package cubepay.radiumonegoplus;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class SetUp {
	public AppiumDriverLocalService service;
    public AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        // Set up and start the Appium server
        service = new AppiumServiceBuilder()
            .withAppiumJS(new File("C:/Users/prave/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"))
            .withIPAddress("127.0.0.1")
            .usingPort(4723)
            .build();
        service.start();

        // Set up the UiAutomator2Options
        UiAutomator2Options options = new UiAutomator2Options()
            .setDeviceName("Test1")
            .setApp("C:\\Users\\prave\\eclipse-workspace\\radiumonegoplus\\src\\test\\java\\resouces\\ApiDemos-debug.apk");

        // Initialize the AndroidDriver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void longPressAction(WebElement element)
    {
    	((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement)element).getId(), 
						"Duration", 2000));
    }
    
    public void ScrollAction()
    {
    	boolean canScrollMore;
		do {
		 canScrollMore = (boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					    "left", 100, "top", 100, "width", 200, "height", 200,
					    "direction", "down",
					    "percent", 3.0
					    ));
		}
		while(canScrollMore);
		
    }
    
    public void SwipeAction(WebElement element, String direction)
    {
    	((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
    		    "elementId", ((RemoteWebElement)element).getId(),
    		    "direction", direction,
    		    "percent", 0.75
    		));
    	
    }
    
    @AfterMethod
    public void tearDown() {
        // Quit the driver and stop the Appium service
        if (driver != null) {
            driver.quit();
        }
        if (service != null && service.isRunning()) {
            service.stop();
        }
    }
}
