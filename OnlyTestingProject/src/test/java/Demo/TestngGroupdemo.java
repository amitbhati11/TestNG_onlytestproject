package Demo;

import org.testng.annotations.Test;

//@Test(groups= {"All test cases"})
public class TestngGroupdemo {
	@Test(groups= {"sainty"})
	public void test1() {
		System.out.println( "i m inside test1");
		
	}
	
	@Test(groups= {"sainty","regression"})
	public void test2() {
		System.out.println( "i m inside test2");
		
	}
	@Test(groups= {"smoke"})
	public void test3() {
		System.out.println( "i m inside test3");
		
	}
	
	@Test
	public void test4() {
		System.out.println( "i m inside test4");
		
	}
	
	@Test(groups= {"regression"})
	public void test5() {
		System.out.println( "i m inside test5");
		
	}

}
