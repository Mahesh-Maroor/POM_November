package HRM.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import HRM.Base.TestBase;

public class Utilityclass extends TestBase {
public static FileInputStream fin;
public static FileOutputStream fout;
public static XSSFWorkbook workbook;
public static XSSFSheet sheet;
public static XSSFCell cell;
public static int rows;
public static int columns;
public static String data;
	public Utilityclass() throws IOException {
		super();
	}
  public static String screenShot(String screenshotName) throws IOException
  {
	  TakesScreenshot screenshot=(TakesScreenshot)driver;
	  File source=screenshot.getScreenshotAs(OutputType.FILE);
	  String filePath=System.getProperty("user.dir")+"\\src\\main\\java\\HRM\\TestResults"+screenshotName+".jpg";
	  File destination=new File(System.getProperty("user.dir")+"\\src\\main\\java\\HRM\\TestResults"+screenshotName+".jpg");
	  FileUtils.copyFile(source,destination);
	  return filePath;
  }
  public static String[][] excelDataRead(String Filename,String sheetname)
  {
	  String[][] values=new String[3][3];
	  try {
		fin=new FileInputStream(Filename);
	   } 
	  catch (FileNotFoundException e)
	  {
		System.out.println(e);
	  }
	  try {
		workbook=new XSSFWorkbook(fin);
	} catch (IOException e) {
		System.out.println(e);
	}
	  sheet=workbook.getSheet(sheetname);
	  rows=sheet.getLastRowNum();
	  columns=sheet.getRow(0).getLastCellNum();
	  for(int i=1;i<=rows;i++)
	  {
		  for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
		  {
			  cell=sheet.getRow(i).getCell(j);
			  if(cell.getCellType()==cell.CELL_TYPE_STRING)
			  {
				  data=cell.getStringCellValue();
				  values[i-1][j]=data;
			  }
			  else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
			  {
				  double value=cell.getNumericCellValue();
				  data=String.valueOf(value);
				  values[i-1][j]=data;
			  }
		  }
	  }
	return values;
  }
  public static void writeInExcelFile(String fileName,String sheetName,String status)
  {
	  String columnName = null;
	  try {
			fin=new FileInputStream(fileName);
		   } 
		  catch (FileNotFoundException e)
		  {
			System.out.println(e);
		  }
		  try {
			workbook=new XSSFWorkbook(fin);
		} catch (IOException e) {
			System.out.println(e);
		}
		  sheet=workbook.getSheet(sheetName);
		  rows=sheet.getLastRowNum();
		  columns=sheet.getRow(0).getLastCellNum();
		  for(int j=0;j<columns;j++)
		  {
		  columnName=sheet.getRow(0).getCell(j).getStringCellValue();
		  }
		  if(columnName.equals("Result"))
		  {
			  for(int i=1;i<=rows;i++)
			  {
				  for(int j=0;j<columns;j++)
				  {
				  sheet.getRow(i).getCell(j).setCellValue(status);
			  }
		  }}
          }
  public static String photoPath(String fileName,String sheetName,String fileType)
  {
	  String filePath = null;
	  String[] value;
	  try {
			fin=new FileInputStream(fileName);
		   } 
		  catch (FileNotFoundException e)
		  {
			System.out.println(e);
		  }
		  try {
			workbook=new XSSFWorkbook(fin);
		} catch (IOException e) {
			System.out.println(e);
		}
		  sheet=workbook.getSheet(sheetName);
		  rows=sheet.getLastRowNum();
		  columns=sheet.getRow(0).getLastCellNum();
		  for(int j=0;j<columns;j++)
		  {
			  fileType=sheet.getRow(0).getCell(j).getStringCellValue();
		  }
		  if(fileType.equals("PhotoPath"))
		  {
			  for(int i=1;i<=rows;i++)
			  {
				  for(int j=0;j<columns;j++)
				  {
					  cell=sheet.getRow(i).getCell(j);
					  if(cell.getCellType()==cell.CELL_TYPE_STRING)
					  {
						  data=cell.getStringCellValue();
						value=data.split("#");
						filePath=value[1];
					  }
			  }
		  }}
	 return filePath;
	  
  }
  public static void uploadFile(String UploadFile)
  {
	  try {
		Runtime.getRuntime().exec(UploadFile);
	} catch (IOException e) {
		System.out.println(e);
	}
  }
  public static void extentReportInitialising()
  {
	  ExtentReports reports=new ExtentReports("C:\\Users\\Mahesh Maroor\\workspace\\November\\POM_Maven_November\\src\\main\\java\\HRM\\TestResults\\extentReports",true);
      reports.addSystemInfo("UserName", "Mahesh");
      reports.addSystemInfo("Environment", "QA");    
  }
  
          }
