package WebOperations;

import java.io.IOException;

import managers.FileReaderManager;
import managers.UtilityManager;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import utils.Generic;
import utils.ScreenshotCapture;
import dataProviders.ConfigFileReader;
/* Methods included 
* void SwitchToFrameByID(String xpath, String ID)
* void SwitchToFrameByIndex(String xpath, int index)
*/

public class Frame extends Generic {

	final static Logger logger=Logger.getLogger(Frame.class);
	ConfigFileReader config = FileReaderManager.getInstance().getConfigReader();
	ScreenshotCapture scr = UtilityManager.getInstance().getScreenshotCapture();
	String message;
	private WebDriver driver;

	public Frame(WebDriver driver) {
		super(driver);
		this.driver =driver;
		// TODO Auto-generated constructor stub
	}

	public void SwitchToFrameByID(String ID) throws IOException	
	{
		try 
		{
			driver.switchTo().frame(ID);	
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:SwitchToFrameByID,ParameterName:ID,ParameterValue:"
					+ID+ ",Note:Able to switch the frame by ID,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:SwitchToFrameByID,ParameterName:ID,ParameterValue:"
					+ID+ "Note:failed to switch the frame by ID,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"SwitchToFrameByID");
		
	}
	public void SwitchToFrameByIndex(int index) throws IOException	
	{
		try 
		{
			driver.switchTo().frame(index);
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:SwitchToFrameByIndex,ParameterName:Index,ParameterValue:"
					+index+ ",Note:Able to switch the frame by Index,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:SwitchToFrameByIndex,ParameterName:Index,ParameterValue:"
					+index+ "Note:failed to switch the frame by Index,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"SwitchToFrameByIndex");
		
	}
}
