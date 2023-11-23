package apisecfree.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import apisecfree.base.TestBase;

public class HomePage1 extends TestBase {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"openAPISpec\"]")
    WebElement SpecTextboxText;

    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement EmailTextboxText;

    @FindBy(xpath = "//*[@id=\"uploadLink\"]")
    WebElement upload;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement Submitbtn;

    @FindBy(xpath = "//*[@id=\"runSampleSpecAnalysis\"]")
    WebElement SampleSpecAnalysisLink;

    @FindBy(xpath = "//*[@id=\"runSample\"]")
    WebElement SampleScanLink;

    public HomePage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean validateSampleSpecAnalysisLink() {
        return SampleSpecAnalysisLink.isDisplayed();
    }

    public boolean validateSampleScanLink() {
        return SampleScanLink.isDisplayed();
    }

    public String validateSpecTextboxText() {
        return SpecTextboxText.getText();
    }

    public String validateEmailTextboxText() {
        return EmailTextboxText.getText();
    }

    public boolean validateSubmitbtn() {
        return Submitbtn.isEnabled();
    }
}