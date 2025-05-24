package TestLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLocator {
	
	@FindBy (xpath = ("//input[@id='input-email']")) public WebElement username;
	@FindBy (xpath = ("//input[@id = 'input-password']")) public WebElement Password;
	@FindBy (xpath = ("//input[@class ='btn btn-primary']")) public WebElement loginbtn;
	@FindBy (xpath = ("//div[@class= alert alert-danger alert-dismissible]")) public WebElement alrtmsg;
	
	String warnmsg= "Warning: No match for E-Mail Address and/or Password.passss";
	
	public LoginLocator(WebDriver driver) {
		
		PageFactory.initElements(driver , this);
	}
	
	public void login_username() {
		username.clear();
		username.sendKeys("suhas");
	}
	
	public void login_password() {
		Password.clear();
		Password.sendKeys("suhas@123");
		
	}
	
	public void login_btn() {
		loginbtn.click();
	}
	
	public void login_warningmsg() {
		
		if (warnmsg.equals(alrtmsg)) {
			System.out.println("login failed");
		}
		else {
			System.out.println("Logon successfully");
		}
	}
	
	

}
