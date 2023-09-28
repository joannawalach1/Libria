package pl.com.coders.libria1.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.com.coders.libria1.controller.view.CategoryName;
import pl.com.coders.libria1.domain.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class LendRepositoryTest {

    @Autowired
    private LendRepository lendRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    private Category category;


//    @Test
//    void lend() {
//        Category category = categoryRepository.save(new Category(CategoryName.FANTASY.name()));
//        Book book = bookRepository.save(new Book("Harry Potter", category, "Rowling", 5));
//        User user = userRepository.save(new User("Piotr", "pass1", "user1@op.pl"));
//        User foundUser = userRepository.findByLogin(user.getLogin()).orElse(null);
//        assertNotNull(foundUser);
//        Book notFoundBook = bookRepository.findByTitle("Harry Potter1").orElse(null);
//
//        Lend lend = new Lend(foundUser, new ArrayList<>());
//        Lend savedLend = lendRepository.save(lend);
//        BookLend bookLend = new BookLend(savedLend, book, 1);
//        savedLend.addLend(bookLend);
//
//        Lend save = lendRepository.save(savedLend);
//
//        Iterable<Lend> allLends = lendRepository.findAll();
//        int lendCount = 0;
//        for (Lend lend1 : allLends) {
//            lendCount++;
//        }
//        assertEquals(1, lendCount);
//    }
}
