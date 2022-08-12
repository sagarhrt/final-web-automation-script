package test;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.collect.Table.Cell;

public class latlongcities {

	public static void main(String[] args) throws Exception {
		 System.setProperty("webdriver.chrome.driver", "E:\\softwares\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://qa.electreps.com/user/login");
			WebElement email = driver.findElement(By.xpath("//*[@id=\"edit-name\"]"));
			email.sendKeys("admin");
			WebElement password = driver.findElement(By.xpath("//*[@id=\"edit-pass\"]"));
			password.sendKeys("prodPNelectreps");
			 Thread.sleep(1000);
			WebElement submit = driver.findElement(By.xpath("//*[@id=\"edit-submit\"]"));
			submit.click();
			//to access excel file 
			  FileInputStream fis = new FileInputStream("E:\\publicnext automation\\publicnextautoEXCEL\\publicnext.xlsx");
			    
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
			    XSSFSheet sheet = workbook.getSheet("Sheet1");
			    //it will count total number of rows in excelsheet
			    int rowCount = sheet.getLastRowNum();
		        System.out.println("the no of rows are : " + rowCount);
		      //for loop for run all row testcases
 
		        for (int row=1; row<=rowCount; row++)
		        {
					Actions action = new Actions(driver);

					action.moveToElement(driver.findElement(By.xpath("//*[@id=\"admin-menu-menu\"]/li[1]"))).perform();
	//select add content menu//
					Actions act = new Actions(driver);

					act.moveToElement(driver.findElement(By.xpath("//*[@id=\"admin-menu-menu\"]/li[1]/ul/li[1]/a"))).perform();
					Thread.sleep(1000);
	//select local news menu 
					Actions act1 = new Actions(driver);

					act1.moveToElement(driver.findElement(By.xpath("//*[@id=\"admin-menu-menu\"]/li[1]/ul/li[1]/ul/li[16]/a"))).click().perform(); 
		        	
					 String location = sheet.getRow(row).getCell(1).getStringCellValue();//it will take 1st row of first cell value
					 //number fields(cells) in excel
					 DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
					 XSSFCell cell = sheet.getRow(row).getCell(2);
					 String lat = formatter.formatCellValue(cell);
					 
					 XSSFCell cell1 = sheet.getRow(row).getCell(3);
					 String lng = formatter.formatCellValue(cell1);
					 
					 String city= sheet.getRow(row).getCell(4).getStringCellValue();
					 //String lat = sheet.getRow(row).getCell(2).getStringCellValue(); 
					//double lng= sheet.getRow(row).getCell(3).getNumericCellValue();
		          //selecting main menu after login to https://qa.electreps.com/
					 
					//select city cellvalue from excel
			            String cityselect="none";
			            switch(city){       
			            case "Udupi": cityselect="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-1\"]";  
			            break;    
			            case "Mangalore": cityselect="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-2\"]";  
			            break; 
			            case "Hubballi-Dharwad": cityselect="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-3\"]";  
			            break; 
			            case "Bangalore": cityselect="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-4\"]";  
			            break; 
			            default: cityselect="//*[@id=\"edit-field-city\"]/div";  
			            break;  
			            }    
					 
  
					
					
					
					WebElement locations = driver.findElement(By.xpath("//*[@id=\"edit-title\"]"));
					locations.sendKeys(sheet.getRow(row).getCell(1).getStringCellValue());
					
					
					WebElement lats = driver.findElement(By.xpath("//*[@id=\"edit-field-location-coordinates-und-0-geom-lat\"]"));
					lats.sendKeys(lat);
					
					WebElement lngs = driver.findElement(By.xpath("//*[@id=\"edit-field-location-coordinates-und-0-geom-lon\"]"));
					lngs.sendKeys(lng);
					
					driver.findElement(By.xpath(cityselect)).click();
					System.out.println(location); System.out.println(cityselect); 
					
					driver.findElement(By.xpath("//*[@id=\"edit-submit\"]")).click();
	}

}
}