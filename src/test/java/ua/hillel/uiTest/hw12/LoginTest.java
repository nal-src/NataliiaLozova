package ua.hillel.uiTest.hw12;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import ua.hillel.uiTest.common.BaseUITest;

public class LoginTest extends BaseUITest {
    @Test
    public void loginSuccessTest() {
          String textSuccess = goToMainPage()
                  .switchToLoginPage()
                  .setUserName("tomsmith")
                  .setPassword("SuperSecretPassword!")
                  .clickLoginButton()
                  .getSuccessFlashMessage();
        Assert.assertTrue(textSuccess.contains("You logged into a secure area!"));
    }

    @Test
    public void loginFailureTest() {
        LoginPage loginPage = goToMainPage()
                .switchToLoginPage()
                .setUserName("zero75")
                .setPassword("SuperSecretPassword!");

        loginPage.clickLoginButton();
        String textFailure = loginPage.getFailureFlashMessage();
        Assert.assertTrue(textFailure.contains("Your username is invalid!"));
    }
}
