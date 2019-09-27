package HelloFeature;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import BasePackage.BaseDriverOperations;
import BasePackage.Reporter;


@RunWith(Cucumber.class)

@CucumberOptions(plugin = "pretty", features = "src/test/resources/HelloFeature"

		)
public class RunCucumberTest  {
	static Reporter rpt;
	@BeforeClass
	public static void setup() throws Exception {
		Reporter.initiate();  
		
		
	}
	@AfterClass
	public static void writeExtentReport() {
		Reporter.flushAll();
	}
}

