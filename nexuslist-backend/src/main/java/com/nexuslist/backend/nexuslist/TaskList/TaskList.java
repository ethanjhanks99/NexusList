package com.nexuslist.backend.nexuslist.TaskList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

import com.nexuslist.backend.nexuslist.User.User;

@Getter
@Entity
@Table(name = "lists")
public class TaskList {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    protected TaskList() {}

    public TaskList(String name) {
        this.name = name;
    }
}
