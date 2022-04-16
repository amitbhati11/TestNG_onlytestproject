package Propertiesclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Properties;

import Tests.Dataproviderdemo1;

 

public class Propertydata {

	Properties prop=new Properties();

	String path="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\Confi.properties";
	public void testreadmethod() throws Exception {
		
	FileInputStream fis=new FileInputStream(path);
	
	prop.load(fis);
	
	       String Browser=prop.getProperty("Browser");
	       
	      Dataproviderdemo1.Browser=prop.getProperty("Browser");
	       
	       
	}
	
	public void writefiledata() throws IOException {
		
		FileOutputStream out=new FileOutputStream(path);
		
		
		prop.setProperty("result", "pass");
		prop.store(out, null);
		
		
		
		
	}

}
