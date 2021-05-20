package com.example.myapplication.webservices;

import com.example.myapplication.model.EpisodeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EpisodeApi {
    @GET("93651dbd-0b38-4562-bc5d-11de7847ee89")
    Call<List<EpisodeResponse>> getEpisodes();

}
