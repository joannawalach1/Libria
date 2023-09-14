package pl.com.coders.libria1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.com.coders.libria1.domain.Lend;
import pl.com.coders.libria1.domain.User;

import java.util.List;

@Repository
public interface LendRepository extends CrudRepository<Lend, Long> {

    List<Lend> findByUser(User user);

}
