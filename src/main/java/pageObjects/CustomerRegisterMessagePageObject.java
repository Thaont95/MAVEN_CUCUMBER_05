package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.AbstractPageUi;
import interfaces.CustomerRegisterMessagePageUi;
import interfaces.HomePageUi;
import interfaces.RegisterPageUi;

public class CustomerRegisterMessagePageObject extends AbstractPage{
	
	WebDriver driver;

	public CustomerRegisterMessagePageObject(WebDriver mappingDriver) {
		driver=mappingDriver;
	}

	public String getCustomerID() {
		waitForControlVisible(driver, RegisterPageUi.USER_ID_TEXT);
		return getTextElement(driver, RegisterPageUi.USER_ID_TEXT);
	}
	
//	public boolean isRegistercCustomerSuccessfully() {
//		waitForControlVisible(driver, AbstractPageUi.GET_DYNAMIC_MESSAGE);
//		return isControlDisplay(driver, AbstractPageUi.GET_DYNAMIC_MESSAGE);
//	}
}
