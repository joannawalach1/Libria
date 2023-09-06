package pl.com.coders.libria1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.com.coders.libria1.controller.request.UserCreateRequest;
import pl.com.coders.libria1.service.UserService;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMVc;

    @MockBean
    private UserService userService;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    void getByLogin() throws Exception {
        UserView user = new UserView(1L, "kowalski", "abcd", "kowalski@", LocalDateTime.now(), LocalDateTime.now());
        when(userService.getByLogin("kowalski")).thenReturn(user);
        MvcResult result = mockMVc.perform(MockMvcRequestBuilders.get("/user/kowalski"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String json = result.getResponse().getContentAsString();
        UserView userfromRequest = objectMapper.readValue(json, UserView.class);
        assertEquals(user, userfromRequest);
    }

    @Test
    void create() throws Exception {
        UserView user = new UserView(1L,"kowalski","abcd","kowalski@",LocalDateTime.now(),LocalDateTime.now());
        when(userService.createUser(new UserCreateRequest())).thenReturn((user));
        String json = objectMapper.writeValueAsString(new UserCreateRequest());
        MvcResult result = mockMVc.perform(MockMvcRequestBuilders.post("/user/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        json = result.getResponse().getContentAsString();
        UserView userFromRequest = objectMapper.readValue(json, UserView.class);// czemu to nie działa?
        assertEquals(user, userFromRequest);

    }

    @Test
    void delete() throws Exception {
        mockMVc.perform(MockMvcRequestBuilders.delete("/user/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void update() throws Exception {
        UserView user = new UserView(1L, "kowalski", "abcd", "kowalski@", LocalDateTime.now(), LocalDateTime.now());
        when(userService.updateUser(new UserView())).thenReturn((user));
        String json = objectMapper.writeValueAsString(new UserView());
        MvcResult result = mockMVc.perform(MockMvcRequestBuilders.put("/user/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        json = result.getResponse().getContentAsString();
        UserView userFromRequest = objectMapper.readValue(json, UserView.class);
        assertEquals(user, userFromRequest);
    }
}






