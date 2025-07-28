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
import lombok.Setter;

@Getter
@Entity
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @Setter
    @ManyToOne
    @JoinColumn(name="tasklist_id", nullable = false)
    private TaskList list;

    @Setter
    private String name;

    @Setter
    private String description;

    @Setter
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Setter
    private LocalDateTime dueDate;

    @ManyToMany()
    @JoinTable(
        name = "task_tags",
        joinColumns = @JoinColumn(name = "task_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    @Setter
    private Boolean completed;

    protected Task() {}

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

}
