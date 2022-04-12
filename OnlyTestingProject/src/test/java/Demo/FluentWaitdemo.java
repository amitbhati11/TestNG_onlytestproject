package Demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FluentWaitdemo {

	WebDriver driver;
	
	@BeforeTest
	
	public void setup() {
		
		String dpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", dpath);
		
		driver =new ChromeDriver();
	}
	
	@Test
	
	public void test() {
		
		driver.get("https://example.testproject.io/web/");
		//driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		
		Wait wait=new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		
		
		
	}
}
