package com.nexuslist.backend.nexuslist.TaskList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

import com.nexuslist.backend.nexuslist.Folder.Folder;
import com.nexuslist.backend.nexuslist.User.User;

@Getter
@Entity
@Table(name = "tasklists")
public class TaskList {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tasklist_id")
    private Long id;

    @Setter
    @NotBlank(message = "List name cannot be empty.")
    @Size(min = 1, max = 20, message = "List name must be between 1 and 20 characters")
    @Column(name = "tasklist_name", length = 20)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;

    protected TaskList() {}

    public TaskList(String name) {
        this.name = name;
    }

}
