package generalStore;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MobileSetUp {

	
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
        UiAutomator2Options options = new UiAutomator2Options();
        	options.setDeviceName("Test1");
       // 	options.setChromedriverExecutable("E://Chrome64_51.0.2704.84");
        	options.setCapability("browserName","chrome");

        // Initialize the AndroidDriver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
