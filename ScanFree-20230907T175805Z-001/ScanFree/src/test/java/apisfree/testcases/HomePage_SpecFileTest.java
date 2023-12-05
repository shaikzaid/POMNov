package apisfree.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import apisecfree.base.TestBase;
import apisecfree.pages.HomePage_SpecFile;
import apisecfree.pages.HomePage_SpecUrl;
import apisecfree.util.FileUtil;

public class HomePage_SpecFileTest extends TestBase {
	HomePage_SpecFile HomePage_SpecFile;
	HomePage_SpecUrl HomePage_SpecUrl;
	FileUtil FileUtil;

	public HomePage_SpecFileTest() {
		super();
	}
	
	 @BeforeMethod
	public void setUp() {
		this.driver = initialization();
		HomePage_SpecFile=new HomePage_SpecFile(driver);
		 HomePage_SpecUrl=new HomePage_SpecUrl(driver);
		 FileUtil = new FileUtil();
		
	}
	@Test
	public void validateSpecFile() throws InterruptedException, IOException {
		   File[] files= FileUtil.GetFiles();
        for (File file : files) {
        	Assert.assertTrue(HomePage_SpecFile.validateSpecFile(file));	
		 System.out.println("SpecAnalysis Completed ");
    	 HomePage_SpecUrl.clickRunTestButton();
    	 Assert.assertTrue(HomePage_SpecUrl.isBackButtonEnabled());	 
    	 Thread.sleep(9000);
    	 System.out.println("RunTest Completed ");
    	driver.get("https://ui.apisecfree-stg-ui.apisec.ai/product.html");	  
	}
}}
