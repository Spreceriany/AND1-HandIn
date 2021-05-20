package com.example.myapplication.webservices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static EpisodeApi episodeApi;

    public static EpisodeApi getEpisodeApi()
    {
        if(episodeApi == null)
        {
            episodeApi = new Retrofit.Builder()
                    .baseUrl("https://run.mocky.io/v3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(EpisodeApi.class);
        }
        return episodeApi;
    }
}
