package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Fbloginpage {
	
	WebDriver driver;
	
	@FindBy(xpath="//img[@alt='Facebook']")
	WebElement fblogo;
	
	
	@FindBy(xpath="//input[starts-with(@id,'email')]")
	WebElement us_name;
	
	@FindBy(xpath="//input[@name='pass']")
	WebElement us_pwd;
	
	@FindBy(xpath="//button[@id='loginbutton']")
	WebElement lgn_btn;
	
	
	//constructor
	
	public Fbloginpage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void testlogo() {
		
		fblogo.isDisplayed();
	}
	
	public void username(String name) {
		
		us_name.sendKeys(name);
	}
	
	public void password(String pass) {
		
		us_pwd.sendKeys(pass);
	}
	
	public void loginbutton() {
		
		lgn_btn.click();
	}

}
