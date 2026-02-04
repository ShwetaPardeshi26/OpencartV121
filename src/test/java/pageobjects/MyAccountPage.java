package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BaseTest {
	public MyAccountPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement confirmAccount;
	
	public boolean isAccountMessageDisplayed() {
		try {
			return (confirmAccount.isDisplayed());
		}catch(Exception e) {
			return false;
		}
}
}
