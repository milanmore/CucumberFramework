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


public class Textbox extends Generic {
	public Textbox(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	final static Logger logger=Logger.getLogger(Textbox.class);
	ConfigFileReader config = FileReaderManager.getInstance().getConfigReader();
	ScreenshotCapture scr = UtilityManager.getInstance().getScreenshotCapture();
	private String message;


	public void EnterValueInTextbox(String xpath, String value) throws IOException
	{
		try 
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			obj.sendKeys(value);
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:EnterValueInTextbox,ParameterName:xPath,ParameterValue:"
					+xpath+",ParameterName:InputValue,ParameterValue:"
					+value+",Note:Able to enter text in textbox,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:EnterValueInTextbox,ParameterName:xPath,ParameterValue:"
					+xpath+",ParameterName:InputValue,ParameterValue:"
					+value+",Note:failed to enter text in textbox,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"EnterValueInTextbox");
	}

	public  void ClearValueInTextbox(String xpath) throws IOException	
	{
		try 
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			obj.clear();
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:ClearValueInTextbox,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:Able to clear value from textbox,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:ClearValueInTextbox,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:failed to clear value from textbox,Exception:NA";
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"ClearValueInTextbox");
		

	}

	public String GetValueFromTextbox(String xpath) throws IOException
	{
		String str = null;
		try 
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			str = obj.getAttribute("value");
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:GetValueFromTextbox,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:Able to Get value from Textbox,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:GetValueFromTextbox,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:failed to Get value from Textbox,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"GetValueFromTextbox");
		return str;

	}
	
	public boolean IsTextBoxReadOnly(String xpath) throws IOException	
	{
		boolean TextBoxStatus = false;
		try 
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			if (obj.isEnabled() != true)
			{
				TextBoxStatus = true;
			}
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:IsTextBoxReadOnly,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:Able to check whether Textbox is read Only,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:IsTextBoxReadOnly,ParameterName:xPath,ParameterValue:"
					+xpath+"Note:failed to check whether Textbox is read Only,Exception:NA";
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"IsTextBoxReadOnly");
		return TextBoxStatus;
	}
}
