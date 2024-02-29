package org.codewithme.collections;

import org.codewithme.models.Book;

import java.util.ArrayList;
import java.util.List;

public class SimpleBookLookupTable implements BookLookupTable {
    private final List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book bookToAdd) {
        var id = bookToAdd.id();

        for (var book : books) {
            if (book.id() == id) {
                throw new IllegalArgumentException("Unable to add book, duplicate id for: " + bookToAdd);
            }
        }

        books.add(bookToAdd);
    }

    @Override
    public Book lookupById(int id) {
        for (var book : books) {
            if (book.id() == id) {
                return book;
            }
        }

        return null;
    }

    @Override
    public void clear() {
        books.clear();
    }
}
