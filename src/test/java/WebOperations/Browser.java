package WebOperations;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import managers.FileReaderManager;
import managers.UtilityManager;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import dataProviders.ConfigFileReader;
import utils.Generic;
import utils.ScreenshotCapture;


public class Browser {	

	private WebDriver driver;
	private Generic generic;


	public Browser(WebDriver driver) {
//		generic(driver);
		// TODO Auto-generated constructor stub
		this.driver= driver;
		generic = UtilityManager.getInstance().getGeneric();
		
	}
	String message;
	final static Logger logger=Logger.getLogger(Browser.class);
	ScreenshotCapture scr = UtilityManager.getInstance().getScreenshotCapture();
	ConfigFileReader config = FileReaderManager.getInstance().getConfigReader();
	
	

public void OpenBrowser(String BrowserName) throws IOException
	{
/*		try
		{
		  driver = new FirefoxDriver();		  
		  wait=new WebDriverWait(driver,getImplicitlyWait);
		  message="Status:PASS,StepNumber:"+(generic.stepCounter)+",StepName:OpenBrowser,ParameterName:BrowserName,ParameterValue:"+BrowserName+",Note:Able to Launch the Browser,Exception:NA";
		  System.out.println(message);	  
		  logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+(generic.stepCounter)+",StepName:OpenBrowser,ParameterName:BrowserName,ParameterValue:"+BrowserName+",Note:Failed to Launch the Browser,Exception:"+ex.getMessage();
			System.out.println(message);	
			logger.error(message);
		}
		scr.CaptureScreenshot((generic.stepCounter)+"_"+"OpenBrowser");		
*/	
	}
	

public void EnterURL(String URL) throws IOException
	{
		
		try
		{
			driver.get(URL);
			message="Status:PASS,StepNumber:"+(generic.stepCounter)+",StepName:EnterURL,ParameterName:URL,ParameterValue:"+URL+",Note:Able to open URL in Browser,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+(generic.stepCounter)+",StepName:EnterURL,ParameterName:URL,ParameterValue:"+URL+",Note:Not able to open URL,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((generic.stepCounter)+"_"+"EnterURL");
	}
	public void WaitTillPageGetsLoaded(long TimeOutInSeconds) throws IOException	
	{
		try
		{
			driver.manage().timeouts().pageLoadTimeout(TimeOutInSeconds, TimeUnit.SECONDS); 
			message="Status:PASS,StepNumber:"+(generic.stepCounter)+",StepName:WaitTillPageGetsLoaded,ParameterName:TimeOutInSeconds,ParameterValue:"+TimeOutInSeconds+",Note:Able to wait till page get loaded,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+(generic.stepCounter)+",StepName:WaitTillPageGetsLoaded,ParameterName:TimeOutInSeconds,ParameterValue:"+TimeOutInSeconds+",Note:failed to wait till page get loaded,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((generic.stepCounter)+"_"+"WaitTillPageGetsLoaded");
	}
	public void MaximizeBrowser() throws IOException
	{
		try
		{
			driver.manage().window().maximize();
			message="Status:PASS,StepNumber:"+(generic.stepCounter)+",StepName:MaximizeBrowser,ParameterName:NA,ParameterValue:NA,Note:Able to maximize the browser,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+(generic.stepCounter)+",StepName:MaximizeBrowser,ParameterName:NA,ParameterValue:NA,Note:failed to maximize the browser,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((generic.stepCounter)+"_"+"MaximizeBrowser");
	}
}
