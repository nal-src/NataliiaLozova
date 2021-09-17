package ua.hillel.uiTest.hw17;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenidePages.DynamicControlPage;

import static com.codeborne.selenide.Selenide.open;

public class DynamicControlTest {
    @Test
    public void dynamicControlCheckboxTest() {
        open("https://the-internet.herokuapp.com/dynamic_controls");
        DynamicControlPage dynamicControlPage = new DynamicControlPage();

        String checkboxMsg =  dynamicControlPage
                .setCheckbox()
                .removeCheckbox()
                .addCheckbox()
                .setCheckbox()
                .getCheckboxMsg();

        Assert.assertEquals(checkboxMsg, "It's back!");
    }

    @Test
    public void dynamicControlInputTest() {
        open("https://the-internet.herokuapp.com/dynamic_controls");
        DynamicControlPage dynamicControlPage = new DynamicControlPage();

        String inputFirstMsg =  dynamicControlPage
                .changeInputStatus()
                .getInputMsg();

        String inputSecondMsg =  dynamicControlPage
                .changeInputStatus()
                .getInputMsg();

        Assert.assertEquals(inputFirstMsg, "It's enabled!");
        Assert.assertEquals(inputSecondMsg, "It's disabled!");
    }
}
