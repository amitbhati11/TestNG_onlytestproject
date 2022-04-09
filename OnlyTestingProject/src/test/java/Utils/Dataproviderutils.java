package Utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviderutils {
	
	
	@DataProvider(name="test1")
	
	public Object [][] providedata() throws Exception{
		String  excelpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\Datautils\\loginDataprovider.xlsx";
		String sheetname="Sheet1";
		
		Object data [][] =getexceldata( excelpath, sheetname);
		
		return data;
		
	}
	
	@Test(dataProvider="test1")
	
	public void testdata(String username,String password) {
		
		System.out.println(username+"  |  "+password);
		
	}
	
	public Object [][] getexceldata(String excelpath, String sheetname) throws Exception {
		
		EXcelUTils exu=new EXcelUTils(excelpath, sheetname);
		
		int rowcount=exu.getrowcount(0);
       int cellcount= exu.getcellcount(0);	
       
       Object data [][] =new Object[rowcount-1][cellcount];
       
       
       
       for(int i=1;i<rowcount;i++) {
    	   for(int j=0;j<cellcount;j++) {
    		   
     data [i-1][j] =   exu.getcellstringdata(i, j);
    	
    	 }
       }return data;
	}
	
	

}
