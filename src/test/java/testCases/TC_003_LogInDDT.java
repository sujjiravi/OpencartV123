package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import testBase.TestBase;
import utilites.XLUtility;

public class TC_003_LogInDDT extends TestBase
{
	@Test(dataProvider="LogInData", groups= {"ddt"})
	public void test_loginDDT(String email,String password, String exp) throws IOException
	{   
		try
		{
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LogInPage lip=new LogInPage(driver);
		lip.setEmail(email);
		lip.setPassword(password);
		lip.clickLogin();
		String confmsg=lip.getConfirmationMsg();
		
		if(exp.equals("valid"))
		{
			if(confmsg.equals("My Account"))
			{
				MyAccountPage map=new MyAccountPage(driver);
				map.ClickLogOut();
			    Assert.assertTrue(true);
			}
		
		    else
		   {
			    Assert.assertTrue(false);
		   }
		}
		if(exp.equals("invalid"))
		{
			if(confmsg.equals("My Account"))
			{ 
				MyAccountPage map=new MyAccountPage(driver);
				map.ClickLogOut();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		
	}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	
	
	@DataProvider(name="LogInData")
   public String[][]getData() throws IOException, InterruptedException
   {
		String path=".\\testData\\OpenCart.loginDDT.xlsx";
		
		XLUtility xlutil=new XLUtility(path);
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
				Thread.sleep(3000);
			}
		}
		return logindata;
   }
} 
