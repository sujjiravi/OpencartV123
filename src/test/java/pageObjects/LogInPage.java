package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage 
	{
WebDriver driver;
public LogInPage(WebDriver driver)
{
  this.driver=driver;
  PageFactory.initElements(driver,this);
}
//locators
@FindBy(xpath="//input[@id='input-email']")WebElement txtEmail;
@FindBy(xpath="//input[@id='input-password']")WebElement txtPassword;
@FindBy(xpath="//input[@value='Login']")WebElement btnLogin;
@FindBy(xpath="//h2[normalize-space()='My Account']")WebElement MsgConfirmation;
//actions
public void setEmail(String email)
{
	txtEmail.sendKeys(email);
}
public void setPassword(String password)
{
	txtPassword.sendKeys(password);
}
public void clickLogin()
{
	btnLogin.click();
}
public String getConfirmationMsg()
{
	try
	{
	return (MsgConfirmation.getText());
	}
	catch(Exception e)
	{
		return(e.getMessage());
	}
}

}
