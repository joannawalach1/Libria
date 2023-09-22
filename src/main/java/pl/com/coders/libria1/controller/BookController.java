package pl.com.coders.libria1.controller;

import org.springframework.web.bind.annotation.*;
import pl.com.coders.libria1.controller.view.BookCreateRequest;
import pl.com.coders.libria1.controller.view.BookView;
import pl.com.coders.libria1.service.BookService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //FIXME Paulina zaimplementuj price i descripttion w book z obsluga
    @GetMapping("/byCategory/{categoryName}")
    public List<BookView> getBooks(@PathVariable String categoryName) {
        List<BookView> byCategory = bookService.getByCategory(categoryName);
        byCategory.forEach(cat -> {
            cat.setDescription("Tu będznie niesamowity opis naszej książki, który do kliknięcia dalej");
            cat.setPrice(BigDecimal.ONE);
        });
        return byCategory;
    }

    @GetMapping("/{title}")
    //FIXME PAaulina usunac po implementacjia price i description
    public BookView get(@PathVariable String title) {
        BookView bookView = bookService.getByTitle(title);
        bookView.setDescription("Tu będznie niesamowity opis naszej książki, który do kliknięcia dalej");
        bookView.setPrice(BigDecimal.ONE);

        return bookView;
    }

    @PostMapping
    public BookView create(@RequestBody BookCreateRequest bookCreateRequest) {
        return bookService.create(bookCreateRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @PutMapping("/{id}")
    public BookView update(@PathVariable Long id, @RequestBody BookCreateRequest bookUpdateRequest) {
        return bookService.update(id, bookUpdateRequest);
    }
}

