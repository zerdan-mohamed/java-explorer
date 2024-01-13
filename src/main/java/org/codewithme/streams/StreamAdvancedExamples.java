package org.codewithme.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAdvancedExamples {
    public static void main(String[] args) {
        advancedStream();
        aggregatingOperationsExamples();
    }

    private static void advancedStream() {
        // ## Creation
        Stream<String> streamFromList = Arrays.asList("Apple", "Banana", "Cherry").stream();
        Stream<String> streamFromValues = Stream.of("One", "Two", "Three");
        IntStream streamFromRange = IntStream.range(1, 4);

        // ## Intermediate Operations
        List<String> mappedList = streamFromList.map(String::toUpperCase).toList();
        List<String> filteredList = streamFromValues.filter(s -> s.length() > 3).toList();
        IntStream doubledNumbers = streamFromRange.map(n -> n * 2);

        // ## Terminal Operations
        mappedList.forEach(System.out::println);
        long count = filteredList.size(); // Count elements with length > 3
        OptionalInt max = doubledNumbers.max(); // Find max in doubled numbers


        System.out.println("1. Additional Examples - Sorting");
        List<Integer> sortedNumbers = Stream.of(3, 1, 4, 1, 5, 9)
                .sorted()
                .toList();

        System.out.println("2. Additional Examples - Reduction");
        int sum = Stream.of(1, 2, 3, 4, 5)
                .reduce(0, Integer::sum);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int product = numbers.stream().reduce(1, (a, b) -> a * b);

        System.out.println("3. Additional Examples - Collecting to Map");
        Map<String, Integer> map = Stream.of("Apple", "Banana", "Apple", "Cherry")
                .collect(Collectors.toMap(Function.identity(), v -> 1, Integer::sum));

        System.out.println("4. Additional Examples - FlatMap");
        List<List<String>> nestedLists = Arrays.asList(
                Arrays.asList("Apple", "Banana"),
                Arrays.asList("Cherry", "Date")
        );

        List<String> flatList = nestedLists.stream()
                .flatMap(Collection::stream)
                .toList();

        System.out.println("5. Additional Examples - Combining FlatMap and Reduce");
        List<List<Integer>> nestedNumbers = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        int totalSum = nestedNumbers.stream()
                .flatMap(List::stream)
                .reduce(0, Integer::sum);

        System.out.println("6. Additional Examples - Parallel Stream");
        long countParallel = Arrays.asList("Apple", "Banana", "Cherry")
                .parallelStream()
                .filter(s -> s.contains("a"))
                .count();

        // Output Results
        System.out.println("Filtered List Count: " + count);
        max.ifPresent(value -> System.out.println("Max of doubled numbers: " + value));
        System.out.println("Sorted Numbers: " + sortedNumbers);
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        System.out.println("TotalSum: " + totalSum);
        System.out.println("Fruit Occurrences: " + map);
        System.out.println("Flattened List: " + flatList);
        System.out.println("Parallel Stream Count: " + countParallel);
    }

    private static void aggregatingOperationsExamples() {
        List<String> words = Arrays.stream("Once upon a midnight dreary while I pondered weak and weary".split("\\s+"))
                .toList();

        System.out.println("1. Check if all items satisfy a criterion:");
        boolean noWordsLongerThan9 = words.stream().allMatch(w -> w.length() <= 9);
        boolean theSame = words.stream().noneMatch(w -> w.length() > 9);
        System.out.println(noWordsLongerThan9);
        System.out.println(theSame);

        System.out.println("2. Check if any item satisfies a criterion:");
        boolean hasShortWords = words.stream().anyMatch(w -> w.length() < 3);
        System.out.println(hasShortWords);

        System.out.println("3. Average over the items");
        double average = words.stream().mapToInt(String::length).average().orElse(0.0);
        System.out.println(average);

        System.out.println("4. Count items that satisfy a criterion:");
        long wordsWithE = words.stream().filter(w -> w.contains("e")).count();
        System.out.println(wordsWithE);

        System.out.println("5. Max and sum");
        int maxWordLength = words.stream().mapToInt(String::length).max().orElse(0); //min is the same
        int sumWordLength = words.stream().mapToInt(String::length).sum();
        System.out.println("max: " + maxWordLength + ", sum: " + sumWordLength);
    }
}
