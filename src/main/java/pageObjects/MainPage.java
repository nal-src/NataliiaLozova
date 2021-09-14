package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    @FindBy(linkText = "Form Authentication")
    private WebElement loginLinkElm;

    @FindBy(linkText = "Geolocation")
    private WebElement geolocationLinkElm;

    @FindBy(linkText = "Challenging DOM")
    private WebElement challengingDomLinkElm;

    @FindBy(linkText = "Hovers")
    private WebElement hoversLinkElm;

    @FindBy(linkText = "File Download")
    private WebElement fileDownloadLinkElm;

    @FindBy(linkText = "File Upload")
    private WebElement fileUploadLinkElm;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage load() {
        driver.get("https://the-internet.herokuapp.com");
        return this;
    }

    public LoginPage switchToLoginPage() {
        loginLinkElm.click();
        return new LoginPage(driver);
    }

    public GeolocationPage switchToGeolocationPage() {
        geolocationLinkElm.click();
        return new GeolocationPage(driver);
    }

    public ChallengingDomPage switchToChallengingDomPage() {
        challengingDomLinkElm.click();
        return new ChallengingDomPage(driver);
    }

    public HoversPage switchToHoverPage() {
        hoversLinkElm.click();
        return new HoversPage(driver);
    }

    public FileDownloadPage switchToFileDownloadPage() {
        fileDownloadLinkElm.click();
        return new FileDownloadPage(driver);
    }

    public FileUploadPage switchToFileUploadPage() {
        fileUploadLinkElm.click();
        return new FileUploadPage(driver);
    }
}
