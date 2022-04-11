package Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebdriverWaitDemo {
	WebDriver driver;
	@BeforeTest
	
	public void setup() {
		
		String path="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject";
		System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"\\\\drivers\\\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		}
	
	@Test
	
	public void run() {
		
		driver.get("https://example.testproject.io/web/");
		
		//Explicitywait
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.id("web")));
		
	}

}
