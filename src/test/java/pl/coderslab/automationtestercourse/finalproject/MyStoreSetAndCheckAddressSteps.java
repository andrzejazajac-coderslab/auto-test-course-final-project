package pl.coderslab.automationtestercourse.finalproject;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MyStoreSetAndCheckAddressSteps {

    private WebDriver driver;
    private MyStoreNavElement msNavElement;

    @Given("^Page (.*) open in browser (.*)$")
    public void pageOpenInBrowser(String pageUrl, String browser)
    {
        driver = TestHelper.beforeEach(driver,browser, Duration.ofSeconds(8));
        driver.get(pageUrl);
    }

    @And("Go to login page")
    public void goToLoginPage() {
        this.msNavElement = new MyStoreNavElement (this.driver);
        this.msNavElement.clickUserIcon();
    }
}
