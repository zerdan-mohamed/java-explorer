package org.codewithme.collections;

import org.codewithme.models.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LookupTableComparison {

    private static final int ITERATIONS = 5;
    private static final int NUMBER_OF_BOOKS = 20_000;

    private static final List<Book> books = generateBooks();

    public static void main(String[] args) {
        runLookups(new MapBookLookupTable());
        runLookups(new SimpleBookLookupTable());
    }

    private static List<Book> generateBooks() {
        final List<Book> books = new ArrayList<>();
        final Random weightGenerator = new Random();

        for (int i = 0; i < NUMBER_OF_BOOKS; i++) {
            books.add(new Book(i, "Book" + i, 10 + weightGenerator.nextInt(10)));
        }

        Collections.shuffle(books);
        Collections.shuffle(books);
        Collections.shuffle(books);

        return books;
    }

    private static void runLookups(final BookLookupTable table) {
        final List<Book> books = LookupTableComparison.books;
        System.out.println("Running lookups with " + table.getClass().getSimpleName());

        for (int i = 0; i < ITERATIONS; i++) {
            final long startTime = System.currentTimeMillis();

            for (Book book : books) {
                table.addBook(book);
            }

            for (Book book : books) {
                final Book result = table.lookupById(book.id());
                if (result != book) {
                    throw new IllegalStateException("Lookup Table returned wrong result for " + book);
                }
            }

            table.clear();

            System.out.println(System.currentTimeMillis() - startTime + "ms");
        }
    }
}
