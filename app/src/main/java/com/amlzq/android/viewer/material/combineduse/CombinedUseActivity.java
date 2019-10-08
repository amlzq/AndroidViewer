package com.amlzq.android.viewer.material.combineduse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.amlzq.android.viewer.R;

/**
 * 组合使用样例
 */
public class CombinedUseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combined_use);
    }

    public void onCollapsingToolbarRecycleView(View view) {
        startActivity(new Intent(this, CollapsingToolbarRecycleViewActivity.class));
    }

    public void onAppBarTabViewPager(View view) {
        startActivity(new Intent(this, AppBarTabViewPagerActivity.class));
    }

}
