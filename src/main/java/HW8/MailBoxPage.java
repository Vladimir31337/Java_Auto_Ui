package HW8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;


public class MailBoxPage {

    SelenideElement newMail = $(By.xpath("//span[@class='compose-button__wrapper']"));
    SelenideElement mailRecipient = $(By.xpath("//div[@class='contactsContainer--3RMuQ']//input"));
    SelenideElement mailTheme = $(By.xpath("//div[@class='subject__wrapper--2mk6m']//input"));
    SelenideElement textArea = $(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div[1]"));
    SelenideElement senMailButton = $(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[1]/span[1]"));

    SelenideElement successent = $(By.xpath("/html/body/div[10]/div/div/div[2]/div[2]/div/div"));
    SelenideElement successSetInfoText = $(By.xpath("/html/body/div[10]/div/div/div[2]/div[2]/div/div/div[2]/a"));

    @Step("Отправка почты другому пользователю")
    public void mailSent() {
        newMail.click();
        mailRecipient.sendKeys("qa1523@mail.ru");
        mailTheme.sendKeys("Test Theme");
        textArea.sendKeys("Test Text");
        senMailButton.click();

    }
@Step("Проверка отправки")
    public void checkSending() {

        Assertions.assertAll(
                () -> successent.shouldBe(Condition.visible),
                () -> successSetInfoText.shouldHave(Condition.text("Письмо отправлено"))
        );

    }
}

