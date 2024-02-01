package com.example.myfirst.entity;

import java.sql.Timestamp;

public class Inquiry {
    private int id;
    private String name;
    private String email;
    private String contents;
    private Timestamp created;

    public Inquiry() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContents() {
        return contents;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    // public void setCreated(LocalDateTime created) {
    // this.created = created;
    // }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
