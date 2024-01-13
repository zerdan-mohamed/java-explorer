package org.codewithme.streams;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {
    public static void main(String[] args) {
        simpleFilter();
        sumNumbers();
        complexFilter();
    }

    private static void simpleFilter() {
        // Filtering and mapping a list of strings
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry", "Avocado", "Apricot");
        List<String> filteredFruits = fruits.stream()  // Create a stream
                .filter(fruit -> fruit.startsWith("A"))  // Intermediate operation: filter
                .map(String::toUpperCase)  // Intermediate operation: map
                .toList();  // Terminal operation: toList

        System.out.println("Fruits that start with 'A': " + filteredFruits);

        List<String> longWords = fruits.stream()
                .filter(s -> s.length() > 4)
                .collect(Collectors.toList()); // Terminal operation: collect
        System.out.println(longWords);
    }

    private static void complexFilter() {
        List<String> words = Arrays.asList("tst", "one", "two", "three", "four", "five", "rotator", "deified");

        System.out.println("filtering :");
        List<String> palindromes = words.stream()
                .filter(s -> s.contentEquals(new StringBuilder(s).reverse()))
                .collect(Collectors.toList());
        System.out.println(palindromes);
    }

    private static void sumNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)  // Intermediate operation: map to int
                .sum();  // Terminal operation: sum

        System.out.println("Sum of numbers: " + sum);
    }

}
