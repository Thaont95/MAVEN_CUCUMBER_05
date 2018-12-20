package stepsDifincations;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.AbstractTest;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import interfaces.AbstractPageUi;
import pageObjects.AbstractPageObject;
import pageObjects.PageFactoryManager;

public class AbstractStepDifinications{
	WebDriver driver;
private AbstractPageObject abstractPage;
private AbstractTest abstractTest;
	
	public AbstractStepDifinications() {
		driver = Hooks.openBrowser();
		abstractPage = PageFactoryManager.openAbstractPage(driver);
		abstractTest = new AbstractTest();

	}
	@When("^I input to \"([^\"]*)\" textbox with data \"([^\"]*)\"$")
    public void iInputToTextboxWithDynamicData(String textboxID, String value) {
		abstractPage.inputToDynamicTextbox(textboxID, value);

    }
	
	@When("^I input to \"([^\"]*)\" textbox with random data \"([^\"]*)\"$")
    public void iInputToTextboxWithDynamicRandomData(String textboxID, String value) {
		value= value + "" + abstractTest.randomNumber();
		abstractPage.inputToDynamicTextbox(textboxID, value);
    }
	
	@When("^I input to \"([^\"]*)\" textbox with \"([^\"]*)\" data \"([^\"]*)\"$")
    public void iInputToTextboxWithRandomData(String textboxID, String statusRandom, String value) {
		if (statusRandom.equals("1")) {
			value= value + "" + abstractTest.randomNumber();
		}else if (statusRandom.equals("2")) {
			value= value + "" + abstractTest.randomEmail();
		}
		
		abstractPage.inputToDynamicTextbox(textboxID, value);
    }

	@When("^I input to \"([^\"]*)\" textarea with data \"([^\"]*)\"$")
    public void iInputToTextAreaWithDynamicData(String textAreaID, String value) {
		abstractPage.inputToDynamicTextArea(textAreaID, value);

    }
	@When("^I select item in \"([^\"]*)\" dropdown with data \"([^\"]*)\"$")
    public void iSelectItemInDropdownWithDynamicData(String dropdownID, String item) {
		abstractPage.selectDynamicDropdownList(dropdownID, item);
    }
	
	@When("^I select \"([^\"]*)\" radio button$")
    public void iSelectItemRadioButtonWithDynamicData(String radioButtonID) {
		abstractPage.selectDynamicRadioButton(radioButtonID);
    }

	@When("^Verify message \"([^\"]*)\" displayed success$")
    public void verifyDynamicMessageDisplayed(String message) {
		abstractTest.verifyTrue(abstractPage.isDynamicMessageDisplayed(message));
    }
	
	@When("^I open \"([^\"]*)\" page$")
    public void iOpenDynamicPage(String pageName) {
		abstractPage.clickToDynamicPageLink(pageName);
    }
	@When("^I click to \"([^\"]*)\" button$")
    public void iClickToDynamicButton(String buttonID) {
		abstractPage.inputToDynamicButton(buttonID);
    }
	
	@When("^I sleep \"([^\"]*)\" times$")
    public void iSleepDynamicTimes(String timeMinute) {
		abstractPage.sleepWithDynamicTime(timeMinute);
    }
	
	@When("^I input (first|second) Account ID$")
	public void iInputToAccountID(String account) {
		if (account.equalsIgnoreCase("first")) {
			//transactionPage.inputAccountNo(shareData.firstAccountID);
		}
		if (account.equalsIgnoreCase("second")) {
			//transactionPage.inputAccountNo(shareData.secoundAccountID);
		}
	}
	@When("^I (?:transfer|withdraw) to \"(.*?)\" USD$")
	public void iTransferToSomethingUSD(String amount) {
		
	}
}
