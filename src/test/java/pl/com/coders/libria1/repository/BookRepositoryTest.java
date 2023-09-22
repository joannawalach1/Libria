package pl.com.coders.libria1.repository;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.com.coders.libria1.controller.view.AuthorView;
import pl.com.coders.libria1.controller.view.CategoryName;
import pl.com.coders.libria1.domain.Author;
import pl.com.coders.libria1.domain.Book;
import pl.com.coders.libria1.domain.Category;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    private Category category;

    @Autowired
    private AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
        category = categoryRepository.save(new Category(CategoryName.DOCUMENT.name()));
        Author author = authorRepository.save(new Author("A", "Sapkowski"));
        Author author1 = authorRepository.save(new Author("A", "Scales"));
        Author author2 = authorRepository.save(new Author("JK", "Rowling"));
        Author author3 = authorRepository.save(new Author("BELL", "Bell"));

        bookRepository.save(new Book("Wiedzmin 1", category, String.valueOf(author), 10));
        bookRepository.save(new Book("Otchłań", category, String.valueOf(author1), 15));
        bookRepository.save(new Book("Harry Potter", category, String.valueOf(author2), 5));
    }

    @AfterEach
    void tearDown() {
        bookRepository.deleteAll();
        categoryRepository.deleteAll();
        authorRepository.deleteAll();
    }

    @Test
    void save() {
        Book book = bookRepository.save(new Book("Tkając Świt", category, String.valueOf(new Author(2L)), 10));
        assertEquals(4, bookRepository.count());
        assertEquals("Tkając Świt", book.getTitle());
        assertEquals(10, book.getAmount());
    }

    @Test
    void saveAll() {
        bookRepository.saveAll(List.of(
                new Book("Citadela", category, String.valueOf(new Author(1L)), 3),
                new Book("Shantaram", category, String.valueOf(new Author(3L)), 5)));
        assertEquals(5, bookRepository.count());
    }

    @Test
    void existById() {
        boolean exist1 = bookRepository.existsById(1L);
        boolean exist2 = bookRepository.existsById(33L);
        assertTrue(exist1);
        assertFalse(exist2);
    }

    @Test
    void findAll() {
        List<Book> books = Lists.newArrayList(bookRepository.findAll());
        assertEquals(3, books.size());
    }

    @Test
    void count() {
        assertEquals(3, bookRepository.count());
    }

    @Test
    void deleteAll() {
        bookRepository.deleteAll();
        assertEquals(0, bookRepository.count());
    }

    @Test
    void deleteByTitle() {
        bookRepository.deleteByTitle("Otchłań");
        assertEquals(2, bookRepository.count());
    }

    @Test
    void update() {
        Book book = bookRepository.findByTitle("Otchłań").orElseThrow();
        book.setTitle("Wiedźmin I");
        book.setAmount(20);
        Book updateBook = bookRepository.save(book);
        assertEquals("Wiedźmin I", updateBook.getTitle());
        assertEquals(20, updateBook.getAmount());
    }

    @Test
    void findByAuthor() {
        AuthorView author = new AuthorView(1L, "M", "Bell", LocalDateTime.now(), LocalDateTime.now());
        Book bookFindByAuthor = bookRepository.save(new Book("Ekspert", category, author.getLastName(), 10));
        Author author1 = authorRepository.getByLastName(author.getLastName()).orElseThrow(() -> new IllegalArgumentException("Author not exist " + author.getLastName()));
        assertNotNull(author1);
        assertEquals("Bell", bookFindByAuthor.getAuthor());
    }

    @Test
    void findByTitle() {
        AuthorView author = new AuthorView(1L, "K", "EStes", LocalDateTime.now(), LocalDateTime.now());
        Book bookFindByTitle = bookRepository.save(new Book("Biegnąca z Wilkami", category, String.valueOf(author), 10));
        Optional<Book> foundTitle = bookRepository.findByTitle(bookFindByTitle.getTitle());
        assertTrue(foundTitle.isPresent());
        assertEquals("Biegnąca z Wilkami", bookFindByTitle.getTitle());
    }

}





