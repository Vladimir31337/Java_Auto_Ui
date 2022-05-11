package lesson6;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLesson6 extends BaseView {


    public LoginPageLesson6(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "SubmitLogin")
    private WebElement submitButton;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @Step("Логин")
    public MyAccountPage login(String email, String pass) {
//        Allure.step("1fewfwfwf");
        emailField.sendKeys(email);
        passwordField.sendKeys(pass);
        submitButton.click();
        return new MyAccountPage(driver);
    }
}

