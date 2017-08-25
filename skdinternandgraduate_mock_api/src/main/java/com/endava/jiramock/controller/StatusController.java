package com.endava.jiramock.controller;

import com.endava.jiramock.model.SearchRequest;
import com.endava.jiramock.model.Status;
import com.endava.jiramock.service.IssueService;
import com.endava.jiramock.service.SessionService;
import com.endava.jiramock.service.StatusService;
import com.endava.jiramock.service.SessionResponseEnumeration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StatusController {

    private final SessionService sessionService;

    private final StatusService statusService;

    private final IssueService issueService;

    @Autowired
    public StatusController(SessionService sessionService, StatusService statusService, IssueService issueService) {
        this.sessionService = sessionService;
        this.statusService = statusService;
        this.issueService = issueService;
    }

    @RequestMapping(value = "/rest/api/{projectCode}/statuses", method = RequestMethod.GET)
    public ResponseEntity<List<Status>> projectStatus(@RequestHeader(value = "JSESSIONID") String jSessionId, @PathVariable("projectCode") String projectCode) {
        if (sessionService.checkSession(jSessionId) != SessionResponseEnumeration.SUCCESS)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        else {
            List<Status> statuses = statusService.findStatusesByCode(projectCode);
            if (statuses == null || statuses.size() == 0) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else
                return ResponseEntity.ok(statuses);
        }
    }

    @RequestMapping(value = "/rest/api/search/{projectCode}/status", method = RequestMethod.POST)
    public ResponseEntity<String> getTotalStatus(@RequestHeader("jSessionId") String jSessionId, @PathVariable String projectCode, @RequestBody SearchRequest searchRequest) {
        if (sessionService.checkSession(jSessionId) != SessionResponseEnumeration.SUCCESS)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        else {
            String status = searchRequest.getValue();
            return new ResponseEntity<>(issueService.getTotalIssuesOfProjectWithStatus(projectCode, status).toString(), HttpStatus.OK);
        }
    }
}
