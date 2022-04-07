package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DesiredCapabilities_Demo {

      WebDriver driver=null;
		
		@BeforeTest
		
	public void Setupbrowser() {
			
			String path="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\chromedriver.exe";
			
			DesiredCapabilities caps=new DesiredCapabilities();
			//caps.setBrowserName("Chrome");
			System.setProperty("webdriver.chrome.driver",path);
			
			driver=new ChromeDriver();
			
			
			
		}
		@Test
		
		public void runtest() {
			driver.get("https://www.indianrail.gov.in/enquiry/SEAT/SeatAvailability.html?locale=en");
			
		}
		@AfterTest
		
		public void teardown() {
			
			driver.close();
			
		}
	
	}


