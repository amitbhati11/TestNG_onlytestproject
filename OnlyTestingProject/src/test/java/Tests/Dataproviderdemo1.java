package Tests;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Excelutils.Ecxlutilsdemo1;
import Pages.Fbloginpage;
import Pages.Testproject;

public class Dataproviderdemo1 {
	WebDriver driver;
	public static String Browser;
	
	@Parameters("Browser")
	@BeforeTest
	
	public void setup(String Browser) {
		System.out.println("the browser is :"+Browser);
		
		if (Browser.contains("chrome")) {
			
			String chropath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",chropath);
			
			driver=new ChromeDriver();
		}else if (Browser.contains("Firefox")) {
			
			
			String firpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", firpath);
			
			driver=new FirefoxDriver();
		}
		
		 
		
	}
	
	@DataProvider(name="testdata")
	
	public Object [][] getdata() throws Exception{
		String xlpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\Datautils\\loginDataprovider.xlsx";
		String Sheetname="Sheet1";
		
		Object data [][]=getcelldatamethod(xlpath, Sheetname);
		
		return data;
	
	}
	@Test(dataProvider="testdata")
	
	public void finaldata(String username,String password, String id) throws InterruptedException {
		System.out.println(username+" | "+password+" | "+id);
		driver.get("https://example.testproject.io/web/");
		
		Testproject tp=new Testproject(driver);
		
		tp.TS_username(username);
		tp.TS_password(password);
		tp.TS_loginbutton();
		Thread.sleep(2000);
		
		
		
	}
	
	
	
	
	
	public Object [][] getcelldatamethod(String xlpath,String Sheetname) throws Exception {
		
		Ecxlutilsdemo1 exd=new Ecxlutilsdemo1(xlpath, Sheetname);
		
		
		
		int RowNum=exd.getRowcount();
		int ColNum=exd.getcellcount();
		
		Object data [][]=new Object[RowNum-1][ColNum];
		
		
		for(int i=1;i<RowNum;i++) {
			for(int j=0;j<ColNum;j++) {
				
			data [i-1][j]=	exd.getcelldata(i, j);
			}
			
		} return data;
		
		
	}
	
	@AfterTest
	
	public void teardwon() {
		System.out.println("test completed");
		driver.close();
		
		
	}

}
