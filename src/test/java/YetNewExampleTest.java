import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class YetNewExampleTest {

    public class YetNewExamplesTest {
        WebDriver driver;
        WebDriverWait webDriverWait;
        Actions actions;

        @BeforeAll
        static void registerDriver() {
            WebDriverManager.chromedriver().setup();
        }

        @BeforeEach
        void setupDriver() {
            driver = new ChromeDriver();
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            actions = new Actions(driver);
        }

        @Test
        void dragAndDropTest() {
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");
            actions.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable")))
                    .build()
                    .perform();
            Assertions.assertEquals(driver.findElement(By.id("droppable")).getText(), "Dropped!");
        }

        @Test
        void selectExampleTest() throws InterruptedException {
            driver.get("https://demoqa.com/automation-practice-form");
            driver.findElement(By.id("dateOfBirthInput")).click();
            Select yearSelect = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
            yearSelect.selectByVisibleText("2054");
            Thread.sleep(5000);
            ((JavascriptExecutor) driver).executeScript("alert('Test!!')");
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            Thread.sleep(2000);
        }

        @AfterEach
        void tearDown() {
            driver.quit();
        }


    }
}
