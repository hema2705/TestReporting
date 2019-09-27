package BasePackage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentBDDReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentTabularReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReporter;

public class Reporter {
	// ExtentBDDReporter bdd;
	static ExtentHtmlReporter html;
	static ExtentReports extent;
	static ExtentTest test;
	public Reporter()
	{


	}


	public static void initiate()
	{
		File fp = new File("Test11.html");
		html = new ExtentHtmlReporter(fp);

		extent = new ExtentReports();
		extent.attachReporter(html);
		html.setAnalysisStrategy(AnalysisStrategy.BDD);
		html.loadXMLConfig("/Users/hema/Documents/workspace/TestFramework/src/main/java/BasePackage/configbdd.xml");
		test = extent.createTest("TestName");

	}

	public static void flushAll()
	{

		extent.flush();


	}

	public static void scenarionameStarted(String s)
	{
		test.info("Scenario started" + s);

	}
	public static void scenarionameEnded(String s)
	{
		test.info("Scenario Ended" + s);

	}
	public static void testStepResult(String screenshotPath , boolean result) throws IOException
	{
		System.out.println("in result");
		if(result)
		{
			System.out.println("in result pas");
			
			test.log(Status.PASS, "test pass", MediaEntityBuilder.createScreenCaptureFromPath("/Users/hema/Documents/workspace/TestFramework/target/Screenshot/download.png ").build());
		}
		else
		{
			System.out.println("in result fail");

			test.log(Status.FAIL, "test fail", MediaEntityBuilder.createScreenCaptureFromPath("/Users/hema/Documents/workspace/TestFramework/target/Screenshot/download.png ").build());
		}
	}
}
