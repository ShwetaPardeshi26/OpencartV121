package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseTest {
	//base test under page objects which includes only constructor
	//this will be invoked by every page object class constructor(reusability)
	public WebDriver driver;
	public BaseTest(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

}
