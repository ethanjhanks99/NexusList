package com.nexuslist.backend.nexuslist.Task;

import org.springframework.data.jpa.domain.Specification;
import com.nexuslist.backend.nexuslist.Tag.Tag;

public class TaskSpecifications {

    public static Specification<Task> hasPriority(Priority priority) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("priority"), priority);
    }

    public static Specification<Task> isCompleted(boolean completed) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("completed"), completed);
    }

    public static Specification<Task> hasTag(Tag tag) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.isMember(tag, root.get("tags"));
    }

}
