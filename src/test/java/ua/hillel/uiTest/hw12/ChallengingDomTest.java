package ua.hillel.uiTest.hw12;

import org.testng.annotations.Test;
import ua.hillel.uiTest.common.BaseUITest;

import java.util.List;

public class ChallengingDomTest extends BaseUITest {
    @Test
    public void clickElements() {
        List<String> values = goToMainPage()
                .switchToChallengingDomPage()
                .getTextFromFourthColumnAfterClickButtons();

        for(String value: values) {
            System.out.println(value);
        }
    }
}
