package Demo;

import org.testng.annotations.Test;

public class TestPriority_demo {
	
	@Test
	public void one() {
		
		System.out.println("i m inside test1");
	}
	@Test(priority=1)
     public void two() {
		
		System.out.println("i m inside test2");
	}
	@Test(priority=1)
     public void three() {
 		
 		System.out.println("i m inside test3");
 	}
	@Test
     public void four() {
		
		System.out.println("i m inside test4");
	}

}
