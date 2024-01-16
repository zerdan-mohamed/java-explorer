package org.codewithme.streams;

import org.codewithme.models.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonStreams {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Sami", 30),
                new Person("Yassine", 20),
                new Person("Badr", 25),
                new Person("Salim", 20)
        );

        // ### Filtering and Mapping
        List<String> namesOfAdults = people.stream()
                .filter(p -> p.age() >= 18)
                .map(Person::name)
                .toList();

        namesOfAdults.forEach(System.out::println);


        // ### Grouping By with a Mappers
        Map<Integer, List<String>> peopleByAge = people.stream()
                .collect(Collectors.groupingBy(
                        Person::age,
                        Collectors.mapping(Person::name, Collectors.toList())
                ));

        peopleByAge.forEach((age, names) -> System.out.println("Age " + age + ": " + names));


        // ### Custom Collector
        Collector<CharSequence, ?, String> joiningWithPipe = Collectors.joining("|");
        String result = Stream.of("One", "Two", "Three").collect(joiningWithPipe);

        System.out.println("Grouped People: " + result);


        // ### Parallel Streams
        List<Person> filteredPeople = people.parallelStream()
                .filter(p -> p.age() >= 20 && p.age() <= 28)
                .toList();

        filteredPeople.forEach(System.out::println);


        // ### Advanced Sorting
        List<Person> sortedPeople = people.stream()
                .sorted(Comparator
                        .comparingInt(Person::age)
                        .thenComparing(Person::name)
                ).toList();

        sortedPeople.forEach(System.out::println);

    }
}
