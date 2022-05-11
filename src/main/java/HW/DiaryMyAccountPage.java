package HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DiaryMyAccountPage extends DiaryMainPage {
    public DiaryMyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='https://diary.ru/u-mail']")
    WebElement myMail;
    @FindBy(xpath = "//a[@href='/u-mail/new']")
    WebElement writeNewMail;
    @FindBy(xpath = "//textarea[@id='touser']")
    WebElement userName;

public void sendNewMail() throws InterruptedException {
//    Thread.sleep(5000);
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/a[@href='https://diary.ru/u-mail']")));
    myMail.click();
    writeNewMail.click();
    userName.sendKeys("qa1524");
}
}
