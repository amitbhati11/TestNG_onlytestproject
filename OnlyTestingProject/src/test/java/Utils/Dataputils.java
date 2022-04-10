package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.Testproject;

public class Dataputils {
	WebDriver driver;
	Testproject testproject;
	
	@BeforeTest
	
	public void setup() {
		
		String drpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\chromedriver.exe ";
		
		System.setProperty("webdriver.chrome.driver", drpath);
		
		driver=new ChromeDriver();
		
	}
	
	@DataProvider(name="testdata")
	
	public Object [][] dataprovide() throws Exception{
		
		String exclpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\Datautils\\loginDataprovider.xlsx";
		String Sheetname="sheet1";
	Object data [][]=	getdata(exclpath, Sheetname);
	
	return data;
	}
	
	@Test(dataProvider="testdata")
	
	public void exceldata(String username, String password) throws Exception {
		
		driver.get("https://example.testproject.io/web/");
		testproject=new Testproject(driver);
		
		testproject.TS_username(username);
		testproject.TS_password(password);
		Thread.sleep(2000);
		testproject.TS_loginbutton();
		
		System.out.println(username+" | "+password);
	}
			
	
	
	
	public Object [][] getdata(String exclpath,String Sheetname) throws Exception {
		
		Excedldatautils ed=new Excedldatautils(exclpath, Sheetname);
		
		
		int Rownumber=ed.getrowcount();
		int Colmnumber=ed.getcellcount();
		
		Object data [][]=new Object [Rownumber-1] [Colmnumber];
		
		for(int i=1;i<Rownumber;i++) {
		for(int j=0;j<Colmnumber;j++)
		{
			data [i-1][j]=ed.getcelldata(i,j);
		}
		}return data;
		
		
		
		
	}
	
	@AfterTest
	
	public void teardownbrowser() {
		
		driver.close();
		System.out.println("Test is completed");
	}

}
