package com.test.myapplication.data;

import com.test.myapplication.data.model.VideoData;

import java.util.List;

import io.reactivex.Observable;

public interface DataManager {
    Observable<List<VideoData>> getVideoList();
}
