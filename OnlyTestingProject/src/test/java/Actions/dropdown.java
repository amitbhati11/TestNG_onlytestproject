package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class dropdown {
	WebDriver driver;
	
	@Parameters("Browser")
	@BeforeTest
	
	public void setup(String Browser) {
		
		System.out.println("The browser is:"+Browser);
		
		if (Browser.contains("Chrome")) {
			String cpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", cpath);
			driver=new ChromeDriver();
			
		}else if(Browser.contains("Firefox")) {
			String geckopath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",geckopath);
			driver=new FirefoxDriver();
		}
		
	}
		
		@Test
		
		public void testexecution() throws InterruptedException {
			driver.get("http://only-testing-blog.blogspot.com/2013/09/test.html");
			WebElement ele=driver.findElement(By.xpath("//option[text()='Russia']"));
			ele.click();
			Select st=new Select(ele);
			st.selectByValue("RUS");
			Thread.sleep(2000);
			WebElement we=driver.findElement(By.xpath("//option[text()='Japan']"));
			Thread.sleep(2000);
			Select sb=new Select(we);
			sb.selectByVisibleText("Japan");
			Thread.sleep(2000);
			
		}
		
		@AfterTest
		
		public void teardown() {
			System.out.println("done");
			
			//driver.close();
		}
		
		
		
		
	}


