package HRM.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import HRM.Utilities.WebEventListener;


public class TestBase 
{
	public static Properties prop;
	public static FileInputStream fin;
	public static WebDriver driver;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static ExtentTest test;
	public static ExtentReports reports;
	public TestBase() 
	{
		prop=new Properties();
	    try {
			fin=new FileInputStream("C:\\Users\\Mahesh Maroor\\workspace\\November\\POM_Maven_November\\src\\main\\java\\HRM\\Configurations\\Config.properties");
			prop.load(fin);
		} 
	    catch (IOException e) 
	    {

			e.printStackTrace();
		}
	}
public static void initializing()
{
	String browserName=prop.getProperty("Browser");
	System.out.println(browserName);
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	else if(prop.getProperty("Browser").equals("FireFox"))
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	e_driver = new EventFiringWebDriver(driver);
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
   
    driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.get(prop.getProperty("Url"));
}

}

