package org.codewithme.functionalinterfaces;

public class StringProcessing {
    // Method to process a string using a StringProcessor
    private static String processString(String input, StringProcessor processor) {
        return processor.process(input);
    }

    public static void main(String[] args) {
        // Define lambda expressions for string processing
        StringProcessor toUpperCase = String::toUpperCase;
        StringProcessor toLowerCase = String::toLowerCase;
        StringProcessor removeSpaces = str -> str.replaceAll(" ", "");
        StringProcessor reverse = str -> new StringBuilder(str).reverse().toString();

        // Input string
        String inputString = "Hello, World!";

        // Perform string processing using lambda expressions
        String resultUpper = processString(inputString, toUpperCase);
        String resultLower = processString(inputString, toLowerCase);
        String resultNoSpaces = processString(inputString, removeSpaces);
        String resultReversed = processString(inputString, reverse);

        // Display the results
        System.out.println("Original String: " + inputString);
        System.out.println("To Uppercase: " + resultUpper);
        System.out.println("To Lowercase: " + resultLower);
        System.out.println("Remove Spaces: " + resultNoSpaces);
        System.out.println("Reversed: " + resultReversed);
    }
}
