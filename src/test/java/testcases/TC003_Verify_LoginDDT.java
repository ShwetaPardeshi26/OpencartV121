package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC003_Verify_LoginDDT extends BaseClass{
	@Test(dataProvider="logInData", dataProviderClass=DataProviders.class,groups="Datadriven")
	public void LoginTest(String email,String psw,String exp) {
		
		logger.info("****************TC003_LoginDDT started*******************");
		try {
			System.out.println(email+" "+psw+" "+exp);
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.inputEmailAddress(email);
		lp.inputPassword(psw);
		lp.clickLogin();
		
		MyAccountPage mp=new MyAccountPage(driver);
		boolean msg=mp.isAccountMessageDisplayed();
		
		if (exp.equalsIgnoreCase("valid")) {

		    if (msg==true) {
		        Assert.assertTrue(true);
		        hp.clickLogout();
		    } else {
		        Assert.fail("Login failed for valid credentials");
		    }

		} else if (exp.equalsIgnoreCase("invalid")) {

		    if (msg==true) {
		        hp.clickLogout();
		        Assert.fail("Login succeeded with invalid credentials");
		    } else {
		        Assert.assertTrue(true);
		    }
		}
		
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("****************TC003_LoginDDT finished*******************");
}
}
