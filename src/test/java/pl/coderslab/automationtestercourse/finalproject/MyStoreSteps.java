package pl.coderslab.automationtestercourse.finalproject;

import io.cucumber.java.en.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.Duration;
import java.time.LocalDateTime;
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
    private MyStoreHomePage msHomePage;
    private MyStoreProductPage msProductPage;
    private MyStoreCartPage msCartPage;
    private MyStoreOrderPage msOrderPage;

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


    @When("^Select product (.*).$")
    public void selectProduct(String productName) {
        this.msHomePage = new MyStoreHomePage(driver);
        msHomePage.goToArticlePage(productName);

    }

    @And("^Select size (.*).$")
    public void selectSize(String sizeToSelect){
        this.msProductPage = new MyStoreProductPage(driver);

        msProductPage.setSize(sizeToSelect);
    }

    @And("^Select quantity (.*).$")
    public void selectQuantity(int quantity) {
        msProductPage.setQuantity(quantity);
    }

    @And("Add to cart.")
    public void addToCart() {
        msProductPage.addToCartClick();
    }

    @And("Click link \"Proceed to checkout\".")
    public void proceedToCheckoutClick() throws InterruptedException {
        //TO DO:
        //Hotfix to ElementNotInteractableException
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        msProductPage.proceedToCheckoutClick();

    }

    @And("Click link \"Proceed to checkout\" in cart.")
    public void proceedToCheckoutCartClick() {
        this.msCartPage = new MyStoreCartPage(driver);

        msCartPage.proceedToCheckoutClick();
    }

    @And("Confirm address.")
    public void confirmAddress() {
        this.msOrderPage = new MyStoreOrderPage(driver);
        msOrderPage.confirmAddressClick();
    }

    @And("Select shipping method.")
    public void selectShippingMethod() {
        msOrderPage.setDeliveryOptionClick("PrestaShop");
        msOrderPage.confirmDeliveryOptionClick();
    }

    @And("Select payment.")
    public void selectPayment() {
        msOrderPage.setPaymentMethodClick("Pay by Check");
    }

    @Then("Click \"Order with an obligation to pay\".")
    public void OrderConfirmationClick() {
        msOrderPage.setConditionApproveCheckbox(true);
        msOrderPage.paymentConfirmationClick();
    }

    @And("Take screenshot.")
    public void saveScreenshot() throws IOException {
        File tmpScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("./", "ss_order_confirmation-"+currentDateTime+".png"));
    }
}
