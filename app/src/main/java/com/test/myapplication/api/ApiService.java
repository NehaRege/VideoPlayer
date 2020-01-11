package com.test.myapplication.api;

import com.test.myapplication.data.model.VideoData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/videos.json")
    Observable<List<VideoData>> getVideoList();
}
