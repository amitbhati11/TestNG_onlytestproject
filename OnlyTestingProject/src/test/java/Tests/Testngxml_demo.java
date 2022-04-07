package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testngxml_demo {
	
	WebDriver driver=null;
	
	@BeforeTest
	
	public void chromebrowsersetup() {
		
		String path="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver",path);
		driver=new ChromeDriver();
			
	}
	
	@Test
	
	public void railwaysitetest() {
		
		driver.get("https://www.indianrail.gov.in/enquiry/SEAT/SeatAvailability.html?locale=en");
		
	}
	
	
	@AfterTest
	
	public void teardownchrome() {
		
		driver.close();
		System.out.println("First test is completed");
		
	}

}
