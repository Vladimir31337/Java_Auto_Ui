import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lesson6.LoginPageLesson6;
import lesson6.MainPage;
import lesson7.CustomLogger;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

@Story("Добавление в корзину")
public class AutomationPracticeTestLesson6 {
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
//        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        actions = new Actions(driver);
    }

    @Test
    @Feature("Работа с корзиной")
    void addToCartTest() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
//        MainPage mainPage = new MainPage(driver);
//        mainPage.signInButton.click();
//        new MainPage(driver).signInButton.click();
//        new LoginPageLesson6(driver).login("spartalex93@test.test","123456");
        new MainPage(driver)
                .clickSignInButton()
                .login("spartalex93@test.test", "123456")
                .hoverWomenButton()
                .tShirtsButtonClick()
                .selectSizeInFilters("S")
                .hoverAndClickAddToCartProductByName("Fadded")
                .checkSuccessWithSum("$16.51");

        Assertions.assertAll(
                () -> assertThat(driver.findElement(By.xpath("//i[@class='icon-ok']")), not(isDisplayed())),
                () -> assertThat(driver.findElement(By.xpath("//span[@class='ajax_block_products_total']")), hasText("16$"))
        );

//        assertThat(driver.findElement(By.xpath("//i[@class='icon-ok']")),not(isDisplayed()));

    }
//        @Test
//        void addToCartNegative () throws InterruptedException {
//            driver.get("http://automationpractice.com/index.php");
//            new MainPage(driver)
//                    .clickSignInButton()
//                    .login("spartalex913@test.test", "1123456");
//            //Ассерт найти надпись о неправильных данных
//
//            Thread.sleep(50000);
//        }

    @AfterEach
    void tearDown() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        for (LogEntry log : logEntries) {
            Allure.addAttachment("Элемент лога браузера", log.getMessage());
        }
        driver.quit();
    }


}
