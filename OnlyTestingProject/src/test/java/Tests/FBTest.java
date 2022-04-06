package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Fbloginpage;

public class FBTest {
	
	WebDriver driver=null;
	Fbloginpage fbloginpage;
	@BeforeTest
	
	public void browsersetup() {
		
		String path="C:\\Users\\Admin_SRV\\eclipse-workspace\\OnlyTestingProject\\drivers\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver",path);
		
		driver=new ChromeDriver();
		
	}
	
    @Test
    
	public void FBloginTest() throws InterruptedException {
		
    	driver.get("https://www.facebook.com/login/");
    	driver.manage().window().maximize();
    	Thread.sleep(3000);
    	
    	fbloginpage =new Fbloginpage(driver);
    	
    	fbloginpage.testlogo();
    	fbloginpage.username("9821416708");
    	fbloginpage.password("9313421910");
    	fbloginpage.loginbutton();
    	
    	Thread.sleep(2000);
    	
    	
		
	}
    @AfterTest
    
    public void shutbrowser() {
    	
    	
    	driver.close();
    }
}
