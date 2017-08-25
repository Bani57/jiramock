package com.endava.jiramock.service;

import com.endava.jiramock.model.Status;
import com.endava.jiramock.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> findStatusesById(Integer id) {
        return statusRepository.findAllByProjectId(id);
    }

    public List<Status> findStatusesByCode(String code) {
        return statusRepository.findAllByProjectCode(code);
    }
}
