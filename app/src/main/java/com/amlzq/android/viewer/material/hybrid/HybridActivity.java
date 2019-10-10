package com.amlzq.android.viewer.material.hybrid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.amlzq.android.viewer.R;

/**
 * 混合使用样例
 */
public class HybridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hybrid);
    }

    public void onCollapsingToolbarRecycleView(View view) {
        startActivity(new Intent(this, CollapsingToolbarRecycleViewActivity.class));
    }

    public void onAppBarTabViewPager(View view) {
        startActivity(new Intent(this, AppBarTabViewPagerActivity.class));
    }

}
