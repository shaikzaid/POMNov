package apisecfree.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import apisecfree.base.TestBase;


public class HomePage_SampleSpecAnalysis extends TestBase{
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"runSampleSpecAnalysis\"]")
	WebElement SampleSpecAnalysisLink;
	
	public HomePage_SampleSpecAnalysis (WebDriver driver) {  
        this.driver = driver;  
        PageFactory.initElements(driver, this);  
   } 
    
    public void clickSampleSpecAnalysisLink() {
    	SampleSpecAnalysisLink.click();
}
}
