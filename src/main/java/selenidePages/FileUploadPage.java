package selenidePages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class FileUploadPage {
    private final SelenideElement fileInputElm = $("#file-upload");

    private final SelenideElement uploadButtonElm = $("#file-submit");

    private final SelenideElement titleElm = $("div.example h3");

    public FileUploadPage uploadFile(File file) {
        fileInputElm.uploadFile(file);
        uploadButtonElm.click();
        return this;
    }

    public String getTitleText() {
        return titleElm.text();
    }
}
