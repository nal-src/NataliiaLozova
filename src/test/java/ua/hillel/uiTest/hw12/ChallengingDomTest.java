package ua.hillel.uiTest.hw12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ua.hillel.uiTest.common.BaseUITest;

import java.util.List;

public class ChallengingDomTest extends BaseUITest {
    @Test
    public void clickElements() {
        driver.get("https://the-internet.herokuapp.com/challenging_dom");

        driver.findElement(By.cssSelector("div.large-2.columns > a.button:nth-child(1)")).click();
        driver.findElement(By.cssSelector("div.large-2.columns > a.button.alert")).click();
        driver.findElement(By.cssSelector("div.large-2.columns > a.button.success")).click();

        List<WebElement> lines = driver.findElements(By.cssSelector("table > tbody > tr"));

        for(WebElement line: lines) {
            WebElement column4 = line.findElement(By.cssSelector("td:nth-child(4)"));
            System.out.println(column4.getText());
        }
    }
}
