package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage{
    WebDriver driver;
    private final By title = By.cssSelector("[data-test = 'title']");

    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean pageTitleVisible(){
        return driver.findElement(title).isDisplayed();
    }

    public String getTitleText(){
        return driver.findElement(title).getText();
    }

    public String currentUrl(){
        return driver.getCurrentUrl();
    }
}
