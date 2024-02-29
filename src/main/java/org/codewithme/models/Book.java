package org.codewithme.models;

import java.util.Comparator;
import java.util.Objects;

import static java.util.Comparator.comparing;

public record Book(int id, String name, int price) {
    public static final Comparator<Book> BY_NAME = comparing(Book::name);
    public static final Comparator<Book> BY_PRICE = comparing(Book::price);

    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public boolean equals(final Object o) {
        if (!(o instanceof Book book)) return false;

        return Objects.equals(id, book.id)
                && Objects.equals(price, book.price)
                && Objects.equals(name, book.name);
    }

}
