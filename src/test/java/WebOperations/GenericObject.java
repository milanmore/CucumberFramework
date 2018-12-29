package WebOperations; 

import java.io.IOException;
import java.util.List;

import managers.FileReaderManager;
import managers.UtilityManager;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.Generic;
import utils.ScreenshotCapture;
import dataProviders.ConfigFileReader;

public class GenericObject extends Generic{

	final static Logger logger=Logger.getLogger(GenericObject.class);
	ConfigFileReader config = FileReaderManager.getInstance().getConfigReader();
	ScreenshotCapture scr = UtilityManager.getInstance().getScreenshotCapture();
	String message;
	private WebDriver driver;
	
	public GenericObject(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}
	public boolean IsObjectEnabled(String xpath) throws IOException	
	{
		Boolean bb = false;
		try
		{
		WebElement obj=super.GetRunTimeObject(xpath);
		bb = obj.isEnabled();
		message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:IsObjectEnabled,ParameterName:xPath,ParameterValue:"
				+xpath+",Note:Able to check whether object is enabled,Exception:NA";
		
		System.out.println(message);	
		logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:ObjectClick,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:failed to check whether object is enabled,Exception:"+ex.getMessage();
			System.out.println(message);			
			logger.error(message);
		}		
		scr.CaptureScreenshot((super.stepCounter)+"_"+"IsObjectEnabled");
		return bb;
	}
	public boolean IsObjectVisible(String xpath) throws IOException	
	{
		Boolean bb = false;
		try
		{
		WebElement obj=super.GetRunTimeObject(xpath);
		bb = obj.isDisplayed();
		message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:IsObjectVisible,ParameterName:xPath,ParameterValue:"
				+xpath+",Note:Able to check whether object is visible,Exception:NA";
		System.out.println(message);	
		logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:IsObjectVisible,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:failed to check whether object is visible,Exception:"+ex.getMessage();
			System.out.println(message);			
			logger.error(message);
		}		
		scr.CaptureScreenshot((super.stepCounter)+"_"+"IsObjectVisible");
		return bb;

	}
	public void ObjectClick(String xpath) throws IOException	
	{
		try
		{
		WebElement obj=super.GetRunTimeObject(xpath);
		//CaptureScreenshot("ObjectClick");
		obj.click();
		message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:ObjectClick,ParameterName:xPath,ParameterValue:"
				+xpath+",Note:Able to click on Button,Exception:NA";
		System.out.println(message);		
		logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:ObjectClick,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:Able to click on Button,Exception:"+ex.getMessage();
			System.out.println(message);			
			logger.error(message);
			scr.CaptureScreenshot((super.stepCounter)+"_"+"ObjectClick");
		}		
		

	}
	
