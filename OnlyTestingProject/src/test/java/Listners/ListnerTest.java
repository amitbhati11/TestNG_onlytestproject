package Listners;

import java.util.Set;

import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class ListnerTest implements ITestListener {
	
	
		
	    public void onFinish(ITestContext context) {					
       System.out.println("****test1"+context.getName());	        		
	    }		

			
	    public void onStart(ITestContext arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	 	
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	 		
	    public void onTestFailure(ITestResult result) {					
                System.out.println("******test2"+result.getName());	        		
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
