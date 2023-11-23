package apisfree.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import apisecfree.base.TestBase;
import apisecfree.pages.HomePage_SpecUrl;
import apisecfree.util.TestUtil;
public class HomePage_SpecUrlTest extends TestBase  {
	 HomePage_SpecUrl HomePage_SpecUrl;
	 TestUtil TestUtil;
	
	public HomePage_SpecUrlTest() {
		super();	}
	 
	 @BeforeMethod
	    public void setUp() throws IOException, InterruptedException {
		 WebDriver driver = initialization();		
	       HomePage_SpecUrl = new HomePage_SpecUrl(driver);
	       TestUtil = new TestUtil();
	       
	    }

	@Test
	    public void validateSpecUrlTest() throws IOException, InterruptedException {
		
	        // Retrieve URLs from Excel sheet
	        List<String> specUrls = TestUtil.GetUrls();
	        if(specUrls.isEmpty()) {
	        	System.out.println("it is null" );
	        }

	        // Iterate through URLs and perform validations
	        for (String specUrl : specUrls) {
	
	        	Assert.assertTrue(HomePage_SpecUrl.validateSpecUrl(specUrl));
	            
	            // Add assertions based on your validation logic
	        	
	        }
	    }
	
}