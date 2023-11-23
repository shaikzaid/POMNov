package apisecfree.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {
	WebDriver driver;
	 static Properties prop;
	 public static long PAGE_LOAD_TIMEOUT = 20;
	 public static long IMPLICIT_WAIT = 10;
	 
	// public static String TESTDATA_SHEET_PATH = "C:\\Users\\RED TAG\\Downloads\\ScanFree-20230907T175805Z-001\\ScanFree\\src\\main\\java\\apisecfree\\testdata\\testdata.xlsx";
	 
	 FileInputStream fs=null;
	 
		public List GetUrls() throws IOException, InterruptedException{
			List<String> urls = new ArrayList<>();
			try {
				   File file = new File("C:\\Users\\RED TAG\\Downloads\\ScanFree-20230907T175805Z-001\\ScanFree\\src\\main\\java\\apisecfree\\testdata\\APIsecFreeTestData.xlsx");
				    if(!file.exists()){
				     // Proceed with reading the file
				    	System.out.print("File not exists");
				 } else if( file.length() == 0) {
				     System.out.println("The file is empty.");
				 }
				 else if(file.length() > 0) {
					 System.out.print("file is not empty");
					 fs = new FileInputStream(file);
			          
						XSSFWorkbook workbook = new XSSFWorkbook(fs);
						
						XSSFSheet sheet = workbook.getSheetAt(0);
						
						int rowcount =sheet.getLastRowNum();
						//int rowcount =sheet.getFirstRowNum();
						//int colcount =sheet.getRow(1).getLastCellNum();
						int colcount =sheet.getFirstRowNum();
						
						
						for(int i=0;i<=rowcount;i++)
						{
							XSSFRow celldata=sheet.getRow(i);
							// urls.add(encodeUrl(celldata.getCell(0).getStringCellValue()));
							urls.add(celldata.getCell(0).getStringCellValue());
									
							
					}
				 }
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
		        if (fs != null) {
		            fs.close();
		        }
			}
			
			return urls;
							
			}
		
	    private String encodeUrl(String url) {
	        try {
	        	 System.out.println(url+"Try Block  ");
	            return URLEncoder.encode(url, "UTF-8   fcwsffxssxed32x1	");
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(url);
	            return url; // return the original URL in case of encoding issues
	        }
	    }
}
  