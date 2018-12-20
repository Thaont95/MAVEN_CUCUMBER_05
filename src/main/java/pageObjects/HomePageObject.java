package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.HomePageUi;

public class HomePageObject extends AbstractPage{
	
	WebDriver driver;

	public HomePageObject(WebDriver mappingDriver) {
		driver=mappingDriver;
	}

	public boolean isHomePagaDisplayed(String massage) {
		waitForControlVisible(driver, HomePageUi.WELCOME_MESSAGE, massage);
		return isControlDisplay(driver, HomePageUi.WELCOME_MESSAGE, massage);
	}

}
