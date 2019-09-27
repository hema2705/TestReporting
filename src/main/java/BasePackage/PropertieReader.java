package BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertieReader {



	static String cwd = System.getProperty("user.dir");
	public static String  filepath = cwd+"/src/main/resources/Utils/Runtime.properties";
	public static  String browser;
	public static  String url;
	public static Properties prop;
	public static FileInputStream inputstrm ;
	public PropertieReader() throws IOException
	{



	}

	public static void setRunnerProperty() throws IOException
	{
		System.out.println("In reader");

		String cwd = System.getProperty("user.dir");

		prop = new Properties();
		inputstrm = new FileInputStream(new File(filepath));
		prop.load(inputstrm);
		url = prop.getProperty("url");
		browser = prop.getProperty("browser");
		
		System.out.println(browser);
		System.out.println(url);

	}

	public static String getBrowser()
	{


		System.out.println(cwd);

		return browser;
	}

	public static String getUrl()
	{
		return url;
	}

	public static void flushFile()
	{

	}
}
