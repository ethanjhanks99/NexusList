package com.nexuslist.backend.nexuslist.Task;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.time.LocalDateTime;

import com.nexuslist.backend.nexuslist.Security.UserAuthService;
import com.nexuslist.backend.nexuslist.Tag.Tag;
import com.nexuslist.backend.nexuslist.Tag.TagRepository;
import com.nexuslist.backend.nexuslist.User.User;
import com.nexuslist.backend.nexuslist.exception.ResourceNotFoundException;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TagRepository tagRepository;
    private final UserAuthService userAuthService;

    public TaskService(TaskRepository taskRepository, TagRepository tagRepository, UserAuthService userAuthService) {
        this.taskRepository = taskRepository;
        this.tagRepository = tagRepository;
        this.userAuthService = userAuthService;
    }

    /*
     * GET METHODS
     */

    public Task getTask(Long taskId) {
        User currentUser = userAuthService.getCurrentUser();
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task does not exist with id: " + taskId));
    
        if (!task.getUser().getId().equals(currentUser.getId())) {
            throw new AccessDeniedException("You do not have access to this task");
        }

        return task;
    }
    
    public List<Task> getTasksForCurrentUser(User user) {
        return taskRepository.findByUser(user);
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

    /*
     * CREATE METHOD
     */

    public Task createTask(TaskDataRequest taskRequest) {
        User currentUser = userAuthService.getCurrentUser();

        Task newTask = new Task();

        newTask.setName(taskRequest.getName());
        newTask.setDescription(taskRequest.getDescription());
        newTask.setDueDate(taskRequest.getDueDate());
        newTask.setPriority(taskRequest.getPriority());

        if (taskRequest.getTagIds() != null && !taskRequest.getTagIds().isEmpty()) {
            List<Tag> tagsList = tagRepository.findAllById(taskRequest.getTagIds());
            Set<Tag> tags = new HashSet<>(tagsList);

            for (Tag tag : tags) {
                if (!tag.getUser().getId().equals(currentUser.getId())) {
                    throw new AccessDeniedException("User does not own tag with id: " + tag.getId());
                }
            }

            newTask.setTags(tags);
        }

        newTask.setUser(currentUser);
        newTask.setCompleted(false);
        return taskRepository.save(newTask);
    }
}
