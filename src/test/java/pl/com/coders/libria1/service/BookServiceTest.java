package pl.com.coders.libria1.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.com.coders.libria1.controller.view.BookCreateRequest;
import pl.com.coders.libria1.controller.view.BookView;
import pl.com.coders.libria1.controller.view.CategoryName;
import pl.com.coders.libria1.domain.Book;
import pl.com.coders.libria1.domain.Category;
import pl.com.coders.libria1.mapper.BookMapper;
import pl.com.coders.libria1.repository.BookRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookMapper bookMapper;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void get() {
        Long id = 1L;
        when(bookRepository.findById(any())).thenReturn(Optional.of(new Book()));
        when(bookMapper.toView(any())).thenReturn(new BookView(12L, "Afryka,", "Pascal", 5));
        BookView bookView = bookService.get(12L);
        assertNotNull(bookView);
    }

    @Test
    void create() {
        BookCreateRequest bookCreateRequest = new BookCreateRequest(13L, "Ameryka", "Pascal", 5);
        Book book = new Book("Ameryka", new Category(CategoryName.DOCUMENT.name()), "Pascal", 5);
        when(bookMapper.toEntity(bookCreateRequest)).thenReturn(book);
        when(bookRepository.save(any())).thenReturn(book);
        when(bookMapper.toView(any())).thenReturn(new BookView(13L, "Ameryka", "Pascal", 5));

        BookView bookView = bookService.create(bookCreateRequest);
        assertThat(bookView).isNotNull();
        verify(bookRepository, times(1)).save(any());
        verify(bookMapper, times(1)).toView(any());
        verify(bookMapper, times(1)).toEntity(any(BookCreateRequest.class));
    }

    @Test
    void delete() {
        bookService.delete(13L);
        verify(bookRepository).deleteById(any());
    }

    @Test
    void update() {
        BookCreateRequest bookCreateRequest = new BookCreateRequest(13L, "AFryka", "Pascal", 5);
        Book book = new Book("Ameryka", new Category(CategoryName.HORROR.name()), "Pascal", 5);
        when(bookMapper.toEntity(bookCreateRequest)).thenReturn(book);
        when(bookRepository.save(book)).thenReturn(book);
        when(bookMapper.toView(book)).thenReturn(new BookView());
    }
}