package com.amlzq.android.viewer.holo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Holo样式
 */
public class HoloThemeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holo_theme);
    }

    public void onBottomNavigation(View view) {
        startActivity(new Intent(this, BottomTabHostActivity.class));
    }

    public void onTranslucentActivity(View view) {
        startActivity(new Intent(this, TranslucentActivity.class));
    }

}
