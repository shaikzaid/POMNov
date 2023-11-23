package apisfree.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import apisecfree.base.TestBase;
import apisecfree.pages.HomePage1;

public class HomePageTest_TC1 extends TestBase {

    HomePage1 HomePage1;

    public HomePageTest_TC1() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        WebDriver driver = initialization();
        HomePage1 = new HomePage1(driver);
    }

    @Test
    public void validateSampleScanLinkTest() {
        Assert.assertTrue(HomePage1.validateSampleScanLink());
    }

    @Test
    public void validateSampleSpecAnalysisLinkTest() {
        Assert.assertTrue(HomePage1.validateSampleSpecAnalysisLink());
    }
    @Test
	public void SpecTextboxTextTest() {
		String Text = HomePage1.validateSpecTextboxText();
		Assert.assertEquals(Text,"");
	}
	@Test
	public void EmailTextboxTextTest() { 
		String Text = HomePage1.validateEmailTextboxText();
		Assert.assertEquals(Text,"");
	}
	public void validateSubmitbtnTest() {
				Assert.assertTrue(HomePage1.validateSubmitbtn());
	}
//	@AfterMethod
//	public void teardown(WebDriver driver) {
//	driver.quit();
//	}
}