package apisecfree.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import apisecfree.base.TestBase;

public class ResultsPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(name="openAPISpec")
	WebElement openAPISpec;
	
	@FindBy(name="email")
	WebElement email;

}
