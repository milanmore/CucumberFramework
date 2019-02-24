package stepDefinitions;


import org.apache.log4j.Logger;

import pageObjects.LoginPage;
import utils.Generic;
import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class login {
	
	TestContext testContext;
	LoginPage login;
	Generic generic;
	final static Logger logger=Logger.getLogger(login.class);

	
	public login(TestContext context) {
		testContext=context;
		login=testContext.getPageObjectManager().getLoginPage();
		generic = testContext.getUtilityManager().getGeneric();
	}	
	
	@Given("^user is on the application login page$")
	public void user_is_on_the_application_login_page() throws Throwable {
		Thread.sleep(100);
		generic.setStepCounter();
		login.UserIsOnLoginPage();
		System.out.println("hello");
	}

	@When("^user logs in with username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_logs_in_with_username_as_and_password_as(String username, String password) throws Throwable {
		generic.setStepCounter();
		login.LoginToFinsysApp(username, password);
	}

	
	@Then("^user gets the message as \"([^\"]*)\" on login page$")
	public void user_gets_the_message_as_on_login_page(String message) throws Throwable {
		generic.setStepCounter();
		login.LoginErrorMessage(message);
	}

}