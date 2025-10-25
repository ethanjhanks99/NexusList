package com.nexuslist.backend.nexuslist.Task;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

import com.nexuslist.backend.nexuslist.Tag.Tag;

import lombok.Data;

@Data
public class TaskDataResponse {
    private Long id;
    private String name;
    private String description;
    private Priority priority;
    private LocalDateTime dueDate;
    private Set<String> tags;
    private Boolean completed;
    private Long userId;
    private Long taskListId;

    public static TaskDataResponse fromTaskEntity(Task task) {
        TaskDataResponse dto = new TaskDataResponse();

        dto.setId(task.getId());
        dto.setName(task.getName());
        dto.setDescription(task.getDescription());
        dto.setPriority(task.getPriority());
        dto.setDueDate(task.getDueDate());
        dto.setCompleted(task.getCompleted());

        if (task.getUser() != null) {
            dto.setUserId(task.getUser().getId());
        }
        if (task.getTaskList() != null) {
            dto.setTaskListId(task.getTaskList().getId());
        }
        if (task.getTags() != null) {
            dto.setTags(task.getTags().stream()
                                      .map(Tag::getName)
                                      .collect(Collectors.toSet()));
        
        }

        return dto;
    }
}
