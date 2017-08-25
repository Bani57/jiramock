package com.endava.jiramock.controller;

import com.endava.jiramock.model.Priority;
import com.endava.jiramock.model.Project;
import com.endava.jiramock.model.SearchRequest;
import com.endava.jiramock.repository.PriorityRepository;
import com.endava.jiramock.repository.ProjectRepository;
import com.endava.jiramock.service.IssueService;
import com.endava.jiramock.service.PriorityService;
import com.endava.jiramock.service.SessionResponseEnumeration;
import com.endava.jiramock.service.SessionService;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TestPriorityController {

    @Mock
    private PriorityService priorityService;
    @Mock
    private SessionService sessionService;
    @Mock
    private IssueService issueService;
    @Mock
    private PriorityRepository priorityRepository;
    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private PriorityController priorityController;

    private MockMvc mockMvc;
    private Gson gson;
    private List<Priority> priorityList = new ArrayList<>();
    private SearchRequest requestOne = new SearchRequest("1234");
    private SearchRequest requestTwo = new SearchRequest("5678");
    private SearchRequest requestThree = new SearchRequest("4321");
    private SearchRequest requestFour = new SearchRequest("8765");
    private Project testProject = new Project("123","Test");
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(priorityController).build();
        gson = new Gson();
        priorityList.add(new Priority("#FFFFFF", "low priority", "LOW"));
        priorityList.add(new Priority("#000000", "Medium priority", "MEDIUM"));
        priorityList.add(new Priority("#FF0000", "High priority", "HIGH"));
        priorityList.add(new Priority("#123456", "Critical priority", "CRITICAL"));
        priorityList.add(new Priority("#123457", "Blocker", "BLOCKER"));
        priorityList.add(new Priority("#985123", "Major priority", "MAJOR"));
        priorityList.add(new Priority("#ABCDEF", "Minor priority", "MINOR"));



    }

    @Test
    public void testPrioritySession() throws Exception {
        when(sessionService.checkSession(anyString())).thenReturn(SessionResponseEnumeration.SUCCESS);
        when(priorityRepository.findAll()).thenReturn(priorityList);
        mockMvc.perform(post("/rest/api/priority").header("JSESSIONID", "JDISAI3")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk());

    }

    @Test
    public void testPrioritySessionInvalid() throws Exception {
        when(sessionService.checkSession(anyString())).thenReturn(SessionResponseEnumeration.UNAUTHORIZED);
        when(priorityRepository.findAll()).thenReturn(priorityList);
        mockMvc.perform(post("/rest/api/priority").header("JSESSIONID", "JDISAI3")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isUnauthorized());

    }

    @Test
    public void testPriorityCorrectData() throws Exception {
        String json = gson.toJson(requestOne);
        when(sessionService.checkSession(anyString())).thenReturn(SessionResponseEnumeration.SUCCESS);
        when(projectRepository.findProjectByCode(anyString())).thenReturn(testProject);
        mockMvc.perform(post("/rest/api/search/{projectCode}/priority",requestOne ).header("JSESSIONID", "JDISAI3")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void testPriorityIncorrectData() throws Exception {
        String incorrectValue = "9999";
        String json = gson.toJson(incorrectValue);
        when(sessionService.checkSession(anyString())).thenReturn(SessionResponseEnumeration.UNAUTHORIZED);
        mockMvc.perform(post("/rest/api/search/{projectId}/priority", "incorrectValue").header("JSESSIONID", "NEPOSTOECKA_SESIJA")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(json))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testPriorityCodeNotValid() throws Exception{
        String json = gson.toJson(requestTwo);
        when(sessionService.checkSession(anyString())).thenReturn(SessionResponseEnumeration.SUCCESS);
        when(projectRepository.findProjectByCode(anyString())).thenReturn(null);
        mockMvc.perform(post("/rest/api/search/{projectId}/priority", "incorrectValue").header("JSESSIONID", "NEPOSTOECKA_SESIJA")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(json))
                .andExpect(status().isNotFound());



    }
}
