package managers;

import org.openqa.selenium.WebDriver;

import utils.FileOperations;
import utils.Generic;
import utils.ScreenshotCapture;

public class UtilityManager {
 
    static UtilityManager  utilsManager;
	ScreenshotCapture screenshotCapture;
	Generic generic;
	FileOperations fileOperations;

	WebDriver driver;
	Long impicitwait;
	String screenshotPath;

 
 public UtilityManager(WebDriver driver) {
	 this.driver = driver;
	 this.impicitwait = FileReaderManager.getInstance().getConfigReader().getImplicitlyWait();
	 this.screenshotPath = FileReaderManager.getInstance().getConfigReader().getScreenShotFolder();
 }
 
 
 
 public static UtilityManager getInstance( ) {
	 if (utilsManager == null) 
	 {utilsManager  =  new UtilityManager(WebDriverManager.getDriver());}
	 return utilsManager;
}
 
 
 public ScreenshotCapture getScreenshotCapture()  {
	 return (screenshotCapture == null) ? screenshotCapture = new ScreenshotCapture(driver) : screenshotCapture;
 }

 public FileOperations getFileOperations()  {
	 return (fileOperations == null) ? fileOperations = new FileOperations() : fileOperations;
 }

 public Generic getGeneric()  {
	 return (generic == null) ? generic = new Generic(WebDriverManager.getDriver()) : generic;
 }

 
}