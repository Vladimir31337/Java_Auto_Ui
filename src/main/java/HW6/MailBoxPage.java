package HW6;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class MailBoxPage extends MainPage {
    //    @FindBy(xpath = "//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/span/div[1]/div[1]/div/div/div/div[1]/div/div/a/span")
    @FindBy(xpath = "//span[@class='compose-button__wrapper']")
    WebElement newMail;
    @FindBy(xpath = "//div[@class='contactsContainer--3RMuQ']//input")
    WebElement mailRecipient;
    @FindBy(xpath = "//div[@class='subject__wrapper--2mk6m']//input")
    WebElement mailTheme;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div[1]")
    WebElement textArea;
    @FindBy(xpath = "//span[text()= 'Отправить']")
    WebElement senMailButton;
    //
    @FindBy(xpath = "/html/body/div[10]/div/div/div[2]/div[2]/div/div")
    WebElement successSentWindow;
    @FindBy(xpath = "/html/body/div[10]/div/div/div[2]/div[2]/div/div/div[2]/a")
    WebElement successSetInfoText;
  //


    @Step("Отправка почты другому пользователю")
    public void mailSent() throws InterruptedException {
//    actions.moveToElement(newMail);
//    Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='compose-button__wrapper']")));
        newMail.click();
//        Thread.sleep(1000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='subject__wrapper--2mk6m']//input")));
        mailRecipient.sendKeys("qa1523@mail.ru");
        mailTheme.sendKeys("Test Theme");
        textArea.sendKeys("Test Text");
        senMailButton.click();
        Thread.sleep(5000);
            Assertions.assertAll(
                    () -> assertThat(driver.findElement(By.xpath("/html/body/div[10]/div/div/div[2]/div[2]/div/div")), isDisplayed()),
                    () -> assertThat(driver.findElement(By.xpath("/html/body/div[10]/div/div/div[2]/div[2]/div/div/div[2]/a")), hasText("Письмо отправлено")));

        }

    public MailBoxPage(WebDriver driver) {
        super(driver);
    }
}
