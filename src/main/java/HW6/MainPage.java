package HW6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @FindBy(xpath = "//*[@data-testid='enter-mail-primary']")
    WebElement enterButton;
@Step("Клик на кнопку авторизации")
    public LoginFormPage clickEnterButton() {
        enterButton.click();
        return new LoginFormPage(driver);
    }



    public MainPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }


}

