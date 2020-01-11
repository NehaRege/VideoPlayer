package com.test.myapplication.data;

import android.content.Context;
import android.net.Uri;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class VideoPlayerManager {
    private static VideoPlayerManager mInstance = null;

    private SimpleExoPlayer mPlayer;
    private PlayerView mPlayerView;
    private DefaultDataSourceFactory mDataSourceFactory;
    private CallBacks.playerCallBack mListener;
    private String mUriString = "";

    private VideoPlayerManager(Context mContext) {
        mPlayer = new SimpleExoPlayer.Builder(mContext).build();

        mPlayerView = new PlayerView(mContext);
        mPlayerView.setUseController(true);
        mPlayerView.requestFocus();
        mPlayerView.setPlayer(mPlayer);

        Uri mp4VideoUri = Uri.parse(mUriString);

        mDataSourceFactory = new DefaultDataSourceFactory(
                mContext,
                Util.getUserAgent(mContext, "videoPlayerApp"));

        final MediaSource videoSource = new ProgressiveMediaSource.Factory(mDataSourceFactory)
                .createMediaSource(mp4VideoUri);

        mPlayer.prepare(videoSource);
    }

    public static VideoPlayerManager getSharedInstance(Context mContext) {
        if (mInstance == null) {
            mInstance = new VideoPlayerManager(mContext);
        }
        return mInstance;
    }

    public void setPlayerListener(CallBacks.playerCallBack mPlayerCallBack) {
        mListener = mPlayerCallBack;
    }

    public PlayerView getPlayerView() {
        return mPlayerView;
    }

    public void playStream(String url) {
        mUriString = url;
        Uri mp4VideoUri = Uri.parse(mUriString);
        HlsMediaSource hlsMediaSource = new HlsMediaSource.Factory(mDataSourceFactory)
                .setAllowChunklessPreparation(true)
                .createMediaSource(mp4VideoUri);

        if (mPlayer != null && hlsMediaSource != null) {
            mPlayer.prepare(hlsMediaSource);
            mPlayer.setPlayWhenReady(true);
        }
    }

    public void pauseVideo() {
        if (mPlayer != null) {
            mPlayer.setPlayWhenReady(false);
            mPlayer.getPlaybackState();
        }
    }

    public void resumeVideo() {
        if (mPlayer != null) {
            mPlayer.setPlayWhenReady(true);
            mPlayer.getPlaybackState();
        }
    }

    public interface CallBacks {
        void callbackObserver(Object object);

        interface playerCallBack {
            void onPlayingEnd();
        }
    }
}
