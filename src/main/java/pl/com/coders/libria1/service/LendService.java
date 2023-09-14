package pl.com.coders.libria1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.coders.libria1.controller.BookLendView;
import pl.com.coders.libria1.controller.request.LendRequest;
import pl.com.coders.libria1.controller.request.ReturnRequest;
import pl.com.coders.libria1.domain.*;
import pl.com.coders.libria1.repository.BookLendRepository;
import pl.com.coders.libria1.repository.BookRepository;
import pl.com.coders.libria1.repository.LendRepository;
import pl.com.coders.libria1.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LendService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LendRepository lendRepository;

    @Autowired
    private BookLendRepository bookLendRepository;

    @Autowired
    private UserRepository userRepository;

    //TODO updateowac stany magazynowe ksiazki
    public Lend lendBook(LendRequest request) {

        for (BookLendView bookLendView : request.getBookLendViews()) {
            String bookTitle = bookLendView.getBookTitle();
            checkBook(bookTitle);
        }

        User user = userRepository.findByLogin(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Login does not exist:" + request.getUsername()));

        Lend lend = new Lend();
        lend.setLendDate(LocalDateTime.now());
        lend.setUser(user);

        Lend lendSaved = lendRepository.save(lend);

        List<BookLend> bookLends = request.getBookLendViews().stream().map(bookLendView -> {
            Book book = bookRepository.findByTitle(bookLendView.getBookTitle()).get();
            return new BookLend(lendSaved, book, bookLendView.getAmount());
        }).collect(Collectors.toList());

        lendSaved.setBookLends(bookLends);
        return lendRepository.save(lend);
    }

    //TODO updateowac stany magazynowe ksiazki
    //TODO naliczyć prowizję za wypożyczenie do usera
    public Lend returnBook(ReturnRequest returnRequest) {

        Lend lend = lendRepository.findById(returnRequest.getLendId())
                .orElseThrow(() -> new IllegalArgumentException("lend exist with id" + returnRequest.getLendId()));

        lend.setReturnDate(LocalDateTime.now());
        lend.setStatus(LendStatus.RETURNED);

        lendRepository.save(lend);

        return lend;
    }

    private Optional<Book> checkBook(String bookTitle) {
        Optional<Book> availableBook = bookRepository.findByTitle(bookTitle);

        if (!availableBook.isPresent()) {
            throw new IllegalArgumentException("Book " + bookTitle + " not found");
        }

        Book book = availableBook.get();
        int amount = book.getAmount();
        if (amount < 1) {
            throw new IllegalArgumentException("Book is not available");
        }

        return availableBook;
    }
}


