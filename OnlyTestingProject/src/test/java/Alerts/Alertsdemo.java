package Alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Alertsdemo {
	WebDriver driver;
	@Parameters("Browser")
	@BeforeTest
	
	public void setupbrowser(String Browser) {
		
		System.out.println("the browser is :"+Browser);
		
		if(Browser.contains("Chrome")) {
			
			String dpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\chromedriver.exe";
			
			System.setProperty("webdriver.chrome.driver",dpath);
			
			driver=new ChromeDriver();
			
		}else if(Browser.contains("Firefox")) {
			
			String fpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\geckodriver.exe";
			
			System.setProperty("webdriver.gecko.driver",fpath);
			
			driver=new FirefoxDriver();
			
		}
		

		
	}
	
	@Test
	public void testmethod() throws Exception {
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		
	//	WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//Alert element=wait1.until(ExpectedConditions.alertIsPresent());
		
		
		//js alert
		Alert alert1= driver.switchTo().alert();
		System.out.println(alert1.getText());
		
		Thread.sleep(2000);
		alert1.accept();
		
		//js confirm
		
	WebElement ele=	driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
	ele.click();
		/*Wait wait=new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.visibilityOf(ele));*/
		Alert alert2=driver.switchTo().alert();
		System.out.println(alert2.getText());
		Thread.sleep(2000);
		alert2.dismiss();
		
		
		//js propmpt
		
		
		WebElement we=driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
		we.click();
		
		/*Wait waitf=new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.visibilityOf(we));*/
		
		Alert alert3=driver.switchTo().alert();
		
		System.out.println(alert3.getText());
		
		alert3.sendKeys("abcd");
		Thread.sleep(2000);
		alert3.accept();
		
		
		
		}
	
	@AfterTest
	
	
	public void teardown() {
		
		driver.close();
		
		System.out.println("test completed");
		
		
		
	}

}
