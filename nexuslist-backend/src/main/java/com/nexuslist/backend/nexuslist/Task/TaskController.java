package com.nexuslist.backend.nexuslist.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        return new ResponseEntity<>(taskService.createTask(taskRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDataResponse>> getTasks(
        @RequestParam(required = false) Priority priority,
        @RequestParam(required = false) Boolean completed,
        @RequestParam(required = false) Set<Long> tagIds,
        @RequestParam(required = false) LocalDateTime dueDate,
        @RequestParam(required = false) Boolean beforeDueDate) {

        return ResponseEntity.ok(taskService.getTasksByCriteria(priority, completed, tagIds, dueDate, beforeDueDate));
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDataResponse> getTaskById(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskService.getTask(taskId));
    }

    @GetMapping("/me")
    public ResponseEntity<List<TaskDataResponse>> getTasksByUser() {
        return ResponseEntity.ok(taskService.getTasksForCurrentUser());
    }
}
