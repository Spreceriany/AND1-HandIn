package com.example.myapplication.repository;

import android.util.Log;


import androidx.lifecycle.MutableLiveData;


import com.example.myapplication.webservices.ServiceGenerator;
import com.example.myapplication.webservices.EpisodeApi;
import com.example.myapplication.model.EpisodeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodeRepository {
    private static EpisodeRepository instance;
    private MutableLiveData<List<EpisodeResponse>> episodes;

    public static EpisodeRepository getInstance(){
        if (instance == null){
            instance = new EpisodeRepository();
        }
        return instance;
    }

    public EpisodeRepository() {
        episodes = new MutableLiveData<>();
    }

    public void requestEpisodes(){
        EpisodeApi episodeApi = ServiceGenerator.getEpisodeApi();
        Call<List<EpisodeResponse>> call = episodeApi.getEpisodes();

        call.enqueue(new Callback<List<EpisodeResponse>>() {
            @Override
            public void onResponse(Call<List<EpisodeResponse>> call, Response<List<EpisodeResponse>> response) {
                if (response.isSuccessful()){
                    List<EpisodeResponse> episodeResponseList;
                    episodeResponseList = response.body();
                    episodes.setValue(episodeResponseList);
                }
            }

            @Override
            public void onFailure(Call<List<EpisodeResponse>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");
            }
        });
    }

    public MutableLiveData<List<EpisodeResponse>> getEpisodes() {
        return episodes;
    }
}
