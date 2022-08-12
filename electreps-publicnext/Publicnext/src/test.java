import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "E:\\softwares\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://qadesktop.electreps.com/");
			driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[2]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"googleSignIn\"]/div/div")).click();
			Thread.sleep(1000);
			
			Set <String> windows =driver.getWindowHandles();
			Iterator <String> it =windows.iterator();
			String p =it.next();
			String c=it.next();
			driver.switchTo().window(c);
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("sagarpublicnext@gmail.com");
			driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
			driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Sagar@123");
			driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/div[3]")).click();
			Thread.sleep(3000);
			driver.switchTo().window(p);
			Thread.sleep(1000);
			
	}

}
