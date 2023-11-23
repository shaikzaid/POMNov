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

public class ScansTest {
	
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
	
	

	
	

	@Test(enabled=false)
	public void MultipleTC() throws IOException, InterruptedException{
		
		
		FileInputStream fs = new FileInputStream("C:\\Users\\RED TAG\\Downloads\\ScanFree-20230907T175805Z-001\\ScanFree\\src\\test\\java\\utils\\testdata.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		
		XSSFSheet sheet = workbook.getSheetAt(6);
		
		int rowcount =sheet.getLastRowNum();
		int colcount =sheet.getRow(1).getLastCellNum();
		
        int ifStatementCounter = 0;
        int elseStatementCounter = 0;
		
		for(int i=1;i<=rowcount;i++)
		{
			XSSFRow celldata=sheet.getRow(i);
			
			String spec=celldata.getCell(0).getStringCellValue();
			
			
			driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
			driver.findElement(By.xpath("//input[@id='openAPISpec']")).clear();

			
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("saqlain@apisec.ai");		
			Thread.sleep(2000);			
			driver.findElement(By.xpath("//input[@id='openAPISpec']")).sendKeys(spec);
			

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("document.getElementById('btn').click();");
			
			
			Thread.sleep(10000);

			
			if(driver.findElement(By.xpath("//*[@id=\"keyerror1\"]")).isDisplayed()){
				Thread.sleep(2000);
				ifStatementCounter++;

		    }else{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(900));
				Thread.sleep(3000);
				
				WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[1]/div/div[4]/div/div/table/tbody/tr[1]/th")));				
//				WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[2]/div/div[2]/div[2]/div")));
				jse.executeScript("arguments[0].click();", element);
				 
				elseStatementCounter++;
				 
				 
//				WebElement element4 =driver.findElement(By.xpath ("/html/body/section/div[1]/div[1]/button"));
//				
//		        JavascriptExecutor executor = (JavascriptExecutor) driver;
//		        executor.executeScript("arguments[0].click();", element4);
				
				driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/button")).click();
		    }
			

	}
		System.out.println("The invalid/Big API statement was executed " + ifStatementCounter + " times.");
        System.out.println("The Valid statement was executed " + elseStatementCounter + " times.");
	}
	
	
	@Test(enabled=false)
	public void ProdTC1() throws IOException, InterruptedException{
		
		
		FileInputStream fs = new FileInputStream("C:\\Users\\Saqlain-Apisec\\eclipse-workspace\\ScanFree\\src\\test\\java\\utils\\testdata.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		
		XSSFSheet sheet = workbook.getSheetAt(5);
		
		int rowcount =sheet.getLastRowNum();
		int colcount =sheet.getRow(1).getLastCellNum();
		
        int ifStatementCounter = 0;
        int elseStatementCounter = 0;
		
		for(int i=1;i<=rowcount;i++)
		{
			XSSFRow celldata=sheet.getRow(i);
			
			String spec=celldata.getCell(0).getStringCellValue();
			
			
	        

	        // Use JavascriptExecutor to scroll to the element
	        JavascriptExecutor jse1 = (JavascriptExecutor)driver;
	        WebElement elementemail = driver.findElement(By.xpath("/html/body/div[5]/section[2]/div/div[1]/div/h2/strong"));
	        jse1.executeScript("arguments[0].scrollIntoView();", elementemail);
	        
			
//			driver.findElement(By.xpath("/html/body/main/section/div[1]/div/div/div/div/div/form/div[1]/div[2]/div/input")).clear();
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
	        WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/section[2]/div/div[2]/div/iframe")));
	        
	        WebElement iframe = driver.findElement(By.id("myIframe"));
	        driver.switchTo().frame(iframe);
	        
			driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
			driver.findElement(By.xpath("//input[@id='openAPISpec']")).clear();
			


			
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("saqlain@apisec.ai");		
			Thread.sleep(2000);			
			driver.findElement(By.xpath("//input[@id='openAPISpec']")).sendKeys(spec);
			

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("document.getElementById('btn').click();");
			
			
			Thread.sleep(10000);

			
			if(driver.findElement(By.xpath("/html/body/main/section/div[7]/div[1]/div/h4/span[1]")).isDisplayed()){
				Thread.sleep(1000);
				ifStatementCounter++;
//				WebElement element3 =driver.findElement(By.xpath ("//*[@id=\"header\"]/div/div/a"));
//				
//		        JavascriptExecutor executor = (JavascriptExecutor) driver;
//		        executor.executeScript("arguments[0].click();", element3);
				
				driver.switchTo().defaultContent();

		    }else{	        
		        
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(600));
				

				WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[1]/div/div[4]/div/div/table/tbody/tr[1]/th")));				
//				WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[2]/div/div[2]/div[2]/div")));
				jse.executeScript("arguments[0].scrollIntoView();", element);
				 
				Thread.sleep(1000);
				elseStatementCounter++;
				
				driver.switchTo().defaultContent();
				
		        JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		        WebElement elementemail1 = driver.findElement(By.xpath("/html/body/div[5]/section[2]/div/div[1]/div/h2/strong"));
		        jse2.executeScript("arguments[0].scrollIntoView();", elementemail1);
		        
		        WebElement iframe2 = driver.findElement(By.id("myIframe"));
		        driver.switchTo().frame(iframe2);
		        
				WebElement element4 =driver.findElement(By.id ("previousBtn"));
				
		        JavascriptExecutor executor = (JavascriptExecutor) driver;
		        executor.executeScript("arguments[0].click();", element4);
				 
				 
//				driver.findElement (By.id ("previousBtn")).click();
				
				driver.switchTo().defaultContent();
		    }
			

	}
		System.out.println("The invalid/Big API statement was executed " + ifStatementCounter + " times.");
        System.out.println("The Valid statement was executed " + elseStatementCounter + " times.");
	}
	
	
	
	
	@Test(enabled=false)
	public void ValidTC1() throws IOException, InterruptedException{
		
		
		FileInputStream fs = new FileInputStream("C:\\Users\\Saqlain-Apisec\\eclipse-workspace\\ScanFree\\src\\test\\java\\utils\\testdata.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rowcount =sheet.getLastRowNum();
		int colcount =sheet.getRow(1).getLastCellNum();
		
		for(int i=1;i<=rowcount;i++)
		{
			XSSFRow celldata=sheet.getRow(i);
			
			String spec=celldata.getCell(0).getStringCellValue();
			
			driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
			driver.findElement(By.xpath("//input[@id='openAPISpec']")).clear();

			
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("saqlain@apisec.ai");	
			
			
			driver.findElement(By.xpath("//input[@id='openAPISpec']")).sendKeys(spec);
			

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("document.getElementById('btn').click();");
			
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(900));
			Thread.sleep(3000);
			
			WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[1]/div/div[4]/div/div/table/tbody/tr[1]/th")));				
//			WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[2]/div/div[2]/div[2]/div")));
//			jse.executeScript("arguments[0].scrollIntoView();", element);
			 
	 
			 
//			WebElement element4 =driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/button"));
//			
//			Thread.sleep(5000);
//			
//	        JavascriptExecutor executor = (JavascriptExecutor) driver;
//	        jse.executeScript("arguments[0].scrollIntoView();", element4);
//	        executor.executeScript("arguments[0].click();", element4);
			
			
			driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/button")).click();
						
			Thread.sleep(5000);
	}
		
	}
	
	
	@Test(enabled=false)
	public void InvalidTC1() throws IOException, InterruptedException {
	    FileInputStream fs = new FileInputStream("C:\\Users\\Saqlain-Apisec\\eclipse-workspace\\ScanFree\\src\\test\\java\\utils\\testdata.xlsx");
	    // Creating a workbook
	    XSSFWorkbook workbook = new XSSFWorkbook(fs);

	    XSSFSheet sheet = workbook.getSheetAt(1);

	    int rowcount = sheet.getLastRowNum();
	    int colcount = sheet.getRow(1).getLastCellNum();

	    for (int i = 1; i <= rowcount; i++) {
	        XSSFRow celldata = sheet.getRow(i);

	        String spec = celldata.getCell(0).getStringCellValue();
	        
			driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
			driver.findElement(By.xpath("//input[@id='openAPISpec']")).clear();

			
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("saqlain@apisec.ai");	

	        driver.findElement(By.xpath("//input[@id='openAPISpec']")).sendKeys(spec);
	        
	        

	        JavascriptExecutor jse = (JavascriptExecutor) driver;
	        jse.executeScript("document.getElementById('btn').click()");
	        
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(600));
			
			WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"keyerror1\"]")));				

			jse.executeScript("arguments[0].scrollIntoView();", element);
			 
			Thread.sleep(1000);      
	        
	    }

	   
	}
	

	@Test(enabled=false)
	public void TroubleTC1() throws IOException, InterruptedException{
		
		
		FileInputStream fs = new FileInputStream("C:\\Users\\Saqlain-Apisec\\eclipse-workspace\\ScanFree\\src\\test\\java\\utils\\testdata.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		
		XSSFSheet sheet = workbook.getSheetAt(2);
		
		int rowcount =sheet.getLastRowNum();
		int colcount =sheet.getRow(1).getLastCellNum();
		
		for(int i=1;i<=rowcount;i++)
		{
			XSSFRow celldata=sheet.getRow(i);
			
			String spec=celldata.getCell(0).getStringCellValue();
			
			driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
			driver.findElement(By.xpath("//input[@id='openAPISpec']")).clear();

			
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("saqlain@apisec.ai");	
			
			
			driver.findElement(By.xpath("//input[@id='openAPISpec']")).sendKeys(spec);
			

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("document.getElementById('btn').click();");
			
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(600));
			
			WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"keyerror1\"]")));				

			jse.executeScript("arguments[0].scrollIntoView();", element);
			 
			Thread.sleep(1000);  
	}
	}
	
	@Test(enabled=false)
	public void OASTC1() throws IOException, InterruptedException{
		
		
		FileInputStream fs = new FileInputStream("C:\\Users\\Saqlain-Apisec\\eclipse-workspace\\ScanFree\\src\\test\\java\\utils\\testdata.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		
		XSSFSheet sheet = workbook.getSheetAt(3);
		
		int rowcount =sheet.getLastRowNum();
		int colcount =sheet.getRow(1).getLastCellNum();
		
		for(int i=1;i<=rowcount;i++)
		{
			XSSFRow celldata=sheet.getRow(i);
			
			String spec=celldata.getCell(0).getStringCellValue();
			
			driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
			driver.findElement(By.xpath("//input[@id='openAPISpec']")).clear();

			
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("saqlain@apisec.ai");	
			
			
			driver.findElement(By.xpath("//input[@id='openAPISpec']")).sendKeys(spec);
			

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("document.getElementById('btn').click();");
			
			Thread.sleep(10000);
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(900));
			Thread.sleep(3000);
			
			WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[1]/div/div[4]/div/div/table/tbody/tr[1]/th")));				


			 
			Thread.sleep(1000);			 

			
			
			driver.findElement(By.xpath("/html/body/section/div[1]/div[1]/button")).click();
						
			Thread.sleep(1000);
	}
	}
	

	
	@Test(enabled=false)
	public void BaseTC1() throws IOException, InterruptedException{
		
		
		FileInputStream fs = new FileInputStream("C:\\Users\\Saqlain-Apisec\\eclipse-workspace\\ScanFree\\src\\test\\java\\utils\\testdata.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		
		XSSFSheet sheet = workbook.getSheetAt(4);
		XSSFSheet sheet1 = workbook.getSheetAt(5);
		
		int rowcount =sheet.getLastRowNum();
		int colcount =sheet.getRow(1).getLastCellNum();
		
		for(int i=1, j=1;i<=rowcount;i++,j++)
		{
			XSSFRow celldata=sheet.getRow(i);
			
			XSSFRow celldata2=sheet1.getRow(j);
			
			String spec=celldata.getCell(0).getStringCellValue();
			String spec1=celldata2.getCell(0).getStringCellValue();
			
			driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
			driver.findElement(By.xpath("//input[@id='openAPISpec']")).clear();

			
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("saqlain@apisec.ai");	
			
			
			driver.findElement(By.xpath("//input[@id='openAPISpec']")).sendKeys(spec);
			
			driver.findElement(By.xpath("//input[@id='openAPISpec']")).sendKeys(spec1);
			

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("document.getElementById('btn').click();");
			
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(900));
			
			WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"errorresult2\"]/div/h4/span")));
			jse.executeScript("arguments[0].scrollIntoView();", element);
			 
			Thread.sleep(3000);
	}
	}
	
	@Test(enabled=false)
	public void FileUploadTC() throws IOException, InterruptedException{

	        List<String> filePaths = Arrays.asList(
	                "C:\\Users\\Saqlain-Apisec\\Desktop\\Extra Validations\\Auto3\\Wso2.json",
	                "C:\\Users\\Saqlain-Apisec\\Desktop\\Extra Validations\\Auto3\\Xapi.json"
	        );
	        

	        Thread.sleep(3000);	        


	        for (String filePath : filePaths) {
	        	
		        WebElement element = driver.findElement(By.linkText("Upload a Spec"));
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click()", element);
		    	
		    	Thread.sleep(3000);
		        
		    	WebElement fileInput = driver.findElement(By.id("getFile"));
	        	
	            fileInput.sendKeys(filePath);
	            
				Thread.sleep(10000);
				
				if(driver.findElement(By.xpath("//*[@id=\"keyerror\"]")).isDisplayed()){
					Thread.sleep(5000);
					driver.findElement (By.xpath ("//*[@id=\"header\"]/div/div/a")).click();
			    }else{
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(900));
					
					WebElement element1 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[2]/div/div[2]/div[2]/div")));
					js.executeScript("arguments[0].scrollIntoView();", element1);
					 
					Thread.sleep(7000);
					 
					 
					driver.findElement (By.xpath ("//*[@id=\"header\"]/div/div/a")).click();
			    }

	        }
	}
	
	@Test(enabled=false)
	public void FileUploadTCX() throws IOException, InterruptedException{

        String directoryPath = "C:\\Users\\Saqlain-Apisec\\Desktop\\Extra Validations\\Autoa3\\";

        
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        
        int ifStatementCounter = 0;
        int elseStatementCounter = 0;

        
        for (File file : files) {
	        WebElement element = driver.findElement(By.linkText("Upload a Spec"));
	    	JavascriptExecutor js1 = (JavascriptExecutor)driver;
	    	js1.executeScript("arguments[0].click()", element);
	    	
	    	Thread.sleep(3000);
	    	
	        
	    	WebElement fileInput = driver.findElement(By.id("getFile"));
            
	    	
	    	if(file.isFile()) {
	    		fileInput.sendKeys(file.getAbsolutePath());
	    	}

				Thread.sleep(10000);
				
				if(driver.findElement(By.xpath("//*[@id=\"keyerror\"]")).isDisplayed()){
					Thread.sleep(5000);
					ifStatementCounter++;
					driver.findElement (By.xpath ("//*[@id=\"header\"]/div/div/a")).click();
			    }else{
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(900));
					
					WebElement element1 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[2]/div/div[2]/div[2]/div")));
					JavascriptExecutor js2 = (JavascriptExecutor)driver;
					js2.executeScript("arguments[0].scrollIntoView();", element1);
					 
					Thread.sleep(7000);
					ifStatementCounter++;
					 
					 
					driver.findElement (By.xpath ("//*[@id=\"header\"]/div/div/a")).click();
			    }

	        }
	}

}
