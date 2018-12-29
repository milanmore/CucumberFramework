package stepDefinitions;

import pageObjects.CreateCompanyPage;
import utils.Generic;
import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class createCompany {

	private TestContext testContext;
	private CreateCompanyPage createCompany;
	Generic generic;

	public createCompany(TestContext context) {
		testContext=context;
		createCompany=testContext.getPageObjectManager().getcreateCompanyPage();
		generic = testContext.getUtilityManager().getGeneric();
		
	}	

	@When("^user clicks on on New button from Manage Company tab$")
	public void clicks_on_on_New_button_from_ManageCompany_tab() throws Throwable {
				generic.setStepCounter();
		createCompany.NavigateToCreateCompany();
	}

	@And("^User enters Company name as \"([^\"]*)\"$")
	public void user_enters_Company_name_as(String CompanyName) throws Throwable {
				generic.setStepCounter();
		createCompany.EnterCompanyName(CompanyName);
	}

	@And("^User selects Company type as \"([^\"]*)\"$")
	public void user_selects_Company_type_as(String CompanyType) throws Throwable {
				generic.setStepCounter();
		createCompany.EnterCompanyType(CompanyType);
	}

	@And("^User Company Subtype as \"([^\"]*)\"$")
	public void user_Company_Subtype_as(String CompanySubtype) throws Throwable {
				generic.setStepCounter();
		createCompany.EnterCompanySubtype(CompanySubtype);
	}

	@And("^User enters Address as \"([^\"]*)\"$")
	public void user_enters_Address_as(String CompanyAddress) throws Throwable {
				generic.setStepCounter();
		createCompany.EnterCompanyAddress(CompanyAddress);
	}

	@And("^User enters Phone as \"([^\"]*)\"$")
	public void user_enters_Phone_as(String CompanyPhone) throws Throwable {
				generic.setStepCounter();
		createCompany.EnterCompanyPhone(CompanyPhone);
	}

	@And("^User enters Email as \"([^\"]*)\"$")
	public void user_enters_Email_as(String CompanyEmail) throws Throwable {
				generic.setStepCounter();
		createCompany.EnterCompanyEmail(CompanyEmail);

	}

	@And("^User enters Pan Details as \"([^\"]*)\"$")
	public void user_enters_Pan_Details_as(String CompanyPAN) throws Throwable {
				generic.setStepCounter();
		createCompany.EnterCompanyPAN(CompanyPAN);

	}

	@And("^User enters Tin details as \"([^\"]*)\"$")
	public void user_enters_Tin_details_as(String CompanyTIN) throws Throwable {
				generic.setStepCounter();
		createCompany.EnterCompanyTIN(CompanyTIN);

	}

	@And("^User selects Country as \"([^\"]*)\"$")
	public void user_selects_Country_as(String CompanyCountry) throws Throwable {
				generic.setStepCounter();
		createCompany.EnterCompanyCountry(CompanyCountry);
	}

	@And("^User selects State as \"([^\"]*)\"$")
	public void user_selects_State_as(String State) throws Throwable {
				generic.setStepCounter();
		createCompany.EnterCompanyState(State);

	}

	@And("^User selects City name as \"([^\"]*)\"$")
	public void user_selects_City_name_as(String CityName) throws Throwable {
				generic.setStepCounter();
		createCompany.EnterCompanyCity(CityName);

	}

	@And("^User enters Total Employee as \"([^\"]*)\"$")
	public void user_enters_Total_Employee_as(String total_Emp) throws Throwable {
				generic.setStepCounter();
		createCompany.EnterTotalEmployeeNo(total_Emp);
	}

	@And("^User clicks on Save button$")
	public void user_clicks_on_Save_button() throws Throwable {
				generic.setStepCounter();
		createCompany.SaveCompanyDetails();

	}

	@Then("^new Company should get created successfully and should see on the first row of the table$")
	public void user_should_see_the_successfully_created_company_name_on_st_row_of_table() throws Throwable {
		Thread.sleep(100);
				generic.setStepCounter();
		createCompany.ViewCompanyOnTopRow();
		
	}
	@Then("^User should get the validation error message \"([^\"]*)\" for \"([^\"]*)\" field$")
	public void user_should_get_the_validation_error_message_for_field(String message, String fieldname) throws Throwable {
				generic.setStepCounter();
		System.out.println(message + " " + fieldname);
	}
	
	@And("^User enters Company details for company \"([^\"]*)\" from \"([^\"]*)\" file for (d*) companies")
	public void User_enters_Company_details(String companyname, String dataType, int count)
	{
				generic.setStepCounter();
		System.out.println("companydetails");
	}
	
	@When("^User enters Company details for company \"([^\"]*)\" from \"([^\"]*)\" file for (\\d+) companies$")
	public void user_enters_Company_details_for_company_from_file_for_companies(String arg1, String arg2, int arg3) {

		
	}
	
}
