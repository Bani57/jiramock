package com.endava.jiramock.controller;

import com.endava.jiramock.model.Project;
import com.endava.jiramock.model.SessionModel;
import com.endava.jiramock.model.Status;
import com.endava.jiramock.service.IssueService;
import com.endava.jiramock.service.SessionResponseEnumeration;
import com.endava.jiramock.service.SessionService;
import com.endava.jiramock.service.StatusService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TestStatusController {
    @Mock
    private SessionService sessionService;
    @Mock
    private StatusService statusService;
    @Mock
    private IssueService issueService;
    @InjectMocks
    private StatusController statusController;

    private MockMvc mockMvc;
    private List<Status> statuses;
    private Status status;
    private String sessionId;
    private String projectCode;


    @Before
    public void setUp() throws  Exception{
        int projectId=1;
        int statusId=1;
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(statusController).build();
        Project project = new Project();
        projectCode="123";
        project.setCode("123");
        project.setId(projectId);
        project.setDescription("test project");


        SessionModel sessionModel = new SessionModel();
        sessionId="23JSDSDA";
        sessionModel.setSessionId(sessionId);
        sessionModel.setDate(new Date());
        HashMap<String, Date> hashmap = new HashMap<>();
        sessionService.setHashmap(hashmap);
        sessionService.setMinutes(15);
        sessionService.insertSession(sessionModel);

        status=new Status();
        status.setId(statusId);
        status.setName("OPEN");
        status.setDescription("Task is open");
        status.setProject(project);




    }
    @Test
    public void TestStatusControllerValidSessionIdAndProjectCode() throws Exception {


        statuses=new ArrayList<>();
        statuses.add(status);
        when(sessionService.checkSession(sessionId)).thenReturn(SessionResponseEnumeration.SUCCESS);
        when(statusService.findStatusesByCode(projectCode)).thenReturn(statuses);

         mockMvc.perform(get("/rest/api/{projectCode}/statuses",projectCode).header("JSESSIONID",sessionId).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    public void TestStatusControllerProjectCodeNotValid() throws Exception{
        statuses=new ArrayList<>();
        statuses.add(status);
        projectCode="223";
        when(sessionService.checkSession(sessionId)).thenReturn(SessionResponseEnumeration.SUCCESS);
        when(statusService.findStatusesByCode(projectCode)).thenReturn(null);

        mockMvc.perform(get("/rest/api/{projectCode}/statuses",projectCode).header("JSESSIONID",sessionId).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    public void TestStatusControllerSessionIdNotValid() throws Exception{
        statuses=new ArrayList<>();
        statuses.add(status);
        sessionId="DJAIS72";
        when(sessionService.checkSession(sessionId)).thenReturn(SessionResponseEnumeration.UNAUTHORIZED);
        when(statusService.findStatusesByCode(projectCode)).thenReturn(statuses);

        mockMvc.perform(get("/rest/api/{projectCode}/statuses",projectCode).header("JSESSIONID",sessionId).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isUnauthorized());

    }

    @Test
    public void TestStatusControllerSessionIdAndProjectCodeNotValid() throws Exception{
        statuses=new ArrayList<>();
        statuses.add(status);
        sessionId="DJAIS72";
        projectCode="223";
        when(sessionService.checkSession(sessionId)).thenReturn(SessionResponseEnumeration.UNAUTHORIZED);
        when(statusService.findStatusesByCode(projectCode)).thenReturn(null);

        mockMvc.perform(get("/rest/api/{projectCode}/statuses",projectCode).header("JSESSIONID",sessionId).accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isUnauthorized());
    }






}

