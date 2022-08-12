package editor;

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
			email.sendKeys("sagarphpublicnext");
			WebElement password = driver.findElement(By.xpath("//*[@id=\"edit-pass\"]"));
			password.sendKeys("Publicnext@123");
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
		        
		      //for loop for run all row testcases
		        for (int row=1; row<=rowCount; row++)
		        {

		        	
					String newstitle = sheet.getRow(row).getCell(0).getStringCellValue();//it will take 1st row of first cell value
					String category = sheet.getRow(row).getCell(1).getStringCellValue();
					String newsbodycontent = sheet.getRow(row).getCell(2).getStringCellValue();
		            String rank1= sheet.getRow(row).getCell(3).getStringCellValue();
		            String image= sheet.getRow(row).getCell(4).getStringCellValue();
		            String video= sheet.getRow(row).getCell(5).getStringCellValue();
		            String videotumb= sheet.getRow(row).getCell(6).getStringCellValue();
		            String city= sheet.getRow(row).getCell(7).getStringCellValue();
		            String notify= sheet.getRow(row).getCell(8).getStringCellValue();
		            String youtube= sheet.getRow(row).getCell(9).getStringCellValue();
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
		           
		               
 //notification
		            String notification="none";
		            switch(notify){       
		            case "Yes": notification="//*[@id=\"edit-field-send-notification\"]/div/label";  
		            break;    
		            case "No": notification="/html/body";  
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
		          //news catagory
		            String cat="none";
		            switch(category){  
		            case "Politics": cat="//*[@id=\"ui-multiselect-0-edit-field-category-und-option-0\"]";  
		            break;    
					case "Jobs": cat="//*[@id=\"ui-multiselect-0-edit-field-category-und-option-2\"]";  
		            break; 
					case "Sports": cat="//*[@id=\"ui-multiselect-0-edit-field-category-und-option-5\"]";  
		            break;
					case "Crime": cat="//*[@id=\"ui-multiselect-0-edit-field-category-und-option-7\"]";  
		            break;
		           
		              
		            } 
	
		            
		            
		           
//selecting main menu after login to https://qa.electreps.com/
					Actions action = new Actions(driver);

					action.moveToElement(driver.findElement(By.xpath("//*[@id=\"admin-menu-menu\"]/li[1]/a"))).perform();
//select add content menu
					Actions act = new Actions(driver);

					act.moveToElement(driver.findElement(By.xpath("//*[@id=\"admin-menu-menu\"]/li/a"))).perform();
					Thread.sleep(1000);
//select State news menu 
					Actions act1 = new Actions(driver);

					act1.moveToElement(driver.findElement(By.xpath("//*[@id=\"admin-menu-menu\"]/li[1]/ul/li[4]/a"))).click().perform();
					//news subject name
					WebElement localsub = driver.findElement(By.xpath("//*[@id=\"edit-field-local-news-subject-und-0-value\"]"));
					localsub.sendKeys(sheet.getRow(row).getCell(0).getStringCellValue());
					 System.out.println(newstitle);
					 System.out.println("..............");
					Thread.sleep(1000);
//select category
					driver.findElement(By.xpath("//*[@id=\"edit-field-category-und_ms\"]")).click();
					WebElement tml = driver.findElement(By.xpath(cat));
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
//select city
					driver.findElement(By.xpath("//*[@id=\"edit-field-state-und\"]")).click();
					driver.findElement(By.xpath(cityselect)).click();
					 System.out.println("State Selected");
				
//select notification option

						driver.findElement(By.xpath(notification)).click();		
						//page scoll down 
						JavascriptExecutor js2 = (JavascriptExecutor) driver;
						js2.executeScript("window.scrollBy(0,350)", "");
// body content
						WebElement body = driver.findElement(By.xpath("//*[@id=\"edit-body-und-0-value\"]"));
						body.sendKeys(sheet.getRow(row).getCell(2).getStringCellValue());
						 System.out.println("Content Updated");
						Thread.sleep(1000);
//image UPLOADING ....
						 String s11=new String("none");
						 if(image.equals(s11)){
							
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
//video UPLOADING ....
						   String s22=new String("none");
							 if(video.equals(s22)){
								
							 }
							 else {
						   WebElement video1 = driver.findElement(By.xpath("//*[@id=\"edit-field-video-und-0-upload\"]"));
						   //click on ‘Choose file’ to upload the desired file
						   video1.sendKeys(sheet.getRow(row).getCell(5).getStringCellValue()); //Uploading the video file using sendKeys
						   driver.findElement(By.xpath("//*[@id=\"edit-field-video-und-0-upload-button\"]")).click();
						   System.out.println("video is Uploaded Successfully");
						 Thread.sleep(4000);
							 }
							 JavascriptExecutor js3 = (JavascriptExecutor) driver;
								js2.executeScript("window.scrollBy(0,350)", "");
//video tumbail UPLOADING ....
						 String s66=new String("none");
						 if(videotumb.equals(s66)){
							
						 }
						 else {
							 WebElement tumbnail = driver.findElement(By.xpath("//*[@id=\"edit-field-video-thumbnail-und-0-upload\"]"));
							   //click on ‘Choose file’ to upload the desired file
							   tumbnail.sendKeys(sheet.getRow(row).getCell(6).getStringCellValue()); //Uploading the video file using sendKeys
							   driver.findElement(By.xpath("//*[@id=\"edit-field-video-thumbnail-und-0-upload-button\"]")).click();
							   System.out.println("video custom tumbnail Uploaded Successfully");
						 }
						 Thread.sleep(1000);		
	//youtube link					 
						 String s77=new String("none");
						 if(youtube.equals(s77)){
							
						 }
						 else {
							 WebElement tumbnail = driver.findElement(By.xpath("//*[@id=\"edit-field-you-tube-video-link-und-0-input\"]"));
							   //click on ‘Choose file’ to upload the desired file
							   tumbnail.sendKeys(sheet.getRow(row).getCell(9).getStringCellValue()); //Uploading the video file using sendKeys
							   
							   System.out.println("video custom tumbnail Uploaded Successfully");
						 }
						 Thread.sleep(1000);	
						 JavascriptExecutor js4 = (JavascriptExecutor) driver;
							js2.executeScript("window.scrollBy(0,450)", "");
	//submit			 
							driver.findElement(By.xpath("//*[@id=\"edit-submit\"]")).click();
							
	//taking node it
							String currentURL = driver.getCurrentUrl();
							System.out.println(currentURL);
							
							String lastsixDigits = "";   //substring containing last 4 characters
							 
							if (currentURL.length() > 4) 
							{
							    lastsixDigits = currentURL.substring(currentURL.length() - 6);
							} 
							else
							{
							    lastsixDigits = currentURL;
							}
							 
							System.out.println(lastsixDigits);
							String nodeurl="https://qadesktop.electreps.com/article/node=";
							String newurl= nodeurl.concat(lastsixDigits);
							System.out.println(newurl);
							Thread.sleep(4000);
							
							driver.get(newurl);		
							Thread.sleep(1000);
							String text11 = driver.findElement(By.xpath("//*[@id=\"all-feeds\"]/div/div[2]/h3")).getText();
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
