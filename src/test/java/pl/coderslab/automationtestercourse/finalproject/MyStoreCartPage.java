package pl.coderslab.automationtestercourse.finalproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyStoreCartPage extends PageObject{

    @FindBy(xpath = "//div[contains(@class, \"cart-detailed-actions \")]/div")
    private WebElement proceedToCheckout;

    public MyStoreCartPage(WebDriver driver) {
        super(driver);
    }

    public void proceedToCheckoutClick(){
        proceedToCheckout.click();
    }

}
