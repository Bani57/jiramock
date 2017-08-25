package com.endava.jiramock.service;

import com.endava.jiramock.model.*;
import com.endava.jiramock.repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PriorityService {

    private final PriorityRepository priorityRepository;

    @Autowired
    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    public Iterable<Priority> getAllPriorities() {
        return priorityRepository.findAll();
    }


}
