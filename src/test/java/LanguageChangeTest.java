
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AwsPage;

import static base.Utilities.initialization;

public class LanguageChangeTest {


    private WebDriver driver;

    @BeforeClass
    public void navigateToPage() {
        initialization("https://repost.aws/questions/QUndEqT6iPSvSLRQOw38r9Ow/1-6-problem-with-vegetation-applied-via-terrain-layers");
    }

    @Test
    public void testLanguageChangeToSpanish() {

        AwsPage awsPage;
        awsPage= new AwsPage();

        // Verify default language is English
       Assert.assertEquals(awsPage.getText(), "This post is closed");

        // Change language to Spanish
        awsPage.changeToSpanishLanguage();;

        // Verify language changed to Spanish
        Assert.assertEquals(awsPage.getText(), "Esta publicación está cerrada");
    }
}
