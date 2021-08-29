package ua.hillel.uiTest.hw12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.hillel.uiTest.common.BaseUITest;

public class LoginTest extends BaseUITest {
    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void loginSuccessTest() {
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.clear();
        userNameField.sendKeys("tomsmith");

        WebElement passwordFiled = driver.findElement(By.id("password"));
        passwordFiled.clear();
        passwordFiled.sendKeys("SuperSecretPassword!");

        WebElement buttonSubmit = driver.findElement(By.cssSelector("form#login button[type='submit']"));
        buttonSubmit.click();

        String textSuccess = driver.findElement(By.cssSelector("div#flash-messages div.flash.success")).getText();

        Assert.assertTrue(textSuccess.contains("You logged into a secure area!"));
    }

    @Test
    public void loginFailureTest() {
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.clear();
        userNameField.sendKeys("zero75");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("SuperSecretPassword!");

        driver.findElement(By.cssSelector("form#login button[type='submit']")).click();

        String textFailure = driver.findElement(By.cssSelector("div#flash-messages div.flash.error")).getText();
        Assert.assertTrue(textFailure.contains("Your username is invalid!"));
    }
}
