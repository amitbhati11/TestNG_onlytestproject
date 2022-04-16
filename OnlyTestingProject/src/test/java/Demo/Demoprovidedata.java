package Demo;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Excelutils.DemoExcelutils;
import Pages.Testproject;

public class Demoprovidedata {
	WebDriver driver;
	Testproject tp;
	
	@BeforeTest
	
	public void setup() {
		
		String driverpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver=new ChromeDriver();
		
//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
	}
	
	
	@DataProvider(name="testdata")
	
	public Object [][] getdatatest() throws Exception{
		
		String xlpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\Datautils\\loginDataprovider.xlsx";
		String sheetname="Sheet1";
		   Object data [][]=getdatacell(xlpath,sheetname);
		   
		   return data;
		
		}
	
	@Test(dataProvider="testdata")
	
	public void finaldata(String username,String password,String id) {
		
		driver.get("https://example.testproject.io/web/");
		tp=new Testproject(driver);
		
		tp.TS_username(username);
		tp.TS_password(password);
		tp.TS_loginbutton();
		//explicilywait
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logo")));
		
		//FluentWait
		
		Wait waitf=new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		
		WebElement element=driver.findElement(By.id("save"));
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
		System.out.println(username+" | "+password+" | "+id);
		
	}
	
	
	public Object [][] getdatacell(String xlpath, String sheetname) throws Exception {
		
		
		
		DemoExcelutils de=new DemoExcelutils(xlpath, sheetname);
		
		int Rownum=de.getrowcount();
		int Colnum=de.getcellcount();
		
		Object data [][]=new Object [Rownum-1][Colnum];
		
		for(int i=1;i<Rownum;i++) {
			for(int j=0;j<Colnum;j++) {
				
			data [i-1][j]=	de.getcelldata(i, j);
			}
		} return data;
		      
		
	}
	
	@Test
	
	public void takescreenshot(ITestResult result) {
		
		
		TakesScreenshot srcshot= (TakesScreenshot)driver;
        File scrfile=srcshot.getScreenshotAs(OutputType.FILE);
        File destfile=new File("C:/Users/Admin_SRV/git/TestNG_onlytestproject/OnlyTestingProject/Screenshot/faildtest.png");
        
        try {
			FileUtils.copyDirectory(scrfile, destfile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}{
			
			
		}
	}
	
	@AfterTest
	
	public void teardown() {
		
		driver.close();
		driver.quit();
		
		
	}

}
