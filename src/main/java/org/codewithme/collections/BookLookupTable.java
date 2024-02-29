package org.codewithme.collections;

import org.codewithme.models.Book;

public interface BookLookupTable {
    void addBook(Book productToAdd);

    Book lookupById(int id);

    void clear();
}
