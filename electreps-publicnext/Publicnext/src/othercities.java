    import java.io.File; 
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Cell;
    import org.apache.poi.ss.usermodel.DataFormatter;
    import org.apache.poi.ss.usermodel.Row;
    import org.apache.poi.xssf.usermodel.XSSFCell;
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



	public class othercities {

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

						act.moveToElement(driver.findElement(By.xpath("//*[@id=\"admin-menu-menu\"]/li[1]/ul/li[1]/a"))).perform();
						Thread.sleep(1000);
						//select local news menu 
						Actions act1 = new Actions(driver);

						act1.moveToElement(driver.findElement(By.xpath("//*[@id=\"admin-menu-menu\"]/li[1]/ul/li[1]/ul/li[9]/a"))).click().perform(); 
						
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