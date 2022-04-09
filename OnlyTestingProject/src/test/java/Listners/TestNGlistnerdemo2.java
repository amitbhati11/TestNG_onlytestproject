package Listners;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.Fbloginpage;

public class TestNGlistnerdemo2 {
	@Test
	public void test5() {
		
		System.out.println("i m inside test5");
	}
	
	@Test
	public void test6() throws Exception {
		
		System.out.println("i m inside test6");
		
	String path="C:\\Users\\Admin_SRV\\eclipse-workspace\\OnlyTestingProject\\drivers\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver",path);
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
    	driver.manage().window().maximize();
    	Thread.sleep(3000);
    	
   
		
	}
	
	@Test
	public void test7() {
		
		System.out.println("i m inside test7");
	}
	
	@Test
	public void test8() {
		
		System.out.println("i m inside test8");
	}

}
