import HW8.MailBoxPage;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lesson8.*;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs2 {

@Given("Авторизция на сайте")
public void userAuth() {
    open("https://mail.ru/");
//    new MainPage().clickSignInButton();
}

    @When("Логин")
    public void loginMail() throws InterruptedException {
    new HW8.MainPage().clickEnterButton().login2("qa1523@mail.ru","leshifre1337");
    }

    @And("Отправка почты другому пользователю")
    public void sentMail() {
    new MailBoxPage().mailSent();
    }

    @Then("Проверка отправки")
    public void checkSending() {
    new MailBoxPage().checkSending();
    }


















    @Given("Пользователь авторизован на сайте")
    public void userAuthorized() {
        Configuration.timeout = 10000;
//        Configuration.headless = true;
        open("http://automationpractice.com");
        new MainPage().clickSignInButton()
                .login("spartalex93@test.test","123456");
    }

    @When("Я навожу мышь на раздел Женщины")
    public void hoverWomanButton() {
        new MyAccountPage().hoverWomenButton();
    }

    @And("Я кликаю на раздел Рубашки")
    public void clickTShirtsButton() {
        new WomenSuggestBlock().tShirtsButtonClick();
    }

    @And("Выбираю в фильтре размер S")
    public void checkSize() {
        new TShirtsPage().selectSizeInFilters("S");
    }

    @And("Добавляю в корзину продукт Faded")
    public void addToCart() {
        new TShirtsPage().hoverAndClickAddToCartProductByName("Faded");
    }

    @Then("Проверяем корректность суммы заказа")
    public void checkSum() {
        new SuccessBlock().checkSuccessWithSum("$16.51");
    }
}
