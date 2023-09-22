package pl.com.coders.libria1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.com.coders.libria1.controller.request.LendRequest;
import pl.com.coders.libria1.controller.request.ReturnRequest;
import pl.com.coders.libria1.domain.Lend;
import pl.com.coders.libria1.repository.AuthorRepository;
import pl.com.coders.libria1.repository.BookRepository;
import pl.com.coders.libria1.repository.CategoryRepository;
import pl.com.coders.libria1.repository.UserRepository;
import pl.com.coders.libria1.service.LendService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(LendController.class)
public class LendControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserRepository userRepository;
//
//    @MockBean
//    private LendService lendService;
//
//    @MockBean
//    private BookRepository bookRepository;
//
//    @MockBean
//    private AuthorRepository authorRepository;
//
//    @MockBean
//    private CategoryRepository categoryRepository;
//    private ObjectMapper objectMapper;
//
//    @BeforeEach
//    void setUp() {
//        objectMapper = new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());
//    }
//
//    @Test
//    void lendBook() throws Exception {
//        BookLendView bookLend = new BookLendView("Harry Potter", 10);
//        UserView user = new UserView("Maja", "majowa", "@maj", LocalDateTime.now(), LocalDateTime.now());
//        List<BookLendView> viewList = new ArrayList<>();
//        viewList.add(bookLend);
//        Lend lend = new Lend(user.getLogin(), viewList);
//        when(lendService.lendBook(new LendRequest())).thenReturn(lend);
//
//        String json = objectMapper.writeValueAsString(new LendRequest());
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/lend")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json)
//                )
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn();
//
//        json = result.getResponse().getContentAsString();
//        BookLendView lendFromRequest = objectMapper.readValue(json, BookLendView.class);
//        assertEquals(lend, lendFromRequest);
//
//    }
//
//    @Test
//    void returnBook() throws Exception {
//        BookLendView bookLend = new BookLendView("Harry Potter", 10);
//        UserView user = new UserView("Maja", "majowa", "@maj", LocalDateTime.now(), LocalDateTime.now());
//
//        BookLendView returnBook = new BookLendView("Harry Potter", 1);
//
//        List<BookLendView> viewList = new ArrayList<>();
//        viewList.add(bookLend);
//        Lend lend = new Lend(user.getLogin(), viewList.remove(returnBook));
//        when(lendService.returnBook(new ReturnRequest())).thenReturn(lend);
//
//        String json = objectMapper.writeValueAsString(new ReturnRequest());
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/lend/return")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json)
//                )
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn();
//
//        json = result.getResponse().getContentAsString();
//        BookLendView returnFromRequest = objectMapper.readValue(json, BookLendView.class);
//        assertEquals(lend, returnFromRequest);
//    }

}