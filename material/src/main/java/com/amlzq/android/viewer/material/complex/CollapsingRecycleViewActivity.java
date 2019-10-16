package com.amlzq.android.viewer.material.complex;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.amlzq.android.app.BaseAppCompatActivity;
import com.amlzq.android.viewer.material.ContentAdapter;
import com.amlzq.android.viewer.material.R;

/**
 * AppBarLayout
 * CollapsingToolbarLayout
 * Toolbar
 * RecyclerView
 * FloatingActionButton
 */

public class CollapsingRecycleViewActivity extends BaseAppCompatActivity {

    protected SwipeRefreshLayout mSwipeRefresh;
    protected int mNextRequestPage = 1;
    protected RecyclerView mRecyclerView;

    ContentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_recycleview);

        mSwipeRefresh = findViewById(R.id.swipe_refresh);

        // 解决CollapsingToolbarLayout和RecyclerView嵌套滚动问题
//        mRecyclerView.setNestedScrollingEnabled(true);
//        mAdapter.notifyDataSetChanged();

        // 设置进度条的颜色主题，最多能设置四种，加载颜色是循环播放的，只要没有完成刷新就会一直循环，holo_blue_bright>holo_green_light>holo_orange_light>holo_red_light
        mSwipeRefresh.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.YELLOW, Color.RED);
        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        mSwipeRefresh.setDistanceToTriggerSync(300);
        // 设定下拉圆圈的背景
        mSwipeRefresh.setProgressBackgroundColorSchemeColor(Color.WHITE);
        // 设置圆圈的大小
        mSwipeRefresh.setSize(SwipeRefreshLayout.LARGE);

    }

    @Override
    public void onFragmentInteraction(Bundle bundle) {

    }

    @Override
    public void onClick(View v) {

    }

}
