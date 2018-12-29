package runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/resources/features/login.feature",
 glue= {"stepDefinitions"},
 plugin = { "pretty", "json:output/cucumber-reports/Cucumber.json",
				 "junit:output/cucumber-reports/Cucumber.xml",
				 "html:output/cucumber-reports",
 				"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
 monochrome = true 
 
 )


public class ExtentRunner {

    @AfterClass
    public static void setup() {
        Reporter.loadXMLConfig(new File("extent-config.xml"));
        Reporter.setSystemInfo("user", "Milan");
        Reporter.setTestRunnerOutput("Extend Report in Cucumber framework");
    }
	
	
	
	
}
