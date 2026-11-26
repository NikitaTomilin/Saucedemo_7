package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
    * Страница авторизации
 */
public class LoginPage {
    private final By loginInput = By.cssSelector("[data-test='username']");
    private final By passwordInput = By.cssSelector("[data-test='password']");
    private final By submitBtn = By.cssSelector("[data-test='login-button']");
    private final By errorMessage = By.cssSelector(".error-message-container");
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open(){
        driver.get("https://www.saucedemo.com");
    }

    public void login(String username,String password){
        driver.findElement(loginInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(submitBtn).click();
    }
    public boolean errorIsVisible(){
        return driver.findElement(errorMessage).isDisplayed();
    }

    public String errorText() {
        return driver.findElement(errorMessage).getText();
    }
}
