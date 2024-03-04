package pages;

import base.TestReport;
import base.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeanwarePage extends Utilities {


    @FindBy(id = "comp-kbgakxea_r_comp-lm376a3w")
    private WebElement contactUs;

    @FindBy(id = "form-ffa91c15-b28b-4281-82c9-440a10ed3ff1")
    private WebElement getInTouch;

    boolean isExpected = false;


    public void contactUs(){
        clickElement(contactUs);
    }

    public LeanwarePage(){

        PageFactory.initElements(driver,this);

    }

    public boolean isGetInTouchEnabled(){

        if(waitForDisplayed(getInTouch)){

            isExpected = true;
        }
        else{
            TestReport.logFail("FAILED - Active Call List detailed page not displayed.");
        }


        return isExpected;
    }


}
