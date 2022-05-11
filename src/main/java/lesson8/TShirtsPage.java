package lesson8;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class TShirtsPage {

    private ElementsCollection sizeList = $$(By.xpath("span[.='Size']/ancestor::div[@class='layered_filter']//a"));

    @Step("Выбрать размер одежды в фильтре")
    public TShirtsPage selectSizeInFilters(String size) {
        sizeList.findBy(Condition.text(size));
        return this;
    }

    private ElementsCollection productList = $$(By.xpath("//ul[contains(@class, 'product_list')]/li"));
    private SelenideElement addToCartButton = $(By.xpath("//span[.='Add to Cart']"));

    @Step("Навести курсор на продукт и добавить его в корзину")
    public SuccessBlock hoverAndClickAddToCartProductByName(String productName) {
        productList.findBy(Condition.text(productName)).hover();
        addToCartButton.click();
        return page(SuccessBlock.class);
    }
}
