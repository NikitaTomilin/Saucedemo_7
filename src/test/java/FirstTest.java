import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstTest {

    @Test
    public void ShareLaneFirstTest() throws InterruptedException {
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("1234");
        browser.findElement(By.cssSelector("[value='Continue']")).click();
        Thread.sleep(2000);
        boolean errorIsVisible = browser.findElement(By.cssSelector(".error_message")).isDisplayed();
        String errorText = browser.findElement(By.cssSelector(".error_message")).getText();

        assertTrue(errorIsVisible);
        assertEquals(errorText, "Oops, error on page. ZIP code should have 5 digits");

        browser.quit();
    }

}
