package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.Path;

public class FileUploadPage extends BasePage {
    @FindBy(id = "file-upload")
    private WebElement fileInputElm;

    @FindBy(id = "file-submit")
    private WebElement uploadButtonElm;

    @FindBy(css = "div.example h3")
    private WebElement titleElm;

    public FileUploadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public FileUploadPage uploadFile(Path pathToFile) {
        fileInputElm.sendKeys(pathToFile.toFile().getAbsolutePath());
        uploadButtonElm.click();
        return this;
    }

    public String getTitleText() {
        return titleElm.getText();
    }
}
