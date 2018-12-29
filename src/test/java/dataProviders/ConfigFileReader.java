package dataProviders;
 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;

import enums.DriverType;
 
public class ConfigFileReader {
 
private Properties properties;
private final String propertyFilePath= "src//test//resources//properties//Configuation.properties";

private static String SCREENSHOT_FOLDER;
private static String LOG_FOLDER;
private static String RESULT_FOLDER;
private String TESTDATA_LOCATION;
private String EXTENT_REPORT_NAME;
private String USER_NAME;
static Boolean IS_SCREEN_CAPTURE_ENABLED = false;


 public ConfigFileReader(){
	 
	 BufferedReader reader;
	 
//	 init();
	 try {
		 reader = new BufferedReader(new FileReader(propertyFilePath));
		 properties = new Properties();
		 try {
			 properties.load(reader);
			 reader.close();
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	 } catch (FileNotFoundException e) {
		 e.printStackTrace();
		 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	 } 
 }

 public String getDriverPath(){
 String driverPath = properties.getProperty("driverPath");
 driverPath = "src//test//resources//Drivers//";
 return driverPath; 
 }
 
 public long getPAGE_LOAD_TIMEOUT()
 {
	 String page_load_timeout = properties.getProperty("PAGE_LOAD_TIMEOUT");
	 
	 if(page_load_timeout != null) return Long.parseLong(page_load_timeout);
	 else throw new RuntimeException("PAGE_LOAD_TIMEOUT not specified in the Configuration.properties file."); 
	 
 }
 public long getImplicitlyWait() { 
 String implicitlyWait = properties.getProperty("implicitlyWait");
 
 if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
 else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file."); 
 }
 
 public String getApplicationUrl() {
 String url = properties.getProperty("url");
 if(url != null) return url;
 else throw new RuntimeException("url not specified in the Configuration.properties file.");
 }
 
public DriverType getBrowser() {
		String browser=properties.getProperty("browser");
		if(browser==null|| browser.equalsIgnoreCase("chrome"))
			return DriverType.CHROME;
		else if(browser.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if(browser.equalsIgnoreCase("internetexplorer"))
			return DriverType.INTERNETEXPLORER;
		else
			throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " +browser);
	}

public Boolean getBrowserWindowSize() {
	 String windowSize = properties.getProperty("windowMaximize");
	 if(windowSize != null) return Boolean.valueOf(windowSize);
	 return true;
	 }


public Boolean Is_ScreenCapture_Enabled(){
	 String status = properties.getProperty("IS_SCREEN_CAPTURE_ENABLED");
	 if(status!= null) return Boolean.valueOf(status);
	 else throw new RuntimeException("IS_SCREEN_CAPTURE_ENABLED not specified in the Configuration.properties file."); 
	}

public String getScreenShotFolder() {
	
	if(SCREENSHOT_FOLDER != null) return SCREENSHOT_FOLDER;
	else throw new RuntimeException("SCREENSHOT_FOLDER not specified in the Configuration.properties file.");
}


private Boolean Is_LOG_Enabled(){
	 String status = properties.getProperty("IS_LOG_ENABLED");
	 if(status!= null) return Boolean.valueOf(status);
	 else throw new RuntimeException("IS_LOG_ENABLED not specified in the Configuration.properties file."); 
	 }

public String getLogFolder(){
	 if(LOG_FOLDER!= null) return LOG_FOLDER;
	 else throw new RuntimeException("LOG_FOLDER not specified in the Configuration.properties file."); 
	 }

public String getReportConfigPath(){
	String reportConfigPath = properties.getProperty("reportConfigPath");
	if(reportConfigPath!= null) return reportConfigPath;
	else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
}

public String getResultFolder() {
	 if(RESULT_FOLDER!= null) return RESULT_FOLDER;
	 else throw new RuntimeException("RESULT_FOLDER not specified in the Configuration.properties file."); 
}

public String getExtentReportName() {
	 if(EXTENT_REPORT_NAME!= null) return EXTENT_REPORT_NAME;
	 else throw new RuntimeException("EXTENT_REPORT_NAME not specified in the Configuration.properties file."); 
}

public String getUserName() {
	
	 USER_NAME = properties.getProperty("USER_NAME");	
	 if(USER_NAME!= null) return USER_NAME;
	 else throw new RuntimeException("USER_NAME not specified in the Configuration.properties file."); 

}

public void init()
 {
	 try
	 {		
		String ROOT_FOLDER_PATH = System.getProperty("user.dir")+"\\output";
		String strdate = utils.FileOperations.GetCurrentDateAsPerGivenFormat("ddMMMyyyy_HHmmss");
			
		utils.FileOperations.CreateChildFolders(System.getProperty("user.dir")+"\\output", strdate);
		String parentfolder = ROOT_FOLDER_PATH + "\\" + strdate;
		utils.FileOperations.CreateChildFolders(parentfolder, "LOG");
		utils.FileOperations.CreateChildFolders(parentfolder, "SCREENSHOT");
		utils.FileOperations.CreateChildFolders(parentfolder, "RESULT");
		
		SCREENSHOT_FOLDER=parentfolder+"\\"+"SCREENSHOT";
		
		LOG_FOLDER=parentfolder+"\\"+"LOG";
		SetLogFileName();		

		RESULT_FOLDER=parentfolder + "\\" + "RESULT";
		TESTDATA_LOCATION = properties.getProperty("TESTDATA_LOCATION");		
		EXTENT_REPORT_NAME= RESULT_FOLDER + "\\report_" + strdate + ".html";
		
	 }
	 catch (Exception ex)
		{
			System.out.println("Error in initializing parameters");
		}
	 }

public String getTestdataFolder(){
	 if (!TESTDATA_LOCATION.equals(null))
		{return TESTDATA_LOCATION;}
	 else throw new RuntimeException("TESTDATA_FOLDER not specified in the Configuration.properties file."); 
}

private void SetLogFileName() {

		System.setProperty("logfile.name", LOG_FOLDER+"\\Log4j-application.log");
		if (!Is_LOG_Enabled())
		{	LogManager.getRootLogger().setLevel(Level.OFF);}
	 
}







}