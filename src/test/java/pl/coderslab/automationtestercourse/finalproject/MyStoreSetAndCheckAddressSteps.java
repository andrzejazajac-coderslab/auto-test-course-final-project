package pl.coderslab.automationtestercourse.finalproject;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MyStoreSetAndCheckAddressSteps {

    private WebDriver driver;
    private MyStoreNavElement msNavElement;
    private MyStoreLoginPage msLoginPage;

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

    @And("^Login user on (.*) and (.*)$")
    public void loginUserOnEmailAndPasswd(String email, String password) {
        this.msLoginPage = new MyStoreLoginPage(this.driver);
        this.msLoginPage.setEmail(email);
        this.msLoginPage.setPassword(password);
        this.msLoginPage.clickLoginButton();
    }
}
