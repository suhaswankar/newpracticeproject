package Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ReaderFile {
	
	
	public static  String FileReader(String key) throws IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\SSK\\eclipse-workspace\\MyProject\\property.properties");
		Properties prop = new Properties();
		prop.load(file);
		
		String value = prop.getProperty(key);
		return value;
		
	}
	
	public static void screenshort(WebDriver driver, String name) throws IOException {
		
		TakesScreenshot src = new ChromeDriver();
		File shot = src.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("C:\\Users\\SSK\\eclipse-workspace\\MyProject\\Screenshot" + name + ".jpg");
		FileHandler.copy(shot, dest);
		
	}

}
