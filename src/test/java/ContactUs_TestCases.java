import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LeanwarePage;

import static base.Utilities.initialization;
import static base.Utilities.suiteFinalization;


public class ContactUs_TestCases {
    private WebDriver driver;

    @BeforeClass
    public void navigateToPage() {
        initialization("https://www.leanware.co/");
    }

    @Test
    public void testContactUsButtonFunctionality() {

        LeanwarePage leanwarePage = new LeanwarePage();
        leanwarePage.contactUs();
        Assert.assertTrue(leanwarePage.isGetInTouchEnabled());
    }

    @AfterClass
    public void suiteTearDown() {
        suiteFinalization();
    }
}
