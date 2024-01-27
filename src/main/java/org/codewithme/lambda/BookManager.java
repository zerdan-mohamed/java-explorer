package org.codewithme.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class BookManager {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBooks(Predicate<Book> condition) {
        books.removeIf(condition);
    }

    public void printBooksSortedBy(Comparator<Book> comparator) {
        books.stream()
                .sorted(comparator)
                .forEach(System.out::println); // Method reference
    }

    public Optional<Book> findBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }

    public void printFirstBookMatchingCondition(Predicate<Book> condition) {
        Optional<Book> optionalBook = books.stream()
                .filter(condition)
                .findFirst();

        optionalBook.ifPresent(System.out::println); // Using ifPresent with method reference
    }

    public void printAllBooks() {
        books.forEach(System.out::println); // Using forEach with method reference
    }


    public static void main(String[] args) {
        BookManager manager = new BookManager();
        manager.addBook(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        manager.addBook(new Book("1984", "George Orwell", 1949));
        manager.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960));

        String titleToFind = "1984";
        Optional<Book> book = manager.findBookByTitle(titleToFind);
        book.ifPresent(b -> System.out.println(titleToFind + " found: " + b));
        book.orElseThrow(() -> new RuntimeException("Book not found: " + titleToFind));

        System.out.println("\nFirst book published after 1950:");
        manager.printFirstBookMatchingCondition(b -> b.getPublishedYear() > 1950);

        // Print all books using printAllBooks
        System.out.println("\nAll books:");
        manager.printAllBooks();

        System.out.println("Books sorted by title:");
        manager.printBooksSortedBy(Comparator.comparing(Book::getTitle)); // Method reference

        System.out.println("\nBooks sorted by published year:");
        manager.printBooksSortedBy(Comparator.comparingInt(Book::getPublishedYear)); // Method reference

        manager.removeBooks(b -> b.getPublishedYear() < 1950); // Lambda expression

        System.out.println("\nBooks after removal:");
        manager.printBooksSortedBy(Comparator.comparing(Book::getTitle));
    }
}
