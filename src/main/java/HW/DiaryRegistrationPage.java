package HW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiaryRegistrationPage extends DiaryMainPage {

    public DiaryRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='signupform-username']")
    WebElement registrationLoginField;
    @FindBy(xpath = "//input[@id='signupform-password']")
    WebElement registrationPasswordField;
    @FindBy(xpath = "//input[@id='signupform-email']")
    WebElement registrationEmailField;
    @FindBy(xpath = "//input[@id='chk_box_user_confirm']")
    WebElement acceptRulesButton;
    @FindBy(xpath = "//button[@id='signup_btn']")
    WebElement registrationConfirmButton;

public DiaryMyAccountPage registrationNewUser (String loginName, String regPassword,String regMail) throws InterruptedException {

    registrationLoginField.sendKeys(loginName);
    registrationPasswordField.clear();
    registrationPasswordField.sendKeys(regPassword);
    registrationEmailField.sendKeys(regMail);
    acceptRulesButton.click();
    registrationConfirmButton.click();
return new DiaryMyAccountPage(driver);
}

}
