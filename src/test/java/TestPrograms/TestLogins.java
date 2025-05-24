package TestPrograms;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Library.OpenBrowser;
import TestLocator.LoginLocator;

public class TestLogins extends OpenBrowser {

	LoginLocator login ;
	
	String Name;

	
	@Test
	public void Testing() throws InterruptedException {
		
		login =  new LoginLocator(driver);
		
		Thread.sleep(3000);
		login.login_username();
		
		Thread.sleep(3000);
		login.login_password();
		
		Thread.sleep(3000);
		login.login_btn();
		
		Thread.sleep(3000);
		login.login_warningmsg();
		
		
		
	}
	
	@AfterClass
	public void CloseBrowser() {
		driver.close();
	}


	

}
