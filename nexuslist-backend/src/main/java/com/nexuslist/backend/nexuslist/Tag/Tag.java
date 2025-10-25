package com.nexuslist.backend.nexuslist.Tag;

import com.nexuslist.backend.nexuslist.User.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @NotBlank(message = "Tag must have a name.")
    @Size(min = 1, max = 15, message = "Tag name must be between 1 and 15 characters.")
    @Column(name = "tag_name", length = 15)
    private String name;

    @Column(name = "tag_color", nullable = false)
    private String colorHex;



    protected Tag() {}

    public Tag(String name, String colorHex) {
        this.name = name;
        this.colorHex = colorHex;
    }
}
