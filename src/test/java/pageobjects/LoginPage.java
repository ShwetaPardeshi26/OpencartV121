package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseTest{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="input-email")
	WebElement txtEmailAddress;

	@FindBy(id="input-password")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btnLogin;
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement confirmAccount;
	
	public void inputEmailAddress(String emailAddr) {
		txtEmailAddress.sendKeys(emailAddr);
	}
	
	public void inputPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	
		
	}
	
	
