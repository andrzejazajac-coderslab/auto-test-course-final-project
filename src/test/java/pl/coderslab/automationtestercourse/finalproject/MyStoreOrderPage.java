package pl.coderslab.automationtestercourse.finalproject;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyStoreOrderPage extends PageObject{

    @FindBy(name ="confirm-addresses")
    private WebElement confirmAddress;
    @FindBy(className = "delivery-option")
    private List<WebElement> shippingMethods;
    @FindBy(name = "confirmDeliveryOption")
    private WebElement confirmDeliveryOption;

    public MyStoreOrderPage(WebDriver driver) {
        super(driver);
    }

    public void confirmAddressClick(){
        confirmAddress.click();
    }

    public void setDeliveryOptionClick(String findOption){
        for(var shippingMethod : shippingMethods){
            String optionName = shippingMethod.findElement(By.xpath("./label/div/div/div/div")).getText();
            if(optionName.equalsIgnoreCase(findOption)){
                try {
                    shippingMethod.findElement(By.xpath("./div/span/input")).click();
                }
                catch (ElementClickInterceptedException exception){

                }
                break;
            }

        }

    }

    public void confirmDeliveryOptionClick() {
        confirmDeliveryOption.click();
    }
}
