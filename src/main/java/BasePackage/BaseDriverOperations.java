package BasePackage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BaseDriverOperations  {

	public WebDriver d ;
	static String browser;
	public BaseDriverOperations() throws Exception
	{
		getOSTypeDriver();
		InitiateDriver_Browser();
	}



	public void InitiateDriver_Browser() throws IOException
	{
		String browser = PropertieReader.getBrowser();
		if(browser.equalsIgnoreCase("ChromeBrowser"))
		{

			d  = new ChromeDriver();

		}
		else if (browser.equalsIgnoreCase("FireFox"))
		{
			d  = new FirefoxDriver();

		}
		else if(browser.equalsIgnoreCase("InternetExplorer"))
		{
			d  = new InternetExplorerDriver();

		}

		//d.manage().window().fullscreen();

	}

	public  void getOSTypeDriver()
	{
		String cwd = System.getProperty("user.dir");

		String OS = System.getProperty("os.name").toLowerCase();
		if (OS.indexOf("win") >= 0) {
			String  filepath = cwd+"/src/main/resources/Utils/Drives/chromedriver.exe";

			System.setProperty("webdriver.chrome.driver", filepath);
			System.setProperty("org.uncommons.reportng.escape-output", "false");

			System.out.println("This is Windows");
		} else if (OS.indexOf("mac") >= 0) {
			String  filepath = cwd+"/src/main/resources/Utils/Drives/chromedriver";

			System.setProperty("webdriver.chrome.driver", filepath);
			System.setProperty("org.uncommons.reportng.escape-output", "false");

			System.out.println("This is Mac");
		}else {
			System.out.println("Your OS is not support!!");
		}

	}


	public void browserClose()
	{
		d.close();
	}

	public void browserquit()
	{
		d.quit();
	}
	public void LauchURL()
	{
		String home = PropertieReader.getUrl();
		d.get(home);

	}
	public void ClickButton(By ele)
	{
		try{
			d.findElement(ele).click();
		}
		catch(NoSuchElementException e)
		{

		}
		
		
	}

	public void SendTheText(By ele,String val)
	{

		try{
			d.findElement(ele).clear();
			d.findElement(ele).sendKeys(val);
		}
		catch(NoSuchElementException e)
		{

		}

	}



	public void verifyElemtPresent(By ele)
	{
		try
		{
			waitOption(ele);
			d.findElement(ele);
		}
		catch(NoSuchElementException e)
		{

		}
	}
	
	public void refreshPage()
	{
		
			d.navigate().refresh();
		
		
	}
	public TreeSet<String> VerifyLinksPresentandGettext(By loc)
	{

		waitOptionlist(loc);
		List<WebElement> leftlinks = d.findElements(loc);
		TreeSet<String> actvals = new TreeSet<>();


		for(int i=0;i<leftlinks.size();i++)
		{
			String s = leftlinks.get(i).getText();
			if(!s.equals(""))
			{
				actvals.add(s);
				System.out.println(s);
			}

		}

		return actvals;


	}

	public void waitOption(By loc)
	{
		WebDriverWait wait = new WebDriverWait(d, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(loc));

	}

	public void waitUntilTitleExpected(String title)
	{
		WebDriverWait wait = new WebDriverWait(d, 10);
		wait.until(ExpectedConditions.titleContains(title));
	}


	public void waitOptionlist(By loc)
	{
		WebDriverWait wait = new WebDriverWait(d, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(loc));

	}
	public void MoveToElement(By ele)
	{
		try{
			Actions ac = new Actions(d);
			ac.moveToElement(d.findElement(ele));
		}
		catch(NoSuchElementException e)
		{

		}
	}


	public TreeSet<String> verifyValuesInDDByValue( By sel )
	{
		waitOption(sel);
		Select s = new Select(d.findElement(sel));
		List<WebElement> eles = s.getOptions();
		TreeSet<String> actval = new TreeSet<>();
		for(int i = 0;i<eles.size();i++)
		{
			//String act = eles.get(i).getAttribute("text");
			String act = eles.get(i).getAttribute("value");

			actval.add(act);
		}


		return actval;

	}

	public TreeSet<String> verifyValuesInDDByVisibleText( By sel )
	{
		waitOption(sel);
		Select s = new Select(d.findElement(sel));
		List<WebElement> eles = s.getOptions();
		TreeSet<String> actval = new TreeSet<>();
		for(int i = 0;i<eles.size();i++)
		{
			String act = eles.get(i).getAttribute("text");

			actval.add(act);
		}


		return actval;

	}


	public String getCurrentTitle(String title)
	{
		waitUntilTitleExpected(title);
		try{
			String s = 		d.getTitle();
			return s;
		}
		catch(WebDriverException e)
		{
			return null;

		}
	}


	public String getCurrentURL()
	{
		String s = d.getCurrentUrl();
		return s;

	}




	public void selecfromDropDisple(By sel_selProduct, String value) {
		waitOption(sel_selProduct);
		Select s = new Select(d.findElement(sel_selProduct));

		s.selectByVisibleText(value);
	}


	public List<WebElement> getAllElemnts(By loc)
	{
		waitOptionlist(loc);
		List<WebElement> allElemts = d.findElements(loc);
		return allElemts;
	}

	public String getElementAttribute(String attr , By loc) throws NoSuchElementException 
	{
		waitOption(loc);
		return d.findElement(loc).getAttribute(attr);
	}

	
	public String getElementtext( By loc) throws NoSuchElementException 
	{
		waitOption(loc);
		return d.findElement(loc).getText();
	}

	public void getCurrentScreenshot() throws IOException
	{
		String cwd = System.getProperty("user.dir");
		

		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File(cwd+"//ScreenShots//"+timeStamp+".png");
		FileUtils.copyFile(scrFile, screenShotName);

		String filePath = screenShotName.toString();

		String path  = "<img src=\"file:///"+filePath+"\">";
		Reporter.log(path);

	}

}
