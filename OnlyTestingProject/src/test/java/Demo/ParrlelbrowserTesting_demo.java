package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParrlelbrowserTesting_demo {
	
	WebDriver driver;
	
	@Parameters("Browser")
	
	@BeforeTest
	
	public void setup(String Browser) {
		
		System.out.println("Browser is:"+Browser);
		
		if(Browser.contains("Chrome")) {
			
			String chdriverpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\chromedriver.exe";
			
			System.setProperty("webdriver.chrome.driver", chdriverpath);
			driver=new ChromeDriver();
			}
		else if(Browser.contains("Firefox")) {
			
			String geckopath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\geckodriver.exe";
			
			System.setProperty("webdriver.gecko.driver",geckopath);
			driver=new FirefoxDriver();
		}
		
	}
	@Test
	
	public void testexecution() throws Exception {
		
		driver.get("https://example.testproject.io/web/");
		
		Thread.sleep(3000);
		
		}
	@AfterTest
	
	public void closebrowser() {
		
		driver.close();
		
		System.out.println("completed");
	}
}
