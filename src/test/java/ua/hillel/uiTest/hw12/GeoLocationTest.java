package ua.hillel.uiTest.hw12;

import org.testng.annotations.Test;
import pageObjects.GeolocationPage;
import ua.hillel.uiTest.common.BaseUITest;

public class GeoLocationTest extends BaseUITest {
    @Test
    public void getLocationTest(){
        GeolocationPage geolocationPage = mainPage()
                .switchToGeolocationPage()
                .clickButton();
        System.out.println("Latitude : " + geolocationPage.getLatValue());
        System.out.println("Longitude : " + geolocationPage.getLongValue());
    }
}
