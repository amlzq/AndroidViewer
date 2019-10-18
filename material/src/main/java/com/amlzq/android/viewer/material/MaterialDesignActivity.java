package com.amlzq.android.viewer.material;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.amlzq.android.viewer.material.complex.BottomNavigationFragmentActivity;
import com.amlzq.android.viewer.material.complex.MaterialComplexActivity;
import com.amlzq.android.viewer.material.complex.TabPagerActivity;
import com.amlzq.android.viewer.material.templates.TemplatesActivity;
import com.amlzq.android.viewer.material.templates.activities.NavigationDrawerActivity;
import com.amlzq.android.viewer.material.templates.activities.ScrollingActivity;

/**
 * material design style guide
 * 材料设计风格的指南
 * https://blog.csdn.net/kong_gu_you_lan/article/details/80755159
 */

public class MaterialDesignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);

        TextView textView = findViewById(R.id.tv_message);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    public void onLayoutDemo(View view) {
        startActivity(new Intent(this, LayoutDemoActivity.class));
    }

    public void onDesignWidget(View view) {
        startActivity(new Intent(this, WidgetDemoActivity.class));
    }

    public void onSnackbar(View view) {
        startActivity(new Intent(this, SnackbarDemoActivity.class));
    }

    public void onRecycleView(View view) {
        startActivity(new Intent(this, RecycleViewDemoActivity.class));
    }

    public void onScrollingActivity(View view) {
        startActivity(new Intent(this, ScrollingActivity.class));
    }

    public void onBottomNavigation(View view) {
        startActivity(new Intent(this, BottomNavigationFragmentActivity.class));
    }

    public void onDrawerNavigation(View view) {
        startActivity(new Intent(this, NavigationDrawerActivity.class));
    }

    public void onTabLayout(View view) {
        startActivity(new Intent(this, TabPagerActivity.class));
    }

    public void onDayNight(View view) {

    }

    public void onComplex(View view) {
        startActivity(new Intent(this, MaterialComplexActivity.class));
    }

    public void onTemplates(View view) {
        startActivity(new Intent(this, TemplatesActivity.class));
    }

}
