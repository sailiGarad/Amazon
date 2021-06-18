package com.pom.testclass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import browser_setup.pojo;
import pom.classes.amazon1.AmazonPay;
import pom.classes.amazon1.HomePage;
import pom.classes.amazon1.LoginPage;
import utilities.utility1;
import utility.Utility1;

public class AmazonTabs {



	private WebDriver driver;
	private AmazonPay aPay;
	private HomePage home;
	private SoftAssert soft;
	private utility1 util;
	private LoginPage login;
	
	int testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")
	
		public void launchBrowser(String browser) {
			
		
		reporter = new ExtentHtmlReporter("test-output//ExtentReort/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver=pojo.openChromeBrowser();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver=pojo.openFirefoxDriver();
		}
		util = new utility1();
		}
	
//		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\saili\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
//			
//	       driver = new FirefoxDriver();  
//		driver.get("https://www.amazon.in/");
////		driver.manage().window().maximize();
//		 login = new LoginPage(driver);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		System.out.println("Welcome To amazon");
//		home = new HomePage(driver);
//		home.clickSignIn();
//		 soft = new SoftAssert();
    	//util = new Utility1();
		 
	
	@BeforeMethod
	public void beforeMethod() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		Thread.sleep(5000);
		util.sendExcelPath("C:\\Users\\saili\\Documents\\Book12.xlsx");
		String s = util.excelData("Sheet1", 1, 0);
		//System.out.println(s);
		login.enterUserName(s);
		login.clickContinue();
	    String c=util.excelData("Sheet1", 1, 1);
	    System.out.println(c);
		login.enterPassword(c);
		login.clickSignIn();
		System.out.println("Log in successfull");
		home.clickAmazonPay();
		aPay = new AmazonPay(driver);
	}
	
	@Test
	public void verifyMobileRecharge() throws EncryptedDocumentException, IOException
	{
		aPay.clickMobileRecharge();
		String url = driver.getCurrentUrl();
		
	//	MobileRechargePage mPay = new  MobileRechargePage(driver);
		soft.assertEquals(url, "https://www.amazon.in/hfc/mobileRecharge?ref_=apay_deskhome_MobileRecharge");
		
		//soft.assertFalse(mPay.enterMobileNo(), "The Mobile enter field is Displayed");
//		soft.assertTrue(mPay.selectCircle(), "The select Mobile circle field is Displayed");
//		soft.fail();
		soft.assertAll();
	}
	@Test //(enabled =false)
	public void verifyDTH() 
	{
		aPay.clickDTH();
		
		String url = driver.getCurrentUrl();
		
		soft.assertEquals(url, "https://www.amazon.in/hfc/dth?ref_=apay_deskhome_DTH" ); 
		
		soft.assertAll();	
	}
	
	@AfterMethod
	public void signOut(ITestResult result) throws InterruptedException, IOException
	{
	if(ITestResult.FAILURE==result.getStatus())
	{
		util.takeScreenshot(driver);
	}
	Thread.sleep(5000);
	
		//utility.takeScreenshot(driver);
		aPay.clickDownArrow();
		aPay.clickSignOut();
		System.out.println("Thank you");
	}

	@AfterClass
	public void afterClass()
	{
	}
	
//	@AfterTest
//	public void closeBrowser()
//	{
//	driver.close();	
//	}
	
	
	@Test (enabled =false)
	public void verifyPostpaid()
	{
		aPay.clickPostpaid();
		
		String url = driver.getCurrentUrl();
		soft.assertEquals(url, "https://www.amazon.in/hfc/bill/mobile_postpaid?ref_" );
		soft.fail();
	}
	
	@Test(enabled =false)
	public void verifyElectricity()
	{
		aPay.clickElectricity();
		
		String url = driver.getCurrentUrl();
		soft.assertEquals(url, "https://www.amazon.in/hfc/bill/electrice_Electricity" );
	}
	
	@Test  (enabled =false)
	public void verifyInsurance()
	{
		aPay.clickInsurance();
		
		String url = driver.getCurrentUrl();
		soft.assertEquals(url, "https://www.amazon.in/hfc/bill/insome_Insurance");
	}
	
	@Test  (enabled =false)
	public void verifyGasCylinder()
	{
		aPay.clickCylinder();
		
		String url = driver.getCurrentUrl();
		soft.assertEquals(url, "https://www.amazon.in/hfc/bill/lpg?re");
		
	}
	
//	@AfterSuite
//	public void afterSuite()
//	{
//		
//	}
	
	
	

}