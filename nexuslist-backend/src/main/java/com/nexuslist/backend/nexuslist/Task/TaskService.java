package com.nexuslist.backend.nexuslist.Task;

import java.util.List;
import java.time.LocalDateTime;

import com.nexuslist.backend.nexuslist.Tag.Tag;


import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    
    public List<Task> getTasksByCriteria(
        Priority priority,
        boolean completed,
        Tag tag,
        LocalDateTime dueDate
    ) {

        return taskRepository.findAll(spec);
    }
}
