import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class AfishaTest2 {

    WebDriver driver;
    WebDriverWait webDriverWait;
    private final static String AFISHA_BASE_URL = "https://afisha.ru";

   @BeforeAll
   static void registerDriver() {
       WebDriverManager.chromedriver().setup();

   }
   @BeforeEach
   void setupDriver() {
       driver = new ChromeDriver();
       webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
       Actions actions;
       driver.get("\"https://afisha.ru\"");
   }
@Test


   @AfterAll
    void teardown() {
       driver.quit();
   }


}

