package com.example.myapplication.ui.episodes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Episode;
import com.example.myapplication.ui.quotes.QuoteAdapter;
import com.example.myapplication.webservices.EpisodeApi;
import com.example.myapplication.webservices.EpisodeResponse;
import com.example.myapplication.webservices.ServiceGenerator;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodesFragment extends Fragment {
    RecyclerView recyclerView;
    private EpisodeAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Episode> list;
    private MutableLiveData<List<Episode>> episodeData;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_episodes, container, false);
        recyclerView = view.findViewById(R.id.episodeRecView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new EpisodeAdapter();
        recyclerView.setHasFixedSize(true);
        requestEpisodes();
        setHasOptionsMenu(true);

        layoutManager = new LinearLayoutManager(getContext());



        return view;
    }


    public void requestEpisodes(){
        EpisodeApi episodeApi = ServiceGenerator.getEpisodeApi();
        Call<List<EpisodeResponse>> call = episodeApi.getEpisodes();
        call.enqueue(new Callback<List<EpisodeResponse>>() {
            @Override
            public void onResponse(Call<List<EpisodeResponse>> call, Response<List<EpisodeResponse>> response) {
                if (response.code() == 200){
                    List<EpisodeResponse> episodeResponses = response.body();
                    adapter.setData(episodeResponses);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<EpisodeResponse>> call, Throwable t) {

            }
        });
    }


}
