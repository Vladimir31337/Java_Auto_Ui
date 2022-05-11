import HW.DiaryLoginPage;
import HW.DiaryMainPage;
import HW6.MainPage;
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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DiaryTest {
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
    void setDriver() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        authCookie = new Cookie("_identity_","83668234c30812b14c46bac1deda1a240770255504032650b42\" +\n" +
                "                \"4a75038c00b3aa%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3545507%2\" +\n" +
                "                \"C%22E_QJqRaNdBrepyeVN7uNXi5Dz9tjGpfX%22%2C2592000%5D%22%3B%7D");

        driver.get("https://diary.ru/");

    }

    @Test
    void loginForm() throws InterruptedException {
        new DiaryMainPage(driver)
                .clickLoginButton()
                .login("spartaLex", "123456");
    }

    @Test
    void registerNewUser() throws InterruptedException {
new DiaryMainPage(driver)
        .clickRegistrationButton()
                .registrationNewUser("Qa1524","qwerty123456","qa1524@mail.ru");
//asserrt зайти в лк выбрать себя и сверить пользователя
Thread.sleep(50000);
    }
    @Test
    void sendMail() throws InterruptedException {
        new DiaryMainPage(driver)
                .clickLoginButton()
                .login("qa1524","123456")
                .sendNewMail();
        Thread.sleep(500000);

    }



    @AfterAll
    static void tearDown() {
        driver.quit();
    }

}


