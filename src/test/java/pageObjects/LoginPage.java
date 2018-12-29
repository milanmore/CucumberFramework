package pageObjects;

import java.io.IOException;







import managers.FileReaderManager;
import managers.OperationManager;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import dataProviders.ConfigFileReader;
import dataProviders.XPathFileReader;
import WebOperations.Browser;
import WebOperations.Button;
import WebOperations.GenericObject;
import WebOperations.Label;
import WebOperations.Textbox;


public class LoginPage {
	
WebDriver driver;
OperationManager opManager;
Browser browser;
ConfigFileReader config; 
XPathFileReader xpath; 
Textbox textbox;
Label label;
Button button;
GenericObject obj;

public LoginPage(WebDriver driver)  {
	this.driver=driver;
	try {
		config = FileReaderManager.getInstance().getConfigReader();
		xpath = FileReaderManager.getInstance().getXPathReader();
		
		browser = OperationManager.getInstance().getBrowser();		
		textbox = OperationManager.getInstance().getTextbox();
		label = OperationManager.getInstance().getlabel();
		button = OperationManager.getInstance().getButton();
		obj = OperationManager.getInstance().getGenericObject();
		

	} catch (Exception ex) {
			// TODO Auto-generated catch block
		ex.printStackTrace();
		}
	}


	private String LBL_LOGINTITLE()
	{
		return xpath.getXPathValue("LBL_LOGINTITLE");
	}
	
	private String TXT_USERNAME()
	{
		return xpath.getXPathValue("TXT_USERNAME");
	}

	private String TXT_PASSWORD()
	{
		return xpath.getXPathValue("TXT_PASSWORD");
	}

	private String BTN_LOGIN()
	
	{
		return xpath.getXPathValue("BTN_LOGIN");
	}

	private String LBL_LOGINERROR()
	{
		return xpath.getXPathValue("LBL_LOGINERROR");
	}

	
	public void UserIsOnLoginPage() throws Throwable {
		try
		{
			LaunchApplication();
			Thread.sleep(1000);
			obj.NavigateToDefaultContent();
			//String str = LBL_LOGINTITLE();
			//"SBDC - Small Business Development Co.""
			Assert.assertEquals("SBDC - Small Business Development Co.", driver.getTitle());
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
 	}

	public void LoginToFinsysApp(String username, String password) throws Throwable {
		Thread.sleep(100);	
					
		textbox.EnterValueInTextbox(TXT_USERNAME(), username);
		textbox.EnterValueInTextbox(TXT_PASSWORD(), password);
		button.ClickOnButton(BTN_LOGIN());
	}
	
	public void LoginErrorMessage(String errormessage) throws Throwable {
					
		Assert.assertEquals(errormessage, label.GetLabelText(LBL_LOGINERROR()));
	}
	
	public void LaunchApplication() throws IOException
	{
		browser.EnterURL(config.getApplicationUrl());
		browser.WaitTillPageGetsLoaded(config.getPAGE_LOAD_TIMEOUT());
		browser.MaximizeBrowser();
	}
	
	public void VerifyLogout() throws IOException
	{
					
		String str = LBL_LOGINTITLE();
		Assert.assertEquals("Login to SBDC", label.GetLabelText(str));
	}
}
