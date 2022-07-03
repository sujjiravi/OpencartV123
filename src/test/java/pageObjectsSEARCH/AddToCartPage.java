package pageObjectsSEARCH;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
WebDriver driver;

public AddToCartPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
//locators
@FindBy(xpath="//button[@id='button-cart']")WebElement AddBtn;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement confmessage;

//actions
public void ClickButton()
{
	AddBtn.click();
}
public String getConfirmationMessage() 
{ 
	try
	{
		
	return(confmessage.getText());
	}
	catch(Exception e)
	{
		return(e.getMessage());
	}
}

}
