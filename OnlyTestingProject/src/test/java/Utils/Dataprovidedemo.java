package Utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovidedemo {
	WebDriver driver;
	@BeforeTest
	
	public void setup() {
		
		String dpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\geckodriver.exe";
		
		System.setProperty("webdriver.gecko.driver", dpath);
		
		driver=new FirefoxDriver();
		
	}
	
	@DataProvider(name="testdata")
	
	public Object [] [] getdataexcel() throws Exception{
		
		String exlpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\Datautils\\FBcred.xlsx";
		
		String sheetname="Sheet1";
		
		Object data [][]= readexcel(exlpath, sheetname);
		
		
		return data;
		
		}
	
	@Test(dataProvider="testdata")
	
	public void Finaltest(String username, String password) {
		
		driver.get("https://www.facebook.com/login/");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("loginbutton")).click();
		
		System.out.println(username+" | "+password);
	}
	
	
	
	public Object [] [] readexcel(String exlpath, String sheetname) throws Exception {
		
		Excelutilsdemo ed=new Excelutilsdemo(exlpath, sheetname);
		
	int Rownum=	ed.getrowcount(0);
	int Cellnum=	ed.getcellcount(0);
	
	Object data [][]  = new Object [Rownum-1][Cellnum];
	
	for(int i=1; i<Rownum;i++) {
		for(int j=0;j<Cellnum;j++) {
			
			data [i-1][j]=ed.getcelldata(i, j);
		}System.out.println();
	}return data;
	
	
		 
	}
	

}
