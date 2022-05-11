import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomationPractiseRegTest {

    static WebDriver driver;
    ChromeOptions chromeOptions;
    WebDriverWait webDriverWait;
    Actions actions;
    final String MAIL_BASEURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";

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
        driver.get(MAIL_BASEURL);
    }

    @AfterAll
    static void tearDown() {
//        driver.quit();
    }

    @Test
    void loginForm() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='email_create']")).sendKeys("qa1523@mail.ru");
        driver.findElement(By.xpath("//*[@id='SubmitCreate']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='std box']")));
        driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Vladimir");
        driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Popov");
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("qa1523@mail.ru");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("leshifre1337");

        Select daySelect = new Select(driver.findElement(By.xpath("//*[@id='days']")));
        daySelect.selectByValue("1");

        Select monthSelect = new Select(driver.findElement(By.xpath("//*[@id='months']")));
        monthSelect.selectByValue("6");

        Select yearSelect = new Select(driver.findElement(By.xpath("//*[@id='years']")));
        yearSelect.selectByValue("1991");

        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Vladimir");
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Popov");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("GB");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Voronezh");
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Moscow");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("City");

        Select stateSelect = new Select(driver.findElement(By.xpath("//*[@id='id_state']")));
        stateSelect.selectByIndex(3);

        Select countrySelect = new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
        countrySelect.selectByIndex(1);

        driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys("33333333");
        driver.findElement(By.xpath("//*[@id='other']")).sendKeys("Test text");
        driver.findElement(By.xpath("//*[@id='phone']")).sendKeys("442233");
        driver.findElement(By.xpath("//*[@id='phone_mobile']")).sendKeys("89001112233");
        driver.findElement(By.xpath("//*[@id='alias']")).sendKeys("My Address");
        driver.findElement(By.xpath("//*[@id='submitAccount']")).click();
//                driver.findElement(By.xpath("")).sendKeys("");

//        Thread.sleep(5000);
    }


}
