package com.nexuslist.backend.nexuslist.Task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.validation.Valid;

@RestController
@RequestMapping()
public class TaskController {
    private final TaskService taskService;
    
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskDataResponse> createTast(@Valid @RequestBody TaskDataRequest taskRequest) {
        TaskDataResponse createdTask = taskService.createTask(taskRequest);

        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    
}
