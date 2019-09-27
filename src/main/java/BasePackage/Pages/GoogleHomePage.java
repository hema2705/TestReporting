package BasePackage.Pages;
import org.openqa.selenium.By;

import BasePackage.BaseDriverOperations;

public class GoogleHomePage extends BaseDriverOperations  {
	
	public GoogleHomePage() throws Exception {
		super();
	}

	By txt_field;
	

	private void initElemnts() {
		txt_field = By.name("q");
	
	}
	
	public void enterTheString()
	{
		d.findElement(txt_field).sendKeys("I am testing");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String VerifyTitle(String exptitle)
	{
		return d.getCurrentUrl();
	}
}
