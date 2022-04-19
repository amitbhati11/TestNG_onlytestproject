package Autoit;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class fileuploaddemoautoit {
	WebDriver driver;
	
	@Test
	
	public void fileuploadautoit() throws Exception {
		String driverpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",driverpath);
		driver=new ChromeDriver();
		
		driver.get("https://www.ilovepdf.com/excel_to_pdf");
		Thread.sleep(1000);
		
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec("C:\\Users\\Admin_SRV\\Desktop\\Automation\\AutoIT\\demouploadscript.exe");
		
		Thread.sleep(3000);
		
		//convert
		driver.findElement(By.id("processTaskTextBtn")).click();
		Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("downloader__btn active")));
		
		driver.findElement(By.className("downloader__btn active")).click();
	}

}
