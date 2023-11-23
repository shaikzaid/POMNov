package apisecfree.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import apisecfree.base.TestBase;

public class HomePage_SampleScan extends TestBase{
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"runSample\"]")
    WebElement SampleScanLink;
	
	public HomePage_SampleScan (WebDriver driver) {  
        this.driver = driver;  
        PageFactory.initElements(driver, this);  
   } 
	
	// This function is to click on SampleSpecAnalysisLink 
    
    public void clickSampleScanLink() {
    	SampleScanLink.click();
}

}
