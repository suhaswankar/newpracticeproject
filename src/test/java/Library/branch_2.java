package Library;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

public class branch_2 {
	
	
	
		
		public static void main(String[] args) throws IOException, InterruptedException {
			
			 System.setProperty("webdriver.chrome.driver", "D:/chromedriver136/chromedriver.exe");
		    	ChromeDriver driver = new ChromeDriver();
				driver.get("https://www.google.com");
				//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				//driver.manage().window().maximize();
				
				Thread.sleep(10000);
				
				
				System.out.println(" testing file for commit on new branch - sample");
				


		}


}
