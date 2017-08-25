package com.endava.jiramock.repository;

import com.endava.jiramock.model.Priority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends CrudRepository<Priority,Integer>{
}
