package ua.hillel.uiTest.hw13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.hillel.uiTest.common.BaseUITest;

public class HoverMenuTest extends BaseUITest {
    @Test
    public void checkLoadSecondaryPageAfterClickTest() {
        driver.get("https://crossbrowsertesting.github.io/hover-menu.html");
        WebElement dropDownElement = driver.findElement(By.cssSelector("ul.nav.navbar-nav > li.dropdown"));
        actions().moveToElement(dropDownElement).perform();

        WebElement secondaryMenu = driver.findElement(By.partialLinkText("Secondary Menu"));

        actions().moveToElement(secondaryMenu).perform();

        WebElement secondaryActionLink = driver.findElement(By.partialLinkText("Secondary Action"));
        secondaryActionLink.click();

        String text = driver.findElement(By.cssSelector("div.jumbotron.secondary-clicked > h1")).getText();

        Assert.assertEquals(text, "Secondary Page");
    }
}
