package com.example.myapplication.ui.episodes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.repository.EpisodeRepository;
import com.example.myapplication.model.EpisodeResponse;

import java.util.List;

public class EpisodeViewModel extends ViewModel {
    private EpisodeRepository episodeRepository;

    public EpisodeViewModel() {
        episodeRepository = EpisodeRepository.getInstance();
    }


    public void requestEpisodes()
    {
        episodeRepository.requestEpisodes();
    }

    public MutableLiveData<List<EpisodeResponse>> getEpisodes()
    {
        return episodeRepository.getEpisodes();
    }
}
