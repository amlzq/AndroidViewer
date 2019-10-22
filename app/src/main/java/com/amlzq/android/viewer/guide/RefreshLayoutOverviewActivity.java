package com.amlzq.android.viewer.guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amlzq.android.viewer.R;
import com.amlzq.android.viewer.expand.SmartRefreshActivity;
import com.amlzq.android.viewer.material.SwipeRefreshActivity;

/**
 * 下拉刷新的演示样例引导
 */
public class RefreshLayoutOverviewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_layout_overview);
    }

    public void onSwipeRefreshLayout(View view) {
        startActivity(new Intent(this, SwipeRefreshActivity.class));
    }

    public void onSmartRefreshLayout(View view) {
        startActivity(new Intent(this, SmartRefreshActivity.class));
    }

}
