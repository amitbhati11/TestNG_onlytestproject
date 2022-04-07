package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testngxml_demo2 {
	
	WebDriver driver=null;
	
	@BeforeTest
	
	public void Firefoxbrowsersetup() {
		
		String Fpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\geckodriver.exe";
		
		System.setProperty("webdriver.gecko.driver",Fpath);
		
		driver=new FirefoxDriver();
		
	}
	
	@Test
	
	public void testraiwaybyfirefox() {
		
		driver.get("https://www.indianrail.gov.in/enquiry/SEAT/SeatAvailability.html?locale=en");
	}

	
	@Test
	
	public void testraiwaybyfirefox1() {
		
		driver.get("https://www.indianrail.gov.in/enquiry/SEAT/SeatAvailability.html?locale=en");
	}
	
	@AfterTest
	
	public void teardownFirefox() {
		
		System.out.println("test2 is completed");
		driver.close();
	}

}
