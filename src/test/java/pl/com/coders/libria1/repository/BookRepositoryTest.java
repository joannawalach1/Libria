package pl.com.coders.libria1.repository;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.com.coders.libria1.domain.Book;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;


    @BeforeEach
    void setUp() {
        bookRepository.save(new Book(1L,"Wiedzmin 1", "Sapkowwski", 10));
        bookRepository.save(new Book(2L,"Otchłań", "Scales", 15));
        bookRepository.save(new Book(3L,"Harry Potter", "Rowling", 5));
    }

    @Test
    void save() {
        Book book = bookRepository.save(new Book(4L,"Tkając Świt", "Kim", 10));
        assertEquals(4, bookRepository.count());
        assertEquals("Tkając Świt", book.getTitle());
        assertEquals("Kim", book.getAuthor());
        assertEquals(10, book.getAmount());

    }

    @Test
    void saveALl() {
        bookRepository.saveAll(List.of(
                new Book(5L,"Citadela", "Mosse", 3),
                new Book(6L,"Shantaram", "Roberts", 5)));
        assertEquals(5, bookRepository.count());
    }

    @Test
    void findByID() {
        Optional<Book> book1 = bookRepository.findById(2L);
        Optional<Book> book2 = bookRepository.findById(33L);
        assertTrue(book1.isPresent());
        assertFalse(book2.isPresent());
    }

    @Test
    void existById() {
        boolean book1 = bookRepository.existsById(2L);
        boolean book2 = bookRepository.existsById(33L);
        assertTrue(book1);
        assertFalse(book2);
    }

    @Test
    void findAll() {

        List<Book> books = Lists.newArrayList(bookRepository.findAll());
        assertEquals(3, books.size());
    }

    @Test
    void findAllById() {
        List<Book> books = Lists.newArrayList(bookRepository.findAllById(List.of(2L, 35L)));
        assertEquals(1, books.size());
    }

    @Test
    void count() {
        bookRepository.save(new Book(7L,"Niebieski", "Gorge", 10));
        assertEquals(4, bookRepository.count());
    }

    @Test
    void deleteByID() {
        bookRepository.deleteById(2L);
        assertEquals(2, bookRepository.count());
    }

    @Test
    void deleteAll() {
        Book book = bookRepository.save(new Book(8L,"Kwiaty Zielone", "Daniel", 10));
        bookRepository.deleteAll();
        assertEquals(0, bookRepository.count());
    }

    @Test
    void update() {
        Book book = bookRepository.save(new Book(9L,"Cud", "Nathan", 10));
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
        Book bookFindByAuthor = bookRepository.save(new Book(10L,"Ekspert", "Bell", 10));
        Optional<Book> foundBook = bookRepository.findByAuthor(bookFindByAuthor.getAuthor());
        assertTrue(foundBook.isPresent());
        assertEquals("Bell", bookFindByAuthor.getAuthor());

    }

    @Test
    void findByTitle(){
        Book bookFindByTitle = bookRepository.save(new Book(11L,"Biegnąca z Wilkami", "Estes", 10));
        Optional<Book >foundTitle = bookRepository.findByTitle(bookFindByTitle.getTitle());
        assertTrue(foundTitle.isPresent());
        assertEquals("Biegnąca z Wilkami", bookFindByTitle.getTitle());
    }

}





