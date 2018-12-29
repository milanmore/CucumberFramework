package managers;

import org.openqa.selenium.WebDriver;

import WebOperations.*;
	 
public class OperationManager {
	 
 private static OperationManager opManager;
 static WebDriver driver;
 Browser browser;
 Button button;
 Dropdown dropdown;
 Frame frame;
 Label label;
 Link link;
 Textbox textbox;
 GenericObject obj;
 
 public OperationManager(WebDriver driver) {
	 OperationManager.driver = driver;
//	 FileReaderManager.getInstance().getConfigReader().getImplicitlyWait();
	 
 }
 
 public static OperationManager getInstance( ) {
     return (opManager == null) ? new OperationManager(WebDriverManager.getDriver()) : opManager;
}
 

 public Browser getBrowser(){
	 
	 return (browser == null) ? browser = new Browser(driver) : browser;
	 
	 }
	 
public Button getButton() {
	 
	 return (button == null) ? button = new Button(driver) : button;
	 
	 }

public Textbox getTextbox() {
	 
	 return (textbox == null) ? textbox = new Textbox(driver) : textbox;
	 
	 }

public Label getlabel() {
	 
	 return (label == null) ? label = new Label(driver) : label;
	 
	 }
public GenericObject getGenericObject() {
	 
	 return (obj == null) ? obj = new GenericObject(driver) : obj;
	 
	 }
public Link getLink() {
	 
	 return (link == null) ? link = new Link(driver) : link;
	 
	 }

public Dropdown getDropdown() {
	 
	 return (dropdown == null) ? dropdown = new Dropdown(driver) : dropdown;
	 
	 }

public Frame getFrame() {
	 
	 return (frame == null) ? frame = new Frame(driver) : frame;
	 
	 }

}