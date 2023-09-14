package pl.com.coders.libria1.controller;

import org.springframework.web.bind.annotation.*;
import pl.com.coders.libria1.controller.view.BookCreateRequest;
import pl.com.coders.libria1.controller.view.BookView;
import pl.com.coders.libria1.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public BookView get(@PathVariable Long id) {
        return bookService.get(id);
    }

    @PostMapping
    public BookView create(@RequestBody BookCreateRequest bookCreateRequest) {
        return bookService.create(bookCreateRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){ bookService.delete(id); }

    @PutMapping("/{id}")
    public BookView update(@PathVariable Long id, @RequestBody BookCreateRequest bookUpdateRequest){
        return bookService.update(id, bookUpdateRequest);
    }
}

