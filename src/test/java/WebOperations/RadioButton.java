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


/* Methods included 
 * void ClickRadioButtonByValue(String xpath, String Radiobuttontext)
 * void ClickRadioButtonByIndex(String xpath, int Index)
 * boolean IsRadioButtonSelected(String xpath)
 */
	
public class RadioButton extends Generic{
	public RadioButton(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	final static Logger logger=Logger.getLogger(RadioButton.class);
	ConfigFileReader config = FileReaderManager.getInstance().getConfigReader();
	ScreenshotCapture scr = UtilityManager.getInstance().getScreenshotCapture();
	String message;

	
	

	public void ClickRadioButtonByValue(String xpath) throws IOException	
	{
		try
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			obj.click();
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:ClickRadioButtonByValue,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:Able to click on radio button with given button text,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:IsCheckboxchecked,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:failed to click on radio button with given button text,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}		
		scr.CaptureScreenshot((super.stepCounter)+"_"+"ClickRadioButtonByValue");

	}
	public void ClickRadioButtonByIndex(String xpath) throws IOException	
	{
		try
		{
			WebElement obj= super.GetRunTimeObject(xpath);;
			obj.click();
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:ClickRadioButtonByIndex,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:Able to click on radio button for given index,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:ClickRadioButtonByIndex,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:failed to click on radio button for given index,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}		
		scr.CaptureScreenshot((super.stepCounter)+"_"+"ClickRadioButtonByIndex");
		
	}
	public boolean IsRadioButtonSelected(String xpath) throws IOException	
	{
		Boolean bb = false;
		try
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			
			bb = obj.isSelected();
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:IsRadioButtonSelected,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:Able to check whether radio button is selected,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:IsRadioButtonSelected,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:failed to check whether radio button is selected,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}		
		scr.CaptureScreenshot((super.stepCounter)+"_"+"IsRadioButtonSelected");
		return bb;	
	}	
}

