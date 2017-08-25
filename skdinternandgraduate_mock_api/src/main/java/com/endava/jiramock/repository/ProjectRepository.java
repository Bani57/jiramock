package com.endava.jiramock.repository;

import com.endava.jiramock.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {

    Project findProjectById(Integer id);

    Project findProjectByCode(String code);
}
