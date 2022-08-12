package Publicnextfinal;

import java.io.File; 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By; 
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class Localnews {

	private static WebDriver chrome;

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
			WebElement submit = driver.findElement(By.xpath("//*[@id=\"edit-submit\"]"));
			submit.click();
			//driver.get("https://qa.electreps.com/node/add/localnews");
			
	//to access excel file 
			  FileInputStream fis = new FileInputStream("E:\\publicnext automation\\publicnextautoEXCEL\\publicnext.xlsx");
			    
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
			    XSSFSheet sheet = workbook.getSheet("Localnews");
			    //it will count total number of rows in excelsheet
			    int rowCount = sheet.getLastRowNum();
		        System.out.println("the no of rows are : " + rowCount);
		      //for loop for run all row testcases
		        for (int row=1; row<=rowCount; row++)
		        {

		        	
					String newstitle = sheet.getRow(row).getCell(0).getStringCellValue();//it will take 1st row of first cell value
		            
					String newsbodycontent = sheet.getRow(row).getCell(2).getStringCellValue();
		            String rank1= sheet.getRow(row).getCell(3).getStringCellValue();
		           
					String image= sheet.getRow(row).getCell(4).getStringCellValue();
		            
					String video= sheet.getRow(row).getCell(5).getStringCellValue();
		            
					String videotumb= sheet.getRow(row).getCell(6).getStringCellValue();
					String area= sheet.getRow(row).getCell(7).getStringCellValue();
		            String city= sheet.getRow(row).getCell(8).getStringCellValue();
		            String city1= sheet.getRow(row).getCell(9).getStringCellValue();
		            String city2= sheet.getRow(row).getCell(10).getStringCellValue();
		            String city3= sheet.getRow(row).getCell(11).getStringCellValue();
		            String citynotify= sheet.getRow(row).getCell(12).getStringCellValue();
		            String citynotify2= sheet.getRow(row).getCell(13).getStringCellValue();
		            String citynotify3= sheet.getRow(row).getCell(14).getStringCellValue();
		            String citynotify4= sheet.getRow(row).getCell(15).getStringCellValue();
		            String promoted= sheet.getRow(row).getCell(16).getStringCellValue();
		            //@SuppressWarnings("unused")
					String youtube2= sheet.getRow(row).getCell(17).getStringCellValue();
		           
		            //System.out.println(newstitle + " , " + newsbodycontent + " , " +image + "," +video+ "," +city+ "," +city1+ "," +city2+ "," +city3);

					driver.get("https://qa.electreps.com/node/add/localnews");
					
//select city cellvalue from excel
		            String cityselect="none";
		            switch(city){       
		            case "Udupi": cityselect="//*[@id=\"ui-multiselect-1-edit-field-city-und-option-0\"]";  
		            break;    
		            case "Mangalore": cityselect="//*[@id=\"ui-multiselect-1-edit-field-city-und-option-1\"]";  
		            break; 
		            case "Hubballi-Dharwad": cityselect="//*[@id=\"ui-multiselect-1-edit-field-city-und-option-2\"]";  
		            break; 
		            case "Bangalore": cityselect="//*[@id=\"ui-multiselect-1-edit-field-city-und-option-3\"]";  
		            break; 
		            default: cityselect="//*[@id=\"edit-field-city\"]/div";  
		            break;  
		            }    
		            //select city from excel
		            String cityselect1="none";
		            switch(city1){       
		            case "Udupi": cityselect1="//*[@id=\"ui-multiselect-1-edit-field-city-und-option-0\"]";  
		            break;    
		            case "Mangalore": cityselect1="//*[@id=\"ui-multiselect-1-edit-field-city-und-option-1\"]";  
		            break; 
		            case "Hubballi-Dharwad": cityselect1="//*[@id=\"ui-multiselect-1-edit-field-city-und-option-2\"]";  
		            break; 
		            case "Bangalore": cityselect1="//*[@id=\"ui-multiselect-1-edit-field-city-und-option-3\"]";  
		            break; 
		            default: cityselect1="//*[@id=\"edit-field-city\"]/div";  
		            break;  
		            }     //select city from excel
		            String cityselect2="none";
		            switch(city2){       
		            case "Udupi": cityselect2="//*[@id=\"ui-multiselect-1-edit-field-city-und-option-0\"]";  
		            break;    
		            case "Mangalore": cityselect2="//*[@id=\"ui-multiselect-1-edit-field-city-und-option-1\"]";  
		            break; 
		            case "Hubballi-Dharwad": cityselect2="//*[@id=\"ui-multiselect-1-edit-field-city-und-option-2\"]";  
		            break; 
		            case "Bangalore": cityselect2="//*[@id=\"ui-multiselect-1-edit-field-city-und-option-3\"]";  
		            break; 
		            default: cityselect2="//*[@id=\"edit-field-city\"]/div";  
		            break;  
		            }     //select city from excel
		            String cityselect3="none";
		            switch(city3){       
		            case "Udupi": cityselect3="//*[@id=\"ui-multiselect-1-edit-field-city-und-option-0\"]";  
		            break;    
		            case "Mangalore": cityselect3="//*[@id=\"ui-multiselect-1-edit-field-city-und-option-1\"]";  
		            break; 
		            case "Hubballi-Dharwad": cityselect3="//*[@id=\"ui-multiselect-1-edit-field-city-und-option-2\"]";  
		            break; 
		            case "Bangalore": cityselect3="//*[@id=\"ui-multiselect-1-edit-field-city-und-option-3\"]";  
		            break; 
		            default: cityselect3="//*[@id=\"edit-field-city\"]/div";  
		            break;  
		            }    
		            
//notification cities
		            String notifycity="none";
		            switch(citynotify){    
		            case "All": notifycity="//*[@id=\"ui-multiselect-2-edit-field-send-notification-area-und-option-1\"]";  
		            break;    
		            case "Udupi": notifycity="//*[@id=\"ui-multiselect-2-edit-field-send-notification-area-und-option-2\"]";  
		            break;    
		            case "Mangalore": notifycity="//*[@id=\"ui-multiselect-2-edit-field-send-notification-area-und-option-3\"]";  
		            break; 
		            case "Hubballi-Dharwad": notifycity="//*[@id=\"ui-multiselect-2-edit-field-send-notification-area-und-option-4\"]";  
		            break; 
		            case "Bangalore": notifycity="//*[@id=\"ui-multiselect-2-edit-field-send-notification-area-und-option-5\"]";  
		            break; 
		            default: notifycity="//*[@id=\"edit-field-send-notification-area\"]/div";  
		            break;  
		            }    
		            String notifycity2="none";
		            switch(citynotify2){    
		            case "All": notifycity2="//*[@id=\"ui-multiselect-2-edit-field-send-notification-area-und-option-1\"]";  
		            break;    
		            case "Udupi": notifycity2="//*[@id=\"ui-multiselect-2-edit-field-send-notification-area-und-option-2\"]";  
		            break;    
		            case "Mangalore": notifycity2="//*[@id=\"ui-multiselect-2-edit-field-send-notification-area-und-option-3\"]";  
		            break; 
		            case "Hubballi-Dharwad": notifycity2="//*[@id=\"ui-multiselect-2-edit-field-send-notification-area-und-option-4\"]";  
		            break; 
		            case "Bangalore": notifycity2="//*[@id=\"ui-multiselect-2-edit-field-send-notification-area-und-option-5\"]";  
		            break; 
		            default: notifycity2="//*[@id=\"edit-field-send-notification-area\"]/div";  
		            break;  
		            }    String notifycity3="none";
		            switch(citynotify3){    
		            case "All": notifycity3="//*[@id=\"ui-multiselect-2-edit-field-send-notification-area-und-option-1\"]";  
		            break;    
		            case "Udupi": notifycity3="//*[@id=\"ui-multiselect-2-edit-field-send-notification-area-und-option-2\"]";  
		            break;    
		            case "Mangalore": notifycity3="//*[@id=\"ui-multiselect-2-edit-field-send-notification-area-und-option-3\"]";  
		            break; 
		            case "Hubballi-Dharwad": notifycity3="//*[@id=\"ui-multiselect-2-edit-field-send-notification-area-und-option-4\"]";  
		            break; 
		            case "Bangalore": notifycity3="//*[@id=\"ui-multiselect-2-edit-field-send-notification-area-und-option-5\"]";  
		            break; 
		            default: notifycity3="//*[@id=\"edit-field-send-notification-area\"]/div";  
		            break;  
		            }    String notifycity4="none";
		            switch(citynotify4){    
		            case "All": notifycity4="//*[@id=\"ui-multiselect-2-edit-field-send-notification-area-und-option-1\"]";  
		            break;    
		            case "Udupi": notifycity4="//*[@id=\"ui-multiselect-2-edit-field-send-notification-area-und-option-2\"]";  
		            break;    
		            case "Mangalore": notifycity4="//*[@id=\"ui-multiselect-2-edit-field-send-notification-area-und-option-3\"]";  
		            break; 
		            case "Hubballi-Dharwad": notifycity4="//*[@id=\"ui-multiselect-2-edit-field-send-notification-area-und-option-4\"]";  
		            break; 
		            case "Bangalore": notifycity4="//*[@id=\"ui-multiselect-2-edit-field-send-notification-area-und-option-5\"]";  
		            break; 
		            default: notifycity4="//*[@id=\"edit-field-send-notification-area\"]/div";  
		            break;  
		            }    
		      
	//promote to state
		            String promote="none";
		            switch(promoted){    
		            case "Yes": promote="//*[@id=\"edit-field-promote-feed\"]/div/label";  
		            break;    
		            default: promote="//*[@id=\"edit-field-promote-feed\"]/div";  
		            break;
		            }
	
		            
	//local toprank
		            String toprank1="none";
		            switch(rank1){  
		            case "none": toprank1="//*[@id=\"edit-field-top-news-rank-und\"]/option[1]";  
		            break;    
		            case "one": toprank1="//*[@id=\"edit-field-top-news-rank-und\"]/option[2]";  
		            break;    
		            case "two": toprank1="//*[@id=\"edit-field-top-news-rank-und\"]/option[3]";  
		            break; 
		            case "three": toprank1="//*[@id=\"edit-field-top-news-rank-und\"]/option[4]";  
		            break; 
		            case "four": toprank1="//*[@id=\"edit-field-top-news-rank-und\"]/option[5]";  
		            break;
		              
		            }  


//news subject name
					WebElement localsub = driver.findElement(By.xpath("//*[@id=\"edit-field-local-news-subject-und-0-value\"]"));
					localsub.sendKeys(sheet.getRow(row).getCell(0).getStringCellValue());
					//c1.setCellValue(newstitle);//it will wite in excel
					//workbook1.write(fos);
					 System.out.println(newstitle);
					 System.out.println("..............");
					Thread.sleep(1000);
//select category
					driver.findElement(By.xpath("//*[@id=\"edit-field-category-und_ms\"]")).click();
					WebElement tml = driver.findElement(By.xpath("//*[@id=\"ui-multiselect-0-edit-field-category-und-option-0\"]"));
					tml.click();
					driver.findElement(By.xpath("//*[@id=\"edit-field-category-und_ms\"]/span[1]")).click();
					Thread.sleep(1000);
					System.out.println("Category selection done");
					
//top rank select section
					WebElement toprank = driver.findElement(By.xpath("//*[@id=\"edit-field-top-news-rank-und\"]"));
					toprank.click();
					driver.findElement(By.xpath(toprank1)).click();
					 System.out.println("top rank selection done");
	
				
					Thread.sleep(1000);
//selecting strangers
					WebElement strangers = driver.findElement(By.xpath("//*[@id=\"edit-field-stringers-und\"]"));
					strangers.click();
					
					Select stgrs=new Select(strangers);
					stgrs.selectByVisibleText("Iranna Y Walikar");
					Thread.sleep(1000);
//select area       
					
					WebElement aaa = driver.findElement(By.xpath("//*[@id=\"edit-field-location-und\"]"));
					Select bbb = new Select(aaa);
					bbb.selectByVisibleText(area);
					
					//driver.findElement(By.xpath(area1)).click();
					
//selecting city					
					driver.findElement(By.xpath("//*[@id=\"edit-field-city-und_ms\"]")).click();
					

					driver.findElement(By.xpath(cityselect)).click();
					driver.findElement(By.xpath(cityselect1)).click();
					driver.findElement(By.xpath(cityselect2)).click();
					driver.findElement(By.xpath(cityselect3)).click();
					 System.out.println("City Selected");
						Thread.sleep(1000);
//select notification option
						
						WebElement notification = driver.findElement(By.xpath("//*[@id=\"edit-field-send-notification-area-und_ms\"]"));
						notification.click();
						
						//selecting all city for notification
						driver.findElement(By.xpath(notifycity)).click();
						driver.findElement(By.xpath(notifycity2)).click();
						driver.findElement(By.xpath(notifycity3)).click();
						driver.findElement(By.xpath(notifycity4)).click();
						 //c3.setCellValue("nitification pass");//it will wite in excel
						// workbook1.write(fos);
						 System.out.println("Notification selected");
	//promote to state?
					    driver.findElement(By.xpath(promote)).click();
						
						Thread.sleep(1000);
						
						Thread.sleep(1000); 
						//page scoll down 
						JavascriptExecutor js1 = (JavascriptExecutor) driver;
						js1.executeScript("window.scrollBy(0,350)", "");

						Thread.sleep(1000);
	//localnews body content
						WebElement body = driver.findElement(By.xpath("//*[@id=\"edit-body-und-0-value\"]"));
						body.sendKeys(sheet.getRow(row).getCell(2).getStringCellValue());
						 //c4.setCellValue("content updated");//it will wite in excel
						 //workbook1.write(fos);
						 System.out.println("Content Updated");
						 
						Thread.sleep(1000);
						//page scoll down 
						JavascriptExecutor js2 = (JavascriptExecutor) driver;
						js2.executeScript("window.scrollBy(0,350)", "");
						
						
	//image UPLOADING ....
						 String s11=new String("none");
						 if(image.equals(s11)){
							
						   System.out.println("its video news image upload not required");
						 }
						 else {
						Thread.sleep(1000);
						   WebElement image1 = driver.findElement(By.xpath("//*[@id=\"edit-field-capture-image-for-idea-exp-und-0-upload\"]"));
						   //click on ‘Choose file’ to upload the desired file
						   image1.sendKeys(sheet.getRow(row).getCell(4).getStringCellValue()); //Uploading the file using sendKeys
						   System.out.println("image is Uploaded Successfully");
						   //clicking uploading button
						   WebElement upload = driver.findElement(By.xpath("//*[@id=\"edit-field-capture-image-for-idea-exp-und-0-upload-button\"]"));
						   upload.click();
						   Thread.sleep(1000);
						 }
// video UPLOADING ....
						   String s22=new String("none");
							 if(video.equals(s22)){
								
							   System.out.println("video link not given so not uploaded");
							 }
							 else {
						   WebElement video1 = driver.findElement(By.xpath("//*[@id=\"edit-field-video-und-0-upload\"]"));
						   //click on ‘Choose file’ to upload the desired file
						   video1.sendKeys(sheet.getRow(row).getCell(5).getStringCellValue()); //Uploading the video file using sendKeys
						   driver.findElement(By.xpath("//*[@id=\"edit-field-video-und-0-upload-button\"]")).click();
						   System.out.println("video is Uploaded Successfully");
						 Thread.sleep(4000);
							 }
// video tumbail UPLOADING ....
						 String s66=new String("none");
						 if(videotumb.equals(s66)){
							
						   System.out.println("default tumbnail updated");
						 }
						 else {
							 WebElement tumbnail = driver.findElement(By.xpath("//*[@id=\"edit-field-video-thumbnail-und-0-upload\"]"));
							   //click on ‘Choose file’ to upload the desired file
							   tumbnail.sendKeys(sheet.getRow(row).getCell(6).getStringCellValue()); //Uploading the video file using sendKeys
							   driver.findElement(By.xpath("//*[@id=\"edit-field-video-thumbnail-und-0-upload-button\"]")).click();
							   System.out.println("video custom tumbnail Uploaded Successfully");
						 }
						 Thread.sleep(1000);
//youtube link :
						 WebElement you = driver.findElement(By.xpath("//*[@id=\"edit-field-you-tube-video-link-und-0-input\"]"));
						 you.sendKeys(sheet.getRow(row).getCell(17).getStringCellValue());
						 
//submitting form			
						 	Thread.sleep(2000);
							driver.findElement(By.xpath("//*[@id=\"edit-submit\"]")).click();
							
							Thread.sleep(4000);
							
							driver.get("https://qadesktop.electreps.com/");
							driver.findElement(By.id(city)).click();
							Thread.sleep(1000);
							String text11 = driver.findElement(By.xpath("//*[@id=\"all-feeds\"]/div[1]/div[2]/a/h5")).getText();
							 System.out.println(text11); 
							 System.out.println(newstitle);
								if(newstitle.equals(text11)) {
									takeSnapShot(driver);
									 System.out.println("qadesktop status-pass News Title:");  
								} else
								{System.out.println("not published-issue ");}
								System.out.println("==================================================================");
								System.out.println("==================================================================");
								
								driver.get("https://qa.electreps.com/");
	}
}
}