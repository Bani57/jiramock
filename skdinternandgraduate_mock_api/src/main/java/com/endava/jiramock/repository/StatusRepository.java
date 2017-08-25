package com.endava.jiramock.repository;

import com.endava.jiramock.model.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends CrudRepository<Status, Integer> {
    List<Status> findAllByProjectCode(String code);

    List<Status> findAllByProjectId(Integer id);


}
