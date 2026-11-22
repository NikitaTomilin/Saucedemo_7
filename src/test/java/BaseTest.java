import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {static WebDriver Browser;

    @BeforeAll
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-features=PasswordLeakDetection");
        // options.addArguments("headless");
        Browser = new ChromeDriver(options);
        Browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    @BeforeEach
    public void openWebsite() {
        Browser.get("https://www.saucedemo.com");
    }

    @AfterAll
    public static void tearDown() {
        Browser.quit();
    }
}
