package com.test.myapplication.screen;

import com.test.myapplication.data.DataManager;
import com.test.myapplication.data.DataManagerImpl;
import com.test.myapplication.data.model.VideoData;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainPresenterImpl implements MainPresenter {

    private Observable<List<VideoData>> mObservable;
    private MainView mMainView;
    private DataManager mDataManager;

    public MainPresenterImpl(MainView mainView) {
        mMainView = mainView;
        mDataManager = new DataManagerImpl();

        getVideoList();
    }

    @Override
    public void getVideoList() {
        mObservable = mDataManager.getVideoList();

        mObservable.subscribe(new Observer<List<VideoData>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(List<VideoData> videoDataList) {
                mMainView.hideErrorView();
                mMainView.isLoading(false);

                mMainView.showVideoList(videoDataList);
            }

            @Override
            public void onError(Throwable e) {
                mMainView.isLoading(false);
                mMainView.hideVideoList();
                mMainView.showErrorView();
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
            }
        });

    }

    @Override
    public void onErrorViewClick() {
        mMainView.hideErrorView();
        mMainView.isLoading(true);
        getVideoList();
    }
}
