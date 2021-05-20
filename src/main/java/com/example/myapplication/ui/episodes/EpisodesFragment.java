package com.example.myapplication.ui.episodes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.EpisodeAdapter;
import com.example.myapplication.model.Episode;
import com.example.myapplication.ui.episodeDetals.EpisodeDetailsActivity;
import com.example.myapplication.model.EpisodeResponse;


import java.util.List;

public class EpisodesFragment extends Fragment implements EpisodeAdapter.ClickedItem{
    RecyclerView recyclerView;
    ProgressBar progressBar;
    List<EpisodeResponse> episodeResponseList;
    private EpisodeAdapter adapter;
    private EpisodeViewModel episodeViewModel;
    private RecyclerView.LayoutManager layoutManager;
    private List<Episode> list;
    private MutableLiveData<List<Episode>> episodeData;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_episodes, container, false);
        recyclerView = view.findViewById(R.id.episodeRecView);
        progressBar = view.findViewById(R.id.progress_bar);
        episodeViewModel = new ViewModelProvider(this).get(EpisodeViewModel.class);
        adapter = new EpisodeAdapter(this::ClickedEpisode);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        
        episodeViewModel.requestEpisodes();
        requestEpisodes();
        return view;
    }

    public void requestEpisodes(){
        episodeViewModel.getEpisodes().observe(getViewLifecycleOwner(), episodes->{
            adapter.clearData();

            adapter.setData(episodes);
            progressBar.setVisibility(View.GONE);

            LayoutAnimationController anima = AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_animation_slide_from_bottom);
            recyclerView.setLayoutAnimation(anima);

            adapter.notifyDataSetChanged();
        });
    }


    @Override
    public void ClickedEpisode(EpisodeResponse episodeResponse) {
        Intent newEpisode = new Intent(getActivity(), EpisodeDetailsActivity.class);
        newEpisode.putExtra("data", episodeResponse);
        startActivity(newEpisode);
    }
}
