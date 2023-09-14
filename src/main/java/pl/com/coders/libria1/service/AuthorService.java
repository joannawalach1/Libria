package pl.com.coders.libria1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.coders.libria1.controller.AuthorView;
import pl.com.coders.libria1.controller.request.AuthorCreateRequest;
import pl.com.coders.libria1.domain.Author;
import pl.com.coders.libria1.mapper.AuthorMapper;
import pl.com.coders.libria1.repository.AuthorRepository;

import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public AuthorView getbyLastName(String lastName) {
        Optional<Author> authorOptional = Optional.ofNullable(authorRepository.getbyLastName(lastName));
        if(authorOptional.isPresent()){
            Author author =authorOptional.get();
            return authorMapper.toAuthorView(author);
        }else {
            return null;
        }
    }

    public AuthorView create(AuthorCreateRequest authorCreateRequest) {
        Author newAuthor = authorMapper.toAuthorEntity(authorCreateRequest);
        return authorMapper.toAuthorView(authorRepository.save(newAuthor));

    }

    public void delete(String lastName) {authorRepository.delete(lastName);

    }

    public AuthorView update(AuthorView authorView) {
        Author existingAuthor = authorRepository.getbyLastName(authorView.getLastName().describeConstable().orElseThrow());
        existingAuthor.setLastName(authorView.getLastName());
        existingAuthor.setFirstName(authorView.getFirstName());
        return authorMapper.toAuthorView(authorRepository.save(existingAuthor));

    }
}
