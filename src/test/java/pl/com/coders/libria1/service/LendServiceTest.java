package pl.com.coders.libria1.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.com.coders.libria1.controller.request.ReturnRequest;
import pl.com.coders.libria1.controller.view.CategoryName;
import pl.com.coders.libria1.domain.*;
import pl.com.coders.libria1.repository.BookLendRepository;
import pl.com.coders.libria1.repository.BookRepository;
import pl.com.coders.libria1.repository.LendRepository;
import pl.com.coders.libria1.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class LendServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private LendRepository lendRepository;

    @Mock
    private BookLendRepository bookLendRepository;

    @InjectMocks
    private LendService lendService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void lendBook() {
//        User user = userRepository.save(new User("Piotr", "pass1", "user1@op.pl"));
//
//        String bookTitle = "Test Book";
//        int amount = 1;
//        LocalDateTime borrowDate = LocalDateTime.now();
//        LocalDateTime returnDate = LocalDateTime.now();
//        String categoryName = CategoryName.FANTASY.name();
//
//        Book mockBook = new Book(bookTitle, categoryName, "Rowling", 5);
//        when(bookRepository.findByTitle(bookTitle)).thenReturn(Optional.of(mockBook));
//
//        Lend mockLend = new Lend(user, new ArrayList<>());
////        when(lendRepository.findByUser(user)).thenReturn(mockLend);
////
////        Lend result = lendService.lendBook(user);
//
//        assertNotNull(result);
//        assertEquals(user, result.getUser());
//    }

    @Test
    void returnBook() {
        User user = userRepository.save(new User("Piotr", "pass1", "user1@op.pl"));
        String bookTitle = "Test Book";
        int amount = 1;
        LocalDateTime borrowDate = LocalDateTime.now();
        LocalDateTime returnDate = LocalDateTime.now();

        Book mockBook = new Book(bookTitle, "FANTASY", "Rowling", 5);
        when(bookRepository.findByTitle(bookTitle)).thenReturn(Optional.of(mockBook));

        Lend mockLend = new Lend(user, new ArrayList<>());
//        when(lendRepository.findByUser(user)).thenReturn(mockLend);

        List<BookLend> bookLends = new ArrayList<>();
        BookLend mockBookLend = new BookLend();
        mockBookLend.setBook(mockBook);
        mockBookLend.setAmount(2);
        mockBookLend.setBorrowDate(borrowDate);
        bookLends.add(mockBookLend);
        mockLend.setBookLends(bookLends);

        when(bookLendRepository.save(any())).thenReturn(mockBookLend);
        ReturnRequest returnRequest = new ReturnRequest();
        lendService.returnBook(returnRequest);
        assertEquals(1, mockLend.getBookLends().size());
        assertEquals(2, mockBookLend.getAmount());
    }
}