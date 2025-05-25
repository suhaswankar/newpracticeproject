package Library;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class OpenBrowser {
	
	
	public WebDriver driver;
	public Logger log;
	public ExtentReports report;
	public ExtentTest test;
	public ExtentSparkReporter spark;
	
	@Parameters("browser")
	@BeforeClass
	public void automatebrowser(String br) throws InterruptedException, IOException {
		
		
		log = Logger.getLogger("MyProjectLogs");
		DOMConfigurator.configure("log4j.xml");
		
	
		
		 if (br.equals("chrome")) {
		 
			 System.setProperty("webdriver.chrome.driver", "D:/chromedriver136/chromedriver.exe");
		    	driver = new ChromeDriver();
				driver.get(ReaderFile.FileReader("url"));
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
				System.out.println("browser is opened");
				log.info("Chrome is opened successfully");
				
		 }
		 else if(br.equals("firefox"))  {
			 
			 	driver = new FirefoxDriver();
				driver.get(ReaderFile.FileReader("pcurl"));
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
				System.out.println("broser is opened");
				
				System.out.println("runnig project");
			 
		 }
	}
	
	
	@BeforeMethod
	public void Reporting () {
		
//		Random  RandomNumber = new Random();
//		int num = RandomNumber.nextInt();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		String timestamp = LocalDateTime.now().format(formatter);
		
		
		String path = System.getProperty("user.dir")+"\\MyProject\\Reports"+timestamp+".html";
		
		spark = new ExtentSparkReporter(path);
		
		spark.config().setDocumentTitle("MyProjectReporting");
		spark.config().setReportName("myproject");
		
		
		report = new ExtentReports();
		report.attachReporter(spark);
		
		report.setSystemInfo("TesterName", "Suhas");
		report.setSystemInfo("Environment", "Testing");
		

	}
	
	


}


