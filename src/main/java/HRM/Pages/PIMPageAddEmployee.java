package HRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HRM.Base.TestBase;
import HRM.Utilities.Utilityclass;

public class PIMPageAddEmployee extends TestBase
{
@FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
public static WebElement pimMenu;

@FindBy(xpath="//a[@id='menu_pim_addEmployee']")
public static WebElement addEmployee;

@FindBy(xpath="//input[@name='firstName']")
public static WebElement firstname;

@FindBy(xpath="//input[@name='lastName']")
public static WebElement lastname;

@FindBy(xpath="//input[@name='employeeId']")
public static WebElement empID;

@FindBy(xpath="//input[@name='photofile']")
public static WebElement photoUploading;

@FindBy(xpath="//input[@id='btnSave']")
public static WebElement saveBtn;


public PIMPageAddEmployee()
{
	PageFactory.initElements(driver, this);
}

public static void addEmployee(String firstName,String lastName,String employeeID) throws InterruptedException
{
	Thread.sleep(2000);
	pimMenu.click();
	addEmployee.click();
	firstname.sendKeys(firstName);
	lastname.sendKeys(lastName);
	Thread.sleep(2000);
	empID.clear();
	empID.sendKeys(employeeID);
	//String [] Abspath=photoUpload.split("#");
	Thread.sleep(3000);
//	photoUploading.click();
//	Thread.sleep(3000);
//	Utilityclass.uploadFile(Abspath[1]);
	//Thread.sleep(3000);
    saveBtn.click();
	Thread.sleep(3000);
	pimMenu.click();
	addEmployee.click();
}
}
