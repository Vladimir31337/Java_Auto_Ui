package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;


public class MainPage extends BaseView {



    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInButton;

@Step("Клик на кнопку авторизации")
    public LoginPageLesson6 clickSignInButton() {
        signInButton.click();
//        assertThat(driver.findElement(By.xpath("//span[@class='ajax_block_products_total']")), hasText("16$"));
        return new LoginPageLesson6(driver);
    }



    public MainPage(WebDriver driver) {
        super(driver);

    }
}

