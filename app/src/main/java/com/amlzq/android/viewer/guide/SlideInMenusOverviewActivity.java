package com.amlzq.android.viewer.guide;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.amlzq.android.viewer.R;

/**
 * 滑入式菜单布局的概述
 * https://github.com/jfeinstein10/SlidingMenu
 * https://github.com/mikepenz/MaterialDrawer
 * https://developer.android.com/reference/android/support/v4/widget/DrawerLayout
 */
public class SlideInMenusOverviewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_in_menus_overview);
    }

    public void onDrawerLayout(View view) {

    }

}
