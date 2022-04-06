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
    @FindBy(className = "payment-option")
    private List<WebElement> paymentMethods;
    @FindBy(id="conditions_to_approve[terms-and-conditions]")
    private WebElement conditionApproveCheckbox;
    @FindBy(id= "payment-confirmation")
    private WebElement paymentConfirmationButton;

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

    public void setPaymentMethodClick(String method){
        for(var paymentMethod : paymentMethods){
            String methodName = paymentMethod.findElement(By.xpath("./label")).getText();
            if(methodName.equalsIgnoreCase(method)){
                paymentMethod.findElement(By.xpath("./span/input")).click();
                break;
            }
        }
    }

    public void setConditionApproveCheckbox(boolean value)
    {
        /* TODO: check actual status*/
        flipConditionApproveCheckbox();
    }

    private void flipConditionApproveCheckbox(){
        conditionApproveCheckbox.click();
    }

    public void paymentConfirmationClick(){
        paymentConfirmationButton.click();
    }
}
