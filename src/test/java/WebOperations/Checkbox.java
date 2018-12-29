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

/* Methods includes 
 * IsCheckboxchecked
 * CheckTheCheckbox
 * UncheckCheckbox
 * ClickCheckbox
 */
public class Checkbox extends Generic{

	

	public Checkbox(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	final static Logger logger=Logger.getLogger(Checkbox.class);
	ConfigFileReader config = FileReaderManager.getInstance().getConfigReader();
	ScreenshotCapture scr = UtilityManager.getInstance().getScreenshotCapture();
	String message;
	
	private int stepCounter;

	
	
	public boolean IsCheckboxchecked(String xpath) throws IOException	
	{
		Boolean bb = false;
		try
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			bb = obj.isSelected();
			message="Status:PASS,StepNumber:"+stepCounter+",StepName:IsCheckboxchecked,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:Able to Check whether checkbox is selected,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+stepCounter+",StepName:IsCheckboxchecked,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:failed to Check whether checkbox is selected,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}		
		scr.CaptureScreenshot((super.stepCounter)+"_"+"IsCheckboxchecked");
		return bb;
		
	}
	public void CheckTheCheckbox(String xpath) throws IOException	
	{
	try
	{
		WebElement obj=super.GetRunTimeObject(xpath);
		if (!obj.isSelected())
		{
			obj.click();
		}
		message="Status:PASS,StepNumber:"+stepCounter+",StepName:CheckTheCheckbox,ParameterName:xPath,ParameterValue:"
				+xpath+",Note:Able to Check the checkbox,Exception:NA";
		System.out.println(message);
		logger.info(message);
	}
	catch (Exception ex)
	{
		message="Status:EORROR,StepNumber:"+stepCounter+",StepName:CheckTheCheckbox,ParameterName:xPath,ParameterValue:"
				+xpath+",Note:failed to Check the checkbox,Exception:"+ex.getMessage();
		System.out.println(message);
		logger.error(message);
	}		
	scr.CaptureScreenshot((super.stepCounter)+"_"+"CheckTheCheckbox");
	}

	public void UncheckCheckbox(String xpath) throws IOException	
	{
		try
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			if (obj.isSelected())
			{
				obj.click();
			}
			message="Status:PASS,StepNumber:"+stepCounter+",StepName:UncheckTheCheckbox,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:Able to Uncheck the checkbox,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+stepCounter+",StepName:UncheckTheCheckbox,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:failed to Uncheck the checkbox,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}		
		scr.CaptureScreenshot((super.stepCounter)+"_"+"UncheckCheckbox");		
	}
	
	public void ClickCheckbox(String xpath) throws IOException	
	{
		try
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			obj.click();
			message="Status:PASS,StepNumber:"+stepCounter+",StepName:ClickCheckbox,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:Able to click the checkbox,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+stepCounter+",StepName:ClickCheckbox,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:failed to Click the checkbox,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}		
		scr.CaptureScreenshot((super.stepCounter)+"_"+"ClickCheckbox");				
	}
}
