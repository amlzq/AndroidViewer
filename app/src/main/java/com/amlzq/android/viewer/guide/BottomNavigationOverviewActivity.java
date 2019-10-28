package com.amlzq.android.viewer.guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amlzq.android.viewer.R;
import com.amlzq.android.viewer.holo.BottomTabHostActivity;
import com.amlzq.android.viewer.material.BottomRadioButtonFragmentActivity;
import com.amlzq.android.viewer.material.complex.BottomNavigationFragmentActivity;
import com.amlzq.android.viewer.material.complex.BottomTabFragmentActivity;

/**
 * 底部导航栏的引导
 * <br>
 * 5 种实现</>
 */
public class BottomNavigationOverviewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_overview);
    }

    public void onTabHost(View view) {
        startActivity(new Intent(this, BottomTabHostActivity.class));
    }

    public void onBottomNavigationView(View view) {
        startActivity(new Intent(this, BottomNavigationFragmentActivity.class));
    }

    public void onRadioGroup(View view) {
        startActivity(new Intent(this, BottomRadioButtonFragmentActivity.class));
    }

    public void onTabLayout(View view) {
        startActivity(new Intent(this, BottomTabFragmentActivity.class));
    }

}