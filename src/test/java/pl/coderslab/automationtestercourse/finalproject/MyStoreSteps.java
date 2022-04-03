package pl.coderslab.automationtestercourse.finalproject;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyStoreSteps {

    private WebDriver driver;
    private MyStoreNavElement msNavElement;
    private MyStoreLoginPage msLoginPage;
    private MyStoreAccountPage msAccountPage;
    private MyStoreAddressPage msAddressPage;
    private MyStoreAddAddressPage msAddAddressPage;

    private boolean isAnyAddress;

    @Given("^Page (.*) open in browser (.*)$")
    public void pageOpenInBrowser(String pageUrl, String browser)
    {
        driver = TestHelper.beforeEach(driver,browser, Duration.ofSeconds(3));
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
        this.msAddressPage = new MyStoreAddressPage(driver);
        if(isAnyAddress=this.msAccountPage.isAnyAddress())
        {
            this.msAccountPage.clickAddressButton();
            msAddressPage.clickCreateNewAddress();
        }
    }

    @And("If no, click Add new address on this page")
    public void ifNoClickAddToNewAddress() {
        if(!isAnyAddress)
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

    @And("Click Save button")
    public void clickSaveButton() {
        msAddAddressPage.clickSave();
    }

    @Then("^Check if the address was added correctly (.*), (.*), (.*), (.*), (.*), (.*).$")
    public void checkIfTheAddressWasAddedCorrectly(String alias, String address, String city, String postal_code, String country, String phone) {
        List<WebElement> addressesList =  msAddressPage.getAddressList();
        String lastAddressString=addressesList.get(addressesList.size()-1).getText();
        List<String>lastAddressStringList  = new ArrayList<String>(Arrays.asList(lastAddressString.split("\n")));
        assertEquals(lastAddressStringList.get(0), alias);
        assertEquals(lastAddressStringList.get(2), address);
        assertEquals(lastAddressStringList.get(3), city);
        assertEquals(lastAddressStringList.get(4), postal_code);
        assertEquals(lastAddressStringList.get(5), country);
        assertEquals(lastAddressStringList.get(6), phone);
    }

    @And("Go to home page")
    public void goToHomePage() {
        //TO DO: Get current URL, prepare home page and go to this
        driver.get("https://mystore-testlab.coderslab.pl");
    }


}
