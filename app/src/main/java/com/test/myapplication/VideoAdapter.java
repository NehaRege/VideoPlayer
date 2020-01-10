package com.test.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.myapplication.data.VideoData;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private static String TAG = "VideoAdapter";

    private Context mContext;
    private List<VideoData> mDataList;

    static class VideoViewHolder extends RecyclerView.ViewHolder {
        ImageView imageThumbnail;
        ImageView playButton;

        public VideoViewHolder(View itemView) {
            super(itemView);

            imageThumbnail = itemView.findViewById(R.id.imageThumbnail);
            playButton = itemView.findViewById(R.id.playButton);


        }
    }


    public VideoAdapter(List<VideoData> dataList, Context context) {
        mDataList = dataList;
        mContext = context;
    }


    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItemLayout = inflater.inflate(R.layout.activity_main, parent, false);
        return new VideoViewHolder(listItemLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        VideoData data = mDataList.get(position);

        // set image
        holder.imageThumbnail.setImageResource(R.drawable.ic_launcher_background);

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


}
