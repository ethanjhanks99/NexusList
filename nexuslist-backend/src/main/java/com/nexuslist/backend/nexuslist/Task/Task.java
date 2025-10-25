package com.nexuslist.backend.nexuslist.Task;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.nexuslist.backend.nexuslist.Tag.Tag;
import com.nexuslist.backend.nexuslist.TaskList.TaskList;
import com.nexuslist.backend.nexuslist.User.User;

import jakarta.persistence.Column;
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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Column(name = "task_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="tasklist_id", nullable = false)
    private TaskList taskList;

    @NotBlank(message = "Task name cannot be empty.")
    @Size(min = 1, max = 50, message = "Task name must be between 1 and 50 characters.")
    @Column(name = "task_name", length = 50)
    private String name;

    @Column(name = "task_description", length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private Priority priority;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @ManyToMany()
    @JoinTable(
        name = "task_tags",
        joinColumns = @JoinColumn(name = "task_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    @Column(name = "completed", nullable = false)
    private Boolean completed;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.completed = false;
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

    @Override
    public String toString() {
        return "Task{" + 
            "\n\tid=" + this.id + 
            ",\n\tname=" + this.name + 
            ",\n\tdescription=" + this.description +
            ",\n\tpriority=" + this.priority +
            ",\n\tdue date=" + this.dueDate +
            ",\n\ttags=" + this.tags +
            ",\n\tcompletion status=" + this.completed + 
        "\n}";
    }
}