	public void ObjectDoubleClick(String xpath) throws IOException	
	{
		try
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			Actions action = new Actions(driver);
			scr.CaptureScreenshot((super.stepCounter)+"_"+"ObjectDoubleClick");
			action.doubleClick(obj);
			action.build().perform();
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:ObjectDoubleClick,ParameterName:xPath,ParameterValue:"
				+xpath+",Note:Able to click on Button,Exception:NA";
			System.out.println(message);	
			logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:ObjectDoubleClick,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:Able to click on Button,Exception:"+ex.getMessage();
			System.out.println(message);			
			logger.error(message);
			scr.CaptureScreenshot((super.stepCounter)+"_"+"ObjectDoubleClick");
		}
		

	}

	public void ObjectMouseHover(String xpath) throws IOException	
	{
		try
		{
			WebElement obj=super.GetRunTimeObject(xpath);
		    Actions action = new Actions(driver);
	        action.moveToElement(obj).build().perform();
//	        action.clickAndHold(obj).perform();
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:ObjectMouseHover,ParameterName:xPath,ParameterValue:"
				+xpath+",Note:Able to see mouseover text,Exception:NA";
			System.out.println(message);	
			logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:ObjectMouseHover,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:failed to see mouseover text,Exception:"+ex.getMessage();
			System.out.println(message);			
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"ObjectMouseOver");
	}
	public void ObjectRightClick(String xpath) throws IOException	
	{
		try
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			Actions action = new Actions(driver);
            //contextClick() method to do right click on the element
            action.contextClick(obj).build().perform();
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:ObjectRightClick,ParameterName:xPath,ParameterValue:"
				+xpath+",Note:Able to right click on object,Exception:NA";
			System.out.println(message);	
			logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:ObjectRightClick,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:failed  to right click on the object,Exception:"+ex.getMessage();
			System.out.println(message);			
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"ObjectRightClick");
		
	}
	public void ObjectLeftClick(String xpath) throws IOException	
	{
		try
		{
			WebElement obj=super.GetRunTimeObject(xpath);
// need to write a right code.....
			obj.click();
			
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:ObjectLeftClick,ParameterName:xPath,ParameterValue:"
				+xpath+",Note:Able to left click on Button,Exception:NA";
			System.out.println(message);	
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:ObjectLeftClick,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:failed to left click on Button,Exception:"+ex.getMessage();
			System.out.println(message);			
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"ObjectLeftClick");	
	}

	public String  GetObjectToolTipText(String xpath) throws IOException	
	{
		String ToolTipText = null;
		try
		{
			WebElement obj=super.GetRunTimeObject(xpath);
		    Actions action = new Actions(driver);
	        action.clickAndHold(obj).perform();
	        ToolTipText = obj.getAttribute("title");
	        
	        message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:GetObjectToolTipText,ParameterName:xPath,ParameterValue:"
				+xpath+",Note:Able to get tooltip text,Exception:NA";
			System.out.println(message);	
			logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:GetObjectToolTipText,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:failed to get tooltip text,Exception:"+ex.getMessage();
			System.out.println(message);			
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"GetObjectToolTipText");
		return ToolTipText;
		
	}
	
	public String GetAttributevalue(String xpath, String AttributeName) throws IOException 
	{
		String strText = null;

		try
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			strText = obj.getAttribute(AttributeName);
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:GetAttributevalue,ParameterName:xPath,ParameterValue:"
				+xpath+",Note:Able to get attribute value,Exception:NA";
			System.out.println(message);	
			logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:GetAttributevalue,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:failed to get attribute value,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"GetAttributevalue");
		System.out.println(strText);
		return strText;
		
}
	
	public String GetAttributeWhichContains(String xpath,String valueContains) throws IOException	
	{
		String strText = null;
		try
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			strText = obj.getText();
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:GetAttributeWhichContains,ParameterName:xPath,ParameterValue:"
				+xpath+",Note:Able to get Attribute value Which Contains given string,Exception:NA";
			System.out.println(message);	
			logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:GetAttributeWhichContains,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:failed  to get Attribute value Which Contains given string,Exception:"+ex.getMessage();
			System.out.println(message);			
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"GetAttributeWhichContains");
		return strText;
	}
	
	public List<WebElement>  GetChildObjects(String xpath) throws IOException
	{
		List<WebElement> rows = null;
		try
		{
			rows = driver.findElements(By.xpath(xpath));
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:GetAttributeWhichContains,ParameterName:xPath,ParameterValue:"
				+xpath+",Note:Able to get child objects,Exception:NA";
			System.out.println(message);	
			logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:GetAttributeWhichContains,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:failed  to get child objects,Exception:"+ex.getMessage();
			System.out.println(message);			
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"GetChildObjects");
		return rows;		
	}
	
	public static List<WebElement> GetSpecificChildObjects(String xPath)
	{
		return null;
		
	}
	public static List<WebElement> GetSpecificChildObjectsAsPerGivenSearchCriteria(String xPath,String searchText)
	{
		return null;
		
	}

	public String  GetObjectText(String xpath) throws IOException	
	{
		String strText = null;
		try
		{
			WebElement obj=super.GetRunTimeObject(xpath);
	        strText = obj.getText();
	        
	        message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:GetObjectText,ParameterName:xPath,ParameterValue:"
				+xpath+",Note:Able to get value of web element,Exception:NA";
			System.out.println(message);	
			logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:GetObjectText,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:failed to get value of web element,Exception:"+ex.getMessage();
			System.out.println(message);			
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"GetObjectToolTipText");
		return strText;
		
	}	

	public void NavigateToDefaultContent() throws IOException
	{
		try
		{
			driver.switchTo().defaultContent();
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:NavigateToDefaultContent,ParameterName:NA,ParameterValue:NA,Note:Able to navigate to default content,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch (Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:NavigateToDefaultContent,ParameterName:NA,ParameterValue:NA,Note:failed to maximize the navigate to default content,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"NavigateToDefaultContent");
		
	}

	
}
