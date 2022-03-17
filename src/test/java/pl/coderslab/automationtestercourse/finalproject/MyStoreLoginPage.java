package pl.coderslab.automationtestercourse.finalproject;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static pl.coderslab.automationtestercourse.finalproject.TestHelper.SetText;

public class MyStoreLoginPage extends PageObject{

    @FindBy(name = "email")
    private WebElement emailInput;
    @FindBy(name = "password")
    private WebElement passwdInput;
    @FindBy(id = "submit-login")
    private WebElement loginButton;

    public MyStoreLoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String email) {
        SetText(this.emailInput, email);
    }

    public void setPassword(String password) {
        SetText(passwdInput, password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }
}
