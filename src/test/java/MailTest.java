import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MailTest {
    static WebDriver driver;
    ChromeOptions chromeOptions;
    Actions actions;
    WebDriverWait webDriverWait;
    Cookie authCookie;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void setupDriver() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("disable-infobars");
        driver = new ChromeDriver(chromeOptions);
        actions = new Actions(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://mail.ru/");

    }

    @Test
    void loginForm() throws InterruptedException {

        driver.findElement(By.xpath("//*[@data-testid='enter-mail-primary']")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']")));

//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']")));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("qa1523@mail.ru");
        driver.findElement(By.xpath("//button[@data-test-id='next-button']")).click();

//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/input[@name='password']")));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("leshifre1337");
        driver.findElement(By.xpath("//label[@data-test-id='saveauth']")).click();
        driver.findElement(By.xpath("//*[@data-test-id='submit-button']")).click();
        driver.switchTo().parentFrame();
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.xpath("//a[@title='Написать письмо']"))).build().perform();
        Thread.sleep(5000);
        Thread.sleep(50000);
//
//
    }

//        @Test
//        void login() throws InterruptedException {
////        driver.get("https://diary.ru");
////        Cookie authCookie = new Cookie("_identity_", "83668234c30812b14c46bac1deda1a240770255504032650b42" +
////                "4a75038c00b3aa%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3545507%2" +
////                "C%22E_QJqRaNdBrepyeVN7uNXi5Dz9tjGpfX%22%2C2592000%5D%22%3B%7D");
////        driver.manage().addCookie(authCookie);
////        driver.navigate().refresh();
//
//            driver.get("https://e.mail.ru");
//            Cookie authCookie = new Cookie("tmr_detect", "0%7C1651531995755");
//            driver.manage().addCookie(authCookie);
//            driver.navigate().refresh();
//
//
//        }

        @AfterAll
       static void tearDown() {
            driver.quit();
        }

    }

