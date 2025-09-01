package com.nexuslist.backend.nexuslist.TaskList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "tasklist_name", nullable = false, length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "folder_id", nullable = false)
    private Folder folder;

    protected TaskList() {}

    public TaskList(String name) {
        this.name = name;
    }

}
