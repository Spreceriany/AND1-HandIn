package com.example.myapplication.ui.episodeDetals;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.EpisodeResponse;

public class EpisodeDetailsActivity extends AppCompatActivity {

    TextView episodeName, episodeNumber, objective, story;
    ImageView image;
    EpisodeResponse episodeResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_details);
        episodeName = findViewById(R.id.episode_detail_name);
        episodeNumber = findViewById(R.id.episode_number);
        objective = findViewById(R.id.objective);
        story = findViewById(R.id.story);
        image = findViewById(R.id.episode_image);
        Intent intent = getIntent();

        if (intent.getExtras() != null){
            episodeResponse = (EpisodeResponse) intent.getSerializableExtra("data");

            String episodenamedata = episodeResponse.getName();
            String episodenumberdata = "Episode: " + Integer.toString(episodeResponse.getId()-1);
            String episodeObjective = episodeResponse.getObjective();
            String episodeStory = episodeResponse.getStory();
            String imageSrc = episodeResponse.getImage();

            episodeName.setText((String) episodenamedata);
            episodeNumber.setText(episodenumberdata);
            objective.setText(episodeObjective);
            story.setText(episodeStory);
            Glide.with(this).load(imageSrc).fitCenter().placeholder(R.drawable.loading_gif).into(image);
        }
    }
}