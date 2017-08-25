package com.endava.jiramock.repository;

import com.endava.jiramock.model.Issue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IssueRepository extends CrudRepository<Issue, Integer>
{
    Integer countIssuesByProjectCodeAndPriorityName(String projectCode, String priorityName);
    Integer countIssuesByProjectCodeAndStatusName(String projectCode,String statusName);


}
