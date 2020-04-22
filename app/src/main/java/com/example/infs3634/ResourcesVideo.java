package com.example.infs3634;

import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

/***************************************************************************************
 *    Title: Tutorial How to Play YouTube VIDEO using YouTube Android Player API in Android Studio
 *    Author:android-coffee.com
 *    Date: Uploaded date -> Jun 19, 2016
 *    Code version: No Version Outlined
 *    Availability: https://www.youtube.com/watch?list=PL0Rw2Fh6RZSHWTvADVGYLHfX-PBNAr1um&v=aJ7BoNG-r2c&feature=emb_logo
 *
 ***************************************************************************************/

/*This is the class for the video activity within the resources section, in which showcases a 2 hour
 workout video utilising the Youtube API.*/

public class ResourcesVideo extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    //Our API key and the video ID of the video which is showcased in the activity.
    public static final String API_KEY = "AIzaSyCLWd97ppT1DWTr0aenHPXhLVC188CGbbQ";
    public static final String VIDEO_ID = "DqAsrY3dalw";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources_video);

        //Finding the resource id for youtube player view and initialising it utilising the API key.
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(API_KEY, this);
    }

    //Initialisation for failure.
    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show();
    }

    //Initialisation for success.
    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }
    }

    //The playback event listener for the video for various events such as paused, playing, stopped etc.
    private PlaybackEventListener playbackEventListener = new PlaybackEventListener() {
        @Override
        public void onBuffering(boolean arg0) {
        }

        @Override
        public void onPaused() {
        }

        @Override
        public void onPlaying() {
        }

        @Override
        public void onSeekTo(int arg0) {
        }

        @Override
        public void onStopped() {
        }
    };

    //The PlayerStateChangeListener for the video for state changes such as loading, error, loaded etc.
    private PlayerStateChangeListener playerStateChangeListener = new PlayerStateChangeListener() {
        @Override
        public void onAdStarted() {
        }

        @Override
        public void onError(ErrorReason arg0) {
        }

        @Override
        public void onLoaded(String arg0) {
        }

        @Override
        public void onLoading() {
        }

        @Override
        public void onVideoEnded() {
        }

        @Override
        public void onVideoStarted() {
        }
    };
}