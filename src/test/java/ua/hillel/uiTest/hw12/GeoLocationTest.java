package ua.hillel.uiTest.hw12;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import ua.hillel.uiTest.common.BaseUITest;

public class GeoLocationTest extends BaseUITest {
    @Test
    public void getLocationTest(){
        driver.get("https://the-internet.herokuapp.com/geolocation");
        driver.findElement(By.cssSelector("div.example button")).click();

        By locatorLatElement = By.id("lat-value");
        By locatorLongElement = By.id("long-value");

        wait.until(ExpectedConditions.and(
                ExpectedConditions.presenceOfElementLocated(locatorLatElement),
                ExpectedConditions.presenceOfElementLocated(locatorLongElement)
        ));

        String latValue = driver.findElement(locatorLatElement).getText();
        String longValue = driver.findElement(locatorLongElement).getText();
        System.out.println("Latitude : " + latValue);
        System.out.println("Longitude : " + longValue);
    }
}
