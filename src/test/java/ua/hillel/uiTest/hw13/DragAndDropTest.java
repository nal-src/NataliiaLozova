package ua.hillel.uiTest.hw13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.hillel.uiTest.common.BaseUITest;

public class DragAndDropTest extends BaseUITest {
    @Test
    public void checkDragAndDropSuccessTest() {
        driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(draggable, droppable).perform();

        Assert.assertEquals(droppable.getText().trim(), "Dropped!");
    }
}
