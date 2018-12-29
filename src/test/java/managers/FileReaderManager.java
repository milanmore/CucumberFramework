package managers;

import dataProviders.ConfigFileReader;
import dataProviders.FakeDataGenerator;
import dataProviders.XPathFileReader;

public class FileReaderManager {
 
 private static FileReaderManager fileReaderManager;
 private ConfigFileReader configFileReader;
 private XPathFileReader xPathReader;
 private FakeDataGenerator fakeDataGen;
 
 public static FileReaderManager getInstance( ) {
     return (fileReaderManager == null) ? new FileReaderManager() : fileReaderManager;
}
 public ConfigFileReader getConfigReader() {
 return (configFileReader == null) ? configFileReader= new ConfigFileReader() : configFileReader;
 }
 
 public XPathFileReader getXPathReader()  {
	 return (xPathReader == null) ? xPathReader= new XPathFileReader() : xPathReader;
 }	 
public FakeDataGenerator getFakeDataGenerator(){

	return (fakeDataGen == null) ? fakeDataGen = new FakeDataGenerator() : fakeDataGen;
	 
}

}