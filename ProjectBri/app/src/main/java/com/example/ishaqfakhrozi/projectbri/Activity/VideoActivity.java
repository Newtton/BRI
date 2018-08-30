package com.example.ishaqfakhrozi.projectbri.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.ishaqfakhrozi.projectbri.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private YouTubePlayerView youtube;
//    private static String url = "" untuk API
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        youtube = findViewById(R.id.Video);
        youtube.initialize(DeveloperKey.DEVELOPER_KEY, this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if (!wasRestored)youTubePlayer.cueVideo("Q1BSO_NXd-E");
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

    class DeveloperKey {
        public static final String DEVELOPER_KEY="AIzaSyArNPuC7kUTwSUZ6I0CSx-MF_nG3MOIxRw";
    }
}

