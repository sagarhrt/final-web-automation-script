package editor;

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

public class prodothercity {
	public static void main(String[] args) throws Exception {
		 System.setProperty("webdriver.chrome.driver", "E:\\softwares\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://prod.publicnext.com/user");
			WebElement email = driver.findElement(By.xpath("//*[@id=\"edit-name\"]"));
			email.sendKeys("sagar.hiremath");
			WebElement password = driver.findElement(By.xpath("//*[@id=\"edit-pass\"]"));
			password.sendKeys("sh@electreps");
			 Thread.sleep(1000);
			WebElement submit = driver.findElement(By.xpath("//*[@id=\"edit-submit\"]"));
			submit.click();
			//to access excel file 
			  FileInputStream fis = new FileInputStream("E:\\publicnext automation\\publicnextautoEXCEL\\publicnext.xlsx");
			    
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
			    XSSFSheet sheet = workbook.getSheet("City123");
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

					act.moveToElement(driver.findElement(By.xpath("//*[@id=\"admin-menu-menu\"]/li/ul/li[2]/a"))).click().perform();
					Thread.sleep(1000);
			
					
					String cityname = sheet.getRow(row).getCell(0).getStringCellValue();
					
					DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
					 XSSFCell cell = sheet.getRow(row).getCell(1);
					String weight= formatter.formatCellValue(cell);
		        
					WebElement city = driver.findElement(By.xpath("//*[@id=\"edit-title\"]"));
					city.sendKeys(sheet.getRow(row).getCell(0).getStringCellValue());
					System.out.println(cityname);
					
					WebElement citynumber = driver.findElement(By.xpath("//*[@id=\"edit-field-weight-und-0-value\"]"));
					citynumber.sendKeys(weight);
		        
					driver.findElement(By.xpath("//*[@id=\"edit-submit\"]")).click();
		        }
	}
}
