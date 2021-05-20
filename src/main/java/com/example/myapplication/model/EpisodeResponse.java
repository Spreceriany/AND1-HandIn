package com.example.myapplication.model;

import android.os.Parcelable;

import com.example.myapplication.model.Episode;

import java.io.Serializable;

public class EpisodeResponse implements Serializable {
    private int id;
    private String name;
    private String story;
    private String objective;
    private String image;
    public Episode getEpisodes(){
        return new Episode(id,name);
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

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
