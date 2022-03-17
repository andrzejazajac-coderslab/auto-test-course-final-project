package pl.coderslab.automationtestercourse.finalproject;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MyStoreSetAndCheckAddressSteps {

    private WebDriver driver;

    @Given("^Page (.*) open in browser (.*)$")
    public void pageOpenInBrowser(String pageUrl, String browser)
    {
        driver = TestHelper.beforeEach(driver,browser, Duration.ofSeconds(8));
        driver.get(pageUrl);
    }
}
