package pl.coderslab.automationtestercourse.finalproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyStoreOrderPage extends PageObject{

    @FindBy(name ="confirm-addresses")
    private WebElement confirmAddress;
    @FindBy(className = "delivery-option")
    private List<WebElement> shippingMethods;

    public MyStoreOrderPage(WebDriver driver) {
        super(driver);
    }

    public void confirmAddressClick(){
        confirmAddress.click();
    }


}
