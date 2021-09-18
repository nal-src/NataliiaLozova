package ua.hillel.uiTest.hw17;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenidePages.FileDownloadPage;
import selenidePages.FileUploadPage;
import ua.hillel.uiTest.common.BaseUITestWithSelenide;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.open;

public class FileTest extends BaseUITestWithSelenide {
    @Test
    public void downloadAndUploadTest() throws FileNotFoundException {
        open("https://the-internet.herokuapp.com/download");
        FileDownloadPage fileDownLoadPage = new FileDownloadPage();
        File fileDownload = fileDownLoadPage.downloadRandomTextFileAndReturnFile();
        writeToFile(fileDownload.toPath(), "Test task -> downloadAndUploadTest");

        open("https://the-internet.herokuapp.com/upload");
        FileUploadPage fileUploadPage = new FileUploadPage();

        fileUploadPage.uploadFile(fileDownload);
        String successUploadTitleText = fileUploadPage.getTitleText();

        fileDownload.deleteOnExit();
        Assert.assertEquals(successUploadTitleText, "File Uploaded!");
    }
}
