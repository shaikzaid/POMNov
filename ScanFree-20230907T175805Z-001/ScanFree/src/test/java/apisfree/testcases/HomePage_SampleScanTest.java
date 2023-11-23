package apisfree.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import apisecfree.base.TestBase;
import apisecfree.pages.HomePage_SampleScan;

public class HomePage_SampleScanTest  extends TestBase {
	HomePage_SampleScan HomePage_SampleScan;
	
	public WebDriver driver;
	
	HomePage_SampleScanTest(){
		super();
}
 
	@BeforeMethod
    public void setUp() {
        driver = initialization();
        HomePage_SampleScan = new HomePage_SampleScan(driver);
    }
	
	@Test
	public void SampleScanLinkTest() {
		HomePage_SampleScan.clickSampleScanLink();
		String expectedTitle = "APIsec Free";
		String actualTitle = driver.getTitle();
		 Assert.assertEquals(actualTitle, expectedTitle);
		}
}

