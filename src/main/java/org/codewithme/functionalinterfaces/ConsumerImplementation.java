package org.codewithme.functionalinterfaces;

import java.util.function.Consumer;

public class ConsumerImplementation {
    // A common use case for the Consumer functional interface is in creating a logging utility
    // that allows us to log messages to different destinations (e.g., console, file, network).

    private final Consumer<String> logConsumer;

    public ConsumerImplementation(Consumer<String> logConsumer) {
        this.logConsumer = logConsumer;
    }

    public static void main(String[] args) {
        ConsumerImplementation consoleLogger = ConsumerImplementation.createConsoleLogger();

        ConsumerImplementation fileLogger = ConsumerImplementation.createFileLogger("log.txt");

        consoleLogger.logInfo("This is an informational message");
        fileLogger.logError("This is an error message");
    }


    public void log(String message) {
        logConsumer.accept(message);
    }

    public void logError(String errorMessage) {
        log("ERROR: " + errorMessage);
    }

    public void logInfo(String infoMessage) {
        log("INFO: " + infoMessage);
    }

    public static ConsumerImplementation createConsoleLogger() {
        return new ConsumerImplementation(System.out::println);
    }

    public static ConsumerImplementation createFileLogger(String filePath) {
        return new ConsumerImplementation(message -> System.out.println("Logging to file '" + filePath + "': " + message));
    }
}
