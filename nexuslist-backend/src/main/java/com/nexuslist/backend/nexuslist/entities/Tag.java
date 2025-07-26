package com.nexuslist.backend.nexuslist.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String colorHex;

    protected Tag() {}

    public Tag(String name, String colorHex) {
        this.name = name;
        this.colorHex = colorHex;
    }

    public Long getId() {return this.id;}

    public String getName() {return this.name;}

    public String getColor() {return this.colorHex;}
    
}
