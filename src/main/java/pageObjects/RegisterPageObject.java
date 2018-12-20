package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.RegisterPageUi;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;

	public RegisterPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public void inputEmailAddress(String email) {
		waitForControlVisible(driver, RegisterPageUi.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUi.EMAIL_TEXTBOX,email);
	}
	
	public void clickSubmitButton() {
		waitForControlVisible(driver, RegisterPageUi.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUi.SUBMIT_BUTTON);
	}
	
	public String getUserIDText() {
		waitForControlVisible(driver, RegisterPageUi.USER_ID_TEXT);
		return getTextElement(driver, RegisterPageUi.USER_ID_TEXT);
	}
	
	public String getPasswordText() {
		waitForControlVisible(driver, RegisterPageUi.PASSWORD_TEXT);
		return getTextElement(driver, RegisterPageUi.PASSWORD_TEXT);
	}
	
	public LoginPageObject openLoginPageUrl(String Url) {
		 openAnyURL(driver, Url);
		 return PageFactoryManager.openLoginPage(driver);
	}

}
