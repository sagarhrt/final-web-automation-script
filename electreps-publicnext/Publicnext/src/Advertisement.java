import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Advertisement {

	public static void main(String[] args) throws Exception {
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
			  
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
			    XSSFSheet sheet = workbook.getSheet("Advertisement");
			    //it will count total number of rows in excelsheet
			    int rowCount = sheet.getLastRowNum();
		        System.out.println("the no of rows are : " + rowCount);
		      
		        for (int row=1; row<=rowCount; row++)
		        {

		        	
					@SuppressWarnings("unused")
					String newstitle = sheet.getRow(row).getCell(0).getStringCellValue();//it will take 1st row of first cell value
					 String location= sheet.getRow(row).getCell(1).getStringCellValue();
					    String city= sheet.getRow(row).getCell(2).getStringCellValue();
			            String city1= sheet.getRow(row).getCell(3).getStringCellValue();
			            String city2= sheet.getRow(row).getCell(4).getStringCellValue();
			            String image=sheet.getRow(row).getCell(8).getStringCellValue();
			            String video=sheet.getRow(row).getCell(9).getStringCellValue();
			            //String url= sheet.getRow(row).getCell(5).getStringCellValue();
			            @SuppressWarnings("unused")
						Date date1= sheet.getRow(row).getCell(6).getDateCellValue();
			            DateFormat df = new SimpleDateFormat();
			            String asd=df.format(date1);
			           // String date2= sheet.getRow(row).getCell(7).getStringCellValue();
			            
	//select Location from excel
		            String adslocation="none";
		            switch(location){       
		            case "0-AustinBand": adslocation="//*[@id=\"edit-field-advertisement-location-und\"]/option[2]";  
		            break;    
		            case "1-HomeAdvertisement": adslocation="//*[@id=\"edit-field-advertisement-location-und\"]/option[3]";  
		            break; 
		            case "4-HomeAdvertisement": adslocation="//*[@id=\"edit-field-advertisement-location-und\"]/option[4]";  
		            break; 
		            case "7-HomeAdvertisement": adslocation="//*[@id=\"edit-field-advertisement-location-und\"]/option[5]";  
		            break; 
		            case "1-DetailedAdvertisement": adslocation="//*[@id=\"edit-field-advertisement-location-und\"]/option[6]";  
		            break; 
		            case "2-DetailedAdvertisement": adslocation="//*[@id=\"edit-field-advertisement-location-und\"]/option[7]";  
		            break; 
		             
		            }    
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
		            default: cityselect="//*[@id=\"edit-field-city-und_ms\"]";  
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
		            default: cityselect1="//*[@id=\"edit-field-city-und_ms\"]";  
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
		            default: cityselect2="//*[@id=\"edit-field-city-und_ms\"]";  
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

			act1.moveToElement(driver.findElement(By.xpath("//*[@id=\"admin-menu-menu\"]/li[1]/ul/li[1]/ul/li[1]/a"))).click().perform();
		
//news subject name
			WebElement localsub = driver.findElement(By.xpath("//*[@id=\"edit-title\"]"));
			localsub.sendKeys(sheet.getRow(row).getCell(0).getStringCellValue());
			 System.out.println(",,,,,,,,,");
			 System.out.println("..............");
			Thread.sleep(1000);
//select advertisement location
			driver.findElement(By.xpath("//*[@id=\"edit-field-advertisement-location-und\"]")).click();
			driver.findElement(By.xpath(adslocation)).click();
//selecting city
			driver.findElement(By.xpath("//*[@id=\"edit-field-city-und_ms\"]")).click();
			driver.findElement(By.xpath(cityselect)).click();
			driver.findElement(By.xpath(cityselect1)).click();
			driver.findElement(By.xpath(cityselect2)).click();
/* //from date
			driver.findElement(By.xpath("//*[@id=\"edit-field-event-start-date-und-0-value-datepicker-popup-0\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"edit-field-event-start-date-und-0-value-datepicker-popup-0\"]")).sendKeys(asd);*/
		
//page scroll down 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,650)", "");
//image UPLOADING ....
			Thread.sleep(1000);
			   WebElement image1 = driver.findElement(By.xpath("//*[@id=\"edit-field-capture-image-for-idea-exp-und-0-upload\"]"));
			   //click on ‘Choose file’ to upload the desired file
			   image1.sendKeys(sheet.getRow(row).getCell(8).getStringCellValue()); //Uploading the file using sendKeys
			   System.out.println("image is Uploaded Successfully");
			   //clicking uploading button
			   WebElement upload = driver.findElement(By.xpath("//*[@id=\"edit-field-capture-image-for-idea-exp-und-0-upload-button\"]"));
			   upload.click();
			   Thread.sleep(2000);
// video UPLOADING ....
				 
			   WebElement video1 = driver.findElement(By.xpath("//*[@id=\"edit-field-video-und-0-upload\"]"));
			   //click on ‘Choose file’ to upload the desired file
			   video1.sendKeys(sheet.getRow(row).getCell(9).getStringCellValue()); //Uploading the video file using sendKeys
			   driver.findElement(By.xpath("//*[@id=\"edit-field-video-und-0-upload-button\"]")).click();
			   System.out.println("video is Uploaded Successfully");
			   Thread.sleep(2000);
			  
			   //submit
			   driver.findElement(By.xpath("//*[@id=\"edit-submit\"]")).click();
			 
			   
		        }
	}

}
