package com.test.myapplication.screen;

import com.test.myapplication.data.model.VideoData;

import java.util.List;

public interface MainView {
    void showVideoList(List<VideoData> list);

    void hideVideoList();

    void isLoading(boolean isLoading);

    void showErrorView();

    void hideErrorView();

}
