package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TShirtsPage extends BaseView {
    public TShirtsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "span[.='Size']/ancestor::div[@class='layered_filter']//a")
    private List<WebElement> sizesList;

    @Step("Выбрать размер одежды в фильтре")
    public TShirtsPage selectSizeInFilters(String size) {
//        sizesList.stream().filter(s -> s.getText().equals()) полный список
        sizesList.stream().filter(s -> s.getText().contains(size)).findFirst().get().click();
        return this;
    }
    @FindBy(xpath = "//span[.='Add to Cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//ul[contains(@class, 'product_list')]/li")
    private List<WebElement> productList;

    @Step("Навести курсор на продукт и добавить его в корзину")
    public SuccessBlock hoverAndClickAddToCartProductByName(String productName) {
       actions.moveToElement(productList.stream().filter(s -> s.getText().contains(productName)).findFirst().get())
               //filter(s -> s.getAttribute("имя атрибута").contains(productName)).
               .build()
               .perform();
       addToCartButton.click();
//       webDriverWait.until(ExpectedConditions.visibilityOf()) Success Block
                return new SuccessBlock(driver);
    }



}