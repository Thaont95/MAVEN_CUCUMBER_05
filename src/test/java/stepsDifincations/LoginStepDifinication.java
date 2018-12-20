package stepsDifincations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageObjects.LoginPageObject;
import pageObjects.PageFactoryManager;

public class LoginStepDifinication{
	
	WebDriver driver;
	static String loginPageUrl;
	private LoginPageObject loginPage;
	private AbstractTest abstractTest;
	
	
	public LoginStepDifinication() {
		driver = Hooks.openBrowser();
		loginPage = PageFactoryManager.openLoginPage(driver);
		abstractTest = new AbstractTest();

	}
	
	@When("^I get login page URL$")
    public void iGetLoginPageUrl()  {
		loginPageUrl = loginPage.getLoginPageUrl();
        
    }
	
	 @When("^I click to here link$")
	    public void iClickToHereLink()  {
		 loginPage.clickHereLinkToOpenRegisterpage();
	        
	 }
	 
	 @When("^I input username textbox$")
	    public void iInputUsernameTextbox()  {
	       loginPage.inputToUserIDtexbox(RegisterStepDifinication.userID);
	    }

	    @When("^I input password textbox$")
	    public void iInputPasswordTextbox()  {
	    	loginPage.inputToPasswordtexbox(RegisterStepDifinication.Password);
	        
	    }

	    @When("^Click submit button at Login page$")
	    public void clickSubmitButtonAtLoginPage()  {
	    	loginPage.clickToLoginButton();
	        
	    }

	
	

}
