package pageobjects;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegisterationPage extends BaseTest {
  public AccountRegisterationPage(WebDriver driver) {
	  super(driver);
  }
  
  @FindBy(id="input-firstname")
  WebElement txtFirstName;
  
  @FindBy(id="input-lastname")
  WebElement txtLastName;
  
  @FindBy(id="input-email")
  WebElement txtEmail;
  
  @FindBy(id="input-telephone")
  WebElement txtTelephone;
  
  @FindBy(id="input-password")
  WebElement txtPassword;
  
  @FindBy(id="input-confirm")
  WebElement txtConfirmPassword;
  
  @FindBy(xpath="//input[@type='checkbox']")
  WebElement chkPolicy;
  
  @FindBy(xpath="//input[@type='submit']")
  WebElement btnContinue;
  
  @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
  WebElement msgConfirmation;
  
  public void setFirstName(String fname) {
	  txtFirstName.sendKeys(fname);
  }
  
  public void setLastName(String lname) {
	  txtLastName.sendKeys(lname);
  }
  
  public void setEmail(String email) {
	  txtEmail.sendKeys(email);
  }
  
  public void setTelephone(String phone) {
	  txtTelephone.sendKeys(phone);
  }
  
  public void setPassword(String password) {
	  txtPassword.sendKeys(password);
  }
  
  public void setConfimPassword(String cPassword) {
	  txtConfirmPassword.sendKeys(cPassword);
  }
  
  public void clickPrivacy() {
	  chkPolicy.click();
  }
  
  public void clickContinue() {
	  //sol 1
	  btnContinue.click();
	  
//	  sol 2
//	  btnContinue.submit();
//	  
//	  sol 3
//	  Actions act=new Actions(driver);
//	  act.moveToElement(btnContinue).click().perform();
//	  
//	  sol 4
//	  JavascriptExecutor js=(JavascriptExecutor) driver;
//	  js.executeScript("arguments[0].click();",btnContinue );
	  
//	  sol 5
//	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
//	  wait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	  
  }
  
  public String getConfirfmationMessage() {
	  try {
		  return (msgConfirmation.getText());
	  }catch(Exception e) {
		 return  (e.getMessage());
	  }
  }
}
