package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement userNameElm;

    @FindBy(id = "password")
    private WebElement passwordElm;

    @FindBy(css = "form#login button[type='submit']")
    private WebElement loginButtonElm;

    @FindBy(css = "div#flash-messages div.flash.error")
    private WebElement flashFailureElm;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Set username")
    public LoginPage setUserName(String value) {
        setValue(userNameElm, value);
        return this;
    }
    @Step("Set password")
    public LoginPage setPassword(String value) {
        setValue(passwordElm, value);
        return this;
    }
    @Step("Log into the app with valid credentials")
    public SecurePage clickLoginButton() {
        loginButtonElm.click();
        return new SecurePage(driver);
    }

    public String getFailureFlashMessage() {
        return flashFailureElm.getText();
    }
}
