package com.endava.jiramock.controller;

import com.endava.jiramock.model.Priority;
import com.endava.jiramock.model.Project;
import com.endava.jiramock.model.SearchRequest;
import com.endava.jiramock.repository.ProjectRepository;
import com.endava.jiramock.service.IssueService;
import com.endava.jiramock.service.PriorityService;
import com.endava.jiramock.service.SessionService;
import com.endava.jiramock.service.SessionResponseEnumeration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PriorityController {

    private final PriorityService priorityService;

    private final IssueService issueService;

    private final SessionService sessionService;

    private final ProjectRepository projectRepository;

    @Autowired
    public PriorityController(PriorityService priorityService, IssueService issueService, SessionService sessionService, ProjectRepository projectRepository) {
        this.priorityService = priorityService;
        this.issueService = issueService;
        this.sessionService = sessionService;
        this.projectRepository = projectRepository;
    }

    @RequestMapping("/rest/api/priority")
    public ResponseEntity<List<Priority>> getPriority(@RequestHeader("jSessionId") String jSessionId) {
        if (sessionService.checkSession(jSessionId) != SessionResponseEnumeration.SUCCESS)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        else {
            return new ResponseEntity<>((List<Priority>) priorityService.getAllPriorities(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/rest/api/search/{projectCode}/priority", method = RequestMethod.POST)
    public ResponseEntity<String> getTotalPriority(@RequestHeader("jSessionId") String jSessionId, @PathVariable String projectCode, @RequestBody SearchRequest searchRequest) {
        if (sessionService.checkSession(jSessionId) != SessionResponseEnumeration.SUCCESS)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        else {
            String priority = searchRequest.getValue();
            Project test = projectRepository.findProjectByCode(projectCode);
            System.out.println(test);
            if (test == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(issueService.getTotalIssuesOfProjectWithPriority(projectCode, priority).toString(), HttpStatus.OK);
        }
    }


}
