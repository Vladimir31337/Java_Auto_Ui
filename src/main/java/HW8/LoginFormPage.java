package HW8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class LoginFormPage {

    private SelenideElement mailField = $(By.xpath("//input[@name='username']"));
    private SelenideElement nextEnterButton = $(By.xpath("//button[@data-test-id='next-button']"));
    private SelenideElement passwordField = $(By.xpath("//input[@name='password']"));
    private SelenideElement submitEnterButton = $(By.xpath("//*[@data-test-id='submit-button']"));
    private SelenideElement loginFrame = $(By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']"));

    @Step("Логин")
    public MailBoxPage login2(String email, String pass) {
  switchTo().frame(loginFrame);
mailField.sendKeys(email);
nextEnterButton.click();
passwordField.sendKeys(pass);
submitEnterButton.click();

return page(MailBoxPage.class);

    }
}
