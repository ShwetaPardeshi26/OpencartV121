package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.AccountRegisterationPage;
import pageobjects.HomePage;
import testbase.BaseClass;

public class TC001_AccountRegisterationPage extends BaseClass {
	@Test(groups= {"Regression","Master"})
	public void Verify_Account_Registeration() throws InterruptedException {
		try {
		HomePage hp=new HomePage(driver);
		logger.info("**************Strating Testcase******************");
		hp.clickMyAccount();
		logger.info("***clicking on my account*******");
		hp.clickRegister();
		logger.info("***clicking on Register*******");
		AccountRegisterationPage reg=new AccountRegisterationPage(driver);
		logger.info("******providing customer details*****************");
		reg.setFirstName(randomString());
		reg.setLastName(randomString());
		reg.setEmail(randomString()+"@gmail.com");
		reg.setTelephone(randomNumber());
		String password=randomAlphaNumeric();
		reg.setPassword(password);
		reg.setConfimPassword(password);
		reg.clickPrivacy();
		Thread.sleep(5000);
		reg.clickContinue();
		String actualMessage=reg.getConfirfmationMessage();
		if(actualMessage.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);		
			}else {
			    logger.info("test failed...");
			    logger.debug("debug logs...");
			    Assert.assertTrue(false);
			}
		Assert.assertEquals(actualMessage, "Your Account Has Been Created!");
		System.out.println("bye");
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("****finished testcase********");
		
	}

	
	

}
