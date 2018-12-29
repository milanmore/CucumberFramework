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


public class Button extends Generic{
	
	public Button(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	final static Logger logger=Logger.getLogger(Button.class);
	ConfigFileReader config = FileReaderManager.getInstance().getConfigReader();
	ScreenshotCapture scr = UtilityManager.getInstance().getScreenshotCapture();
	String message;

		public void ClickOnButton(String xpath) throws IOException
	{
		try
		{
			WebElement obj= super.GetRunTimeObject(xpath);
			scr.CaptureScreenshot((super.stepCounter)+"_"+"ClickOnButton");	
			obj.click();
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:ClickOnButton,ParameterName:xPath,ParameterValue:"
				+xpath+",Note:Able to click on Button,Exception:NA";
			System.out.println(message);	
			logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:ClickOnButton,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:Able to click on Button,Exception:"+ex.getMessage();
			System.out.println(message);	
			logger.error(message);
			scr.CaptureScreenshot((super.stepCounter)+"_"+"ClickOnButton");	
		}
			
	}
}

