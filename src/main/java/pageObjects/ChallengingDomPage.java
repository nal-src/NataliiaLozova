package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ChallengingDomPage extends BasePage {
    @FindBy(css = "div.large-2.columns > a.button:nth-child(1)")
    private WebElement firstButtonElm;

    @FindBy(css = "div.large-2.columns > a.button.alert")
    private WebElement secondButtonElm;

    @FindBy(css = "div.large-2.columns > a.button.success")
    private WebElement thirdButtonElm;
    
    @FindAll({@FindBy(css = "table > tbody > tr")})
    private List<WebElement> lines;

    public ChallengingDomPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<String> getTextFromFourthColumnAfterClickButtons() {
        firstButtonElm.click();
        secondButtonElm.click();
        thirdButtonElm.click();

        List<String> values = new ArrayList<>();

        for(WebElement line: lines) {
            WebElement column4 = line.findElement(By.cssSelector("td:nth-child(4)"));
            values.add(column4.getText());
        }

        return values;
    }
}
