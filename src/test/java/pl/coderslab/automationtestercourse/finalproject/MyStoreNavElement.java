package pl.coderslab.automationtestercourse.finalproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyStoreNavElement extends PageObject {

    @FindBy(xpath = "//*[contains(@class,\"user-info\")]/a")
    private WebElement userIcon;

    public MyStoreNavElement(WebDriver driver) {
        super(driver);
    }

    public void clickUserIcon() {
        userIcon.click();
    }
}
