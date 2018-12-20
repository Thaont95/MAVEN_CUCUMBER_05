package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPage;
import interfaces.LoginPageUi;

public class LoginPageObject  extends AbstractPage {

	WebDriver driver;
	
	public LoginPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public String getLoginPageUrl() {
		return getPageCurrentUrl(driver);		
		
	}
	
	public RegisterPageObject clickHereLinkToOpenRegisterpage() {
		waitForControlVisible(driver, LoginPageUi.HERE_LINK);
		clickToElement(driver, LoginPageUi.HERE_LINK);
		return PageFactoryManager.openRegisterPage(driver);
	}
	
	public void inputToUserIDtexbox(String userID) {
		waitForControlVisible(driver, LoginPageUi.USERNAME);
		sendKeyToElement(driver, LoginPageUi.USERNAME, userID);	
		
	}
	
	public void inputToPasswordtexbox(String password) {
		waitForControlVisible(driver, LoginPageUi.PASSWORD);
		sendKeyToElement(driver,  LoginPageUi.PASSWORD, password);	
		
	}
	
	public HomePageObject clickToLoginButton() {
		waitForControlVisible(driver, LoginPageUi.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUi.LOGIN_BUTTON);
		//return new HomePageObject(driver);
		return PageFactoryManager.openHomePage(driver);
	}

}
