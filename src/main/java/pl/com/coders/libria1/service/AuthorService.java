package pl.com.coders.libria1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.coders.libria1.controller.request.AuthorCreateRequest;
import pl.com.coders.libria1.controller.view.AuthorView;
import pl.com.coders.libria1.domain.Author;
import pl.com.coders.libria1.mapper.AuthorMapper;
import pl.com.coders.libria1.repository.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public AuthorView getByLastName(String lastName) {
        Author author = authorRepository.getByLastName(lastName)
                .orElseThrow(() -> new IllegalArgumentException("Author not exist " + lastName));
        return authorMapper.toAuthorView(author);
    }

    public AuthorView create(AuthorCreateRequest authorCreateRequest) {
        Author newAuthor = authorMapper.toAuthorEntity(authorCreateRequest);
        return authorMapper.toAuthorView(authorRepository.save(newAuthor));

    }

    public void delete(String lastName) {
        authorRepository.deleteByLastName(lastName);
    }

    public AuthorView update(AuthorView authorView) {
        Author existingAuthor = authorRepository.getByLastName(authorView.getLastName())
                .orElseThrow(() -> new IllegalArgumentException("Author not exist:" + authorView.getLastName()));
        existingAuthor.setLastName(authorView.getLastName());
        existingAuthor.setFirstName(authorView.getFirstName());
        return authorMapper.toAuthorView(authorRepository.save(existingAuthor));

    }
}
