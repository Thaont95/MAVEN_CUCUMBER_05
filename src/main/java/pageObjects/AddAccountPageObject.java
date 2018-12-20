package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.LoginPageUi;

public class AddAccountPageObject extends AbstractPage {
	WebDriver driver;
	
	public AddAccountPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	

}
