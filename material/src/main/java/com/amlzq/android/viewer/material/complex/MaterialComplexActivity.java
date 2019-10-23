package com.amlzq.android.viewer.material.complex;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
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

    public void onBottomNavigation(View view) {
        startActivity(new Intent(this, BottomNavigationFragmentActivity.class));
    }

    public void onTabPager(View view) {
        startActivity(new Intent(this, TabPagerActivity.class));
    }

    public void onCollapsingScrollView(View view) {
        Intent intent = CollapsingScrollViewActivity.newIntent(this,
                "CollapsingScrollViewActivity",
                R.drawable.ippawards_1st_panorama_vincent_chen,
                "");
        startActivity(intent);
    }

    public void onCollapsingRecycleView(View view) {
        startActivity(new Intent(this, CollapsingRecycleViewActivity.class));
    }

    public void onCollapsingTabPager(View view) {
        startActivity(new Intent(this, CollapsingTabPagerActivity.class));
    }

}
