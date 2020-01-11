package com.test.myapplication.screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.test.myapplication.R;
import com.test.myapplication.VideoAdapter;
import com.test.myapplication.data.model.VideoData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    @BindView(R.id.mainToolbar)
    Toolbar toolbar;
    @BindView(R.id.errorView)
    CardView errorView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private VideoAdapter mVideoAdapter;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setUpMVP();
        setToolbar();

        setLayoutManager();

        initVideoAdapter();
    }

    private void initVideoAdapter() {
        mVideoAdapter = new VideoAdapter(new ArrayList<VideoData>(), this);
        recyclerView.setAdapter(mVideoAdapter);
    }

    private void setLayoutManager() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setToolbar() {
        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorWhite));
        setSupportActionBar(toolbar);
    }

    @Override
    public void showVideoList(List<VideoData> videoDataList) {
        recyclerView.setVisibility(View.VISIBLE);
        mVideoAdapter.setData(videoDataList);
        mVideoAdapter.notifyDataSetChanged();
    }

    @Override
    public void hideVideoList() {
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void isLoading(boolean isLoading) {
        if (isLoading) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showErrorView() {
        errorView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorView() {
        errorView.setVisibility(View.INVISIBLE);
    }

    private void setUpMVP() {
        mMainPresenter = new MainPresenterImpl(this);
    }

    @OnClick(R.id.errorView)
    void onErrorViewCardClick() {
        mMainPresenter.onErrorViewClick();
    }
}
