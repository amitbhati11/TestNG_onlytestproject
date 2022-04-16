package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseActions {
	WebDriver driver;
	@Test
	
	public void test() throws InterruptedException {
		
		String driverpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver=new ChromeDriver();
		
		driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
		
	WebElement A=	driver.findElement(By.xpath("//li[text()='A']"));
	WebElement D=	driver.findElement(By.xpath("//li[text()='D']"));
	
	Actions action=new Actions(driver);
	action.moveToElement(A);
	action.clickAndHold();
	action.moveToElement(D)
;
	action.contextClick(D);
	action.build().perform();
	action.doubleClick().build().perform();
	Thread.sleep(2000);
	
	driver.get("https://selenium08.blogspot.com/2020/01/drag-drop.html");
	
	WebElement src=driver.findElement(By.id("draggable"));
	WebElement dest=driver.findElement(By.id("droppable"));
	
	Actions dr=new Actions(driver);
	
	dr.dragAndDrop(src, dest).build().perform();
	Thread.sleep(3000);
	driver.quit();
		
	}

}
