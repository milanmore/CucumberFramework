package stepDefinitions;


import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.Generic;
import cucumber.TestContext;
import cucumber.api.java.en.Then;

public class home {
	TestContext testContext;
	HomePage home;
	LoginPage login;
	private Generic generic;
	
	public home(TestContext context) {
		testContext=context;
		home=testContext.getPageObjectManager().getHomePage();
		login=testContext.getPageObjectManager().getLoginPage();
		generic=testContext.getUtilityManager().getGeneric();

	}	
	
	@Then("^user is on the application home page$")
	public void user_is_on_the_application_home_page() throws Throwable {
		generic.setStepCounter();
		home.UserIsOnHomePage();
	}

	@Then("^user gets the message starting with Welcome on the top$")
	public void user_gets_the_message_starting_with_on_the_top() throws Throwable {
		generic.setStepCounter();
		home.CheckWelcomeMessageOnHomePage();
	}
	
	@Then("^user gets logged out$")
	public void user_gets_logged_out() throws Throwable
	{
		generic.setStepCounter();
		home.Logout();
		login.VerifyLogout();
	}
}
