package pageObjects;

import java.io.IOException;
import java.util.Hashtable;

import managers.FileReaderManager;
import managers.OperationManager;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import WebOperations.Button;
import WebOperations.Dropdown;
import WebOperations.Frame;
import WebOperations.GenericObject;
import WebOperations.Textbox;
import dataProviders.FakeDataGenerator;
import dataProviders.XPathFileReader;

public class CreateCompanyPage extends XPathFileReader{

	public String $COMPANYNAME;
	public Hashtable<String,String> $COMPANYDATA = new Hashtable<String, String>();
	
	
	private XPathFileReader xpath;
	private Textbox textbox;
	private Dropdown dropdown;
	private Button button;
	private GenericObject obj;
	private Frame frame;
	private FakeDataGenerator fakedata;
	
	
	public CreateCompanyPage(WebDriver driver) {
		
		xpath = FileReaderManager.getInstance().getXPathReader();
		fakedata = FileReaderManager.getInstance().getFakeDataGenerator();
		
		dropdown = OperationManager.getInstance().getDropdown();
		textbox = OperationManager.getInstance().getTextbox();
		button = OperationManager.getInstance().getButton();
		obj = OperationManager.getInstance().getGenericObject();
		frame = OperationManager.getInstance().getFrame();
	}
	
//XPath for Create Company functionality

	
/*	private String OBJ_COMPANY()
	{
		return xpath.getXPathValue("OBJ_COMPANY");
	}
*/
	private String LNK_MANAGE_COMPANY()
	{
		return xpath.getXPathValue("LNK_MANAGE_COMPANY");
		
	}
	private String BTN_NEWCOMPANY()
	{
		return xpath.getXPathValue("BTN_NEWCOMPANY");
	}
	private String TXT_COMPANYNAME()  
	{
		return xpath.getXPathValue("TXT_COMPANYNAME");
	}
	private String DD_COMPANYTYPE()  
	{
		return xpath.getXPathValue("DD_COMPANYTYPE");
	}
	private String DD_COMPANY_SUBTYPE()  
	{
		return xpath.getXPathValue("DD_COMPANY_SUBTYPE");
	}
	private String AREA_COMPANYADDRESS()  
	{
		return xpath.getXPathValue("AREA_COMPANYADDRESS");
	}
	private String TXT_PHONENUMBER()  
	{
		return xpath.getXPathValue("TXT_PHONENUMBER");
	}
	private String TXT_EMAIL()  
	{
		return xpath.getXPathValue("TXT_EMAIL");
	}
	private String TXT_PAN_DETAILS()  
	{
		return xpath.getXPathValue("TXT_PAN_DETAILS");
	}
	private String TXT_TIN_DETAILS()  
	{
		return xpath.getXPathValue("TXT_TIN_DETAILS");
	}
	private String TXT_MOBILE()  
	{
		return xpath.getXPathValue("TXT_MOBILE");
	}
	private String TXT_WEBSITE()  
	{
		return xpath.getXPathValue("TXT_WEBSITE");
	}
	private String DD_COUNTRY()  
	{
		return xpath.getXPathValue("DD_COUNTRY");
	}
	private String DD_CITY()  
	{
		return xpath.getXPathValue("DD_CITY");
	}
	private String DD_STATE()  
	{
		return xpath.getXPathValue("DD_STATE");
	}
	private String TXT_TOTAL_EMP()  
	{
		return xpath.getXPathValue("TXT_TOTAL_EMP");
	}
	private String BTN_SAVECOMPANY()  
	{
		return xpath.getXPathValue("BTN_SAVECOMPANY");
	}
/*
	private String BTN_CANCELCOMPANY()  
	{
		return xpath.getXPathValue("BTN_CANCELCOMPANY");
	}
	private String BTN_DESTROYCOMPANY()  
	{
		return xpath.getXPathValue("BTN_DESTROYCOMPANY");
	}
	private String OBJ_NEWCOMPANY_ROW()  
	{
		return xpath.getXPathValue("OBJ_NEWCOMPANY_ROW");
	}
	private String LBL_DELETECOMPANY_MSG()  
	{
		return xpath.getXPathValue("LBL_DELETECOMPANY_MSG");
	}
	
	private String LBL_SAVECOMPANY_MSG()  
	{
		return xpath.getXPathValue("LBL_SAVECOMPANY_MSG");
	}
*/
	public void NavigateToCreateCompany() throws IOException, InterruptedException
	{
		obj.ObjectClick(LNK_MANAGE_COMPANY());
		Thread.sleep(100);
		//driver.switchTo().frame(0);
		frame.SwitchToFrameByIndex(0);
		Thread.sleep(1000);
		obj.ObjectClick(BTN_NEWCOMPANY());
	}

