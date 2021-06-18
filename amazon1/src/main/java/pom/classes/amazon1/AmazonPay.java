package pom.classes.amazon1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPay {
	
	@FindBy(xpath="//span[text()='Mobile Recharge']")
	private WebElement mobile;
	
	@FindBy(xpath="//span[text()='Electricity']")
	private WebElement electricity;
	
	@FindBy(xpath="//span[text()='DTH Recharge']")
	private WebElement dth;
	
	@FindBy(xpath="//span[text()='Mobile Postpaid']")
	private WebElement postpaid;
	
	@FindBy(xpath="//span[text()='Gas Cylinder']")
	private WebElement gasCylinder;
	
	@FindBy(xpath="//span[text()=' Insurance Premium']")
	private WebElement insurance;
	
	@FindBy (xpath="(//span[@class='nav-icon nav-arrow'])[2]")
	private WebElement dropArrow;
	
	@FindBy (xpath="//span[text()='Sign Out']")
	private WebElement signOut;
	
	public AmazonPay(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickMobileRecharge() {
		mobile.click();
		
	}

	
	
	public void clickElectricity()
	{
		electricity.click();
			
	}

	   public void clickDTH() {
			dth.click();
			
		}


	public void clickPostpaid() {
		postpaid.click();
		
	}
	public void clickCylinder() {
		gasCylinder.click();
		
	}

	public void clickInsurance() {
		insurance.click();
	}

	
	
	

	public void clickDownArrow() {
		dropArrow.click();
		
	}

	public void clickSignOut() {
		signOut.click();
		
	}


	

	

}

