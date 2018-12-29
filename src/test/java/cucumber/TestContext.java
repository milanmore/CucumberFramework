package cucumber;
 
import managers.FileReaderManager;
import managers.OperationManager;
import managers.PageObjectManager;
import managers.UtilityManager;
import managers.WebDriverManager;
 
public class TestContext {
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	public  ScenarioContext scenarioContext;
	private FileReaderManager fileReaderManager;
	private OperationManager operationManager;
	private UtilityManager utilityManager;
	

	public TestContext(){
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(WebDriverManager.getDriver());
		fileReaderManager = new FileReaderManager();
		FileReaderManager.getInstance().getConfigReader().init();
		utilityManager = new UtilityManager(WebDriverManager.getDriver());
		operationManager = new OperationManager(WebDriverManager.getDriver());
		scenarioContext = new ScenarioContext();
	}
	
	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public FileReaderManager getFileReaderManager() {
		return fileReaderManager;
	}
	
	public OperationManager getOperationManager() {
		return operationManager;
	}
	
	public UtilityManager getUtilityManager() {
		return utilityManager;
	}

	
	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}
	
	
 
}