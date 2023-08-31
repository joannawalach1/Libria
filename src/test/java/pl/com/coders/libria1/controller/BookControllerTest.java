package pl.com.coders.libria1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.com.coders.libria1.service.BookService;

import static org.junit.jupiter.api.Assertions.*;
import static  org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookController.class)
class BookControllerTest{
    @Autowired
    private MockMvc mockMVc;

    @MockBean
    private BookService bookService;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper =new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    void get() throws Exception {
        BookView book =new BookView(1L, "W pustyni i w puszczy", "Sienkiewicz", 10);
        when(bookService.get(1L)).thenReturn(book);
        MvcResult result =mockMVc.perform(MockMvcRequestBuilders.get("/book/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String json = result.getResponse().getContentAsString();
        BookView bookFromRequest = objectMapper.readValue(json, BookView.class);
        assertEquals(book, bookFromRequest);
    }

    @Test
    void create() throws Exception{
        BookView book = new BookView(1L, "W pustyni i w puszczy", "Sienkiewicz", 10);
        when(bookService.create(new BookCreateRequest(1L, "W pustyni i w puszczy", "Sienkiewicz", 10)).thenReturn(book));
        MvcResult result =mockMVc.perform(MockMvcRequestBuilders.get("/book/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();



    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}