package apisecfree.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import apisecfree.base.TestBase;

public class HomePage_SpecUrl extends TestBase {
    WebDriver driver;

    By SpecUrl = By.name("openAPISpec");
    By Email = By.name("email");
    By Submit = By.id("btn");
    By BasicInfoTab = By.name("Basic");
    
    By ParametersTab = By.name("param");

    By OwaspTab = By.name("owaspt");
    

    public HomePage_SpecUrl(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean validateSpecUrl(String specUrl) {
        try {
            driver.findElement(Email).clear();
            driver.findElement(SpecUrl).clear();
            driver.findElement(Email).sendKeys("uiauto@apisec.ai");
            driver.findElement(SpecUrl).sendKeys(specUrl);

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("document.getElementById('btn').click()");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            Thread.sleep(3000);
//            WebElement progressBar;
//
//            try {
//                progressBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='progressOne']/div/progress")));
//            } catch (TimeoutException e) {
//                // Handle the timeout exception
//                System.out.println("Timeout waiting for the progress bar. URL might be taking too long to load.");
//                throw e; // Re-thro   
//            

            WebElement progressBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='progressOne']/div/progress")));
            Thread.sleep(3000);
            Boolean progressBar1 = wait.until(ExpectedConditions.attributeToBe(progressBar, "value", "100"));
            Thread.sleep(3000);
            
           // driver.findElement(BasicInfoTab).click();
            // write if condition to check whether the webelemtn of infotab is visible. 
           // if element.is_displayed():
              //  print("Element is visible.")
            //else:
             //   print("Element is not visible.")
            
            

            WebElement runButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("runbtn")));
            Thread.sleep(3000);

            // The rest of the code after successful validation
            // ...

            return true;
        } catch (Exception e) {
            // Handle exceptions specific to URL validation
            System.out.println("Exception occurred while processing URL: " + specUrl);
            e.printStackTrace(); // This is for debugging purposes, you can customize it.

            // Additional handling based on the type of exception can be added here.
            // For example, you might want to log the exception, mark the URL as invalid, etc.
        } finally {
            // This block will be executed whether an exception occurs or not
            // You can put cleanup or follow-up code here
           driver.get("https://ui.apisecfree-stg-ui.apisec.ai/product.html");
         
        }

        return false; // Return false in case of an exception
    }
    
}