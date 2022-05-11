package HW8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    private SelenideElement enterButton = $(By.xpath("//*[@data-testid='enter-mail-primary']"));

    @Step("Клик на кнопку авторизации")
    public LoginFormPage clickEnterButton() {
        enterButton.click();
        return page(HW8.LoginFormPage.class);
    }

}
