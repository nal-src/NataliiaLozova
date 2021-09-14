package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurePage extends BasePage {
    @FindBy(css = "div#flash-messages div.flash.success")
    private WebElement flashSuccessElm;

    public SecurePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getSuccessFlashMessage() {
        return flashSuccessElm.getText();
    }
}
