package pl.com.coders.libria1.controller.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.com.coders.libria1.controller.AuthorView;
import pl.com.coders.libria1.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{lastName}")
    public AuthorView getByLastName(@PathVariable String lastName) {
        return authorService.getByLastName(lastName);
    }

    @PostMapping
    public AuthorView create(@RequestBody AuthorCreateRequest authorCreateRequest) {
        return authorService.create(authorCreateRequest);
    }

    @DeleteMapping("/{lastName}")
    public void delete(@PathVariable String lastName) {
        authorService.delete(lastName);
    }

    @PutMapping
    public AuthorView update(@RequestBody AuthorView authorView) {
        return authorService.update(authorView);
    }
}