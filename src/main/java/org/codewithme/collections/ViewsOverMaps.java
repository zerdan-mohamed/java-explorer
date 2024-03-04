package org.codewithme.collections;

import org.codewithme.models.Book;

import java.util.HashMap;
import java.util.Map;

public class ViewsOverMaps {
    static Book book1 = new Book(1, "Who Rules the World?", 50);
    static Book book2 = new Book(2, "Understanding Power: The Indispensable Chomsky", 80);
    static Book book3 = new Book(3, "Chomsky On Anarchism", 40);

    public static void main(String[] args) {
        var idToBook = new HashMap<Integer, Book>();
        idToBook.put(1, book1);
        idToBook.put(2, book2);
        idToBook.put(3, book3);

        var ids = idToBook.keySet();
        System.out.println(ids);
        System.out.println(idToBook);
        System.out.println(" ### ### ### \n");

        // remove from the view has modified the backing map
        // and also remove fom the map has removed a value from the view
        ids.remove(1);
        System.out.println(ids);
        System.out.println(idToBook);
        System.out.println(" ### ### ### \n");

        // unsupported operation: exception because we can't add a key without adding a value and vice versa
        // ids.add(5);

        var books = idToBook.values();
        System.out.println(books);
        System.out.println(idToBook);
        System.out.println(" ### ### ### \n");

        books.remove(book3);

        System.out.println(books);
        System.out.println(idToBook);
        System.out.println(" ### ### ### \n");

        var entries = idToBook.entrySet();
        for (var entry : entries) {
            System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println(" ### ### ### \n");
        }

        var entry = Map.entry(3, book3);
        // unsupported operation: exception because we can't alter an immutable collection
        // entries.add(entry);

        System.out.println(idToBook);
    }
}
