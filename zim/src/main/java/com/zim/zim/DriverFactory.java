package com.zim.zim;




import java.awt.List;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import com.zim.zim.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class DriverFactory 
{
	public static AppiumDriver<WebElement> driver;
	public static DesiredCapabilities cap;
	
	public static void Android_LaunchApp() throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();

		// Platform version
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "My New Phone");
		cap.setCapability("UdiD", "R58M481MXVF");
		cap.setCapability("appPackage", "com.zim");
		cap.setCapability("appActivity", "com.zim.MainActivity");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		Assert.assertNotNull(driver);
		MobileDriver.setWebDriver(driver);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static WebElement WaitUntilElementClickable( WebElement elementLocator, int timeout)
    {
       
		    try {
		    	WebDriverWait wait = new WebDriverWait(driver, timeout);
		    	wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
			} catch (Exception e) {
				
            System.out.println("Element with locator: '" + elementLocator + "' was not found in current context ");
          
			}
			return null;
    }
	public static WebElement WaitUntilNotvizble( WebElement elementLocator, int timeout)
    {
       
		    try {
		    	WebDriverWait wait = new WebDriverWait(driver, timeout);
		    	
		    	wait.until(ExpectedConditions.invisibilityOfAllElements(elementLocator));
			} catch (Exception e) {
				
            System.out.println("Element with locator: '" + elementLocator + "' was not found in current context ");
          
			}
			return null;
    }
	public static void CloseApp() {
		driver.quit();
	}
	

	

	
}
