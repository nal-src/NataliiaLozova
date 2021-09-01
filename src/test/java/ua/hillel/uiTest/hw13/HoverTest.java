package ua.hillel.uiTest.hw13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ua.hillel.uiTest.common.BaseUITest;

import java.util.List;

public class HoverTest extends BaseUITest {
    @Test
    public void getUserNameTest() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> avatars = driver.findElements(By.cssSelector("div.example > div.figure"));
        for (WebElement avatar : avatars) {
            actions().moveToElement(avatar).perform();
            String text = avatar.findElement(By.cssSelector("div.figcaption > h5")).getText();
            String username = text.replace("name:", "");
            System.out.println(username);
        }
    }
}
