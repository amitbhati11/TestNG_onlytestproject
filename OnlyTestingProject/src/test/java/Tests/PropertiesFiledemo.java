package Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFiledemo {
	static String configpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\config.properties";
	static Properties prop=new Properties();
	
	
	public static void main(String [] xyz) {
		
		getdatafromproperties();
		writedatainproperties();
	}
	
	public static void getdatafromproperties() {
		
		
		
		
		try {
			 
			
			FileInputStream fis=new FileInputStream(configpath);
			
				prop.load(fis);
			String Browser1=	prop.getProperty("browser");
			PropertiesTestNGDemo.Browser=Browser1;
			
			System.out.println(Browser1);
			
			
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

   
public static void writedatainproperties() {
	
	try {
		FileOutputStream output=new FileOutputStream(configpath);
		
		prop.setProperty("result","pass");
		prop.store(output, null);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
