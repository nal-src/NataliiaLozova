package selenidePages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$$;

public class FileDownloadPage {
    private final ElementsCollection textLinksElements = $$("div a[href$='.txt']");

    public File downloadRandomTextFileAndReturnFile() throws FileNotFoundException {
        Random rand = new Random();
        SelenideElement textLink = textLinksElements.get(rand.nextInt(textLinksElements.size()));
        return textLink.download();
    }
}
