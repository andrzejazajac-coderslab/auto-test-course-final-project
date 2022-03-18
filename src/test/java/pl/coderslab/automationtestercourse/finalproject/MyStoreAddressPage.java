package pl.coderslab.automationtestercourse.finalproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyStoreAddressPage extends PageObject{

    @FindBy(xpath = "//div[contains(@class,\"addresses-footer\")]/a")
    private WebElement createNewAddress;

    public MyStoreAddressPage(WebDriver driver) {
        super(driver);
    }

    public void clickCreateNewAddress(){
        createNewAddress.click();
    }
}
