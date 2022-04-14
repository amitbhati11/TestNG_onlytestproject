package PageloadStretgy;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Pageloadstretgy {
	WebDriver driver;
	@BeforeTest
	
	public void setup() {
		
		String dpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", dpath);
		
		//Normal
		
		ChromeOptions option=new ChromeOptions();
		
	//	option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		option.setPageLoadStrategy(PageLoadStrategy.EAGER);
	//	option.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		  driver=new ChromeDriver();
	}
	
	@Test
	
	public void testmethod() {
		
		driver.get("https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1.1");
		
		}
	@AfterTest
	
	public void teardown() {
		driver.close();
		System.out.println("test completed");
		
		
	}

}
