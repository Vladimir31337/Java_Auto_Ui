package demoqa.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckBoxTest {
    static WebDriver driver;
    ChromeOptions chromeOptions;
    Actions actions;
    WebDriverWait webDriverWait;
    private final String BASE_SITE_URL = "https://demoqa.com/checkbox";

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
        driver.findElement(By.xpath("//*[@class='rct-option rct-option-expand-all']")).click();
        driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[1]/span/label")).click();
       Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@class='rct-option rct-option-collapse-all']")).click();
        Thread.sleep(5000);
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }


}
