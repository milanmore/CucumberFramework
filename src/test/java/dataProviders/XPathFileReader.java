package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class XPathFileReader {
	private final String propertyFilePath= "src//test//resources//properties//ObjectRepo.properties";
	private Properties properties;
	
	public XPathFileReader()
	{
		 BufferedReader reader;
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
		 throw new RuntimeException("ObjectRepo.properties not found at " + propertyFilePath);
		 }
	 }
	 
	 public By getObjectLocator(String locatorName)
	 {
	 String locatorProperty = properties.getProperty(locatorName);
	 
	 System.out.println(locatorProperty.toString());
	 String locatorType = locatorProperty.split(":")[0];
	 String locatorValue = locatorProperty.split(":")[1];
	 
	 By locator = null;
	 switch(locatorType) 
	 {
	 case "Id":
	 locator = By.id(locatorValue);
	 break;
	 case "Name":
	 locator = By.name(locatorValue);
	 break;
	 case "CssSelector":
	 locator = By.cssSelector(locatorValue);
	 break;
	 case "LinkText":
	 locator = By.linkText(locatorValue);
	 break;
	 case "PartialLinkText":
	 locator = By.partialLinkText(locatorValue);
	 break;
	 case "TagName":
	 locator = By.tagName(locatorValue);
	 break;
	 case "Xpath":
	 locator = By.xpath(locatorValue);
	 break;
	 }
	 return locator;
	 }
	 
	 public String getXPathValue(String locatorName)
	 {
	 String locatorProperty = properties.getProperty(locatorName);
	 //System.out.println(locatorProperty.toString());
	 /*String locatorType = locatorProperty.split(":")[0];
	 String locatorValue = locatorProperty.split(":")[1];

	 if (locatorType.equalsIgnoreCase("XPath"))
		 return locatorValue;
	 else
		 return null;
*/
	 System.out.println(locatorName);
	 System.out.println(locatorProperty);
	 return locatorProperty;	 
	 } 	 
	 
}
	
