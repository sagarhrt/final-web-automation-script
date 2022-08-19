package Publicnextfinal;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
			            String pay= sheet.getRow(row).getCell(15).getStringCellValue();
			            String notify= sheet.getRow(row).getCell(5).getStringCellValue();
			            String subject1= sheet.getRow(row).getCell(6).getStringCellValue();
			            String category= sheet.getRow(row).getCell(7).getStringCellValue();
			           String wtext = sheet.getRow(row).getCell(17).getStringCellValue();
			           
			           DataFormatter formatter1 = new DataFormatter(); //creating formatter using the default locale
						 XSSFCell cell1 = sheet.getRow(row).getCell(13);
						String fromd= formatter1.formatCellValue(cell1);
						
						DataFormatter formatter2 = new DataFormatter(); //creating formatter using the default locale
						 XSSFCell cell2 = sheet.getRow(row).getCell(14);
						String fromd1= formatter2.formatCellValue(cell2);
			           
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
			            //payment
			            String payment="none";
			            switch(pay){       
			            case "Yes": payment="//*[@id=\"edit-field-received-payment-und\"]";  
			            break;    
			            case "No": payment="/html/body";  
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
				driver.get("https://qa.electreps.com/node/add/business-advertisement");
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
				

	//ads subject
				WebElement subject = driver.findElement(By.xpath("//*[@id=\"edit-field-local-news-subject-und-0-value\"]"));
				subject.sendKeys(sheet.getRow(row).getCell(6).getStringCellValue());
				 System.out.println("4-Subject updated");
				Thread.sleep(1000);
	//ads category
				driver.findElement(By.xpath(adscategory)).click();
				System.out.println("5-Ads Category updated");	
	
//adding mobile number
				DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
				 XSSFCell cell = sheet.getRow(row).getCell(8);
				String mob= formatter.formatCellValue(cell);
				WebElement mobnu = driver.findElement(By.xpath("//*[@id=\"edit-field-phone-number-und-0-value\"]"));
				mobnu.sendKeys(mob);
				System.out.println("6-mobile number added");	
				
//adding wtsapp number
				DataFormatter formatter4 = new DataFormatter(); 
				XSSFCell cell4 = sheet.getRow(row).getCell(16);
				String wts1= formatter4.formatCellValue(cell4);
				WebElement wtsap1 = driver.findElement(By.xpath("//*[@id=\"edit-field-whatsapp-number-und-0-value\"]"));
				wtsap1.sendKeys(wts1);
				System.out.println("7-wtsapp number added");
				
//wts app text
				WebElement txt = driver.findElement(By.xpath("//*[@id=\"edit-field-whatsapp-text-und-0-value\"]"));
				txt.sendKeys(wtext);
				System.out.println("8-Wtsapp text updated");
				
				//page scroll down 
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,350)", "");
				Thread.sleep(1000);
				
//image uploading
				WebElement img = driver.findElement(By.xpath("//*[@id=\"edit-field-capture-image-for-idea-exp-und-0-upload\"]"));
				img.sendKeys(sheet.getRow(row).getCell(9).getStringCellValue());
				driver.findElement(By.xpath("//*[@id=\"edit-field-capture-image-for-idea-exp-und-0-upload-button\"]")).click();
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("window.scrollBy(0,350)", "");
				System.out.println("8-image uploaded");
				Thread.sleep(2000);
//video uploading
				/*WebElement vdeo =driver.findElement(By.xpath("//*[@id=\"edit-field-video-und-0-upload\"]"));
				vdeo.sendKeys(sheet.getRow(row).getCell(10).getStringCellValue());
				driver.findElement(By.xpath("//*[@id=\"edit-field-video-und-0-upload-button\"]")).click();
				
//video tumbnail upload
				WebElement tumb = driver.findElement(By.xpath("//*[@id=\"edit-field-video-thumbnail-und-0-upload\"]"));
				tumb.sendKeys(sheet.getRow(row).getCell(11).getStringCellValue());
				driver.findElement(By.xpath("//*[@id=\"edit-field-video-thumbnail-und-0-upload-button\"]")).click();*/
				
//youtube link
				WebElement yotub = driver.findElement(By.xpath("//*[@id=\"edit-field-you-tube-video-link-und-0-input\"]"));
				yotub.sendKeys(sheet.getRow(row).getCell(12).getStringCellValue());
				
//start date
				driver.findElement(By.xpath("//*[@id=\"edit-field-event-start-date-und-0-value-datepicker-popup-0\"]")).clear();
				Thread.sleep(1000);
				WebElement toda11 = driver.findElement(By.xpath("//*[@id=\"edit-field-event-start-date-und-0-value-datepicker-popup-0\"]"));
				toda11.sendKeys(fromd);
				driver.findElement(By.xpath("//*[@id=\"field-event-start-date-add-more-wrapper\"]/fieldset/div/div[3]")).click();
				
//end date
				driver.findElement(By.xpath("//*[@id=\"edit-field-event-start-date-und-0-value2-datepicker-popup-0\"]")).clear();
				Thread.sleep(1000);
				WebElement toda = driver.findElement(By.xpath("//*[@id=\"edit-field-event-start-date-und-0-value2-datepicker-popup-0\"]"));
				toda.sendKeys(fromd1);
				driver.findElement(By.xpath("//*[@id=\"field-event-start-date-add-more-wrapper\"]/fieldset/div/div[3]")).click();
				
//payment
				driver.findElement(By.xpath(payment)).click();
				System.out.println("3-payment status updated");				
//notification
				driver.findElement(By.xpath(notification)).click();
				System.out.println("3-notification updated");
				
//submit
				driver.findElement(By.xpath("//*[@id=\"edit-submit\"]")).click();

	}

}

}
