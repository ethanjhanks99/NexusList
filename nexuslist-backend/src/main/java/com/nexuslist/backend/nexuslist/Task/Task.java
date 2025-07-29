package com.nexuslist.backend.nexuslist.Task;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.nexuslist.backend.nexuslist.Tag.Tag;
import com.nexuslist.backend.nexuslist.TaskList.TaskList;
import com.nexuslist.backend.nexuslist.User.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="tasklist_id", nullable = false)
    private TaskList list;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private LocalDateTime dueDate;

    @ManyToMany()
    @JoinTable(
        name = "task_tags",
        joinColumns = @JoinColumn(name = "task_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    private Boolean completed;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.completed = false;
    }

    public Task(String name, String description, LocalDateTime dueDate) {
        this.name = name;
        this.description = description;
        this.completed = false;
        this.dueDate = dueDate;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    public void removeTag(Tag tag) {
        this.tags.remove(tag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id != null && id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
