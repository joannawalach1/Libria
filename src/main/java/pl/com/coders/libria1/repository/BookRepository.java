package pl.com.coders.libria1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.com.coders.libria1.domain.Book;
import pl.com.coders.libria1.domain.Category;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository  extends CrudRepository<Book, Long> {
    Optional<Book> findByAuthor(String author);
    Optional<Book> findByTitle(String title);
    List<Book> findByCategory(Category category);

    void deleteByTitle(String title);
}


