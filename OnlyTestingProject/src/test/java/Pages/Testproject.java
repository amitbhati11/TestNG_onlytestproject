package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Testproject {
	
	WebDriver driver;
	
	@FindBy(id="name")
	WebElement us_name;
	
	@FindBy(id="password")
	WebElement us_pass;
	
	
	@FindBy(id="login")
	WebElement lgn_btn;
	
	//Constructor
	
	public Testproject(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
		}
	 public void TS_username(String username) {
		 us_name.sendKeys(username);
	 }
	 public void TS_password(String password) {
		 
		 us_pass.sendKeys(password);
		 
	 }
	 
	 public void TS_loginbutton() {
		 
		 
		lgn_btn.click();
	 }

}
