import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SecondTest extends BaseTest{

    // позитивные тесты
    @Test
    public void loginWithStandardUserAndSecretSauce()throws InterruptedException{
        Browser.findElement(By.cssSelector("[data-test='username']")).sendKeys("standard_user");
        Browser.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
        Browser.findElement(By.cssSelector("[data-test='login-button']")).click();
        Thread.sleep(2000);

        String currentUrl = Browser.getCurrentUrl();
        assertTrue(currentUrl.contains("inventory.html"));

        boolean ElementProducts = Browser.findElement(By.cssSelector("[data-test = 'title']")).isDisplayed();
        String TextElementProducts = Browser.findElement(By.cssSelector("[data-test = 'title']")).getText();
        assertTrue(ElementProducts);
        assertEquals(TextElementProducts, "Products");
    }

    //негативные тесты
    @Test
    public void loginWithInvalidUsernameAndPassword()throws InterruptedException{
        Browser.findElement(By.cssSelector("[data-test='username']")).sendKeys("1234");
        Browser.findElement(By.cssSelector("[data-test='password']")).sendKeys("1234");
        Browser.findElement(By.cssSelector("[data-test='login-button']")).click();
        Thread.sleep(2000);

        boolean ErrorIsVisible = Browser.findElement(By.cssSelector(".error-message-container")).isDisplayed();
        String ErrorText = Browser.findElement(By.cssSelector(".error-message-container")).getText();

        assertTrue(ErrorIsVisible);
        assertEquals(ErrorText, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginWithInvalidUsername()throws InterruptedException{
        Browser.findElement(By.cssSelector("[data-test='username']")).sendKeys("1234");
        Browser.findElement(By.cssSelector("[data-test='login-button']")).click();
        Thread.sleep(2000);

        boolean ErrorIsVisible = Browser.findElement(By.cssSelector(".error-message-container")).isDisplayed();
        String ErrorText = Browser.findElement(By.cssSelector(".error-message-container")).getText();

        assertTrue(ErrorIsVisible);
        assertEquals(ErrorText, "Epic sadface: Password is required");
    }

    @Test
    public void loginWithInvalidPassword()throws InterruptedException {
        Browser.findElement(By.cssSelector("[data-test='password']")).sendKeys("1234");
        Browser.findElement(By.cssSelector("[data-test='login-button']")).click();
        Thread.sleep(2000);

        boolean ErrorIsVisible = Browser.findElement(By.cssSelector(".error-message-container")).isDisplayed();
        String ErrorText = Browser.findElement(By.cssSelector(".error-message-container")).getText();

        assertTrue(ErrorIsVisible);
        assertEquals(ErrorText, "Epic sadface: Username is required");
    }

    @Test
    public void loginWithEmptyFields()throws InterruptedException {
        Browser.findElement(By.cssSelector("[data-test='login-button']")).click();
        Thread.sleep(2000);

        boolean ErrorIsVisible = Browser.findElement(By.cssSelector(".error-message-container")).isDisplayed();
        String ErrorText = Browser.findElement(By.cssSelector(".error-message-container")).getText();

        assertTrue(ErrorIsVisible);
        assertEquals(ErrorText, "Epic sadface: Username is required");
    }
}
