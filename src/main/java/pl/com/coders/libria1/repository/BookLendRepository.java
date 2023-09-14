package pl.com.coders.libria1.repository;

import org.springframework.data.repository.CrudRepository;
import pl.com.coders.libria1.domain.BookLend;

public interface BookLendRepository extends CrudRepository <BookLend, Long> {
}
