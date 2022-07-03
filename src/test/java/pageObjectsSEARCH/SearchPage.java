package pageObjectsSEARCH;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage
{ 
	WebDriver driver;

public SearchPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
//locators
@FindBy(xpath="//input[@placeholder='Search']")WebElement SearchBar ;
@FindBy(xpath="//i[@class='fa fa-search']")WebElement SearchButton;

//actions
public void findItem(String Item)
{
	SearchBar.sendKeys(Item);
}
 
public void clickSearch()
{
	SearchButton.click();
}


}
