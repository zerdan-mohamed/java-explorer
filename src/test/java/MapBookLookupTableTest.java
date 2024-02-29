import org.codewithme.collections.MapBookLookupTable;
import org.codewithme.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapBookLookupTableTest {

    private MapBookLookupTable table;

    @BeforeEach
    void setUp() {
        table = new MapBookLookupTable();
    }

    @Test
    void addBookSuccessfully() {
        Book book = new Book(1, "Who Rules the World?", 50);
        table.addBook(book);
        assertThat(table.lookupById(1), is(equalTo(book)));
    }

    @Test
    void addBookThrowsExceptionOnDuplicateId() {
        Book book1 = new Book(1, "Understanding Power: The Indispensable Chomsky", 80);
        table.addBook(book1);
        Book book2 = new Book(1, "Chomsky On Anarchism", 40);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> table.addBook(book2));
        assertThat(exception.getMessage(), containsString("Unable to add book, duplicate id for:"));
    }

    @Test
    void lookupByIdReturnsCorrectBook() {
        Book book = new Book(2, "Hegemony or Survival: America's Quest for Global Dominance", 65);
        table.addBook(book);
        assertThat(table.lookupById(2), is(equalTo(book)));
    }

    @Test
    void lookupByIdReturnsNullForUnknownId() {
        assertThat(table.lookupById(999), is(nullValue()));
    }

    @Test
    void clearRemovesAllBooks() {
        table.addBook(new Book(1, "Who Rules the World?", 50));
        table.addBook(new Book(2, "Chomsky On Anarchism", 40));
        table.clear();
        assertThat(table.lookupById(1), is(nullValue()));
        assertThat(table.lookupById(2), is(nullValue()));
    }
}
