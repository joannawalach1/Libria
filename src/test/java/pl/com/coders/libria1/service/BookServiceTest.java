package pl.com.coders.libria1.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.com.coders.libria1.controller.BookCreateRequest;
import pl.com.coders.libria1.controller.BookView;
import pl.com.coders.libria1.domain.Book;
import pl.com.coders.libria1.mapper.BookMapper;
import pl.com.coders.libria1.repository.BookRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookMapper bookMapper;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void get() {
        Long id = 1L ;
        BookView bookView = new BookView(12L, "Ameryka", "Pascal", 5);
        Book book = new Book(12L, "Afryka","Pascal", 5 );
        when(bookRepository.findById(12L)).thenReturn(Optional.of(book));
        when(bookMapper.toView(book)).thenReturn(new BookView(12L,"Afryka,", "Pascal",5));
        BookView retrievedBook = bookService.get(12L);
        assertNotNull(bookView);
    }

    @Test
    void create() {
        BookCreateRequest bookCreateRequest = new BookCreateRequest(13L,"Ameryka", "Pascal", 5);
        Book book = new Book(13L,"Ameryka", "Pascal", 5);
        when(bookMapper.toEntity(bookCreateRequest)).thenReturn(book);
        when(bookRepository.save(any())).thenReturn(book);
        when(bookMapper.toView(any())).thenReturn(new BookView(13L,"Ameryka", "Pascal", 5));
        BookView bookView = bookService.create(bookCreateRequest);
        assertThat(bookView).isNotNull();
        assertEquals(bookView, bookService.create(bookCreateRequest));
    }

    @Test
    void delete() {
        Book book = new Book(13L,"Ameryka", "Pascal", 5);
        when(bookRepository.delete()).thenReturn(true);
        boolean isDeleted = bookService.deleteById(13L);
        assertTrue(isDeleted);
    }

    @Test
    void update() {
        BookCreateRequest bookCreateRequest = new BookCreateRequest(13L,"AFryka", "Pascal", 5);
        Book book = new Book(13L,"Ameryka", "Pascal", 5);
        when(bookMapper.toEntity(bookCreateRequest)).thenReturn(book);
        when(bookRepository.save(book)).thenReturn(book);
        when(bookMapper.toView(book)).thenReturn(new BookView());
        //BookCreateRequest updatedBook = bookService.update(book.getId());
      //  assertNotNull(updatedBook);

    }
}