package stepsDifincations;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;

public class LoginSteps{
	
	WebDriver driver;
	
	public LoginSteps() {
		driver = Hooks.openBrowser();
	}

	
	static String userID,Password, loginPageUrl;
	
	@When("^I input username \"(.*?)\"$")
	public void iInputUsername(String userName)  {
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userName);
	   
	    
	}

	@When("^I input password \"(.*?)\"$")
	public void iInputPassword(String password)  {
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	    
	}

	@When("^Click submit button$")
	public void clickSubmitButton()  {
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	    
	}

	

   

    
  

   

   

   
 

    @Then("^Verify Home page is displayed with message \"(.*?)\"Welcome To Manager's Page of Guru(\\d+) Bank\"(.*?)\"$")
    public void verifyHomePageIsDisplayedWithMessageWelcomeToManagerSPageOfGuruBank(String arg1, int arg2, String arg3)  {
        
        
    }

    @Given("^I open new customer page$")
    public void iOpenNewCustomerPage()  {
    	driver.findElement(By.xpath("//a[text()='New Customer']")).click();
        
    }

    @When("^Input to new customer form with data$")
    public void inputToNewCustomerFormWithData(DataTable customerTable)  {
        List<Map<String,String>> customer = customerTable.asMaps(String.class, String.class);
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(customer.get(0).get("Name"));
        //driver.findElement(By.xpath("//input[@name='rad1']")).sendKeys(customer.get(0).get("Name"));
        driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(customer.get(0).get("DateOfBirth"));
        driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(customer.get(0).get("Address"));
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys(customer.get(0).get("City"));
        driver.findElement(By.xpath("//input[@name='state']")).sendKeys(customer.get(0).get("State"));
        driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(customer.get(0).get("Pin"));
        driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(customer.get(0).get("Phone"));
        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(customer.get(0).get("Phone"));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(customer.get(0).get("Phone"));

//        for(Map<String,String> customerLoop : customerTable.asMaps(String.class, String.class)) {
//        	Assert.assertArrayEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), customerLoop.get("Name"));
//        }
        
    }

    @When("^Click submit button at New customer page$")
    public void clickSubmitButtonAtNewCustomerPage()  {
    	driver.findElement(By.xpath("//input[@name='sub']")).click();
        
    }

    @When("^I sleep some time$")
    public void iSleepSomeTime() throws InterruptedException {
       Thread.sleep(10000);
    }
    
    @Then("^Verify message display with data \"(.*?)\"$")
    public void verifyMessageDisplayWithData(String arg1)  {
        
        
    }

    @Then("^I veify all above informationcreate success$")
    public void iVeifyAllAboveInformationcreateSuccess(DataTable arg1)  {
        
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        
    }

    @When("^I get Customer ID at New customer page$")
    public void iGetCustomerIDAtNewCustomerPage()  {
        
        
    }

    @Then("^Verify Home page is displayed with message \"(.*?)\"$")
    public void verifyHomePageIsDisplayedWithMessage(String arg1)  {
        
        
    }

    @When("^I open edit customer page$")
    public void iOpenEditCustomerPage()  {
        
        
    }

    @When("^Input customer ID to textbox$")
    public void inputCustomerIDToTextbox()  {
        
        
    }

    @When("^I click Submit button at Edit customer page$")
    public void iClickSubmitButtonAtEditCustomerPage()  {
        
        
    }

    @When("^I input to new customer form with data$")
    public void iInputToNewCustomerFormWithData(DataTable table)  {
        
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        
    }

 public String randomEmail() {
	 Random random = new Random();
	 String randomEmail = random.nextInt(999999)+"@gmail.com";
	 return randomEmail;
 }


}
