package HW;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DiaryMainPage {

    WebDriver driver;
    ChromeOptions chromeOptions;
    Actions actions;
    WebDriverWait webDriverWait;
    Cookie authCookie;

    public DiaryMainPage(WebDriver driver) {
        chromeOptions = new ChromeOptions().addArguments("chromeOptions.addArguments(\"--start-maximized\");");
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
        chromeOptions.addArguments("--start-maximized");
    }

    @FindBy(xpath = "//a[.='Вход']")
    private WebElement loginButton;
    @FindBy(xpath = "//a[@href='https://diary.ru/user/registration']")
    private WebElement registrationButton;

    public DiaryRegistrationPage clickRegistrationButton() {
        registrationButton.click();
        return new DiaryRegistrationPage(driver);
    }


    public DiaryLoginPage clickLoginButton() {
        loginButton.click();
        return new DiaryLoginPage(driver);
    }


}
