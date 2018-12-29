package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.CreateCompanyPage;
import pageObjects.LoginPage;
 
import pageObjects.HomePage;
 
 
 
public class PageObjectManager {
 
 private WebDriver driver;
 
 private LoginPage loginPage;
 
 private CreateCompanyPage createCompanyPage;
 
 private HomePage homePage;
 
 
 public PageObjectManager(WebDriver driver) {
 
 this.driver = driver;
 
 }
 
 public HomePage getHomePage(){
 
 return (homePage == null) ? homePage = new HomePage(driver) : homePage;
 
 }
 
 public LoginPage getLoginPage() {
 
 return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
 
 }
 
 public CreateCompanyPage getcreateCompanyPage() {
 
 return (createCompanyPage == null) ? createCompanyPage = new CreateCompanyPage(driver) : createCompanyPage;
 
 }
 
 
}
