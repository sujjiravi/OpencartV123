package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//locators
	@FindBy(xpath="//span[normalize-space()='My Account']")WebElement lnkMyAccount;
	@FindBy(xpath="//a[normalize-space()='Register']")WebElement lnkRegister;
	@FindBy(xpath="//a[normalize-space()='Login']")WebElement lnkLogin;
	//actions
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	public void clickRegister()
	{
		lnkRegister.click();
	}
	public void clickLogin()
	{
		lnkLogin.click();
	}
}
