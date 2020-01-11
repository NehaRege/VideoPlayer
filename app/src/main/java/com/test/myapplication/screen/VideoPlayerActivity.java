package com.test.myapplication.screen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.ui.PlayerView;
import com.test.myapplication.R;
import com.test.myapplication.data.VideoPlayerManager;
import com.test.myapplication.utils.Constants;

public class VideoPlayerActivity extends AppCompatActivity implements VideoPlayerManager.CallBacks.playerCallBack {

    private String mUrlString;

    public static Intent getStartIntent(Context context, String url) {
        Intent intent = new Intent(context, VideoPlayerActivity.class);
        intent.putExtra(Constants.VIDEO_URL, url);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        if (getIntent().hasExtra(Constants.VIDEO_URL)) {
            mUrlString = getIntent().getStringExtra(Constants.VIDEO_URL);
        }
        PlayerView mPlayerView = findViewById(R.id.player_view);
        mPlayerView.setPlayer(VideoPlayerManager.getSharedInstance(this).getPlayerView().getPlayer());
        VideoPlayerManager.getSharedInstance(this).playStream(mUrlString);
        VideoPlayerManager.getSharedInstance(this).setPlayerListener(this);
    }

    @Override
    public void onPlayingEnd() {
        VideoPlayerManager.getSharedInstance(this).pauseVideo();
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        VideoPlayerManager.getSharedInstance(this).pauseVideo();
    }

    @Override
    protected void onResume() {
        super.onResume();
        VideoPlayerManager.getSharedInstance(this).resumeVideo();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VideoPlayerManager.getSharedInstance(this).pauseVideo();
    }
}
