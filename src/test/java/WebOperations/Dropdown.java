package WebOperations;

import java.io.IOException;
import java.util.List;

import managers.FileReaderManager;
import managers.UtilityManager;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Generic;
import utils.ScreenshotCapture;
import dataProviders.ConfigFileReader;


public class Dropdown extends Generic{
	public Dropdown(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	final static Logger logger=Logger.getLogger(Dropdown.class);
	ConfigFileReader config = FileReaderManager.getInstance().getConfigReader();
	ScreenshotCapture scr = UtilityManager.getInstance().getScreenshotCapture();
	String message;
	
	

	public void SelectValueByValue(String xpath, String value) throws IOException	
	{
		try 
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			Select objdropdown= new Select(obj);
			objdropdown.selectByValue(value);
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:SelectValueByValue,ParameterName:xPath,ParameterValue:"
					+xpath+",ParameterName:InputValue,ParameterValue:"
					+value+",Note:Able to select item from dropdownby value,Exception:NA";
			System.out.println(message);
			logger.info(message);	
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:SelectValueByValue,ParameterName:xPath,ParameterValue:"
					+xpath+",ParameterName:InputValue,ParameterValue:"
					+value+",Note:failed to select item from dropdown by value ,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"SelectValueByValue");

	}			

	public void SelectValueByIndex(String xpath, int index) throws IOException	
	{
		try 
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			Select objdropdown= new Select(obj);
			objdropdown.selectByIndex(index);
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:SelectValueByValue,ParameterName:xPath,ParameterValue:"
					+xpath+",ParameterName:InputValue,ParameterValue:"
					+index+",Note:Able to select item from dropdown by index,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROr,StepNumber:"+super.stepCounter+",StepName:SelectValueByValue,ParameterName:xPath,ParameterValue:"
					+xpath+",ParameterName:InputValue,ParameterValue:"
					+index+",Note:failed to select item from dropdown by index,Exception:NA";
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"SelectValueByIndex");

	}
	public void SelectValueByVisibleText(String xpath,String value) throws IOException	
	{
		try 
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			Select objdropdown= new Select(obj);
			objdropdown.selectByVisibleText(value);
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:SelectValueByValue,ParameterName:xPath,ParameterValue:"
					+xpath+",ParameterName:InputValue,ParameterValue:"
					+value+",Note:Able to select item from dropdown by Visible text,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:SelectValueByValue,ParameterName:xPath,ParameterValue:"
					+xpath+",ParameterName:InputValue,ParameterValue:"
					+value+",Note:failed to select item from dropdown by visible text,Exception:NA";
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"SelectValueByVisibleText");

	}
	public String GetValueByIndex(String xpath, int index) throws IOException	
	{
		String strText = null;
		try 
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			Select objList = new Select(obj);
			List<WebElement> objList1 = objList.getOptions();
			WebElement option = objList1.get(index);
			strText = option.getText();
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:EnterValueInTextbox,ParameterName:xPath,ParameterValue:"
					+xpath+",ParameterName:Index,ParameterValue:"
					+index+",Note:Able to Get value by index from dropdown,Exception:NA";
			System.out.println(message);					
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:EnterValueInTextbox,ParameterName:xPath,ParameterValue:"
					+xpath+",ParameterName:Index,ParameterValue:"
					+index+",Note:failed to Get value by index from dropdown,Exception:"+ex.getMessage();
			System.out.println(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"GetValueByIndex");
		return strText; 
	}

	public String GetValueByVisibleText(String xpath,String value ) throws IOException	
	{
		String strText = null;
		try 
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			Select objdropdown= new Select(obj);
			objdropdown.selectByVisibleText(value);
			WebElement option = objdropdown.getFirstSelectedOption();
			strText = option.getText();
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
		scr.CaptureScreenshot((super.stepCounter)+"_"+"GetValueByVisibleText");
		return strText;
	}

	public int GetItemCount(String xpath) throws IOException	
	{
		int i = 0;
		try 
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			Select objList = new Select (obj);
			i = objList.getOptions().size();
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:GetItemCount,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:Able to get count of dropdown items,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:GetItemCount,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:failed to get count of dropdown items,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"GetItemCount");
		return i;
	}
	public List<WebElement> GetAllItems(String xpath) throws IOException
	{
		List<WebElement> loptions = null;
		try 
		{
			WebElement obj=super.GetRunTimeObject(xpath);
			Select objList = new Select (obj);
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:GetAllItems,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:Able to get all the items from dropdown,Exception:NA";
			System.out.println(message);
			loptions = objList.getOptions();
			logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:GetAllItems,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:failed to get all items from dropdown,Exception:"+ex.getMessage();
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"GetAllItems");
		return loptions;
	}
	

}
