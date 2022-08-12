import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Businessads {

	public static void main(String[] args) throws InterruptedException, IOException {
		 System.setProperty("webdriver.chrome.driver", "E:\\softwares\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://qa.electreps.com/user/login/");
			WebElement email = driver.findElement(By.xpath("//*[@id=\"edit-name\"]"));
			email.sendKeys("admin");
			WebElement password = driver.findElement(By.xpath("//*[@id=\"edit-pass\"]"));
			password.sendKeys("prodPNelectreps");
			 Thread.sleep(1000);
			WebElement submit = driver.findElement(By.xpath("//*[@id=\"edit-submit\"]"));
			submit.click();
			
	//to access excel file 
			  FileInputStream fis = new FileInputStream("E:\\publicnext automation\\publicnextautoEXCEL\\publicnext.xlsx");
			    @SuppressWarnings("resource")
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
			    XSSFSheet sheet = workbook.getSheet("Businessads");
			    //it will count total number of rows in excelsheet
			    int rowCount = sheet.getLastRowNum();
		        System.out.println("the no of rows are : " + rowCount);
		        
		        for (int row=1; row<=rowCount; row++)
		        {

		        	
					@SuppressWarnings("unused")
					String newstitle = sheet.getRow(row).getCell(0).getStringCellValue();//it will take 1st row of first cell value
					 String city= sheet.getRow(row).getCell(1).getStringCellValue();
			            String city1= sheet.getRow(row).getCell(2).getStringCellValue();
			            String city2= sheet.getRow(row).getCell(3).getStringCellValue();
			            String city3= sheet.getRow(row).getCell(4).getStringCellValue();
			            String notify= sheet.getRow(row).getCell(5).getStringCellValue();
			            String subject1= sheet.getRow(row).getCell(6).getStringCellValue();
			            String category= sheet.getRow(row).getCell(7).getStringCellValue();
			            String mobilenum= sheet.getRow(row).getCell(8).getStringCellValue();
			            DataFormatter df = new DataFormatter();
			            //String value = df.formatCellValue(mobilenum);
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
			            //select city from excel
			            String cityselect1="none";
			            switch(city1){       
			            case "Udupi": cityselect1="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-1\"]";  
			            break;    
			            case "Mangalore": cityselect1="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-2\"]";  
			            break; 
			            case "Hubballi-Dharwad": cityselect1="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-3\"]";  
			            break; 
			            case "Bangalore": cityselect1="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-4\"]";  
			            break; 
			            default: cityselect1="//*[@id=\"edit-field-city\"]/div";  
			            break;  
			            }     //select city from excel
			            String cityselect2="none";
			            switch(city2){       
			            case "Udupi": cityselect2="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-1\"]";  
			            break;    
			            case "Mangalore": cityselect2="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-2\"]";  
			            break; 
			            case "Hubballi-Dharwad": cityselect2="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-3\"]";  
			            break; 
			            case "Bangalore": cityselect2="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-4\"]";  
			            break; 
			            default: cityselect2="//*[@id=\"edit-field-city\"]/div";  
			            break;  
			            }     //select city from excel
			            String cityselect3="none";
			            switch(city3){       
			            case "Udupi": cityselect3="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-1\"]";  
			            break;    
			            case "Mangalore": cityselect3="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-2\"]";  
			            break; 
			            case "Hubballi-Dharwad": cityselect3="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-3\"]";  
			            break; 
			            case "Bangalore": cityselect3="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-4\"]";  
			            break; 
			            default: cityselect3="//*[@id=\"edit-field-city\"]/div";  
			            break;  
			            }  
			            //notification
			            String notification="none";
			            switch(notify){       
			            case "Yes": notification="//*[@id=\"edit-field-send-notification-und\"]";  
			            break;    
			            case "No": notification="/html/body";  
			            break; 
			            }
			          //select ads category from excel
			            String adscategory="none";
			            switch(category){       
			            case "Rentals": adscategory="//*[@id=\"edit-field-classified-category-und\"]/option[2]";  
			            break;    
			            case "Services": adscategory="//*[@id=\"edit-field-classified-category-und\"]/option[3]";  
			            break; 
			            case "Jobs": adscategory="//*[@id=\"edit-field-classified-category-und\"]/option[4]";  
			            break;  
			            }    
//selecting main menu after login to https://qa.electreps.com/
				Actions action = new Actions(driver);

				action.moveToElement(driver.findElement(By.xpath("//*[@id=\"admin-menu-menu\"]/li[1]/a"))).perform();
	//select add content menu
				Actions act = new Actions(driver);

				act.moveToElement(driver.findElement(By.xpath("//*[@id=\"admin-menu-menu\"]/li[1]/ul/li[1]/a"))).perform();
				Thread.sleep(1000);
	//select advertisement menu 
				Actions act1 = new Actions(driver);

				act1.moveToElement(driver.findElement(By.xpath("//*[@id=\"admin-menu-menu\"]/li[1]/ul/li[1]/ul/li[4]/a"))).click().perform();
			
	//ads description
				WebElement localsub = driver.findElement(By.xpath("//*[@id=\"edit-body-und-0-value\"]"));
				localsub.sendKeys(sheet.getRow(row).getCell(0).getStringCellValue());
				 System.out.println("1-description updated");
				Thread.sleep(1000);
				
	//select city
				driver.findElement(By.xpath("//*[@id=\"edit-field-city-und_ms\"]")).click();
				
				//selecting city
				driver.findElement(By.xpath(cityselect)).click();
				driver.findElement(By.xpath(cityselect1)).click();
				driver.findElement(By.xpath(cityselect2)).click();
				driver.findElement(By.xpath(cityselect3)).click();
				System.out.println("2-cities updated");
				
	//selecting city
				driver.findElement(By.xpath(notification)).click();
				System.out.println("3-notification updated");
	//ads subject
				WebElement subject = driver.findElement(By.xpath("//*[@id=\"edit-field-local-news-subject-und-0-value\"]"));
				subject.sendKeys(sheet.getRow(row).getCell(6).getStringCellValue());
				 System.out.println("4-Subject updated");
				Thread.sleep(1000);
	//selecting city
				driver.findElement(By.xpath(adscategory)).click();
				System.out.println("5-Ads Category updated");	
	//adding mobile number
				//driver.findElement(By.xpath("//*[@id=\"edit-field-phone-number-und-0-value\"]")).sendKeys(iTest);
				System.out.println("5-Ads Category updated");	
	}

}

}