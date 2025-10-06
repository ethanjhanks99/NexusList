package com.nexuslist.backend.nexuslist.Task;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskDataRequest {

    @NotBlank(message = "Task name cannot be empty.")
    @Size(min = 1, max = 50, message = "Task name must be between 1 and 50 characters.")
    private String name;

    private String description;

    private LocalDateTime dueDate;

}
