package HelloFeature;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginVerifyFeature {
	@Given("the page is opened")
	public void the_page_is_opened() {
		
		System.out.println(" in th login fatrue");
	    
	}

	@When("the user and password entered")
	public void the_user_and_password_entered() {
		System.out.println(" in th login fatrue");

	}

	@Then("click the login button")
	public void click_the_login_button() {
		System.out.println(" in th login fatrue");

	}

	@Then("the Home page should be opned")
	public void the_Home_page_should_be_opned() {
		System.out.println(" in th login fatrue");
 
	}


}
