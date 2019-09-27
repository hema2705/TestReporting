package HelloFeature;

import BasePackage.Pages.GoogleHomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class BrowserLaunch {

	
	
	@Given("the url name is mentioned")
	public void the_url_name_is_mentioned() {
		System.out.println("given called");

	}

	@When("browser is opened")
	public void browser_is_opened() {
		Assert.assertEquals(false, true);
		System.out.println("when called");

	}

	@Then("url should be entered and navigated to the page")
	public void url_should_be_entered_and_navigated_to_the_page() {
		System.out.println("then called");

	}

}
