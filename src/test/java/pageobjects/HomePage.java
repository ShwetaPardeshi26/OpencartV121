package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseTest {
	
  public HomePage(WebDriver driver) {
		super(driver);
	}

  @FindBy(xpath="//span[normalize-space()='My Account']")
  WebElement lnkMyAccount;
  
  @FindBy(xpath="//a[normalize-space()='Register']")
  WebElement lnkRegister;
  
  @FindBy(xpath="//a[text()='Login']")
  WebElement lnkLogin;
  
  @FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
  WebElement lnkLogout;
  
  public void clickMyAccount() {
	  lnkMyAccount.click();
  }
  
  public void clickRegister() {
	  lnkRegister.click();
  }
  
  public void clickLogin() {
	  lnkLogin.click();
  }
 
  public void clickLogout() {
	  lnkLogout.click();
  }
  
  
}
