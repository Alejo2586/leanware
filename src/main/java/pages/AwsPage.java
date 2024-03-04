package pages;

import base.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AwsPage extends Utilities {

    @FindBy(id = "app_layout") //language-dropdown
    private WebElement languages;

    @FindBy(xpath = "//option[text()='Spanish']")
    private WebElement spanish;

    @FindBy(css= "[data-test='closed-alert']")
    private WebElement text;

    public void changeToSpanishLanguage(){
        languages.click();
        spanish.click();
    }

    public String getText(){
        String texto = text.getText();

        return texto;
    }

//


}
