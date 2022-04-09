package Excelutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderutils {
	WebDriver driver;
	@BeforeTest
	
	public void setup() {
		String path="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",path);
		driver=new ChromeDriver();
		
		
	}
	
	@Test(dataProvider="test1")
	
	public void finaldata(String username,String password) throws Exception
	{
		driver.get("https://example.testproject.io/web/");
		driver.findElement(By.id("name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		Thread.sleep(2000);
		
		System.out.println(username+" | "+password);
	}
	@AfterTest
	public void teardown() {
		
		driver.close();
		
	System.out.println("test is completed");
			}
	@DataProvider(name="test1")
	
	public Object[][] getdata()  {
		
		String filepath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\Datautils\\loginDataprovider.xlsx";
		
	     Object data[][] = testdata(filepath,"Sheet1");
		
		return data;
	
	}
	

	public Object [][] testdata(String path,String sheetname)  {
		
		
		DataexcelUtils du = null;
		try {
			du = new  DataexcelUtils(path, sheetname);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	int rowCount=	du.getrowcount();
	int cellCount=	du.getcellcount();
	 
	Object data [][]=new Object[rowCount-1][cellCount] ; 
	
	for(int i=1;i<rowCount;i++) {
		for(int j=0;j<cellCount;j++) {

       String exceldata=du.getcelldata(i, j);
 
      //  System.out.print(exceldata+" | ");
        data[i-1][j]=exceldata;
 
		
	}
	//System.out.println();	
				
	}
return data;
		
	}

}
