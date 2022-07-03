package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage 
{
	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
		//locators
		@FindBy(name="firstname")WebElement inputFirstname ;
		@FindBy(xpath="//input[@id='input-lastname']")WebElement inputLastname;
		@FindBy(xpath="//input[@id='input-email']")WebElement inputEmail ;
		@FindBy(xpath="//input[@id='input-telephone']")WebElement inputPhone;
		@FindBy(xpath="//input[@id='input-password']")WebElement inputPassword;
		@FindBy(xpath="//input[@id='input-confirm']")WebElement inputCfrmPassword;
		
		@FindBy(name="agree")WebElement clickagree ;
		@FindBy(xpath="//input[@value='Continue']")WebElement clickSubmit;
		@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
		 WebElement msgConfirmation; 
		//actions
		public void setFirstName(String fname)
		{
			inputFirstname.sendKeys(fname);
		}
		
		public void setLastName(String lname)
		{
			inputLastname.sendKeys(lname);
		}
		
		public void setEmail(String email)
		{
			inputEmail.sendKeys(email);
		}
		public void setTelephone(String phone)
		{
			inputPhone.sendKeys(phone);
		}
		public void setPassword(String pwd)
		{
			inputPassword.sendKeys(pwd);
		}
		public void setCnfrmPassword(String cnfrmPwd)
		{
			inputCfrmPassword.sendKeys(cnfrmPwd);
		}
		public void setPrivacyPolicy()
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
		    js.executeScript("arguments[0].click()",clickagree );
			//clickagree.click();
		}
		
		public void clickContinue()
		{
			
			
			clickSubmit.click();
		}
		public String getConfirmationMsg()
		{
			try
			{
			return (msgConfirmation.getText());
			}
			catch(Exception e)
			{
				return(e.getMessage());
			}
		}
		
		
}


