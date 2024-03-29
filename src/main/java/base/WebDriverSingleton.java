package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton(){

    }

    public static WebDriver getInstance() {

        if (driver == null) {

            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }

        return driver;
    }

    public static WebDriver setInstanceToNull(){

        return driver = null;
    }
}
