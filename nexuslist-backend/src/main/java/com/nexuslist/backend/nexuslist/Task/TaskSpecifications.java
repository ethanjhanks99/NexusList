package com.nexuslist.backend.nexuslist.Task;

import org.springframework.data.jpa.domain.Specification;

public class TaskSpecifications {

    public static Specification<Task> hasPriority(Priority priority) {

        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("priority"), priority);
    }

    public static Specification<Task> isCompleted(boolean completed) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("completed"), completed);
    }

}
