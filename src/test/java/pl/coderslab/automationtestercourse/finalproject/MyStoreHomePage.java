package pl.coderslab.automationtestercourse.finalproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyStoreHomePage extends PageObject{

    @FindBy(xpath = "//article")
    private List<WebElement> articles;

    public MyStoreHomePage(WebDriver driver) {
        super(driver);
    }


    public void goToArticlePage(String articleName){
        for(var article : articles){
            String nameElement = article.findElement(By.xpath(".//h3")).getText();
            if(articleName.equalsIgnoreCase(nameElement)){
                article.click();
                break;
            }
        }
    }
}
