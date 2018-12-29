package utils;

	import java.io.File;
	import java.io.IOException;
	import org.apache.commons.io.FileUtils;

	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;

import managers.FileReaderManager;


	public class ScreenshotCapture {

	String SCREENSHOT_FOLDER;

	private WebDriver driver;

	public ScreenshotCapture(WebDriver driver) {
			this.driver = driver;
			SCREENSHOT_FOLDER = FileReaderManager.getInstance().getConfigReader().getScreenShotFolder();

	}

	public void CaptureScreenshot(String Screenname) throws IOException
		{
			if (FileReaderManager.getInstance().getConfigReader().Is_ScreenCapture_Enabled())
			{
				TakesScreenshot scrShot =((TakesScreenshot)driver);
				File srcFile=scrShot.getScreenshotAs(OutputType.FILE); 
				String FileName = SCREENSHOT_FOLDER +"//"+  Screenname + ".png"; 
				File destFile = new File(FileName);
				FileUtils.copyFile(srcFile, destFile);			
			}
		}
	}
	
	
