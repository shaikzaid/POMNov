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


public class AddBaseUrl {

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
	public void BaseUrlTC() throws IOException, InterruptedException{
		
		
		FileInputStream fs = new FileInputStream("C:\\Users\\RED TAG\\Downloads\\ScanFree-20230907T175805Z-001\\ScanFree\\src\\test\\java\\utils\\testdata.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		
		XSSFSheet sheet = workbook.getSheetAt(4);
		
		int rowcount =sheet.getLastRowNum();
		int colcount =sheet.getRow(1).getLastCellNum();
		
		for(int i=1;i<=rowcount;i++)
		{
			XSSFRow celldata=sheet.getRow(i);
			
			String spec=celldata.getCell(0).getStringCellValue();
			
			driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
			driver.findElement(By.xpath("//input[@id='openAPISpec']")).clear();

			
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("uiauto@apisec.ai");	
			
			
			driver.findElement(By.xpath("//input[@id='openAPISpec']")).sendKeys(spec);
			

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("document.getElementById('btn').click();");
			
			
			
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
			
			WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/section/div[5]/div/div/div/div/form/input")));
			jse.executeScript("arguments[0].scrollIntoView();", element);
			 
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//input[@id='baseUrlInput']")).sendKeys("google.com");
			
			Thread.sleep(2000);
			
			
			WebElement element4 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/section/div[5]/div/div/div/div/form/button[1]")));
			jse.executeScript("arguments[0].click()", element4);
			
			
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(900));

			
			WebElement element1 =wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[1]/div/div[4]/div/div/table/tbody/tr[1]/th")));				
			
			Thread.sleep(3000);
			
			

		
		driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/button")).click();
						
			Thread.sleep(3000);
	}
		
	}
}


