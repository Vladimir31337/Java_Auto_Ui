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

import java.sql.DriverManager;
import java.time.Duration;

public class RegistrationTest {
    static WebDriver driver;
    ChromeOptions chromeOptions;
    WebDriverWait webDriverWait;
    Actions actions;
    private final String DIARY_BASE_URL = "https:/diary.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setDriver() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(DIARY_BASE_URL);
    }

    @Test
    void newUser() throws InterruptedException {
driver.get(DIARY_BASE_URL);
driver.findElement(By.xpath("//*[@href='https://diary.ru/user/registration']")).click();
driver.findElement(By.xpath("//*[@id='signupform-username']")).sendKeys("Vladimir112233");
driver.findElement(By.xpath("//*[@id='signupform-email']")).sendKeys("qa1523@mail.ru");
driver.findElement(By.xpath("//*[@id='chk_box_user_confirm']")).click();
driver.findElement(By.xpath("//*[@id='signup_btn']")).click();
Thread.sleep(5000);
    }

    @AfterAll
   static void tearDown() {
        driver.quit();
    }
}
