package pl.coderslab.automationtestercourse.finalproject;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MyStoreSetAndCheckAddressSteps {

    private WebDriver driver;
    private MyStoreNavElement msNavElement;
    private MyStoreLoginPage msLoginPage;
    private MyStoreAccountPage msAccountPage;
    private MyStoreAddressPage msAddressPage;
    private MyStoreAddAddressPage msAddAddressPage;

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

    @And("Check if there is already an address")
    public void isAnyAddressExist() {
        this.msAccountPage = new MyStoreAccountPage(this.driver);
    }

    @And("If yes, go to site address manage and there click Add new address")
    public void ifYesGoToSiteAddressManage() {
        if(this.msAccountPage.isAnyAddress())
        {
            this.msAccountPage.clickAddressButton();
            this.msAddressPage = new MyStoreAddressPage(driver);
            msAddressPage.clickCreateNewAddress();
        }
    }

    @And("If no, click Add new address on this page")
    public void ifNoClickAddToNewAddress() {
        boolean b = this.msAccountPage.isAnyAddress();
        if(!b)
        {
            msAccountPage.clickAddressButton();
        }
    }

    @When("^Entered address data to form (.*), (.*), (.*), (.*), (.*), (.*).$")
    public void enteredAddressDataToForm(String alias, String address, String city, String postal_code, String country, String phone ) {
        msAddAddressPage = new MyStoreAddAddressPage(driver);
        msAddAddressPage.addAlias(alias)
                    .addAddress(address)
                    .addPostalCode(postal_code)
                    .addCity(city)
                    .addCountry(country)
                    .addPhone(phone);

    }
}
