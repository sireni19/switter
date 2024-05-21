package by.prokopovich.switter.security.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class DemoControllerTest {
    @InjectMocks
    private DemoController controller;
    @Mock
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc= MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void justAuth() throws Exception {
        mockMvc.perform(get("/api/v1/demo/just-auth"))
                .andExpect(status().isOk())
                .andExpect(content().string("This is protected resource-1"));
    }

    @Test
    void justRoleUser() {
    }

    @Test
    void justRoleAdmin() throws Exception {

    }
}