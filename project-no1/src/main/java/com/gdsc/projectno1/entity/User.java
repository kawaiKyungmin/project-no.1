package com.gdsc.projectno1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Getter
@Setter
public class User {
    public User() {
    }

    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Id
    private String id;
    @Column(columnDefinition = "VARCHAR(30)")
    private String name;
    @Column(columnDefinition = "VARCHAR(30)")
    private String password;


}
