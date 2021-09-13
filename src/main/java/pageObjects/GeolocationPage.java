package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GeolocationPage extends BasePage {
    @FindBy(css = "div.example button")
    private WebElement buttonElm;

    @FindBy(id = "lat-value")
    private WebElement latElement;

    @FindBy(id = "long-value")
    private WebElement longElement;

    public GeolocationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GeolocationPage clickButton() {
        buttonElm.click();
        return this;
    }

    public String getLatValue() {
        wait.until(ExpectedConditions.visibilityOf(latElement));
        return latElement.getText();
    }

    public String getLongValue() {
        wait.until(ExpectedConditions.visibilityOf(longElement));
        return latElement.getText();
    }
}
