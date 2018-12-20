package stepsDifincations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractTest;
import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import pageObjects.HomePageObject;
import pageObjects.PageFactoryManager;

public class HomePageStepDifinication{
	
	private WebDriver driver;
	static String loginPageUrl;
	private HomePageObject homePage;
	private AbstractTest abstractTest;
	
	
	public HomePageStepDifinication() {
		driver = Hooks.openBrowser();
		homePage = PageFactoryManager.openHomePage(driver);
		abstractTest = new AbstractTest();

	}
	
	@Then("^Verify Home page is displayed with message \"(.*?)\" $")
	public void verifyHomePageIsDisplay(String messageName)  {
		abstractTest.verifyTrue(homePage.isHomePagaDisplayed(messageName));
		
	    
	}

	
	

}
