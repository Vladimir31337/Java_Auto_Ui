package lesson3;

//1 зайти на сайт http://automationpractice.com/
//        2 нажать dresses
//        3 выбрать суммер дресс
//        4добавить любое в корзину
//        5 процед ту чекаут
//        6 процед

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutomaticPractice {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("http://automationpractice.com/");

        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[3]/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]/div/div[1]/div/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
     driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
    driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("1337");

        Thread.sleep(5000);
        driver.close();


    }

}
