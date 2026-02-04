package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbase.BaseClass;

public class TC002_Verify_LoginTest extends BaseClass{
   
	@Test(groups= {"Sanity","Master"})
	public void LoginTest() {
		
		logger.info("****************TC002 started*******************");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.inputEmailAddress(p.getProperty("email"));
		lp.inputPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage mp=new MyAccountPage(driver);
		boolean msg=mp.isAccountMessageDisplayed();
		
		Assert.assertTrue(msg);
		}catch(Exception e) {
			Assert.fail();
		}
		System.out.println("bye");
		logger.info("****************TC002 finished*******************");
	}
}
