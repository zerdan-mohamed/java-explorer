package org.codewithme.collections;

import org.codewithme.models.Book;

import java.util.HashMap;

public class AdvancedMapOperations {

    // HashMap :
    //  - good general purpose implementation
    //  - use the .hashCode() method
    //  - maintains an array of buckets
    //  - buckets are linked lists to accommodate collisions
    //  - buckets can be trees
    //  - performance complexity: put -> O(1|N), get -> O(1|N), containsKey -> O(1|N),
    //                            next -> O(capacity/N) [capacity: nb size of the backing array]
    //                            replace -> O(1|N), replaceAll -> O(N), putIfAbsent -> O(1|N),
    //                            compute -> O(1|N), computeIfPresent -> O(1|N), merge -> O(1|N)

    // TreeMap :
    //  - have keys with a defined sort order
    //  - use a red/black (balanced) binary search tree
    //  - slower than Hashmap because there's a lot of pointer chasing and comparison
    //  - performance complexity: put -> O(logN), get -> O(logN), containsKey -> O(1|logN), next -> O(logN)

    static Book book1 = new Book(1, "Who Rules the World?", 50);
    static Book book2 = new Book(2, "Understanding Power: The Indispensable Chomsky", 80);
    static Book book3 = new Book(3, "Chomsky On Anarchism", 40);

    public static void main(String[] args) {
        var defaultBook = new Book(-1, "Book of the year?", 100);

        var idToBook = new HashMap<Integer, Book>();
        idToBook.put(1, book1);
        idToBook.put(2, book2);
        idToBook.put(3, book3);

        var result = idToBook.getOrDefault(10, defaultBook);
        System.out.println(result);
        System.out.println(idToBook.get(10));
        System.out.println(" ### ### ### \n");

        result = idToBook.computeIfAbsent(10, (id) -> new Book(id, "Custom Book", 10));
        System.out.println(result);
        System.out.println(idToBook.get(10));
        System.out.println(" ### ### ### \n");

        idToBook.replaceAll((key, oldBook) -> new Book(oldBook.id(), oldBook.name(), oldBook.price() + 10));

        System.out.println(idToBook);

        idToBook.replace(1, new Book(1, "Hegemony or Survival: America's Quest for Global Dominance", 65));

        idToBook.remove(2);

        idToBook.putIfAbsent(4, new Book(4, "Propaganda and the Public Mind", 70));

        idToBook.computeIfPresent(3, (id, book) -> new Book(book.id(), book.name(), book.price() + 20));

        idToBook.compute(
                5,
                (id, book) -> book == null
                        ? new Book(id, "Language and Mind", 60)
                        : new Book(id, book.name(), book.price() + 5)
        );

        idToBook.merge(
                5,
                new Book(5, "Language and Mind", 75),
                (oldBook, newBook) -> new Book(oldBook.id(), oldBook.name(), oldBook.price() + newBook.price())
        );

        System.out.println(idToBook);
    }
}
