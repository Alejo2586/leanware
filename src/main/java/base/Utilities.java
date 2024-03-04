package base;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorConfig;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.time.Duration;
import java.util.*;

public class Utilities {

    protected static WebDriver driver;
    private WebDriverWait wait;
    //static XLSReader reader;
    @FindBy(id="i0116")
    private WebElement userName;

    @FindBy(id="i0118")
    private WebElement password;

    @FindBy(id="idSIButton9")
    private WebElement btnNext;

    @FindBy(id="idTxtBx_SAOTCC_OTC")
    private WebElement onePassCode;

    @FindBy(id="idSubmit_SAOTCC_Continue")
    private WebElement btnVerify;

    @FindBy(id="idBtn_Back")
    private WebElement btnNo;

    int index = 0;

    boolean isElement;
    String xpathExpression;

    public static void initialization(String url) {

        driver = WebDriverSingleton.getInstance();
        driver.manage().window().setPosition(new Point(1920, 0));
        driver.manage().window().maximize();
        driver.get(url);
    }

    public boolean waitForDisplayed(WebElement element){

       try{

            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            isElement = true;
        }
        catch(Exception e){

            isElement = false;
        }

        return isElement;
    }

    public boolean waitForEnabled(WebElement element){

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element.isEnabled();
    }


    public void clickElement(WebElement element){

        waitForEnabled(element);
        element.click();
    }


    public static void suiteFinalization() {

        driver.quit();
        driver = WebDriverSingleton.setInstanceToNull();
    }

}
