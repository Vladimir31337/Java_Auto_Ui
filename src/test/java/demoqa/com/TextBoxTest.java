package demoqa.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextBoxTest {

    static WebDriver driver;
    ChromeOptions chromeOptions;
    WebDriverWait webDriverWait;
    Actions actions;
    private final String BASE_SITE_URL = "https://demoqa.com/text-box";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void setupDriver() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        actions = new Actions(driver);
        driver.get(BASE_SITE_URL);

    }

    @Test
    void textBoxCheck() throws InterruptedException {
driver.get(BASE_SITE_URL);
driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("Vladimir");
driver.findElement(By.xpath("//*[@id='userEmail']")).sendKeys("qa1523@mail.ru");
driver.findElement(By.xpath("//*[@id='currentAddress']")).sendKeys("Voronezh");
driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("Russia");
driver.findElement(By.xpath("//*[@id='submit']")).click();
Thread.sleep(5000);
    }

    @AfterAll
   static void tearDown() {
        driver.quit();
    }

}
