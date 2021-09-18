package ua.hillel.uiTest.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class BaseUITestWithSelenide {

    protected void writeToFile(Path pathToFile, String value) {
        try {
            List<String> lines = Files.readAllLines(pathToFile);
            lines.add(value);
            Files.write(pathToFile, lines, StandardOpenOption.APPEND);
        } catch (IOException ignored) {
        }
    }
}
