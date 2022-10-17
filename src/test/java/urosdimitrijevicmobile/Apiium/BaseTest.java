package urosdimitrijevicmobile.Apiium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
	MutableCapabilitiesConfig config = new MutableCapabilitiesConfig();
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
			//path to the appium server. With this lines of code appium server starts automatically each time before test is executed
		 service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\uros.dimitrijevic\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
					//line bellow tells us on which IP adress we start the server and on which port. The adress and port bellow is default, just copy it
				 .withIPAddress("127.0.0.1").usingPort(4723).build();
		 service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
			//name of the device on which we are performing tests(This name you gave previously when creating emulator in Android studio)
		options.setDeviceName(config.DeviceName);
			//path to the app that we are testing. For this, first create new package ("resources"). Then right click on the app.apk on your local machine and paste it to resources package.
			//next, right click on the app in resources package and copy path. You can paste the path directly as function parameter, or you can set path in config class and call it from that clas (as showed bellow)
		options.setApp(config.AppPath);
		options.setChromedriverExecutable(config.ChromeDriver);
		
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
				"duration",2000));
	}
	boolean canScrollMore;
	public void ScrollToEndAction() {
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				"left", 100, "top", 100, "width", 200, "height", 200,
				"direction", "down",
				"percent", 3.0
					));
			} while(canScrollMore);
	}
	
	public void swipeAction(WebElement ele,String direction) {
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)ele).getId(),
				
				"direction", direction,
				"percent", 1
				));
	}
	public Double getFormatedAmount(String amount)
	{

		Double price = Double.parseDouble(amount.substring(1));
		return price;

	}


	@AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}


}
