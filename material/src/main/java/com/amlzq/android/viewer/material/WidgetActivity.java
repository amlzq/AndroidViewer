package com.amlzq.android.viewer.material;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 材料库的小部件
 * // Toolbar和Menu
 * // 基于CoordinatorLayout的联动
 * // NavigationView
 * // CardView
 * // TextInputLayout
 * // RecyclerView
 * // TabLayout
 * // SnackBar
 * // FloatingActionButton
 * // https://www.jianshu.com/p/776cc6329fff
 */
public class WidgetActivity extends AppCompatActivity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_material);
    }

    @Override
    public void onClick(View v) {

    }

}
