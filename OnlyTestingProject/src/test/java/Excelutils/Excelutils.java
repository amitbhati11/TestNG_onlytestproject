package Excelutils;

import org.testng.annotations.Test;

public class Excelutils {
	
	@Test
	public void Exceldata() throws Exception {
		
		String xlpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\Datautils\\DataTestNG.xlsx";
		String Sheetname="Sheet1";
		Execl_TestNG excl=new Execl_TestNG(xlpath,Sheetname);
		
		excl.readexcel(0, 0);
		excl.readexcel(0, 1);
		excl.readexcel(0, 2);
		excl.readexcel(1, 0);
		excl.readexcel(1, 1);
		excl.readexcel(1, 2);
		
		
		
		
		
		
	}

}
