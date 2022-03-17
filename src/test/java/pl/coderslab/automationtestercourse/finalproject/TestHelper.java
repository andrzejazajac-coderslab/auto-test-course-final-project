package pl.coderslab.automationtestercourse.finalproject;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.UUID;

public class TestHelper {

    public static void SetText(WebElement targetElement, String text){
        targetElement.clear();
        targetElement.sendKeys(text);
    }

    public enum Browser{
        CHROME,
        FIREFOX
    }

    public static String RandomUUIDtoString(){
        return UUID.randomUUID().toString();
    }

    public static WebDriver beforeEach(WebDriver driver, String browser, Duration timeout){
        browser = browser.toLowerCase();
        TestHelper.Browser browser1 = switch (browser) {
            case "chrome" -> Browser.CHROME;
            case "firefox" -> Browser.FIREFOX;
            default -> Browser.FIREFOX;
        };
        return beforeEach(driver, browser1, timeout);
    }

    public static WebDriver beforeEach(WebDriver driver, @NotNull Browser browser, Duration timeout){
        String setPropertyKey="", setPropertyValue="";
        switch (browser) {
            case FIREFOX -> {
                setPropertyKey = "webdriver.gecko.driver";
                setPropertyValue = "src/test/resources/geckodriver.exe";
                System.setProperty(setPropertyKey, setPropertyValue);
                driver = new FirefoxDriver();
            }
            case CHROME -> {
                setPropertyKey = "webdriver.chrome.driver";
                setPropertyValue = "src/test/resources/chromedriver.exe";
                System.setProperty(setPropertyKey, setPropertyValue);
                driver = new ChromeDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(timeout);
        return driver;

    }

}
