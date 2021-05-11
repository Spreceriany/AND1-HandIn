package com.example.myapplication.webservices;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EpisodeApi {
    @GET("a1b63d21-0d1d-4a51-a02d-8839a02c0fc7")
    Call<List<EpisodeResponse>> getEpisodes();
}
