package pl.com.coders.libria1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.coders.libria1.controller.BookCreateRequest;
import pl.com.coders.libria1.controller.BookView;
import pl.com.coders.libria1.domain.Book;
import pl.com.coders.libria1.mapper.BookMapper;
import pl.com.coders.libria1.repository.BookRepository;

import java.util.Optional;

@Service
//TODO add mockito TEST
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public BookView get(Long id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        Book book = bookOpt.orElseThrow(() -> new IllegalArgumentException("Book not exist with id : " + id));

        return bookMapper.toView(book);
    }

    public BookView create(BookCreateRequest bookCreateRequest) {
        Book book = bookMapper.toEntity(bookCreateRequest);

        return bookMapper.toView(bookRepository.save(book));
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public BookView update(Long id, BookCreateRequest bookUpdateRequest) {
        Optional<Book> oldBookOptional = bookRepository.findById(id);

        if (oldBookOptional.isPresent()) {
            Book outdatedBook = oldBookOptional.get();
            outdatedBook.setTitle(bookUpdateRequest.getTitle());
            outdatedBook.setAuthor(bookUpdateRequest.getAuthor());
            outdatedBook.setAmount(bookUpdateRequest.getAmount());
            Book updatedBook = bookRepository.save(outdatedBook);
            return bookMapper.toView(updatedBook);
        } else {
            throw new IllegalArgumentException("Book not exist with id" + id);
        }
    }

    public boolean deleteById(long l) {
        return true;
    }
}

