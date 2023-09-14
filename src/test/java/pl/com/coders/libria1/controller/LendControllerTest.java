package pl.com.coders.libria1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.com.coders.libria1.controller.request.LendRequest;
import pl.com.coders.libria1.domain.Lend;
import pl.com.coders.libria1.domain.User;
import pl.com.coders.libria1.repository.UserRepository;
import pl.com.coders.libria1.service.LendService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.aspectj.bridge.MessageUtil.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
class LendControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @MockBean
//    private LendService lendService;
//
//    private ObjectMapper objectMapper;
//
//    @BeforeEach
//    void setUp() {
//        objectMapper = new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());
//    }
//
//    @Test
//    void borrowBookTest() throws Exception {
//        try {
//            User user = userRepository.save(new User("Piotr", "pass1", "user1@op.pl"));
//            assertNotNull(user);
//
//            String bookTitle = "Test Book";
//            int amount = 1;
//
//            List<BookLendView> viewList = new ArrayList<>();
//            viewList.add(new BookLendView(bookTitle, 1));
//            LendRequest lendRequest = new LendRequest(user.getLogin(), viewList);
//
//            Lend lendBook = new Lend();
//
//            Mockito.when(lendService.lendBook(
//                    Mockito.any(User.class)
//            )).thenReturn(lendBook);
//
//            String json = objectMapper.writeValueAsString(lendRequest);
//
//            mockMvc.perform(MockMvcRequestBuilders.post("/lend/borrowBook")
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(json)
//                    )
//                    .andDo(print())
//                    .andExpect(status().isOk())
//                    .andReturn();
//        } catch (Exception e) {
//            e.printStackTrace();
//            fail("Exception occurred: " + e.getMessage());
//        }
//    }
//
//
//    @Test
//    void returnBookTest() throws Exception {
//        User user = userRepository.save(new User("Piotr", "pass1", "user1@op.pl"));
//
//        String bookTitle = "Test Book";
//        int amount = 1;
//        LocalDateTime borrowDate = LocalDateTime.now();
//        LocalDateTime returnDate = LocalDateTime.now();
//
//        List<BookLendView> viewList = new ArrayList<>();
//        viewList.add(new BookLendView(bookTitle, 1));
//        LendRequest lendRequest = new LendRequest(user, viewList);
//
//
//        Lend lendBook = new Lend();
//
//        Mockito.when(lendService.returnBook(
//                Mockito.any(User.class),
//                Mockito.eq(bookTitle),
//                Mockito.eq(amount),
//                Mockito.any(LocalDateTime.class),
//                Mockito.any(LocalDateTime.class)
//        )).thenReturn(lendBook);
//
//        String json = objectMapper.writeValueAsString(lendRequest);
//
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/lend/returnBook")
//                        .param("user", String.valueOf(user))
//                        .param("bookTitle", bookTitle)
//                        .param("amount", String.valueOf(amount))
//                        .param("borrowDate", borrowDate.toString())
//                        .param("returnDate", returnDate.toString())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json)
//                )
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn();
//
//        int status = result.getResponse().getStatus();
//        assertEquals(200, status);
//    }
}



