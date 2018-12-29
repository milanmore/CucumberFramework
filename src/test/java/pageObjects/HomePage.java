package pageObjects;

import java.io.IOException;

import managers.FileReaderManager;
import managers.OperationManager;

import org.openqa.selenium.WebDriver;

import dataProviders.XPathFileReader;
import org.junit.Assert;
import WebOperations.GenericObject;


public class HomePage {

	private XPathFileReader xpath;
	private GenericObject obj;
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		try {
			this.driver = driver;
			xpath = FileReaderManager.getInstance().getXPathReader();
			obj = OperationManager.getInstance().getGenericObject();

			} catch (Exception e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}

	private String LBL_HOMEPAGETITLE()
	{
		return xpath.getXPathValue("LBL_HOMEPAGETITLE");
	}
	
	private String LNK_LOGOUT()
	{
		return xpath.getXPathValue("LNK_LOGOUT");
	}
	
	
	public void UserIsOnHomePage() throws Throwable {
				
		String xpath = LBL_HOMEPAGETITLE();
		Assert.assertEquals(true, obj.IsObjectVisible(xpath));
		}

	public void CheckWelcomeMessageOnHomePage() throws Throwable {
		
		Assert.assertEquals(true, obj.IsObjectVisible(LBL_HOMEPAGETITLE()));
	}
	
	public void Logout() throws IOException, InterruptedException
	{
		
		obj.NavigateToDefaultContent();
	    obj.ObjectClick(LNK_LOGOUT());
		Thread.sleep(100);
	}
	
}
