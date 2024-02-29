package org.codewithme.collections;

import org.codewithme.models.Book;

import java.util.HashMap;
import java.util.Map;

public class MapBookLookupTable implements BookLookupTable {
    private final Map<Integer, Book> books = new HashMap<>();

    @Override
    public void addBook(Book bookToAdd) {
        var id = bookToAdd.id();

        if (books.containsKey(id)) {
                throw new IllegalArgumentException("Unable to add book, duplicate id for: " + bookToAdd);
        }

        books.put(id, bookToAdd);
    }

    @Override
    public Book lookupById(int id) {
        return books.get(id);
    }

    @Override
    public void clear() {
        books.clear();
    }
}
