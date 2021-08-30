package ua.hillel.uiTest.hw12;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ua.hillel.uiTest.common.BaseUITest;

public class GeoLocationTest extends BaseUITest {
    @Test
    public void getLocationTest(){
        driver.get("https://the-internet.herokuapp.com/geolocation");
        driver.findElement(By.cssSelector("div.example button")).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ignored) {
        }
        String latValue = driver.findElement(By.id("lat-value")).getText();
        String longValue = driver.findElement(By.id("long-value")).getText();
        System.out.println("Latitude : " + latValue);
        System.out.println("Longitude : " + longValue);
    }
}
