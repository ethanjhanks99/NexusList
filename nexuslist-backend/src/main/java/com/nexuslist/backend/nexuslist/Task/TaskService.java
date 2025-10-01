package com.nexuslist.backend.nexuslist.Task;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.time.LocalDateTime;

import com.nexuslist.backend.nexuslist.Tag.Tag;
import com.nexuslist.backend.nexuslist.Tag.TagRepository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TagRepository tagRepository;

    public TaskService(TaskRepository taskRepository, TagRepository tagRepository) {
        this.taskRepository = taskRepository;
        this.tagRepository = tagRepository;
    }
    
    public List<Task> getTasksByCriteria(
        Priority priority,
        Boolean completed,
        Set<Long> tagIds,
        LocalDateTime dueDate,
        Boolean beforeDueDate
    ) {
        Specification<Task> spec = null;
        
        if (priority != null) {
            spec = TaskSpecifications.hasPriority(priority);
        }
        if (completed != null) {
            if (spec == null) {
                spec = TaskSpecifications.completionStatus(completed);
            } else {
                spec = spec.and(TaskSpecifications.completionStatus(completed));
            }
        }
        if (tagIds != null && !tagIds.isEmpty()) {
            Set<Tag> tags = new HashSet<>(tagRepository.findAllById(tagIds));

            Specification<Task> tagSpec = null;
            for (Tag tag : tags) {
                if (tagSpec == null) {
                    tagSpec = TaskSpecifications.hasTag(tag);
                } else {
                    tagSpec = tagSpec.and(TaskSpecifications.hasTag(tag));
                }
            }

            if (spec == null) {
                spec = tagSpec;
            } else {
                spec = spec.and(tagSpec);
            }
        }
        if (dueDate != null) {
            if (beforeDueDate == null) {
                if (spec == null) {
                    spec = TaskSpecifications.isDueOn(dueDate);
                } else {
                    spec = spec.and(TaskSpecifications.isDueOn(dueDate));
                }
            } else if (beforeDueDate) {
                if (spec == null) {
                    spec = TaskSpecifications.isDueBefore(dueDate);
                } else {
                    spec = spec.and(TaskSpecifications.isDueBefore(dueDate));
                }
            } else {
                if (spec == null) {
                    spec = TaskSpecifications.isDueAfter(dueDate);
                } else {
                    spec = spec.and(TaskSpecifications.isDueAfter(dueDate));
                }
            }
        }

        return taskRepository.findAll(spec);
    }
}
