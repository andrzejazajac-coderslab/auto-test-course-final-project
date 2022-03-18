package pl.coderslab.automationtestercourse.finalproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyStoreAddressPage extends PageObject{

    @FindBy(xpath = "//div[contains(@class,\"addresses-footer\")]/a")
    private WebElement createNewAddress;
    @FindBy(xpath = "//section/section/div/article/div[1]")
    private List<WebElement> addresses;

    public MyStoreAddressPage(WebDriver driver) {
        super(driver);
    }



    public void clickCreateNewAddress() {
        createNewAddress.click();
    }

    public List<WebElement> getAddressList() {
        return addresses;
    }
}
