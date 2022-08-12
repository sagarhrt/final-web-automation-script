package Publicnextfinal;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Quiz {
	public static void takeSnapShot(WebDriver webdriver) throws Exception{
		//this method is for take screenshot 
		Date d = new Date();
	        System.out.println(d.toString());
	         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");  
	         TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	         File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
             FileUtils.copyFile(SrcFile, new File("E://results screenshots//"+sdf.format(d)+".png")); 
             System.out.println(sdf.format(d)); 
	 			}
	
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
			    XSSFSheet sheet = workbook.getSheet("Quiz");
			    //it will count total number of rows in excelsheet
			    int rowCount = sheet.getLastRowNum();
		        System.out.println("the no of rows are : " + rowCount);
		        for (int row=1; row<=rowCount; row++)
		        {

		        	
					String question = sheet.getRow(row).getCell(0).getStringCellValue();//it will take 1st row of first cell value
		            
					String choiceone = sheet.getRow(row).getCell(1).getStringCellValue();
		            String choicetwo= sheet.getRow(row).getCell(2).getStringCellValue();
		           
					String duration= sheet.getRow(row).getCell(3).getStringCellValue();
		            
					String image= sheet.getRow(row).getCell(4).getStringCellValue();
		            
					String city= sheet.getRow(row).getCell(5).getStringCellValue();
					String city1= sheet.getRow(row).getCell(6).getStringCellValue();
					String city2= sheet.getRow(row).getCell(7).getStringCellValue();
					String city3= sheet.getRow(row).getCell(8).getStringCellValue();
					String notification= sheet.getRow(row).getCell(9).getStringCellValue();
					String answer= sheet.getRow(row).getCell(10).getStringCellValue();
//duration
		            String dur="none";
		            switch(duration){  
		            case "unlimited": dur="//*[@id=\"edit-runtime\"]/option[1]";  
		            break;    
		            case "1 day": dur="//*[@id=\"edit-runtime\"]/option[2]";  
		            break;    
		            case "2 days": dur="//*[@id=\"edit-runtime\"]/option[3]";  
		            break; 
		            case "3 days": dur="//*[@id=\"edit-runtime\"]/option[4]";  
		            break; 
		            case "4 days": dur="//*[@id=\"edit-runtime\"]/option[5]";  
		            break;
		            case "5 days": dur="//*[@id=\"edit-runtime\"]/option[6]";  
		            break;
		            case "6 days": dur="//*[@id=\"edit-runtime\"]/option[7]";  
		            break;
		            case "1 week": dur="//*[@id=\"edit-runtime\"]/option[8]";  
		            break;
		            case "2 weeks": dur="//*[@id=\"edit-runtime\"]/option[9]";  
		            break;
		            case "3 weeks": dur="//*[@id=\"edit-runtime\"]/option[10]";  
		            break;
		            case "1 month": dur="//*[@id=\"edit-runtime\"]/option[11]";  
		            break;
		            case "2 months": dur="//*[@id=\"edit-runtime\"]/option[12]";  
		            break;
		            case "3 months": dur="//*[@id=\"edit-runtime\"]/option[13]";  
		            break;
		            case "6 months": dur="//*[@id=\"edit-runtime\"]/option[14]";  
		            break;
		            case "9 months": dur="//*[@id=\"edit-runtime\"]/option[15]";  
		            break;
		            case "1 year": dur="//*[@id=\"edit-runtime\"]/option[16]";  
		            break;
		            } 
  //select city cellvalue from excel
		            String cityselect="none";
		            switch(city){       
		            case "Udupi": cityselect="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-0\"]";  
		            break;    
		            case "Mangalore": cityselect="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-1\"]";  
		            break; 
		            case "Hubballi-Dharwad": cityselect="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-2\"]";  
		            break; 
		            case "Bangalore": cityselect="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-3\"]";  
		            break; 
		            default: cityselect="//*[@id=\"edit-field-city\"]/div";  
		            break;  
		            }   
		            String cityselect1="none";
		            switch(city1){       
		            case "Udupi": cityselect1="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-0\"]";  
		            break;    
		            case "Mangalore": cityselect1="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-1\"]";  
		            break; 
		            case "Hubballi-Dharwad": cityselect1="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-2\"]";  
		            break; 
		            case "Bangalore": cityselect1="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-3\"]";  
		            break; 
		            default: cityselect1="//*[@id=\"edit-field-city\"]/div";  
		            break;  
		            }   
		            String cityselect2="none";
		            switch(city2){       
		            case "Udupi": cityselect2="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-0\"]";  
		            break;    
		            case "Mangalore": cityselect2="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-1\"]";  
		            break; 
		            case "Hubballi-Dharwad": cityselect2="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-2\"]";  
		            break; 
		            case "Bangalore": cityselect2="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-3\"]";  
		            break; 
		            default: cityselect2="//*[@id=\"edit-field-city\"]/div";  
		            break;  
		            }   
		            String cityselect3="none";
		            switch(city3){       
		            case "Udupi": cityselect3="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-0\"]";  
		            break;    
		            case "Mangalore": cityselect3="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-1\"]";  
		            break; 
		            case "Hubballi-Dharwad": cityselect3="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-2\"]";  
		            break; 
		            case "Bangalore": cityselect3="//*[@id=\"ui-multiselect-0-edit-field-city-und-option-3\"]";  
		            break; 
		            default: cityselect3="//*[@id=\"edit-field-city\"]/div";  
		            break;  
		            }   
		            
//notification cities
		            String notifycity="none";
		            switch(notification){    
		            case "Yes": notifycity="//*[@id=\"edit-field-send-notification-und\"]";  
		            break;    
		            default: notifycity="//*[@id=\"edit-field-send-notification\"]/div";  
		            break;  
		            }  

		            
		            driver.get("https://qa.electreps.com/node/add/poll");
//add question
					WebElement quest = driver.findElement(By.xpath("//*[@id=\"edit-title\"]"));
					quest.sendKeys(question);
					 System.out.println(question);
					 System.out.println("..............");
					Thread.sleep(1000);
					
//add choice one
					WebElement choice = driver.findElement(By.xpath("//*[@id=\"edit-choice-new0-chtext\"]"));
					choice.sendKeys(choiceone);
					 System.out.println(choiceone);
					 System.out.println("..............");
					Thread.sleep(1000);
					
//add choice two
					WebElement choice2 = driver.findElement(By.xpath("//*[@id=\"edit-choice-new1-chtext\"]"));
					choice2.sendKeys(choicetwo);
					 System.out.println(question);
					 System.out.println("..............");
					Thread.sleep(1000);
					
//poll duration
					WebElement polldur = driver.findElement(By.xpath("//*[@id=\"edit-runtime\"]"));
					polldur.click();
					driver.findElement(By.xpath(dur)).click();
					 System.out.println("Poll duration selected");

//image UPLOADING ....
					 String s11=new String("none");
					 if(image.equals(s11)){
						
					   System.out.println("image not selected");
					 }
					 else {
					Thread.sleep(1000);
					   WebElement image1 = driver.findElement(By.xpath("//*[@id=\"edit-field-capture-image-for-idea-exp-und-0-upload\"]"));
					   //click on ‘Choose file’ to upload the desired file
					   image1.sendKeys(image); //Uploading the file using sendKeys
					   System.out.println("image is Uploaded Successfully");
					   //clicking uploading button
					   WebElement upload = driver.findElement(By.xpath("//*[@id=\"edit-field-capture-image-for-idea-exp-und-0-upload-button\"]"));
					   upload.click();
					   Thread.sleep(1000);
					 }
//selecting city					
						driver.findElement(By.xpath("//*[@id=\"edit-field-city-und_ms\"]")).click();
						

						driver.findElement(By.xpath(cityselect)).click();
						driver.findElement(By.xpath(cityselect1)).click();
						driver.findElement(By.xpath(cityselect2)).click();
						driver.findElement(By.xpath(cityselect3)).click();
						 System.out.println("City Selected");
							Thread.sleep(1000);
							
//select notification option
							
							WebElement notifi = driver.findElement(By.xpath(notifycity));
							notifi.click();
//selecting quiz option
							driver.findElement(By.xpath("//*[@id=\"edit-field-poll-type-und-quiz\"]")).click();
//answer
							
							WebElement ans = driver.findElement(By.xpath("//*[@id=\"edit-field-quiz-answer-und-0-value\"]"));
							ans.sendKeys(answer);
							 System.out.println(answer);
							 System.out.println("..............");
							
							
//submit
							driver.findElement(By.xpath("//*[@id=\"edit-submit\"]")).click();
		        }
		        }	

}
