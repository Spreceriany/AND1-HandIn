package com.example.myapplication.webservices;

import com.example.myapplication.model.Episode;

public class EpisodeResponse {
    private int id;
    private String name;

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

    @Override
    public String toString() {
        return "EpisodeResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
