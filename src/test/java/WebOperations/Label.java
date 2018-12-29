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


public class Label extends Generic{
	public Label(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	final static Logger logger=Logger.getLogger(Label.class);
	ConfigFileReader config = FileReaderManager.getInstance().getConfigReader();
	ScreenshotCapture scr = UtilityManager.getInstance().getScreenshotCapture();
	private String message;


	
	public String GetLabelText(String xpath) throws IOException
	{
		String labelText = null;
		try 
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			labelText = obj.getText();
			System.out.println(labelText);
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:GetLabelText,ParameterName:xPath,ParameterValue:"+xpath+",Note:Able to get Label Text,Exception:NA";
			System.out.println(message);
			logger.info(message);			
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:GetLabelText,"
					+ "ParameterName:xPath,ParameterValue:"+xpath+",Note:Not able to get Label Text,Exception:"+ex.getMessage();
			System.out.println(message);			
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"GetLabelText");
		return labelText;
			
	}
	public boolean IsLabelVisible(String xpath, String label) throws IOException	
	{
		boolean bVisible = false;
		try 
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			bVisible = obj.isDisplayed();
			if (bVisible == true)
			{
				if (obj.getText() == label)
				{
					bVisible = true;
				}
				else
				{
					bVisible = false;
				}
			}
			else
				bVisible = false;		
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:IsLabelVisible,ParameterName:xPath,ParameterValue:"
					+xpath+",ParameterName:LabelName,ParameterValue:"
					+label+",Note:Able to check whether Label is visible,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:IsLabelVisible,ParameterName:xPath,ParameterValue:"
					+xpath+",ParameterName:LabelName,ParameterValue:"
					+label+",Note:failed to check whether Label is visible,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"IsLabelVisible");
		return bVisible;
	}
	

}
