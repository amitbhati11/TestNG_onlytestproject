package Proxy;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProxyDemo {

	WebDriver driver;
	
	@BeforeTest
	
	public void setup() {
		
		Proxy proxy=new Proxy();
		
		proxy.setSslProxy("");
		
		ChromeOptions  option=new ChromeOptions();
		
		option.setCapability("Proxy", proxy);
		String path="";
		System.setProperty("webdriver.chrome.driver",path);
		
		driver=new ChromeDriver(option);
	}
	
	@Test
	
	public void testM() {
		
		driver.get("https://www.charlesproxy.com/previous-release/download.do");
		
		
	}
	
	@AfterTest
	
	public void teardown() {
		
		driver.close();
	}
}
