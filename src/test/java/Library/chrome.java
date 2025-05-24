package Library;

import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;

public class chrome {
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		 System.setProperty("webdriver.chrome.driver", "D:/chromedriver136/chromedriver.exe");
	    	ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.google.com");
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//driver.manage().window().maximize();
			
			Thread.sleep(10000);
			


	}

}



