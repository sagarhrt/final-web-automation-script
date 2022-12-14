import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class Statenews {

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
			    @SuppressWarnings("resource")
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
			    XSSFSheet sheet = workbook.getSheet("Statenews");
			    //it will count total number of rows in excelsheet
			    int rowCount = sheet.getLastRowNum();
		        System.out.println("the no of rows are : " + rowCount);
	//write into excel file
		        
		       
				FileInputStream fis1 = new FileInputStream("E:\\publicnext automation\\publicnextautoEXCEL\\auto1.xlsx"); 
		        @SuppressWarnings("resource")
				XSSFWorkbook workbook1 = new XSSFWorkbook(fis1);
		        XSSFSheet sheet1 = workbook1.getSheet("Sheet3");
		       Row row1 = sheet1.createRow(1);
		        @SuppressWarnings("unused")
				Cell cell1 = row1.createCell(1);
		        @SuppressWarnings("unused")
				int rowCount1 = sheet1.getLastRowNum();
		        
		    
		        
		//for loop for run all row testcases
		        for (int row=1; row<=rowCount; row++)
		        {

		        	
					String newstitle = sheet.getRow(row).getCell(0).getStringCellValue();//it will take 1st row of first cell value
		            @SuppressWarnings("unused")
					String newsbodycontent = sheet.getRow(row).getCell(1).getStringCellValue();
		            String rank1= sheet.getRow(row).getCell(2).getStringCellValue();
		            @SuppressWarnings("unused")
					String image= sheet.getRow(row).getCell(3).getStringCellValue();
		            @SuppressWarnings("unused")
					String video= sheet.getRow(row).getCell(4).getStringCellValue();
		            @SuppressWarnings("unused")
					String videotumb= sheet.getRow(row).getCell(5).getStringCellValue();
		            String city= sheet.getRow(row).getCell(6).getStringCellValue();
		            
		            
		            String citynotify= sheet.getRow(row).getCell(7).getStringCellValue();
		           
		            //@SuppressWarnings("unused")
					//String youtube2= sheet.getRow(row).getCell(15).getStringCellValue();
		           
		            //System.out.println(newstitle + " , " + newsbodycontent + " , " +image + "," +video+ "," +city+ "," +city1+ "," +city2+ "," +city3);
		            
//select city cellvalue from excel
		            String cityselect="none";
		            switch(city){       
		            case "Karnataka": cityselect="//*[@id=\"edit-field-state-und\"]/option[1]";  
		            break;    
		            case "Maharashtra": cityselect="//*[@id=\"edit-field-state-und\"]/option[2]";  
		            break; 
		            case "Delhi": cityselect="//*[@id=\"edit-field-state-und\"]/option[3]";  
		            break; 
		            case "Gujarat": cityselect="//*[@id=\"edit-field-state-und\"]/option[4]";  
		            break; 
		            default: cityselect="//*[@id=\"edit-field-state\"]/div";  
		            break;  
		            }    
		           
		            
//notification cities
		            String notifycity="none";
		            switch(citynotify){    
		            case "Yes": notifycity="//*[@id=\"edit-field-send-notification\"]/div/label";  
		            break;    
		            default: notifycity="//*[@id=\"edit-field-send-notification\"]/div";  
		            break;  
		            }    
	
		            
	//State toprank
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
	//image validation
		           /* String image1;
		            if(image==null) {  image1="";
		            	
		            }else { image1="";
		            }
		            }*/
		            
		            Row r1 = sheet1.createRow(row);
		            Cell c1 = r1.createCell(1);
		            Cell c2 = r1.createCell(2);
		            Cell c3 = r1.createCell(3);
		            Cell c4 = r1.createCell(4);
		            Cell c5 = r1.createCell(5);
		            Cell c6 = r1.createCell(6);
		            Cell c7 = r1.createCell(7);
		            Cell c8 = r1.createCell(8); 
		            Cell c9 = r1.createCell(9);
		            Cell c10 = r1.createCell(10);
		            FileOutputStream fos = new FileOutputStream("E:\\publicnext automation\\publicnextautoEXCEL\\auto1.xlsx"); 
		            
		           
//selecting main menu after login to https://qa.electreps.com/
					Actions action = new Actions(driver);

					action.moveToElement(driver.findElement(By.xpath("//*[@id=\"admin-menu-menu\"]/li[1]/a"))).perform();
//select add content menu
					Actions act = new Actions(driver);

					act.moveToElement(driver.findElement(By.xpath("//*[@id=\"admin-menu-menu\"]/li[1]/ul/li[1]/a"))).perform();
					Thread.sleep(1000);
//select State news menu 
					Actions act1 = new Actions(driver);

					act1.moveToElement(driver.findElement(By.xpath("//*[@id=\"admin-menu-menu\"]/li[1]/ul/li[1]/ul/li[24]/a"))).click().perform();
				
//news subject name
					WebElement localsub = driver.findElement(By.xpath("//*[@id=\"edit-field-local-news-subject-und-0-value\"]"));
					localsub.sendKeys(sheet.getRow(row).getCell(0).getStringCellValue());
					c1.setCellValue(newstitle);//it will wite in excel
					workbook1.write(fos);
					 System.out.println(newstitle);
					 System.out.println("..............");
					Thread.sleep(1000);
//select category
					driver.findElement(By.xpath("//*[@id=\"edit-field-category-und_ms\"]")).click();
					WebElement tml = driver.findElement(By.xpath("//*[@id=\"ui-multiselect-0-edit-field-category-und-option-2\"]"));
					tml.click();
					Thread.sleep(1000);
			
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
					//page scroll down 
					//JavascriptExecutor js = (JavascriptExecutor) driver;
					//js.executeScript("window.scrollBy(0,650)", "");
					
					//Thread.sleep(1000);
					//select radio button for is this special news section
					//WebElement radio2 = driver.findElement(By.xpath("//*[@id=\"edit-field-is-special-news-und-1\"]"));
					//radio2.click();	
					
					 
//select city
					driver.findElement(By.xpath("//*[@id=\"edit-field-state-und\"]")).click();
					
					//selecting city
					driver.findElement(By.xpath(cityselect)).click();
					
					c2.setCellValue("State selected");//it will wite in excel
					//workbook1.write(fos);
					 System.out.println("State Selected");
					Thread.sleep(1000);
//select notification option
					
					WebElement notification = driver.findElement(By.xpath("//*[@id=\"edit-field-send-notification\"]/div/label"));
					notification.click();
					
					//selecting all city for notification
					driver.findElement(By.xpath(notifycity)).click();
				
					 c3.setCellValue("nitification pass");//it will wite in excel
					// workbook1.write(fos);
					 System.out.println("Notification selected");

					//page scoll down 
					JavascriptExecutor js1 = (JavascriptExecutor) driver;
					js1.executeScript("window.scrollBy(0,350)", "");

					Thread.sleep(1000);
//localnews body content
					WebElement body = driver.findElement(By.xpath("//*[@id=\"edit-body-und-0-value\"]"));
					body.sendKeys(sheet.getRow(row).getCell(1).getStringCellValue());
					 c4.setCellValue("content updated");//it will wite in excel
					 //workbook1.write(fos);
					 System.out.println("Content Updated");
					 
					Thread.sleep(1000);
					//page scoll down 
					JavascriptExecutor js2 = (JavascriptExecutor) driver;
					js2.executeScript("window.scrollBy(0,350)", "");
					
//image UPLOADING ....
					Thread.sleep(1000);
					   WebElement image1 = driver.findElement(By.xpath("//*[@id=\"edit-field-capture-image-for-idea-exp-und-0-upload\"]"));
					   //click on ?Choose file? to upload the desired file
					   image1.sendKeys(sheet.getRow(row).getCell(3).getStringCellValue()); //Uploading the file using sendKeys
					   System.out.println("image is Uploaded Successfully");
					   //clicking uploading button
					   WebElement upload = driver.findElement(By.xpath("//*[@id=\"edit-field-capture-image-for-idea-exp-und-0-upload-button\"]"));
					   upload.click();
					   c5.setCellValue("image uploaded");//it will wite in excel
					   //workbook1.write(fos);
					   Thread.sleep(1000);
					 //page scoll down 
						//JavascriptExecutor js3 = (JavascriptExecutor) driver;
						//js3.executeScript("window.scrollBy(0,600)", "");
						
// video UPLOADING ....
						 
					   WebElement video1 = driver.findElement(By.xpath("//*[@id=\"edit-field-video-und-0-upload\"]"));
					   //click on ?Choose file? to upload the desired file
					   video1.sendKeys(sheet.getRow(row).getCell(4).getStringCellValue()); //Uploading the video file using sendKeys
					   driver.findElement(By.xpath("//*[@id=\"edit-field-video-und-0-upload-button\"]")).click();
					   System.out.println("video is Uploaded Successfully");
					 Thread.sleep(2000);
					 c6.setCellValue("video uploaded");//it will wite in excel
					 //workbook1.write(fos);
					   
// video tumbail UPLOADING ....
						 
					   WebElement tumbnail = driver.findElement(By.xpath("//*[@id=\"edit-field-video-thumbnail-und-0-upload\"]"));
					   //click on ?Choose file? to upload the desired file
					   tumbnail.sendKeys(sheet.getRow(row).getCell(5).getStringCellValue()); //Uploading the video file using sendKeys
					   driver.findElement(By.xpath("//*[@id=\"edit-field-video-thumbnail-und-0-upload-button\"]")).click();
					   System.out.println("video tumbnail Uploaded Successfully");
					 Thread.sleep(1000);
				     c7.setCellValue("custom tumbnail uploaded");//it will wite in excel
				     //workbook1.write(fos);
				     
				    
//youtubelink uploading
				    
				    // WebElement youtube1=driver.findElement(By.xpath("//*[@id=\"edit-field-you-tube-video-link-und-0-input\"]"));
				 	//youtube1.sendKeys(sheet.getRow(row).getCell(15).getStringCellValue());
				 	 //c8.setCellValue("youtubelink");//it will wite in excel
				     //workbook1.write(fos);
				     
				 	
//submitting form
					driver.findElement(By.xpath("//*[@id=\"edit-submit\"]")).click();
					c9.setCellValue("submit done");//it will wite in excel
					//workbook1.write(fos);     
					       
					
				            System.out.println("status updated in excel");
				            System.out.println("*********************************************************************");
				        
					
						Thread.sleep(4000);
						
						driver.get("https://qadesktop.electreps.com/");
						driver.findElement(By.xpath("//*[@id=\"Bangalore\"]")).click();
						String text = driver.findElement(By.xpath("//*[@id=\"all-feeds\"]/div[1]/div[2]/a/h5")).getText();
						
							if(newstitle.equals(text)) {
								takeSnapShot(driver);
					System.out.printf("qadesktop status-pass News Title:",text);  
							} else
							{System.out.println("not published-issue ");}
							
							c10.setCellValue("qadesktop status-pass");//it will wite in excel
							//workbook1.write(fos); 
							fos.close();	
						driver.get("https://qa.electreps.com/");
						
						
						//edit published news
						//Thread.sleep(120000);
						//driver.findElement(By.xpath("//*[@id=\"admin-menu-menu\"]/li[9]/a")).click();
						 
						//String heading = driver.findElement(By.xpath("//*[@id=\"messages\"]/div/div/text()")).getText();	
						//System.out.println(heading);
						//c9.setCellValue(heading);//it will wite in excel
						
		} 

	}
}
