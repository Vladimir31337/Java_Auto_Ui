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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeFormTest {
    static WebDriver driver;
    ChromeOptions chromeOptions;
    Actions actions;
    WebDriverWait webDriverWait;
    private final String BASE_SITE_URL = "https://demoqa.com/automation-practice-form";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setDriver() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        actions = new Actions(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(BASE_SITE_URL);
    }

    @Test
    void formTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("Vladimir");
        driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("Popov");
        driver.findElement(By.xpath("//*[@id='userEmail']")).sendKeys("qa1523@mail.ru");
        driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")).click();
       driver.findElement(By.xpath("//*[@id='userNumber']")).sendKeys("59004316670");
        driver.findElement(By.xpath("//*[@id='dateOfBirthInput']")).click();
        Select yearSelect = new Select(driver.findElement(By.xpath("//*[@class='react-datepicker__year-select']")));
        yearSelect.selectByVisibleText("1991");
        driver.findElement(By.xpath("//*[@id='dateOfBirthInput']")).click();
        Select monthSelect = new Select(driver.findElement(By.xpath("//*[@class='react-datepicker__month-select']")));
       monthSelect.selectByVisibleText("February");
        driver.findElement(By.xpath("//*[@class='react-datepicker__day react-datepicker__day--025']")).click();
       driver.findElement(By.xpath("//*[@id='subjectsInput']")).sendKeys("Test");
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='hobbies-checkbox-3']"))).click().build().perform();
        driver.findElement(By.xpath("//*[@id='hobbies-checkbox-3']")).click();
        Thread.sleep(55555);
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

}
