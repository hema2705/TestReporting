package HelloFeature;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import BasePackage.BaseDriverOperations;
import BasePackage.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.runtime.StepDefinition;
import junit.framework.TestResult;

public class InitiAllHooks {
	@Before
	public void doSomethingBefore(Scenario s) throws Exception {
	    //BaseDriverOperations m = new BaseDriverOperations();

		Reporter.scenarionameStarted(s.getName());		

	}

	@Before
	public void beforeStep(Scenario s)
	{
	
	}


	@AfterStep
	public void doSomethingAfterStep(Scenario s) throws IOException{

		
		if(s.isFailed())
		{
			System.out.println("After step defination scenario failed");
			Reporter.testStepResult("path", false);		
			}
		else
		{
			// take screen shot faled at step for the scenario 
			System.out.println("After step defination pass");
			System.out.println("After step defination scenario failed");
			Reporter.testStepResult("path", true);	
		}
	}

	@After
	public void doSomethingAfter(Scenario s ){
		Reporter.scenarionameEnded(s.getName());	

	}


}
