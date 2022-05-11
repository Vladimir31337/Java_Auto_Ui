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

public class AutomationPracticeTest {
    static WebDriver driver;
    ChromeOptions chromeOptions;
    WebDriverWait webDriverWait;
    Actions actions;
    private final String AUTOMATION_PRACTICE_BASE_URL = "http://automationpractice.com/";

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
//        driver.get(AUTOMATION_PRACTICE_BASE_URL);
    }

    @Test
    void newUser() throws InterruptedException {
//        driver.get(AUTOMATION_PRACTICE_BASE_URL);
//        driver.findElement(By.xpath("//*[@class='login']")).click();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.findElement(By.xpath("//*[@id='email_create']")).sendKeys("qa1523@mail.ru");
        driver.findElement(By.xpath("//*[@id='SubmitCreate']")).click();
//        driver.findElement(By.id("//*[@id='uniform-id_gender2']")).click();
//        driver.findElement(By.xpath("//input[@name='customer_firstname']")).sendKeys("Vladimir");
//        driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        Thread.sleep(500000);
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
