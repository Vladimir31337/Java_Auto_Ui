package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Registration {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);

       driver.get("https://sirus.one/#");

        //Регистрация на сайте
                Thread.sleep(555);
        driver.findElement(By.xpath("//*[@placeholder='Аккаунт']")).sendKeys("313337");
        driver.findElement(By.xpath("//*[@placeholder='Пароль']")).sendKeys("leshifre1337");
        driver.findElement(By.xpath("//*[@placeholder='Электронная почта']")).sendKeys("qa15233@mail.ru");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        driver.findElement(By.xpath("//*[@id='recaptcha-anchor']")).click();
        Thread.sleep(3000);
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(10000);
        //https://sirus.one/registered
        driver.quit();


        //Зайти через куки на этот сайт

//        driver.get("https://sirus.su/#/");
//        Cookie authCookie = new Cookie();
//        driver.manage().addCookie(authCookie);
//        driver.navigate().refresh();
//        Thread.sleep(5000);
//        driver.quit();

    }

}
