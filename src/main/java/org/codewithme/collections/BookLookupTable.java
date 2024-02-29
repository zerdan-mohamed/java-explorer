package org.codewithme.collections;

import org.codewithme.models.Book;

public interface BookLookupTable {
    void addBook(Book bookToAdd);

    Book lookupById(int id);

    void clear();
}
