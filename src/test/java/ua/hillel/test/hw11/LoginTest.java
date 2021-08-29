package ua.hillel.test.hw11;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
    @DataProvider(name = "loginData")
    public Object[][] generateLoginData() {
        return new Object[][] {
                {"test", "qwerty123", "admin"}
        };
    }

    @Test(groups = {"login"}, dataProvider = "loginData")
    public void loginTest(String userName, String password, String role) {
        Assert.assertEquals(userName, "test");
        Assert.assertEquals(password, "qwerty123");
        Assert.assertEquals(role, "admin");
    }

    @Test(dependsOnGroups = {"login"})
    public void loginDependentTest() {
        System.out.println("Run loginDependentTest");
    }
}
