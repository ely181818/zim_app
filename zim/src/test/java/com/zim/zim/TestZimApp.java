package com.zim.zim;

import java.io.File;
import java.net.MalformedURLException;

import javax.mail.Message;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.zim.zim.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class TestZimApp {
	ExtentReports extent;
	ExtentTest logger;
	
	
	performingActivities perform;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
	DriverFactory.Android_LaunchApp();
	perform=new performingActivities();
	}
	
	

	@BeforeSuite
	public void startReport(){
	
	extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);

	extent
	.addSystemInfo("Host Name", "Automation Report")
	.addSystemInfo("Environment", "QA")
	.addSystemInfo("User Name", "roy");
	
	extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	
	
	@Test//(priority=1)
	public void Test1() throws InterruptedException  {
		  logger = extent.startTest("click on permissionButton Button");
	perform.permissionButton();
	Assert.assertTrue(true);
	  logger.log(LogStatus.PASS, "Test Case Passed permissionButton Button");
	}
	
	@Test (dependsOnMethods={"Test1"})
	public void Test2() {
		  logger = extent.startTest("click on SaveButton Button ");
	perform.clickOnSaveButton(); 
	Assert.assertTrue(true);
	logger.log(LogStatus.PASS, "Test Case Passed SaveButton Button");
	}

	@Test (dependsOnMethods={"Test2"})
	public void Test3() {
		  logger = extent.startTest("click on More Button");
	perform.clickOnMore();
	Assert.assertTrue(true);
	logger.log(LogStatus.PASS, "Test Case Passed More Button");
	}

	@Test (dependsOnMethods={"Test3"})
	public void Test4() {
		  logger = extent.startTest("click on Contact Button ");
	perform.clickOnContact();
	Assert.assertTrue(true);
	logger.log(LogStatus.PASS, "Test Case Passed Contact Button");
	}
	@Test (dependsOnMethods={"Test4"})
	public void Test5() {
		  logger = extent.startTest("click on Contact Drop List");
	 perform.clickDrop();
	 Assert.assertTrue(true);
	 logger.log(LogStatus.PASS, "Test Case Passed Drop List Button");
	}
	@Test (dependsOnMethods={"Test5"})
	public void Test6() {
		  logger = extent.startTest("click on customerSerivce Button ");
	perform.clickcustomerSerivce();
	Assert.assertTrue(true);
	 logger.log(LogStatus.PASS, "Test Case Passed customerSerivce Button");
	}
	@Test (dependsOnMethods={"Test6"})
	public void Test7() {
		  logger = extent.startTest("update firstName ");
    perform.firstName();
    Assert.assertTrue(true);
    logger.log(LogStatus.PASS, "Test Case Passed update firstName");
	}
	
	
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		
		extent.endTest(logger);
	}
	@AfterTest
	public void endReport(){
		
                extent.flush();
                
                extent.close();
                DriverFactory.CloseApp();
    }
	
	
}
