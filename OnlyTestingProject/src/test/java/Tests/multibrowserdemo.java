package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Excelutils.ExlUtilsdemo;
import Pages.Testproject;

public class multibrowserdemo {
	
	WebDriver driver;
	Testproject testp;
	
	@Parameters("Browser")

	
	@BeforeTest
	
	public void setup(String Browser) {
		System.out.println("the Browser is:"+Browser);
		System.out.println("Thread id is :"+Thread.currentThread().getId());
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			String cpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",cpath);
			driver=new ChromeDriver();
			} else if(Browser.contains("Firefox")) {
				String fpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\geckodriver.exe";
				System.setProperty("webdriver.gecko.driver",fpath);
				driver=new FirefoxDriver();
				
			}
		
	}
	@DataProvider(name="test")
	
	public Object [] []   callmethod() throws Exception{
		
		String xlpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\Datautils\\loginDataprovider.xlsx";
		String Sheetname="Sheet1";
		
		Object data [][]=cellstringdata(xlpath, Sheetname);
		
		return data;
		
		
	}
	
	@Test(dataProvider="test")
	
	public void finaldata(String username,String password) throws Exception {
		driver.get("https://example.testproject.io/web/");
		
		testp=new Testproject(driver);
		testp.TS_username(username);
		testp.TS_password(password);
		Thread.sleep(2000);
		testp.TS_loginbutton();
		
		
		
		System.out.println(username+" | "+password);
	}
	
	
	public Object [][] cellstringdata(String xlpath,String Sheetname) throws Exception {
		
		ExlUtilsdemo exd=new ExlUtilsdemo(xlpath, Sheetname);
		
	int Rownum=	exd.rowcount();
	int Colnum=exd.cellcount();
	
	
		
		Object data [][]=new Object [Rownum-1][Colnum];
		
		for(int i=1;i<Rownum;i++) {
			for(int j=0;j<Colnum;j++) {
				
		data[i-1][j]=exd.getcelldata(i, j);
			}
			
		}return data;
		
		
		
		
	}
	
	@AfterTest
	
	public void teardown() {
		
		driver.close();
		System.out.println("Test is completed");
		
		
	}

}
