package Actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class dropdownlist {
	WebDriver driver;
	@Test
	
	public void selectdropdownlist() throws InterruptedException {
		
		String cpath="C:\\Users\\Admin_SRV\\git\\TestNG_onlytestproject\\OnlyTestingProject\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", cpath);
		driver=new ChromeDriver();
		
		driver.get("https://trytestingthis.netlify.app/");
		
		WebElement op=driver.findElement(By.id("option"));
		Select st=new Select(op);
		st.selectByIndex(1);
		Thread.sleep(2000);
		st.selectByValue("option 2");
		Thread.sleep(2000);
		st.selectByVisibleText("Option 3");
		
		WebElement options=driver.findElement(By.id("owc"));
		Select sp=new Select(options);
		//sp.selectByIndex(1);
		Thread.sleep(1000);
		//sp.selectByValue("option 2");
		Thread.sleep(1000);;
		sp.selectByVisibleText("Option 3");
		//diselect
		Thread.sleep(2000);
		sp.deselectByIndex(3);
		
		//list of elements
		List<WebElement> alllist=sp.getOptions();
		List<WebElement> byfinds=driver.findElements(By.id("owc"));
		
		/*for(WebElement list:alllist ) {
			System.out.println(list.getText());
			
			if(list.getText().equalsIgnoreCase("option3")) {
				
				list.click();
				
				Thread.sleep(1000);
				
				driver.close();
			}
		}*/
		
		for(WebElement list1:byfinds) {
			System.out.println(list1.getText());
			if(list1.getText().equalsIgnoreCase("option 2")) {
				
				list1.click();
				Thread.sleep(2000);
				
			}
			
			driver.close();
		}
	}

}
