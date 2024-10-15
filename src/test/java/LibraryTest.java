import org.example.Book;
import org.example.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("1984", "George Orwell");
        book2 = new Book("Brave New World", "Aldous Huxley");
    }

    @Test
    public void testAddBook() {
        library.addBook(book1);
        assertEquals(1, library.getBookCount());
        assertTrue(library.getBooks().contains(book1));
    }

    @Test
    public void testAddNullBook() {
        assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(null);
        });
    }

    @Test
    public void testRemoveBook() {
        library.addBook(book1);
        library.addBook(book2);
        boolean result = library.removeBook(book1);
        assertTrue(result);
        assertEquals(1, library.getBookCount());
        assertFalse(library.getBooks().contains(book1));
    }

    @Test
    public void testRemoveNonExistentBook() {
        boolean result = library.removeBook(book1);
        assertFalse(result);
    }

    @Test
    public void testRemoveNullBook() {
        assertThrows(IllegalArgumentException.class, () -> {
            library.removeBook(null);
        });
    }

    @Test
    public void testGetBooks() {
        library.addBook(book1);
        library.addBook(book2);
        List<Book> books = library.getBooks();
        assertEquals(2, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
    }

    @Test
    public void testGetBookCount() {
        assertEquals(0, library.getBookCount());
        library.addBook(book1);
        assertEquals(1, library.getBookCount());
        library.addBook(book2);
        assertEquals(2, library.getBookCount());
    }
}
