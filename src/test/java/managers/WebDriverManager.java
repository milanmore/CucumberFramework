package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import enums.DriverType;

public class WebDriverManager {
	
	private static WebDriver driver;
	private static DriverType driverType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
	private static final String IE_DRIVER_PROPERTY="webdriver.ie.driver";
	private static String driverPath;
	public static long implicitwait;
	static WebDriverWait wait;

	public WebDriverManager() 
	
	{
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		driverPath = FileReaderManager.getInstance().getConfigReader().getDriverPath();
	}
	
	
	public WebDriverWait getWebDriverwait()
	{
		
		return wait;

		
	}
	

	public void setWebDriverwait(WebDriverWait webDriverWait)
	{
		
		wait = webDriverWait;
		
	}

	
	public static WebDriver getDriver() {
		if(driver==null)
			driver=createDriver();
		return driver;
	}

	
	@SuppressWarnings("deprecation")
	private static WebDriver createDriver() {
		switch(driverType) {
		case CHROME:
			System.setProperty(CHROME_DRIVER_PROPERTY, driverPath +"\\ChromeDriver.exe");
			driver=new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty(FIREFOX_DRIVER_PROPERTY, driverPath +"\\GeckoDriver.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities = DesiredCapabilities.firefox();
			capabilities.setBrowserName("firefox");
			 capabilities.setVersion("46.0.1");
			 capabilities.setPlatform(Platform.WINDOWS);
			 capabilities.setCapability("marionette", false);
			driver=new FirefoxDriver(capabilities);
			break;
		case INTERNETEXPLORER:
			System.setProperty(IE_DRIVER_PROPERTY, driverPath);
			driver=new InternetExplorerDriver();
			break;
		default:
			System.setProperty(FIREFOX_DRIVER_PROPERTY, driverPath +"\\GeckoDriver.exe");
			driver=new FirefoxDriver();
			break;
		}
		driver.manage().timeouts().implicitlyWait(implicitwait, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(implicitwait, TimeUnit.SECONDS);
		return driver;
	}
	

	public void closeBrowser() {
		driver.close();
		driver.quit();
	}


	public void quitDriver() {
		driver.close();
		driver.quit();
	}


	public static long getImplicitwait() {
		return implicitwait;
	}


	public void setImplicitwait(long implicitlywait) {
		implicitwait = implicitlywait;
	}
}
