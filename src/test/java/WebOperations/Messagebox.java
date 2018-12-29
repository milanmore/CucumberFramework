package WebOperations;

import java.io.IOException;

import managers.FileReaderManager;
import managers.UtilityManager;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import utils.Generic;
import utils.ScreenshotCapture;
import dataProviders.ConfigFileReader;


public class Messagebox extends Generic{
	final static Logger logger=Logger.getLogger(Messagebox.class);
	ConfigFileReader config = FileReaderManager.getInstance().getConfigReader();
	ScreenshotCapture scr = UtilityManager.getInstance().getScreenshotCapture();
	String message;
	WebDriver driver;

	public Messagebox(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}

	public void SwitchToMessageBox(String xPath) throws IOException	
	{
		try 
		{
			driver.switchTo().alert();
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:SwitchToMessageBox,ParameterName:NA,ParameterValue:NA"
					+",Note:Able to accept messagebox,Exception:NA";
			System.out.println(message);	
			logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:SwitchToMessageBox,ParameterName:NA,ParameterValue:NA"
					+",Note:Able to accept messagebox,Exception:"+ex.getMessage();
			System.out.println(message);	
			logger.error(message);
			
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"SwitchToMessageBox");
	}
	
	public String GetTextFromMessageBox(String xPath) throws IOException	
	{
		String strText = null; 
		try 
		{
			driver.switchTo().alert().getText();
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:GetTextFromMessageBox,ParameterName:NA,ParameterValue:NA"
					+",Note:Able to accept messagebox,Exception:NA";
			System.out.println(message);	
			logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:GetTextFromMessageBox,ParameterName:NA,ParameterValue:NA"
					+",Note:Able to accept messagebox,Exception:"+ex.getMessage();
			System.out.println(message);	
			logger.error(message);
			
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"GetTextFromMessageBox");
		return strText;
	}
	
	public void AcceptMessagebox() throws IOException {
		// TODO Auto-generated method stub
	try 
	{
		driver.switchTo().alert().accept();
		message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:AcceptMessagebox,ParameterName:NA,ParameterValue:NA"
				+",Note:Able to accept messagebox,Exception:NA";
		System.out.println(message);	
		logger.info(message);
	}
	catch (Exception ex)
	{
		message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:AcceptMessagebox,ParameterName:NA,ParameterValue:NA"
				+",Note:Able to accept messagebox,Exception:"+ex.getMessage();
		System.out.println(message);	
		logger.error(message);
		
	}
	scr.CaptureScreenshot((super.stepCounter)+"_"+"AcceptMessagebox");
	}
}
