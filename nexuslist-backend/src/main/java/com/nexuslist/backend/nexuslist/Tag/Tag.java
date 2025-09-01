package com.nexuslist.backend.nexuslist.Tag;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "Tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    @Setter
    @Column(name = "tag_name", nullable = false, length = 15)
    private String name;

    @Setter
    @Column(name = "tag_color", nullable = false)
    private String colorHex;



    protected Tag() {}

    public Tag(String name, String colorHex) {
        this.name = name;
        this.colorHex = colorHex;
    }
}
