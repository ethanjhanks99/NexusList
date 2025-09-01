package com.nexuslist.backend.nexuslist.Task;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;
import com.nexuslist.backend.nexuslist.Tag.Tag;

public class TaskSpecifications {

    public static Specification<Task> hasPriority(Priority priority) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("priority"), priority);
    }

    public static Specification<Task> completionStatus(boolean completed) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("completed"), completed);
    }

    public static Specification<Task> hasTag(Tag tag) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.isMember(tag, root.get("tags"));
    }

    public static Specification<Task> isDueOn(LocalDateTime dueDate) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("dueDate"), dueDate);
    }

    public static Specification<Task> isDueBefore(LocalDateTime dueDate) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.lessThanOrEqualTo(root.get("dueDate"), dueDate);
    }

    public static Specification<Task> isDueAfter(LocalDateTime dueDate) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.greaterThanOrEqualTo(root.get("dueDate"), dueDate);
    }

}
