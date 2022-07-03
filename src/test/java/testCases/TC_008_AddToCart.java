package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectsSEARCH.AddToCartPage;
import pageObjectsSEARCH.ProductDisplayedPage;
import pageObjectsSEARCH.SearchPage;
import testBase.TestBase;

public class TC_008_AddToCart extends TestBase
{
@Test(groups= {"master"})
public void test_AddToCart() throws InterruptedException
{  try
{
	driver.get("http://localhost/opencart/upload/");
	driver.manage().window().maximize();
	SearchPage sp=new SearchPage(driver);
	
	sp.findItem("mac");
	sp.clickSearch();
	
	ProductDisplayedPage pdp=new ProductDisplayedPage(driver);
	pdp.clickProduct();
	
	AddToCartPage acp=new AddToCartPage(driver);
	acp.ClickButton();
	Thread.sleep(3000);
	String message=acp.getConfirmationMessage();
	
	if (message.equals(" 1 item(s) - $602.00"))
	{
		Assert.assertTrue(true);
	}
	else
	{   captureScreen( driver,"test_AddToCart");
		Assert.assertTrue(false);
	}
	//Assert.assertEquals((message.equals("Success: You have added iPhone to your shopping cart!")),true);
}
catch(Exception e)
{
	Assert.fail();
}
	

}
}
