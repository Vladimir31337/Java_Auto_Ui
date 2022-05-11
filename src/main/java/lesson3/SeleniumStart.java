package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.DriverManager;

public class SeleniumStart {

public static void main(String[] args) throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "src/main/resourсes/chromedriver.exe");

    WebDriver driver = new ChromeDriver();


    driver.get("https://google.com");
    Thread.sleep(5000);
    driver.quit();

    WebDriverManager.firefoxdriver().setup();

    WebDriver ffdriver = new FirefoxDriver();

    ffdriver.get("https://ya.ru");
    Thread.sleep(5000);
    ffdriver.quit();
}

}
