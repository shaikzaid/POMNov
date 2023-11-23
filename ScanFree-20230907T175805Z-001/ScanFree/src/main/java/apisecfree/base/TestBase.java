package apisecfree.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import apisecfree.pages.HomePage1;
import apisecfree.util.TestUtil;

public class TestBase {
	HomePage1 HomePage1;
	 protected  WebDriver driver;
	//Initializing driver with static variable//
	
	static Properties prop;
	//prop is a global variable used through out the program, inside child class and testbase//
	
	//TestBase is a constructor.create constructor and read the properties//
	//ip reference variable//
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream config = new FileInputStream("C:\\Users\\RED TAG\\Downloads\\ScanFree-20230907T175805Z-001\\ScanFree\\src\\main\\java\\apisecfree\\config\\config.properties");
			//FileInputStream ip = new FileInputStream(prop.getProperty("propertyfiles"));//path of property files//
			prop.load(config);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 public WebDriver initialization() {
		 String browserName = prop.getProperty("browser");
		 WebDriver driver = null;
		 
		 
		 
		 if(browserName.equals("chrome")) {
			 System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriverpath"));
			  driver = new ChromeDriver();//UpCasting.
			 }
		 
		 if (driver != null) {
			
			 driver.manage().window().maximize();
			 driver.manage().deleteAllCookies();
//			 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			 driver.get(prop.getProperty("url"));
			
			
		 }
		 return driver; 
			 
		 }
		
		 
		 //else if(browserName.equals("FF")){
			// System.setProperty("webdriver.gecko.driver","\\Users\\RED TAG\\OWASP ZAP\\webdriver\\windows\\32"\\geckodriver.exe");
			// WebDriver driver = new FirefoxDriver();
		// }
		 //public String getDriverPath(){
			//	String driverPath = Properties.getprop("chromedriverpath");
				//if(driverPath!= null) return driverPath;
				//else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
			//}
		 //driver.get("http://test-scan.apisec.ai/product.html");
		 //driver.manage().window().maximize();
		 //driver.manage().deleteAllCookies();
		 //driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		 //driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		 
		
	 }