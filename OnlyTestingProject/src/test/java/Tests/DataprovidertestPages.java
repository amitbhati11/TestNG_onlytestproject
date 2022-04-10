package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.Testproject;
import Utils.Exceldatautistest;

public class DataprovidertestPages {
	
	WebDriver driver;
	Testproject tsp;
	
	@BeforeTest
	public void setup() {
		String pathD="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",pathD);
		driver=new ChromeDriver();
		
		}
	
	@DataProvider(name="testdata")
	
	public Object [][] getdataexcelP() throws Exception{
		
		String xlpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\Datautils\\loginDataprovider.xlsx";
		String Sheetname="Sheet1";
		
		Object data [][]=readexceldata(xlpath, Sheetname);
		
		return data;
		
	}
	
	@Test(dataProvider="testdata")
	
	public void exceltest(String username,String password) throws Exception {
		driver.get("https://example.testproject.io/web/");
		tsp=new Testproject(driver);
		tsp.TS_username(username);
		tsp.TS_password(password);
		tsp.TS_loginbutton();
		Thread.sleep(3000);
		
		System.out.println(username+"  |  "+password);
		
		
	}
	
	public Object [][] readexceldata(String xlpath,String Sheetname) throws Exception {
		
		Exceldatautistest edt=new Exceldatautistest(xlpath, Sheetname);
		
	int Rownum=	edt.getRowcount(0);
	int Colnum=edt.getColmcount(0);
	
  Object data [][] =new Object [Rownum-1][Colnum];
	
	for(int i=1; i<Rownum;i++) {
		for(int j=0;j<Colnum;j++) {
		data	[i-1][j] =  edt.getexceldata(i, j);
		}
		
		
	}return data;
		
	}
	@AfterTest
	
	public void teardown() {
		
		driver.close();
		
		System.out.println("######Completed*********");
	}

}
