import HW6.LoginFormPage;
import HW6.MailBoxPage;
import HW6.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import lesson7.CustomLogger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class HomeWorkTest {

    WebDriver driver;
    ChromeOptions chromeOptions;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    void setupDriver() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver(chromeOptions));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
//        driver.get("https://mail.ru/");
    }

    @Test
    @Feature("Логин и работа с почтой")
    void authAndSenMailTest() throws InterruptedException {
        driver.get("https://mail.ru/");
//            MainPage mainPage = new MainPage(driver);
//            mainPage.clickEnterButton();
//            new LoginFormPage(driver).login("qa1523@mail.ru","leshifre1337");
//            Thread.sleep(50000);


        new MainPage(driver)
                .clickEnterButton()
                .login("qa1523@mail.ru", "leshifre1337")
                .mailSent();

//        Assertions.assertAll(
//                () -> assertThat(driver.findElement(By.xpath("//a[@class='hRgwsmL']")), hasText("Пиьсмо Отправлено"))
//                () -> assertThat(driver.findElement(By.xpath("/html/body/div[10]/div/div/div[2]/div[2]/div/div")), isDisplayed()),
//                () -> assertThat(driver.findElement(By.xpath("/html/body/div[10]/div/div/div[2]/div[2]/div/div/div[2]/a")), hasText("Письмо отправлено"))

//        );


//           Thread.sleep(1000); или в Mailboxe ili tyt
//        MailBoxPage mailBoxPage = new MailBoxPage(driver);
//        mailBoxPage.mailSent();
//            Thread.sleep(5000000);

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


}
