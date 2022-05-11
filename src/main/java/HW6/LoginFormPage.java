package HW6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginFormPage extends MainPage {

    @FindBy(xpath = "//iframe[@class='ag-popup__frame__layout__iframe']")
    WebElement loginIframe;
    @FindBy(xpath = "//input[@name='username']")
    WebElement mailField;
    @FindBy(xpath = "//button[@data-test-id='next-button']")
    WebElement nextEnterButton;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;
    @FindBy(xpath = "//*[@data-test-id='submit-button']")
    WebElement submitEnterButton;

@Step("Логин")
    public MailBoxPage login(String email,String pass) throws InterruptedException {
        driver.switchTo().frame(loginIframe);
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']")));
Thread.sleep(1000);
        mailField.sendKeys(email);
        nextEnterButton.click();
Thread.sleep(1000);
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/input[@name='password']")));
        passwordField.sendKeys(pass);
        submitEnterButton.click();
        driver.switchTo().parentFrame();
        return new MailBoxPage(driver);

    }



    public LoginFormPage(WebDriver driver) {
        super(driver);
    }
}
