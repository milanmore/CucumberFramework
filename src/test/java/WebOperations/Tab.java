package WebOperations;

import java.io.IOException;
import java.util.ArrayList;

import managers.FileReaderManager;
import managers.UtilityManager;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import utils.Generic;
import utils.ScreenshotCapture;
import dataProviders.ConfigFileReader;

public class Tab extends Generic {
	final static Logger logger=Logger.getLogger(Tab.class);
	ConfigFileReader config = FileReaderManager.getInstance().getConfigReader();
	ScreenshotCapture scr = UtilityManager.getInstance().getScreenshotCapture();
	String message;
	private WebDriver driver;
	
	public Tab(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		
	}
	public void SwitchToTabByWindowHandle(String windowHandle) throws IOException	
	{
		try 
		{
			driver.switchTo().window(windowHandle);
			message="Status:PASS,StepNumber:"+super.stepCounter+",SwitchToTabByWindowHandle,ParameterName:Window Handler,ParameterValue:"
					+windowHandle+",Note:Able to switch to another tab by window handler,Exception:NA";
			System.out.println(message);
			logger.info(message);
		
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",SwitchToTabByWindowHandle,ParameterName:Window Handler,ParameterValue:"
					+windowHandle+",Note:Able to switch to another tab by window handler,Exception:NA";
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"SwitchToTabByWindowHandle");
	}
	public void SwitchToTabByIndex(int index) throws IOException	
	{
		
		try 
		{
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			String ss = tabs2.get(index);	
			driver.switchTo().window(ss);
			message="Status:PASS,StepNumber:"+super.stepCounter+",SwitchToTabByIndexWindow,ParameterName:Index,ParameterValue:"
					+index+",Note:Able to switch to another tab by index,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:SwitchToTabByIndex,ParameterName:Index,ParameterValue:"
					+index+",Note:failed to switch to another tab by index,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"SwitchToTabByIndex");
	}
	public void SwitchToWindow(int index) throws IOException
	{
		try 
		{
			for (String childWindow : driver.getWindowHandles()) 
	    	{
	       // Switch to Newly open window using switchTo().
	    	       driver.switchTo().window(childWindow);
	        }
			message="Status:PASS,StepNumber:"+super.stepCounter+",SwitchToWindow,ParameterName:Index,ParameterValue:"
					+index+",Note:Able to switch to another window by index,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:SwitchToWindow,ParameterName:Index,ParameterValue:"
					+index+",Note:failed to switch to another window by index,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"SwitchToWindow");
	}
	
	public void ScrollUp() throws IOException
	{

		try 
		{
			Actions actions = new Actions(driver);
		    // Scroll Up using Actions class
		    actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:ScrollUp,ParameterName:NA,ParameterValue:NA"
					+",Note:Able to scroll up,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:ScrollUp,ParameterName:NA,ParameterValue:NA"
					+",Note:failed to scroll up,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"ScrollUp");
	}
	public void ScrollDown() throws IOException
	{
		try 
		{
			Actions actions = new Actions(driver);
			// Scroll Down using Actions class
		    actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:ScrollDown,ParameterName:NA,ParameterValue:NA"
					+",Note:Able to scroll down,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:ScrollDown,ParameterName:NA,ParameterValue:NA"
					+",Note:failed  to scroll down,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"ScrollDown");
	}
	public void RefreshCurrentTab() throws IOException	
	{
		driver.navigate().refresh();
		try 
		{
			driver.navigate().refresh();
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:RefreshCurrentTab,ParameterName:NA,ParameterValue:NA"
					+",Note:Able to refresh current tab,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:RefreshCurrentTab,ParameterName:NA,ParameterValue:NA"
					+",Note:failed to refresh current tab,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"RefreshCurrentTab");
	}
	
}
