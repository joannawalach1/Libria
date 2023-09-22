package pl.com.coders.libria1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.coders.libria1.controller.view.BookCreateRequest;
import pl.com.coders.libria1.controller.view.BookView;
import pl.com.coders.libria1.domain.Book;
import pl.com.coders.libria1.domain.Category;
import pl.com.coders.libria1.exception.BookNotExistException;
import pl.com.coders.libria1.mapper.BookMapper;
import pl.com.coders.libria1.mapper.CategoryMapper;
import pl.com.coders.libria1.repository.AuthorRepository;
import pl.com.coders.libria1.repository.BookRepository;
import pl.com.coders.libria1.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public List<BookView> getByCategory(String category) {
        return bookRepository.findByCategory(categoryRepository.findByName(category).get()).stream()
                .map(book -> bookMapper.toView(book))
                .collect(Collectors.toList());
    }

    public BookView getByTitle(String title) {
        Optional<Book> bookOpt = bookRepository.findByTitle(title);
        Book book = bookOpt.orElseThrow(() -> new BookNotExistException(title));

        return bookMapper.toView(book);
    }

    public BookView create(BookCreateRequest bookCreateRequest) {
        Book book = bookMapper.toEntity(bookCreateRequest);
        Category category = categoryRepository.findByName(book.getCategory().getName()).get();
        book.setCategory(category);
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

}

