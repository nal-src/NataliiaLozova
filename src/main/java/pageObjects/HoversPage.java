package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoversPage extends BasePage {
    @FindBy(css = "div.example div.figure:nth-of-type(1)")
    private WebElement firstAvatarsElm;

    @FindBy(css = "div.example div.figure:nth-of-type(2)")
    private WebElement secondAvatarsElm;

    @FindBy(css = "div.example div.figure:nth-of-type(3)")
    private WebElement thirdAvatarsElm;

    private final By byUserTitle = By.cssSelector("div.figcaption > h5");

    public HoversPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getFirstUserName() {
        return getTextFormAvatar(firstAvatarsElm);
    }

    public String getSecondUserName() {
        return getTextFormAvatar(secondAvatarsElm);
    }

    public String getThirdUserName() {
        return getTextFormAvatar(thirdAvatarsElm);
    }

    private String getTextFormAvatar(WebElement avatar) {
        actions.moveToElement(avatar).perform();
        return cleanUserName(avatar.findElement(byUserTitle).getText());
    }

    private String cleanUserName(String value) {
        return value.replace("name:", "");
    }
}
