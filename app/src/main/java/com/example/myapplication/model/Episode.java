package com.example.myapplication.model;

import androidx.room.PrimaryKey;

import java.io.Serializable;

public class Episode implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;

    public Episode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
