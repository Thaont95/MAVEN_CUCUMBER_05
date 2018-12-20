package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.AbstractPageUi;

public class AbstractPageObject extends AbstractPage{
	WebDriver driver;

	public AbstractPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void inputToDynamicTextbox(String textboxID,String value) {
waitForControlVisible(driver, AbstractPageUi.DYNAMIC_TEXTBOX,textboxID);
sendKeyToElement(driver, AbstractPageUi.DYNAMIC_TEXTBOX,textboxID, value);
	}

	public void inputToDynamicTextArea(String textAreaID,String value) {
		waitForControlVisible(driver, AbstractPageUi.DYNAMIC_TEXTAREA,textAreaID);
		sendKeyToElement(driver, AbstractPageUi.DYNAMIC_TEXTAREA,textAreaID, value);
	}

	public void selectDynamicDropdownList(String dropdownID,String item) {
		waitForControlVisible(driver, AbstractPageUi.DYNAMIC_DROPDOWN,dropdownID);
		selectItemInDropdown(driver, AbstractPageUi.DYNAMIC_DROPDOWN,dropdownID, item);
	}

	public void selectDynamicRadioButton(String radioButtonID) {
		waitForControlVisible(driver, AbstractPageUi.DYNAMIC_RADIO_BUTTON, radioButtonID);
		clickToElement(driver,AbstractPageUi.DYNAMIC_RADIO_BUTTON, radioButtonID);
	}

	public void inputToDynamicButton(String buttonID) {
		waitForControlVisible(driver, AbstractPageUi.DYNAMIC_BUTTON,buttonID);
		clickToElement(driver, AbstractPageUi.DYNAMIC_BUTTON,buttonID);
	}
	
	public boolean isDynamicMessageDisplayed(String message) {
		waitForControlVisible(driver, AbstractPageUi.DYNAMIC_MESSAGE, message);
		return isControlDisplay(driver, AbstractPageUi.DYNAMIC_MESSAGE, message);
	}
	
	public void clickToDynamicPageLink(String pageName) {
		waitForControlVisible(driver,AbstractPageUi.DYNAMIC_PAGE_LINK, pageName);
		clickToElement(driver, AbstractPageUi.DYNAMIC_PAGE_LINK, pageName);
	
	}
	public void sleepWithDynamicTime(String timeMinute){
		long time = Long.parseLong(timeMinute);
		try {
			Thread.sleep(time *1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}
}
