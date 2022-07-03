package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.TestBase;

public class TC_001_AccountRegistration extends TestBase
{
	
	@Test(priority=1, groups= {"sanity" ,"master"})
	public void test_accountRegistrartion() throws InterruptedException
	{    logger.info("Starting TC_001_AccountRegistration ");
		try 
		{
			logger.info("Launching Application");
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		HomePage hp=new HomePage(driver);
		logger.info("clicking and registering for MyAccount");
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("provided FirstName");
		regpage.setFirstName("Krishna");
		logger.info("provided LastName");
		regpage.setLastName("Madhava");
		logger.info("provided Email");
		regpage.setEmail(randomstring()+"@gmail.com");
		//regpage.setEmail("xyz");
		
		logger.info("provided telephone number");
		regpage.setTelephone("656565655");
		logger.info("provided password and confirm password");
		regpage.setPassword("Govinda");
		regpage.setCnfrmPassword("Govinda");
		
		
		logger.info("clicked privacy policy");
		regpage.setPrivacyPolicy();
		
		logger.info("clicked   on continue");
		regpage.clickContinue();
		logger.info("Validation Started");
       String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Registation test passed");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen( driver,"test_accountRegistrartion");
			logger.error("Registration test Failed");
			Assert.assertTrue(false);
		}
	}
	catch(Exception e)
	{
		logger.fatal("Registration Failed");
	}
  }
}
	
	

