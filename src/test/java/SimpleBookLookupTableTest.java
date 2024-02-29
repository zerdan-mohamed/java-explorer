import org.codewithme.collections.SimpleBookLookupTable;
import org.codewithme.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleBookLookupTableTest {
    private SimpleBookLookupTable table;

    @BeforeEach
    void setUp() {
        table = new SimpleBookLookupTable();
    }

    @Test
    void addBookAndLookupById() {
        Book book = new Book(1, "Test Driven Development", 2500);
        table.addBook(book);
        assertThat(table.lookupById(1), is(equalTo(book)));
    }

    @Test
    void lookupByIdNotFound() {
        assertThat(table.lookupById(999), is(nullValue()));
    }

    @Test
    void clearBooks() {
        table.addBook(new Book(1, "Refactoring", 3200));
        table.clear();
        assertThat(table.lookupById(1), is(nullValue()));
    }

    @Test
    void addBookWithDuplicateIdThrowsException() {
        table.addBook(new Book(1, "First Book", 1000));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> table.addBook(new Book(1, "Duplicate Id Book", 2000)));
        assertThat(exception.getMessage(), containsString("Unable to add book, duplicate id for"));
    }
}
