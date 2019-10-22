package com.amlzq.android.viewer.material;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 布局样例
 */
public class LayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_material);
    }

    public void onAppBarLayout(View view) {
        startActivity(new Intent(this, AppBarActivity.class));
    }

    public void onCollapsingToolbarLayout(View view) {
        startActivity(new Intent(this, CollapsingToolbarActivity.class));
    }

}
