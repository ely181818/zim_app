package com.zim.zim;


import java.awt.Point;
import java.time.Duration;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

//import com.mobile.MobileTest.MobileDriver;
import com.zim.zim.*;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.*;
public class performingActivities {
	
	
	
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.widget.EditText")
	WebElement firstName;
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]")
	WebElement customerSerivce;
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[2]")
	WebElement Drop;
	
	//android.view.View[@index='1']
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.widget.TabWidget/android.view.View[4]/android.view.View")
	WebElement MoreXpath;
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.Button[4]")
	WebElement ContactUs;
	@FindBy(className ="android.widget.CheckBox")
	List<WebElement> CheckBox;	
	@FindBy(className ="android.view.View")
	List<WebElement> view;	
	@FindBy(xpath="//android.widget.TextView[@content-desc='Preference']")
	WebElement Preference;	
	
	@FindBy(xpath="//android.widget.TextView[@content-desc='1. Preferences from XML']")
	WebElement PreferencesFromXML;
	
	@FindBy(className ="android.widget.Button")	
	List<WebElement> Button;
	
	@FindBy(id ="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	WebElement permissionButton;
	
	@FindBy(className ="android.widget.TextView")
	WebElement shipLoading;
	
	String songname="Labels.More";
	@FindBy(id="tab-button-more")
	WebElement More;
	
	@FindBy(className ="android.widget.TabWidget")
	WebElement TabWidget;
	
	@FindBy(xpath ="//android.view.View[@index='1']")
	WebElement drop_index;

	
	public performingActivities() {
		PageFactory.initElements(MobileDriver.getDriver(), this);
	}
	
	
	public void permissionButton() {
		DriverFactory.WaitUntilElementClickable(permissionButton,10);	
		 this.permissionButton.click();
	}
	
	public void clickOnSaveButton() {
		
		DriverFactory.WaitUntilNotvizble(shipLoading,100000);
		
		List<WebElement> elments =getItemsButtons();
		DriverFactory.WaitUntilElementClickable(elments.get(2),10);	
		elments.get(2).click();
		
		}
	
	
       public void clickOnMore() {
    	DriverFactory.WaitUntilElementClickable(MoreXpath,10);	
    	this.MoreXpath.click();
		
    	   
    	   
    	
		}
       
       public void clickOnContact() {
    	  
    	this.ContactUs.click();
		
    	   
       }
       
       public void clickDrop() {
    	  try {
			
		
			 WebElement parentElement1 = Drop;
			 Drop.click();
			
			 WebElement childElement1 = 
					 parentElement1.findElement(By
					.xpath("//android.view.View[@index='1']"));
			childElement1.click();
    	   } catch (Exception e) {
   			// TODO: handle exception
   		}
       }
	public void clickcustomerSerivce() {
		 DriverFactory.WaitUntilElementClickable(customerSerivce,10);
	this.customerSerivce.click();
	}
    public void firstName() {
    	this.firstName.sendKeys("roy");
    }
	public List<WebElement> getItemsButtons() {
		return this.Button;
		
	}

	
	public List<WebElement> getItemsCheckBox() {
		return this.CheckBox;
		
	}
	
	public List<WebElement> getItemsviews() {
		return this.view;
		
	}
	

	public void clickOnPreference() {
		
	  this.Preference.click();
	}


	


	public void CheckboxPreference() throws InterruptedException {
		List<WebElement> elments =getItemsCheckBox();
		elments.get(1).click();
		
	}
	
	
	public void ChildCheckboxPreference() throws InterruptedException {
		
		List<WebElement> elments =getItemsCheckBox();
		DriverFactory.WaitUntilElementClickable(elments.get(2),10);	
		elments.get(2).click();
		
	}

}