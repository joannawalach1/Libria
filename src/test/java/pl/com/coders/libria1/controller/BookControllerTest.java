package pl.com.coders.libria1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
import pl.com.coders.libria1.controller.view.AuthorView;
import pl.com.coders.libria1.controller.view.BookCreateRequest;
import pl.com.coders.libria1.controller.view.BookView;
import pl.com.coders.libria1.repository.BookRepository;
import pl.com.coders.libria1.service.BookService;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    private MockMvc mockMVc;

    @MockBean
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    void get() throws Exception {
        AuthorView author =new AuthorView(1L, "Henryk", "Sienkiewicz", LocalDateTime.now(),LocalDateTime.now());
        BookView book = new BookView(1L, "W pustyni i w puszczy", author.getLastName(), 10);
        when(bookService.get(1L)).thenReturn(book);
        MvcResult result = mockMVc.perform(MockMvcRequestBuilders.get("/book/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String json = result.getResponse().getContentAsString();
        BookView bookFromRequest = objectMapper.readValue(json, BookView.class);
        assertEquals(book, bookFromRequest);
    }

    @Test
    void create() throws Exception {
        AuthorView author =new AuthorView(1L, "Henryk", "Sienkiewicz", LocalDateTime.now(),LocalDateTime.now());
        BookView book = new BookView(1L, "W pustyni i w puszczy",author.getLastName(), 10);
        when(bookService.create(new BookCreateRequest())).thenReturn(book);

        String json = objectMapper.writeValueAsString(new BookCreateRequest());
        MvcResult result = mockMVc.perform(MockMvcRequestBuilders.post("/book")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        json = result.getResponse().getContentAsString();
        BookView bookFromRequest = objectMapper.readValue(json, BookView.class);
        assertEquals(book, bookFromRequest);
    }

    @Test
    void delete() throws Exception {
        mockMVc.perform(MockMvcRequestBuilders.delete("/book/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void update() throws Exception {
        AuthorView author =new AuthorView(1L, "Henryk", "Sienkiewicz", LocalDateTime.now(),LocalDateTime.now());
        BookView book = new BookView(1L, "W pustyni i w puszczy",author.getLastName(), 10);
        when(bookService.update(1L,new BookCreateRequest())).thenReturn(book);
        String json = objectMapper.writeValueAsString(new BookCreateRequest());
        MvcResult result = mockMVc.perform(MockMvcRequestBuilders.put("/book/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        json = result.getResponse().getContentAsString();
        BookView bookFromRequest = objectMapper.readValue(json, BookView.class);
        assertEquals(book, bookFromRequest);
    }
}