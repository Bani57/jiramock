package com.endava.jiramock.service;

import com.endava.jiramock.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueService {
    private final IssueRepository issueRepository;

    @Autowired
    public IssueService(IssueRepository issueRepository) {
        this.issueRepository=issueRepository;
    }

    public Integer getTotalIssuesOfProjectWithPriority(String projectCode, String priorityName) {
        return issueRepository.countIssuesByProjectCodeAndPriorityName(projectCode, priorityName);
    }

    public Integer getTotalIssuesOfProjectWithStatus(String projectCode, String statusName) {
        return issueRepository.countIssuesByProjectCodeAndStatusName(projectCode, statusName);
    }
}
