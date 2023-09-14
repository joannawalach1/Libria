package pl.com.coders.libria1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.com.coders.libria1.domain.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author getByLastName(String lastName);

    void deleteByLastName(String lastName);

}
