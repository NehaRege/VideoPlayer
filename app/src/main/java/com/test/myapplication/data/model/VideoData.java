package com.test.myapplication.data.model;

import com.google.gson.annotations.SerializedName;

public class VideoData {
    @SerializedName("url")
    public String url;
    @SerializedName("duration")
    public Integer duration;
    @SerializedName("title")
    public String title;
    @SerializedName("description")
    public String description;
    @SerializedName("thumbnail")
    public String thumbnail;

    public VideoData(String url, Integer duration, String title, String description, String thumbnail) {
        this.url = url;
        this.duration = duration;
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
    }
}
