package com.amlzq.android.viewer.material.complex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.amlzq.android.viewer.material.R;

/**
 * 材料设计综合使用样例
 */
public class MaterialComplexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design_complex);
    }

    public void onCollapsingScrollView(View view) {
        startActivity(new Intent(this, CollapsingScrollViewActivity.class));
    }

    public void onCollapsingRecycleView(View view) {
        startActivity(new Intent(this, CollapsingRecycleViewActivity.class));
    }

    public void onCollapsingTabPager(View view) {
        startActivity(new Intent(this, CollapsingTabPagerActivity.class));
    }

    public void onTranslucentStatusBar(View view) {
        startActivity(new Intent(this, TranslucentStatusBarActivity.class));
    }

}
