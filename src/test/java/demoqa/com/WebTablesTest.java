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

public class WebTablesTest {

    static WebDriver driver;
    WebDriverWait webDriverWait;
    ChromeOptions chromeOptions;
    Actions actions;
    private final String BASE_SITE_URL = "https://demoqa.com/webtables";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(BASE_SITE_URL);

    }

    @Test
    void webTablesTest() throws InterruptedException {
        driver.get("https://demoqa.com/webtables");
        driver.findElement(By.xpath("//*[@id='addNewRecordButton']")).click();
        driver.findElement(By.xpath("//*[@id='firstName-wrapper']/div[2]/input")).sendKeys("Vladimir");
        driver.findElement(By.xpath("//*[@id='lastName-wrapper']/div[2]/input")).sendKeys("Popov");
        driver.findElement(By.xpath("//*[@id='userEmail-wrapper']/div[2]/input")).sendKeys("qa1523@mail.ru");
        driver.findElement(By.xpath("//*[@id='age-wrapper']/div[2]/input")).sendKeys("30");
        driver.findElement(By.xpath("//*[@id='salary-wrapper']/div[2]/input")).sendKeys("60000");
        driver.findElement(By.xpath("//div[@id='department-wrapper']/div[2]/input")).sendKeys("Voronezh");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='submit']")).click();

    }
    @Test
    void searchUser() throws InterruptedException {
       driver.get(BASE_SITE_URL);
       driver.findElement(By.xpath("//*[@id='searchBox']")).sendKeys("Cierra");
       driver.findElement(By.xpath("//*[@class='action-buttons']/span[1]")).click();
       driver.findElement(By.xpath("//div[@id='salary-wrapper']/div[2]/input")).clear();
       driver.findElement(By.xpath("//div[@id='salary-wrapper']/div[2]/input")).sendKeys("1337");
       driver.findElement(By.xpath("//*[@id='department-wrapper']/div[2]/input")).sendKeys("1337");
       Thread.sleep(3000);
       driver.findElement(By.xpath("//*[@id='submit']")).click();

    }


    @AfterAll
  static   void tearDown() {
        driver.quit();
    }


}

