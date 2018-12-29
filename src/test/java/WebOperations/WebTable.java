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

public class WebTable extends Generic {
	
	public WebTable(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	final static Logger logger=Logger.getLogger(WebTable.class);
	ConfigFileReader config = FileReaderManager.getInstance().getConfigReader();
	ScreenshotCapture scr = UtilityManager.getInstance().getScreenshotCapture();
	String message;
	
	
	public int GetRowCount(String xpath) throws IOException	
	{
//		int rowcount = 0;
		try 
		{
//			AnyObject opObj = new AnyObject();
//			List<WebElement> rows = opObj.GetSpecificChildObjects(xpath);
//			rowcount = rows.size();
			
			message="Status:PASS,StepNumber:"+(super.stepCounter)+",StepName:GetRowCount,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:Able to get row count for the table,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:GetRowCount,ParameterName:xPath,ParameterValue:"
					+xpath+"Note:failed to get row count of the table,Exception:NA";
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"GetRowCount");
		return 0;
		
	}
	
	public int GetColumnCount(String xpath,int RowIndex) throws IOException	
	{
		try 
		{
	
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:GetColumnCount,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:Able to get column count for the table,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:GetColumnCount,ParameterName:xPath,ParameterValue:"
					+xpath+"Note:failed to get column count of the table,Exception:NA";
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"GetColumnCount");

		return 0;
		
	}
	public String GetTextOfCell(String xpath, int RowIndex, int ColumnIndex) throws IOException	
	{
		String cellvalue = null;
		try 
		{
			WebElement oo = super.GetRunTimeObject("//*[@class='datagrid-btable']//tr[2]//td[2]");
			cellvalue =  oo.getText();
			message="Status:PASS,StepNumber:"+super.stepCounter+",StepName:GetTextOfCell,ParameterName:xPath,ParameterValue:"
					+xpath+",Note:Able to get value of cell from the table,Exception:NA";
			System.out.println(message);
			logger.info(message);
		}
		catch(Exception ex)
		{
			message="Status:ERROR,StepNumber:"+super.stepCounter+",StepName:GetTextOfCell,ParameterName:xPath,ParameterValue:"
					+xpath+"Note:failed to get value of cell from the table,Exception:NA";
			System.out.println(message);
			logger.error(message);
		}
		scr.CaptureScreenshot((super.stepCounter)+"_"+"GetTextOfCell");
		return cellvalue;		
	}
}
