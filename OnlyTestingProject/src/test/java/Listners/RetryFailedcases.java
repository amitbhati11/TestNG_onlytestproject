package Listners;

import static org.testng.Assert.assertTrue;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryFailedcases implements IRetryAnalyzer {
	
	private int retryCount = 0;
	  private static final int maxRetryCount = 5;
	 
	  
	  public boolean retry(ITestResult result) {
	    if (retryCount < maxRetryCount) {
	      retryCount++;
	      return true;
	    }
	    return false;
	  }
	

	
	
	@Test
	
	public void Test1() {
		System.out.println("i am inside test1");
		
	}
	
	@Test(retryAnalyzer=Listners.RetryFailedcases.class)
	
	public void Test2() {
		
		System.out.println("i am inside test2");
		int j=1/0;
	}

	
@Test
	
	public void Test3() {
		
		System.out.println("i am inside test4");
	}

}
