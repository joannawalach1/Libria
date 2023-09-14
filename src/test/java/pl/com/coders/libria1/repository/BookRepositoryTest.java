package pl.com.coders.libria1.repository;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.com.coders.libria1.controller.CategoryName;
import pl.com.coders.libria1.domain.Book;
import pl.com.coders.libria1.domain.Category;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
//TODO FIX ME
@Disabled
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private Category category;

    @BeforeEach
    void setUp() {
        Category save = categoryRepository.save(new Category(CategoryName.DOCUMENT.name()));
        category = categoryRepository.findByName(CategoryName.DOCUMENT.name()).get();
        bookRepository.save(new Book("Wiedzmin 1", category, "Sapkowwski", 10));
        bookRepository.save(new Book("Otchłań", category, "Scales", 15));
        bookRepository.save(new Book("Harry Potter", category, "Rowling", 5));
    }

    @Test
    void save() {
        Book book = bookRepository.save(new Book("Tkając Świt", category, "Kim", 10));
        assertEquals(4, bookRepository.count());
        assertEquals("Tkając Świt", book.getTitle());
        assertEquals("Kim", book.getAuthor());
        assertEquals(10, book.getAmount());

    }

    @Test
    void saveALl() {
        bookRepository.saveAll(List.of(
                new Book("Citadela", category, "Mosse", 3),
                new Book("Shantaram", category, "Roberts", 5)));
        assertEquals(5, bookRepository.count());
    }

    @Test
    void findByID() {
        Book book = bookRepository.findByTitle("Wiedzmin 1").get();
        Optional<Book> book1 = bookRepository.findById(book.getId());
        assertTrue(book1.isPresent());
    }

    @Test
    void existById() {
        Optional<Book> byTitle = bookRepository.findByTitle("Wiedzmin 1");
        boolean book2 = bookRepository.existsById(33L);
        assertTrue(byTitle.isPresent());
        assertFalse(book2);
    }

    @Test
    void findAll() {

        List<Book> books = Lists.newArrayList(bookRepository.findAll());
        assertEquals(3, books.size());
    }

    @Test
    void count() {
        bookRepository.save(new Book("Niebieski", category, "Gorge", 10));
        assertEquals(4, bookRepository.count());
    }

    @Test
    void deleteByID() {
        Book book = bookRepository.findByTitle("Wiedzmin 1").get();
        bookRepository.deleteById(book.getId());
        assertEquals(2, bookRepository.count());
    }

    @Test
    void deleteAll() {
        Book book = bookRepository.save(new Book("Kwiaty Zielone", category, "Daniel", 10));
        bookRepository.deleteAll();
        assertEquals(0, bookRepository.count());
    }

    @Test
    void update() {
        Book book = bookRepository.save(new Book("Cud", category, "Nathan", 10));
        book.setTitle("Uważność");
        book.setAuthor("Norbert");
        book.setAmount(20);
        Book updatedBook = bookRepository.save(book);
        assertEquals("Uważność", updatedBook.getTitle());
        assertEquals("Norbert", updatedBook.getAuthor());
        assertEquals(20, updatedBook.getAmount());
    }

    @Test
    void findByAuthor() {
        Book bookFindByAuthor = bookRepository.save(new Book("Ekspert", category, "Bell", 10));
        Optional<Book> foundBook = bookRepository.findByAuthor(bookFindByAuthor.getAuthor());
        assertTrue(foundBook.isPresent());
        assertEquals("Bell", bookFindByAuthor.getAuthor());
    }

    @Test
    void findByTitle() {
        Book bookFindByTitle = bookRepository.save(new Book("Biegnąca z Wilkami", category, "Estes", 10));
        Optional<Book> foundTitle = bookRepository.findByTitle(bookFindByTitle.getTitle());
        assertTrue(foundTitle.isPresent());
        assertEquals("Biegnąca z Wilkami", bookFindByTitle.getTitle());
    }
}





