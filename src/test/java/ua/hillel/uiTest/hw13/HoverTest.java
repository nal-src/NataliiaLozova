package ua.hillel.uiTest.hw13;

import org.testng.annotations.Test;
import pageObjects.HoversPage;
import ua.hillel.uiTest.common.BaseUITest;

public class HoverTest extends BaseUITest {
    @Test
    public void getUserNameTest() {
        HoversPage hoversPage = goToMainPage().switchToHoverPage();
        System.out.println(hoversPage.getFirstUserName());
        System.out.println(hoversPage.getSecondUserName());
        System.out.println(hoversPage.getThirdUserName());
    }
}
