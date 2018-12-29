package WebOperations;

import java.io.IOException;

import managers.FileReaderManager;
import managers.UtilityManager;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Generic;
import utils.ScreenshotCapture;
import dataProviders.ConfigFileReader;

public class Link extends Generic{
	public Link(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	final static Logger logger=Logger.getLogger(Link.class);
	ConfigFileReader config = FileReaderManager.getInstance().getConfigReader();
	ScreenshotCapture scr = UtilityManager.getInstance().getScreenshotCapture();
	String message;


	public void ClickOnLink(String xpath) throws IOException
	{
		try
		{
		WebElement obj=super.GetRunTimeObject(xpath);
		obj.click();
		message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:ClickOnLink,ParameterName:xPath,ParameterValue:"
				+xpath+",Note:Able to click on Button,Exception:NA";
		System.out.println(message);
		logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:ClickOnLink,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:Able to click on Button,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"ClickOnLink");
		
	}
	public String GetLinkText(String xpath) throws IOException	
	{
		String linkText = null;
		try
		{
		WebElement obj=super.GetRunTimeObject(xpath);
		linkText = obj.getText();			
		message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:GetLinkText,ParameterName:xPath,ParameterValue:"
				+xpath+",Note:Able to click on Button,Exception:NA";
		System.out.println(message);
		logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:GetLinkText,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:Able to click on Button,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"GetLinkText");
		return linkText;
	}
}
