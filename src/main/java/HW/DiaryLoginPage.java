package HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DiaryLoginPage extends DiaryMainPage {
    public DiaryLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='loginform-username']")
    WebElement loginField;
    @FindBy(xpath = "//input[@id='loginform-password']")
    WebElement passField;
    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    WebElement reCaptchaIframe;
    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    WebElement captchaConfirm;
    @FindBy(xpath = "//button[@id='login_btn']")
    WebElement confirmLoginButton;

    public DiaryMyAccountPage login(String name, String pass) throws InterruptedException {
        loginField.sendKeys("spartaLex");
        passField.sendKeys("123456");
        webDriverWait.until(ExpectedConditions.visibilityOf(reCaptchaIframe));
        driver.switchTo().frame(reCaptchaIframe);
        captchaConfirm.click();
        driver.switchTo().parentFrame();
        confirmLoginButton.click();
        return new DiaryMyAccountPage(driver);
    }
}
