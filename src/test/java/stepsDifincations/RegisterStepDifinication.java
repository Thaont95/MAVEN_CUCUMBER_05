package stepsDifincations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterPageObject;

public class RegisterStepDifinication{
	
	WebDriver driver;
	
	static String userID,Password;
	private RegisterPageObject registerPage;
	private AbstractTest abstractTest;
	
	public RegisterStepDifinication() {
		driver = Hooks.openBrowser();
		registerPage = PageFactoryManager.openRegisterPage(driver);
		abstractTest = new AbstractTest();
	}

	
	 @When("^I input to Email textbox with data \"(.*?)\"$")
	    public void iInputToEmailTextboxWithData(String email)  {	        
	    	registerPage.inputEmailAddress(email + abstractTest.randomEmail());
	    }
	 
	 @When("^I click to submit button at Register page$")
	    public void iClickToSubmitButtonAtRegisterPage()  {
	    	registerPage.clickSubmitButton();
	        
	    }
	 
	 @Then("^I get UserID info$")
	    public void iGetUserIDInfo()  {
		 userID = registerPage.getUserIDText();
	        
	    }

	    @Then("^I get Password info$")
	    public void iGetPasswordInfo()  {
	    	Password = registerPage.getPasswordText();
	        
	    }
	    
	    @When("^open login page again$")
	    public void openLoginPageAgain() {
	    	registerPage.openLoginPageUrl(LoginStepDifinication.loginPageUrl);
	    }
}
