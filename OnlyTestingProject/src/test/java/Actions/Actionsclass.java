package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Actionsclass {
	WebDriver driver;
	@BeforeTest
	
	public void setup() {
		
		String driverpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver=new ChromeDriver();
		
	}
	
	@Test
	
	public void testexcution() throws InterruptedException {
		
		
		driver.get("https://www.indianrail.gov.in/enquiry/SEAT/SeatAvailability.html?locale=en");
		
	//WebElement ele=	driver.findElement(By.id("trainNo"));
//	ele.sendKeys("Arc");
	Thread.sleep(3000);
	/*Actions act=new Actions(driver);
	
	act.sendKeys(Keys.DOWN).perform();
	act.sendKeys(Keys.ENTER).perform();
	*/
	//keydown()
	
	/*Actions selectall=new Actions(driver);
	Action ac=selectall.keyDown(Keys.CONTROL).sendKeys("a").build();
	ac.perform();*/
	
	
	
	//keyup
	
	/*Actions keyup=new Actions(driver);
	keyup.keyUp(Keys.SHIFT).perform();*/
	
	//clear
	WebElement ele=	driver.findElement(By.id("trainNo"));
	ele.sendKeys("arc");
	Actions pr=new Actions(driver);
	pr.sendKeys(Keys.DOWN).perform();
	pr.sendKeys(Keys.ENTER).perform();
	Thread.sleep(3000);
	ele.clear();
	Thread.sleep(2000);
	
	}
	
	@AfterTest
	
	public void teardown() {
		
		System.out.println("completed");
		driver.close();
		
		
		
		
		
	}

}
