package ua.hillel.test.hw11;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task3Test {
    @Parameters({"version","url", "browser"})
    @Test
    public void someTest(String version, String url, @Optional("Chrome") String browser){
        System.out.println("Version: " + version);
        System.out.println("Url: " + url);
        System.out.println("Browser: " + browser);

    }
}
