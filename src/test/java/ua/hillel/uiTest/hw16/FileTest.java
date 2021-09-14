package ua.hillel.uiTest.hw16;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.MainPage;
import ua.hillel.uiTest.common.BaseUITest;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTest extends BaseUITest {
    @Test
    public void downloadAndUploadTest() {
        MainPage mainPage = goToMainPage();
        String fileName = mainPage
                .switchToFileDownloadPage()
                .downloadRandomTextFileAndReturnName();

        Path pathToFile = Paths.get(downloadDirectory + '/' + fileName);
        waitDownloadFile(pathToFile);
        writeToFile(pathToFile, "Test task -> downloadAndUploadTest");

        String successUploadTitleText = mainPage.load()
                .switchToFileUploadPage()
                .uploadFile(pathToFile)
                .getTitleText();

        pathToFile.toFile().deleteOnExit();
        Assert.assertEquals(successUploadTitleText, "File Uploaded!");
    }
}
