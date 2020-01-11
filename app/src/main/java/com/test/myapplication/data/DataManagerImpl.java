package com.test.myapplication.data;

import com.test.myapplication.api.ApiClient;
import com.test.myapplication.api.ApiService;
import com.test.myapplication.data.model.VideoData;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DataManagerImpl implements DataManager {
    @Override
    public Observable<List<VideoData>> getVideoList() {
        return ApiClient.getRetrofit()
                .create(ApiService.class)
                .getVideoList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
