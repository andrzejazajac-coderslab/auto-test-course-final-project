package pl.coderslab.automationtestercourse.finalproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MyStoreProductPage extends PageObject{

    @FindBy(id = "group_1")
    private WebElement sizeSelect;
    @FindBy(id = "quantity_wanted")
    private WebElement quantityInput;
    @FindBy(xpath = "//div[contains(@class, \"add\")]/button")
    private WebElement addToCartButton;

    public MyStoreProductPage(WebDriver driver) {
        super(driver);
    }

    public void setSize(String size) {

        List<WebElement> sizeOptions;

        sizeOptions = sizeSelect.findElements(By.xpath("./option"));

        for(var option : sizeOptions){
            String optionText = option.getText();
            if(optionText.equalsIgnoreCase(size)){
                sizeSelect.click();
                option.click();
                break;
            }
        }

    }

    public void setQuantity(int quantity){
        TestHelper.SetText(quantityInput, String.valueOf(quantity));
    }

    public void addToCartClick(){
        addToCartButton.click();
    }
}
