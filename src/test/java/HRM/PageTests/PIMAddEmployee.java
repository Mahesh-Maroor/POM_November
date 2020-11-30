package HRM.PageTests;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import HRM.Base.TestBase;
import HRM.Pages.LoginPage;
import HRM.Pages.PIMPageAddEmployee;
import HRM.Utilities.Utilityclass;

public class PIMAddEmployee extends TestBase {
	static LoginPage login;
@DataProvider(name="Add Employee")
public static String[][] employeeData()
{
	String data[][]=Utilityclass.excelDataRead(System.getProperty("user.dir")+"\\src\\main\\java\\HRM\\TestData\\AddEmployeeData.xlsx", "Sheet1");
    return data;
}
/*@Test(priority=0)
public static void loginTest()
{
	initializing();
	login=new LoginPage();
	login.login();
	login.loginPageLinks();
	
	
}*/
@Test(priority=1,dataProvider="Add Employee")
public static void addEmployee(String firstName,String lastName,String EmplId) throws InterruptedException
{
	test=reports.startTest("addEmploye");
	PIMPageAddEmployee p=new PIMPageAddEmployee();
	p.addEmployee(firstName, lastName, EmplId);
	System.out.println(firstName+" "+ lastName+" "+EmplId);
}
@AfterMethod
public static void results(ITestResult result)
{
	String screenshotPath = null;
	if(result.getStatus()==result.SUCCESS)
	{
		test.log(LogStatus.PASS, "Test case pass is:"+result.getName());
	}
	else if(result.getStatus()==result.FAILURE)
	{
		try {
			 screenshotPath=Utilityclass.screenShot(result.getName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL, "Test case failed is:"+result.getName()+" "+result.getThrowable()+" "+test.addScreenCapture(screenshotPath));
		test.log(LogStatus.FAIL, "Test case failed is:"+result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		
	}
	else if(result.getStatus()==result.SKIP)
	{
		test.log(LogStatus.SKIP, "Test case skipped is:"+result.getName());
	}
	reports.endTest(test);
	
}
}
