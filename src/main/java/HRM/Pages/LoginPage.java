package HRM.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import HRM.Base.TestBase;

public class LoginPage extends TestBase
{
@FindBy(xpath="//input[@id='txtUsername']")
public static WebElement UserNameField;

@FindBy(xpath="//input[@id='txtPassword']")
public static WebElement PasswordField;

@FindBy(xpath="//input[@id='btnLogin']")
public static WebElement loginButton;

@FindBys(@FindBy(tagName="a"))
public static List<WebElement> links;
public LoginPage()
{
	PageFactory.initElements(driver, this);
}

public static void login()
{
	UserNameField.sendKeys(prop.getProperty("Username"));
	PasswordField.sendKeys(prop.getProperty("Password"));
	loginButton.click();
}
public static void loginPageLinks()
{
	System.out.println(links.size());
}
}
