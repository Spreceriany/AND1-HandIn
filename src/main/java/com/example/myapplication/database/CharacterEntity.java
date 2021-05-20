package com.example.myapplication.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "character")
public class CharacterEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String hairColor;
    private String eyeColor;
    private String cast;
    private String status;

    public CharacterEntity(int id, String hairColor, String eyeColor, String cast, String status) {
        this.id = id;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.cast = cast;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