	public void EnterCompanyName(String CompanyName) throws Throwable {
		if (CompanyName.equalsIgnoreCase("[randam]"))
			$COMPANYNAME = fakedata.GetFakeData("CompanyName");
		else
			$COMPANYNAME = CompanyName;
		textbox.EnterValueInTextbox(TXT_COMPANYNAME(), $COMPANYNAME);
	}

	public void EnterCompanyType(String CompanyType) throws Throwable {
		dropdown.SelectValueByVisibleText(DD_COMPANYTYPE(), CompanyType);
		
	}

	public void EnterCompanySubtype(String CompanySubtype) throws Throwable {
		dropdown.SelectValueByVisibleText(DD_COMPANY_SUBTYPE(), CompanySubtype);
	}

	public void EnterCompanyAddress(String CompanyAddress) throws Throwable {
		textbox.EnterValueInTextbox(AREA_COMPANYADDRESS(), CompanyAddress);
	}

	public void EnterCompanyPhone(String CompanyPhone) throws Throwable {
		textbox.EnterValueInTextbox(TXT_PHONENUMBER(), CompanyPhone);
	}

	public void EnterCompanyEmail(String CompanyEmail) throws Throwable {
		textbox.EnterValueInTextbox(TXT_EMAIL(), CompanyEmail);

	}

	public void EnterCompanyPAN(String CompanyPAN) throws Throwable {
		textbox.EnterValueInTextbox(TXT_PAN_DETAILS(), CompanyPAN);
		}

	public void EnterCompanyTIN(String CompanyTIN) throws Throwable {
		textbox.EnterValueInTextbox(TXT_TIN_DETAILS(), CompanyTIN);

	}
	public void EnterCompanyMobile(String MobileNumber) throws Throwable {
		textbox.EnterValueInTextbox(TXT_MOBILE(), MobileNumber);

	}
	public void EnterCompanyWebsite(String Website) throws Throwable {
		textbox.EnterValueInTextbox(TXT_WEBSITE(), Website);

	}

	
	public void EnterCompanyCountry(String Country) throws Throwable {
		dropdown.SelectValueByVisibleText(DD_COUNTRY(), Country);
	}

	public void EnterCompanyState(String State) throws Throwable {
		dropdown.SelectValueByVisibleText(DD_STATE(), State);
		
	}

	public void EnterCompanyCity(String CityName) throws Throwable {
		dropdown.SelectValueByVisibleText(DD_CITY(), CityName);
	}

	public void EnterTotalEmployeeNo(String total_Emp) throws Throwable {
		textbox.EnterValueInTextbox(TXT_TOTAL_EMP(), total_Emp);
		
	}

	public void SaveCompanyDetails() throws Throwable {
		button.ClickOnButton(BTN_SAVECOMPANY());		
	}
	
	public void ViewCompanyOnTopRow() throws IOException, InterruptedException
	{
		String str = "//*[.='" + $COMPANYNAME + "']";	
		Thread.sleep(5000);
    	Assert.assertEquals($COMPANYNAME, obj.GetObjectText(str));
    	Thread.sleep(100);
    	System.out.println($COMPANYNAME);
	}
}


