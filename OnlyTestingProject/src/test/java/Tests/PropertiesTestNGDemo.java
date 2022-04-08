package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PropertiesTestNGDemo {
	WebDriver driver;
	public static String  Browser;
	
	@BeforeTest
	
	public void setup() {
		
		PropertiesFiledemo.getdatafromproperties();
		if(Browser.equalsIgnoreCase("Firefox")) {
			
			String geckopath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\geckodriver.exe";
			
			System.setProperty("webdriver.gecko.driver",geckopath);
			driver=new FirefoxDriver();
			
			
		}else if(Browser.contains("Chrome")) {
			
			String chromepath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\chromedriver.exe";
			
			System.setProperty("webdriver.chrome.driver",chromepath);
			
			driver=new ChromeDriver();
		}
	}
		
		@Test
		
		public void testexecution() {
			
			
			driver.get("https://www.indianrail.gov.in/enquiry/SEAT/SeatAvailability.html?locale=en");
			
			driver.findElement(By.xpath("//input[@id=\"trainNo\"]")).sendKeys("123");
			
			
			}
		@AfterTest
		
		public void teardown() {
			PropertiesFiledemo.writedatainproperties();
		//	driver.close();
			
			
			System.out.println("test completed");
			
		}
		
		
	

}
