package com.example.springwebtesting;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.springwebtesting.controllers.GreetingController;
import com.example.springwebtesting.services.GreetingService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(GreetingController.class)
public class WebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService service;

    @Test
    public void greeting_returns_x() throws Exception {
        // Spring.io way
        //when here is using setting return for the mocked service
        when(service.greet()).thenReturn("Hello, World");
        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
    }
    @Test
    public void greeting_returns_x_gSchool() throws Exception {
        //Galvanize way
        //GIVEN
        when(service.greet()).thenReturn("Hello, World");
        RequestBuilder request = MockMvcRequestBuilders.get("/greeting");
        //WHEN THEN
        this.mockMvc.perform(get("/greeting")).andExpect(status().isOk()).andExpect(content().string(containsString("Hello, World")));
    }
}