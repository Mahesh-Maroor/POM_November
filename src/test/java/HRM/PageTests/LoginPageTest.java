package HRM.PageTests;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import HRM.Base.TestBase;
import HRM.Pages.LoginPage;

public class LoginPageTest extends TestBase
{
public static LoginPage login;

public LoginPageTest()
{
	super();
}
@BeforeSuite
public static void reporting()
{
	reports=new ExtentReports("C:\\Users\\Mahesh Maroor\\workspace\\November\\POM_Maven_November\\src\\main\\java\\HRM\\TestResults\\extentReports.html",true);
    reports.addSystemInfo("UserName", "Mahesh");
    reports.addSystemInfo("Environment", "QA");
}
@AfterSuite
public static void reportclose()
{
	reports.flush();
	reports.close();
}
@BeforeTest
public static void loginTest()
{
	initializing();
	login=new LoginPage();
	login.login();
	login.loginPageLinks();
	
	
}

}
