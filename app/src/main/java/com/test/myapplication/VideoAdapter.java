package com.test.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.google.android.exoplayer2.ui.PlayerView;
import com.test.myapplication.data.model.VideoData;
import com.test.myapplication.screen.VideoPlayerActivity;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private Context mContext;
    private List<VideoData> mDataList;

    static class VideoViewHolder extends RecyclerView.ViewHolder {
        PlayerView playerView;
        public ImageView thumbnail;

        public VideoViewHolder(View itemView) {
            super(itemView);

            playerView = itemView.findViewById(R.id.player_view);
            thumbnail = itemView.findViewById(R.id.imageThumbnail);
        }
    }


    public VideoAdapter(List<VideoData> dataList, Context context) {
        mDataList = dataList;
        mContext = context;
    }

    public void setData(List<VideoData> dataList) {
        mDataList = dataList;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_item, parent, false);

        return new VideoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final VideoViewHolder holder, int position) {
        final VideoData data = mDataList.get(position);

        Glide.with(holder.itemView)
                .load(data.thumbnail)
                .apply(new RequestOptions()
                        .centerCrop()
                        .format(DecodeFormat.PREFER_ARGB_8888)
                        .override(Target.SIZE_ORIGINAL))
                .into(holder.thumbnail);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mPlayerIntent = VideoPlayerActivity.getStartIntent(holder.itemView.getContext(), data.url);
                holder.itemView.getContext().startActivity(mPlayerIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
