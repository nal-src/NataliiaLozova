package ua.hillel.uiTest.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pageObjects.MainPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseUITest {
    public WebDriver driver;
    protected final String downloadDirectory = "target";

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();

        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", Paths.get(downloadDirectory).toFile().getAbsolutePath());
        prefs.put("safebrowsing.enabled", "false");
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

    protected MainPage goToMainPage() {
        return new MainPage(driver).load();
    }

    protected void waitDownloadFile(Path pathToFile) {
        waitDownloadFile(pathToFile, 500);
    }

    protected void waitDownloadFile(Path pathToFile, int timeOut) {
        File file = pathToFile.toFile();
        while (true) {
            if(!file.exists()) {
                try {
                    Thread.sleep(timeOut);
                } catch (InterruptedException ignored) {
                }
            } else {
                break;
            }
        }
    }

    @SneakyThrows
    @AfterMethod
    public void takeScreenshot(ITestResult result){
        if (!result.isSuccess()){
           File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           saveScreenshot(Files.readAllBytes(screenshot.toPath()));
        }
    }

    protected void writeToFile(Path pathToFile, String value) {
        try {
            List<String> lines = Files.readAllLines(pathToFile);
            lines.add(value);
            Files.write(pathToFile, lines, StandardOpenOption.APPEND);
        } catch (IOException ignored) {
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
