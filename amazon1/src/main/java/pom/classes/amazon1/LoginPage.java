package pom.classes.amazon1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy (xpath="//input[@id='ap_email']")
	private WebElement userId;
	
	@FindBy(xpath="//input[@id='continue']")
	 private WebElement continue1;
	
		
	@FindBy (xpath="(//input[@type='password'])[1]")
	private WebElement password;
	
	@FindBy (xpath="//input[@id='signInSubmit']")
	private WebElement login;
	
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String u)
	{
		userId.sendKeys(u);
		
	}
	public void clickContinue()
	{
		continue1.click();
	}
	
	public void enterPassword(String p)
	{
		password.sendKeys(p);
	}
	
	public void clickLogin()
	{
		login.click();
	}

	public void clickSignIn() {
		login.click();
		
	}

	

}
