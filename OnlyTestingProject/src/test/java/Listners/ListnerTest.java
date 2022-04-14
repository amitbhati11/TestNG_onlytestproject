package Listners;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class ListnerTest implements ITestListener {
	WebDriver driver;
	
		
	    public void onFinish(ITestContext context) {					
       System.out.println("****test1"+context.getName());	        		
	    }		

			
	    public void onStart(ITestContext arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	 	
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
	        System.out.println("#####test6"+result.getName());			
	        		
	    }		

	 		
	    public void onTestFailure(ITestResult result) {					
                System.out.println("******test2"+result.getName());	
                
              /*  TakesScreenshot srcshot= (TakesScreenshot)driver;
                File srcfile=srcshot.getScreenshotAs(OutputType.FILE);
                File destfile=new File("C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\target");
                
                try {
					FileUtils.copyDirectory(srcfile, destfile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println();
				}*/
	    }		

			
	    public void onTestSkipped(ITestResult result) {					
            System.out.println("******test3"+result.getName());	        		
	    }		

	  		
	    public void onTestStart(ITestResult result) {					
                 
	    	System.out.println("****test4"+result.getName());
	    }		

	  			
	    public void onTestSuccess(ITestResult result) {					
             System.out.println("*****test5"+result.getName());	        		
	    }		

	

}
