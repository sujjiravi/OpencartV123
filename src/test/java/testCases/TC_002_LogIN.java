package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;

import pageObjects.LogInPage;
import testBase.TestBase;

public class TC_002_LogIN extends TestBase
{
	@Test(groups= {"regression","master"})
	public void test_LogIn()
	{   try {
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LogInPage lip=new LogInPage(driver);
		lip.setEmail(rb.getString("email"));
		lip.setPassword(rb.getString("password"));
		lip.clickLogin();
		String confmsg=lip.getConfirmationMsg();
		if(confmsg.equals("My Account"))
		{
			Assert.assertTrue(true);
		}
		else
		{   captureScreen( driver,"test_LogIn");
			Assert.assertTrue(false);
		}
	}
	catch(Exception e)
	{
		Assert.fail();
	}
		
	}

}
