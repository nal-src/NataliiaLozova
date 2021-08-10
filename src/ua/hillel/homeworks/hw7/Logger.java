package ua.hillel.homeworks.hw7;

import java.time.LocalDateTime;

public class Logger {
    public static final String ANSI_RESET = "\u001B[0m";

    private enum LogLevel {
        INFO("\u001B[34m"),
        ERROR("\u001B[31m"),
        WARNING("\u001B[33m"),
        DEBUG("\u001B[32m");

        private String level;
        LogLevel(String level) {
            this.level = level;
        }

        private String getValue() {
            return level;
        }
    }

    public void info(String message) {
        print(LogLevel.INFO, message);
    }

    public void debug(String message) {
        print(LogLevel.DEBUG, message);
    }

    public void error(String message) {
        print(LogLevel.ERROR, message);
    }

    public void warning(String message) {
        print(LogLevel.WARNING, message);
    }

    private void print(LogLevel type, String message) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println(type.getValue() + type + "[" + currentDateTime + "]: " + ANSI_RESET + message);
    }
}