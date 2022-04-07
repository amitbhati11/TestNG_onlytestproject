package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.Fbloginpage;

public class ExtentreportTestng {
	
	WebDriver driver=null;
	Fbloginpage fbloginpage;
	ExtentReports extent;
	
	@BeforeSuite
	
	public void Extetntreportsetup() {
		// initialize the HtmlReporter
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		
		// initialize ExtentReports and attach the HtmlReporter
		 extent = new ExtentReports();
		
		// attach only HtmlReporter
		extent.attachReporter(htmlReporter);
		
		
	}
	@BeforeTest
	
	public void browsersetup() {
  String path="C:\\Users\\Admin_SRV\\eclipse-workspace\\OnlyTestingProject\\drivers\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver",path);
		
		driver=new ChromeDriver();
		
	}
	
	@Test
	
	public void testexecution() throws InterruptedException, IOException {
		

		// creating tests
		ExtentTest test = extent.createTest("MyFirstTest");
		//loggor
		
		  // log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");
        
        // log with snapshot
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
        
       
  
		
		driver.get("https://www.facebook.com/login/");
		
		fbloginpage=new Fbloginpage(driver);
		fbloginpage.testlogo();
		fbloginpage.username("9821416708");
		fbloginpage.password("9313421910");
		
	
		fbloginpage.loginbutton();
		
	}
	
@Test
	
	public void testexecution1() throws InterruptedException, IOException {
		

		// creating tests
		ExtentTest test = extent.createTest("MyFirstTest");
		//loggor
		
		  // log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");
        
        // log with snapshot
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
        
       
  
		
		driver.get("https://www.facebook.com/login/");
		
		fbloginpage=new Fbloginpage(driver);
		fbloginpage.testlogo();
		fbloginpage.username("9821416708");
		fbloginpage.password("9313421910");
		
		
		fbloginpage.loginbutton();
		
	}

  @AfterTest
  
public void closedbrowser() {
	  
	  driver.close();
	  System.out.println("driver closed");
	  
  }
@AfterSuite
	
	
	public void teardown() {
		 // calling flush writes everything to the log file
	      extent.flush();
		
		
		
	}
	
}
