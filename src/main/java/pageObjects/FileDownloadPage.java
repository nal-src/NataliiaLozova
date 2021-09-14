package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class FileDownloadPage extends BasePage {
    @FindAll({@FindBy(css = "div a[href$='.txt']")})
    private List<WebElement> textLinksElements;

    public FileDownloadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String downloadRandomTextFileAndReturnName() {
        Random rand = new Random();
        WebElement textLink = textLinksElements.get(rand.nextInt(textLinksElements.size()));
        String fileName = textLink.getText();
        textLink.click();
        return fileName;
    }
}
