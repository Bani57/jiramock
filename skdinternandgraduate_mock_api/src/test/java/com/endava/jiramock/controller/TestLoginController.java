package com.endava.jiramock.controller;
import com.endava.jiramock.repository.UserRepository;
import com.google.gson.Gson;
import com.endava.jiramock.model.User;
import com.endava.jiramock.service.SessionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class TestLoginController {
    @Mock
    private UserRepository userRepository;
    @Mock
    private SessionService sessionService;
    @InjectMocks
    private LoginController loginController;
    private MockMvc mockMvc;
    private Gson gson;
    private User userValid;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(loginController).build();
        gson=new Gson();
        userValid=new User();
        userValid.setUsername("admin");
        userValid.setPassword("admin");
    }

    @Test
    public void testLoginSession() throws Exception {
        String json=gson.toJson(userValid);
        when(userRepository.findByUsername("admin")).thenReturn(userValid);
        mockMvc.perform(post("/rest/login/session")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void testLoginSessionNegativeUsername() throws Exception {
        User userInvalid=new User();
        userInvalid.setUsername("andrej");
        userInvalid.setPassword(userValid.getPassword());
        String json=gson.toJson(userInvalid);
        when(userRepository.findByUsername("andrej")).thenReturn(null);
        mockMvc.perform(post("/rest/login/session")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(json))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testLoginSessionNegativePassword() throws Exception {
        User userInvalid=new User();
        userInvalid.setUsername(userValid.getUsername());
        userInvalid.setPassword("1234");
        String json=gson.toJson(userInvalid);
        when(userRepository.findByUsername("admin")).thenReturn(userValid);
        mockMvc.perform(post("/rest/login/session")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(json))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testLoginSessionNegativeUsernameAndPassword() throws Exception {
        User userInvalid=new User();
        userInvalid.setUsername("andrej");
        userInvalid.setPassword("1234");
        String json=gson.toJson(userInvalid);
        when(userRepository.findByUsername("andrej")).thenReturn(null);
        mockMvc.perform(post("/rest/login/session")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(json))
                .andExpect(status().isUnauthorized());
    }
}
