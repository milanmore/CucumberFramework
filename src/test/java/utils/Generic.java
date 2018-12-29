package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.FileReaderManager;

public class Generic {
	
	
	public int stepCounter = 0; 
	private static WebDriverWait wait;
	private WebDriver driver;

	public Generic(WebDriver driver)
	{
		this.driver = driver;
		setWebDriverWait();
	}
	
	public static WebDriverWait getWait() {
		return wait;
	}

	public void setWebDriverWait() {
		wait=new WebDriverWait(driver,FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
	}

	public WebElement GetRunTimeObject(String xPath)
	{
		return getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
		
	}
	
	public void setStepCounter()
	{
		stepCounter++;
	}


}
