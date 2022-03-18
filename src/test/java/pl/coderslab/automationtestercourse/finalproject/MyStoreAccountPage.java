package pl.coderslab.automationtestercourse.finalproject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyStoreAccountPage extends PageObject{

    @FindBy(id="addresses-link")
    private WebElement existAddressButton;
    @FindBy(id="address-link")
    private WebElement notExistAddressButton;

    public MyStoreAccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddressButton(){
        try {
            existAddressButton.click();
        }
        catch (NoSuchElementException e) {
            notExistAddressButton.click();
        }
    }

    public boolean isAnyAddress(){
        try{
            existAddressButton.isEnabled();
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

}

