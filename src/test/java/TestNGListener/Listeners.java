package TestNGListener;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Listeners implements ITestListener {
	
public WebDriver driver;
	
	
	public void onTestStart(ITestResult result) {
		
		System.out.println("test execution is started");
	
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is passed");
		
	}
	
	public void onTestFailure(ITestResult result) {
	    // Get the current WebDriver from your test context (pass it from your tests)
	    WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");

	    if (driver instanceof TakesScreenshot) {
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	        String testName = result.getName();
	        String timestamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());

	        String screenshotDir = System.getProperty("user.dir") + "\\MyProject\\Screenshots\\";
	        new File(screenshotDir).mkdirs();

	        File dest = new File(screenshotDir + testName + "_" + timestamp + ".png");

	        try {
	            FileHandler.copy(src, dest);
	            System.out.println("Screenshot saved to: " + dest.getAbsolutePath());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("test is skipped");
	
	}
	
	
	public void onFinish(ITestContext context) {
		System.out.println("test is finished");
		
	}
		
	
	

}
