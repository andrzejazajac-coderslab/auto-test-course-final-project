package pl.coderslab.automationtestercourse.finalproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static pl.coderslab.automationtestercourse.finalproject.TestHelper.*;

public class MyStoreAddAddressPage extends PageObject{

    @FindBy(name="alias")
    private WebElement aliasInput;
    @FindBy(name="address1")
    private WebElement address1Input;
    @FindBy(name="city")
    private WebElement cityInput;
    @FindBy(name="postcode")
    private WebElement postCodeInput;
    @FindBy(name = "id_country")
    private WebElement countrySelect;
    @FindBy(name = "phone")
    private WebElement phoneInput;
    @FindBy(xpath = "//form/*/button")
    private WebElement saveButton;


    public MyStoreAddAddressPage(WebDriver driver) {
        super(driver);
    }

    public MyStoreAddAddressPage addAlias(String alias){
        SetText(aliasInput, alias);
        return this;
    }

    public MyStoreAddAddressPage addAddress(String address){
        SetText(address1Input, address);
        return this;
    }

    public MyStoreAddAddressPage addPostalCode(String postCode){
        SetText(postCodeInput, postCode);
        return this;
    }

    public MyStoreAddAddressPage addCity(String city) {
        SetText(cityInput, city);
        return this;
    }

    public MyStoreAddAddressPage addCountry (String country){
        List<WebElement> countries = countrySelect.findElements(By.xpath("./option"));
        for(WebElement option : countries){
            if(option.getText().equals(country)) {
                countrySelect.click();
                option.click();
            }
        }
        return this;
    }

    public MyStoreAddAddressPage addPhone(String phone){
        SetText(phoneInput, phone);
        return this;
    }


    public void clickSave() {
        saveButton.click();
    }
}
