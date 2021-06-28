package steps;

import org.junit.BeforeClass;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import pages.Page;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs extends Page implements En  {
	   
	@Given("^I go to url (.*)$")
	public void get(String url){
    	 Page.getUrl(url);
     }
       
    @When("^I am a person from 'Wales' and I enter my dob \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and click next button$") 
    public void I_am_a_person_from_Wales(String day, String month, String year) throws InterruptedException{
       Page.Clickonstart(day,month,year); 
    }

    @Then("^I put my circumstances into the Checker tool$")
    public void Circustances(){
    	
        Page.Mycircustances();
    }
    
    @Then("^I should get a result of whether I will get help or not$")
    public void Nhshelp(){
    	System.out.println("Test Execution is success!!");
    }       
    
    @Given("^I access url (.*)$")
	public void geturl(String url){
    	 Page.getUrl(url);
     }

    
    @When("^I am a person from 'Wales' and I enter my dob \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and click next$") 
    public void I_am_a_person_from_wales_no_partner(String day, String month, String year) throws InterruptedException{
       Page.Clickonstart(day,month,year); 
    }

    @Then("^I put my circumstances into the Checker tool with no partner$")
    public void Nopartnercircustances(){
    	
        Page.Mcircustances();
    }
    
   @Then("^I should get a result of whether I will get help\\?$") 
   		public void help(){
	   System.out.println("Test2 Execution is success!!");
    }

}
    
   
