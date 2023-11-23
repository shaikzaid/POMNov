package APIsecFree.ScanFree;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;


public class ValidFile {

	WebDriver driver;
	

	@BeforeTest
	public void beforetest() throws IOException{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
//		driver.get("https://www.apisec.ai/product");
		driver.get("http://test-scan.apisec.ai/product.html");
		

		
//		driver.get("https://apisecfree-4w7ghmnvva-uw.a.run.app/product.html");
		
		driver.manage().window().maximize();
	}
	
	
	
	@Test(enabled=true)
	public void FileUploadTCX() throws IOException, InterruptedException{

        String directoryPath = "C:\\Users\\Saqlain-Apisec\\Desktop\\Extra Validations\\Autoa3\\";

        
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("uiauto@apisec.ai");	

        
        for (File file : files) {
	        WebElement element = driver.findElement(By.linkText("Upload a Spec"));
	    	JavascriptExecutor js1 = (JavascriptExecutor)driver;
	    	js1.executeScript("arguments[0].click()", element);
	    	
	    	Thread.sleep(3000);
	    	
	        
	    	WebElement fileInput = driver.findElement(By.id("getFile"));
            
	    	
	    	if(file.isFile()) {
	    		fileInput.sendKeys(file.getAbsolutePath());
	    	}
	    	
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("document.getElementById('btn').click();");
				
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(900));
					
					WebElement element1 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[1]/div/div[4]/div/div/table/tbody/tr[1]/th")));
					JavascriptExecutor js2 = (JavascriptExecutor)driver;
					js2.executeScript("arguments[0].scrollIntoView();", element1);
					 
					Thread.sleep(7000);
					 
					 
					driver.findElement (By.xpath ("/html/body/section/div[1]/div[1]/button")).click();
			    }

	        }
	}



