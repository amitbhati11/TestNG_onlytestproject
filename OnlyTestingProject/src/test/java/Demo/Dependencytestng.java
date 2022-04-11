package Demo;

import org.testng.annotations.Test;

public class Dependencytestng {
	
	@Test(dependsOnGroups= {"smoke.*"})
	public void test1() {
		
		System.out.println("test1 is completed");
	}
	@Test(groups= {"smoke1"})
  public void test2() {
		
		System.out.println("test2 is completed");
	}

	@Test(groups= {"smoke2"})
  public void test3() {
	
	System.out.println("test3 is completed");
}
  @Test(dependsOnMethods= {"test6"},priority= 1)
  public void test4() {
	
	System.out.println("test4 is completed");
}
 @Test(priority=1)
   public void test5() {
	
	System.out.println("test5 is completed");
}

 @Test(priority=2)
  public void test6() {
	
	System.out.println("test6 is completed");
}

}
