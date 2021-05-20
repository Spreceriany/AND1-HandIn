package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.EpisodeResponse;

import java.util.ArrayList;
import java.util.List;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>{

    private List<EpisodeResponse> episodeList = new ArrayList<>();
    private ClickedItem clickedItem;
    private EpisodeResponse episodeResponse;
    public EpisodeAdapter(ClickedItem clickedItem) {
        this.clickedItem = clickedItem;
    }

    public void setData(List<EpisodeResponse> list){
        this.episodeList = list;
        notifyDataSetChanged();
    }

    public void clearData()
    {
        episodeList.clear();
    }

    static class EpisodeViewHolder extends RecyclerView.ViewHolder {
        public TextView episode_name;
        public TextView episode;
        public ImageView imageMore;

        public EpisodeViewHolder(@NonNull View itemView) {
            super(itemView);
            episode_name = itemView.findViewById(R.id.episode_name);
            episode = itemView.findViewById(R.id.episode);
            imageMore = itemView.findViewById(R.id.image_more);
        }
    }

    public interface ClickedItem{
        public void ClickedEpisode(EpisodeResponse episodeResponse);
    }

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.episode_item, parent, false);
        EpisodeViewHolder episodeViewHolder = new EpisodeViewHolder(view);
        return episodeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {
        EpisodeResponse currentItem = episodeList.get(position);
        holder.episode_name.setText(currentItem.getName());
        holder.episode.setText("Episode: "+ Integer.toString(currentItem.getId() - 1));

        holder.imageMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedItem.ClickedEpisode(currentItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return episodeList.size();
    }


}
