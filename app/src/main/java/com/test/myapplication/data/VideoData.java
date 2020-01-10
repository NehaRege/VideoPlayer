package com.test.myapplication.data;

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
}
