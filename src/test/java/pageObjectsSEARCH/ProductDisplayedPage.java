package pageObjectsSEARCH;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDisplayedPage
{
	WebDriver driver;
	
public ProductDisplayedPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
//locators
@FindBy(xpath="//img[@title='MacBook']")WebElement Product;
//actions
public void clickProduct()
{
	Product.click();
}
	

}
