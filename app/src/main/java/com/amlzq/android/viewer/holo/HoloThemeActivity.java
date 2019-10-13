package com.amlzq.android.viewer.holo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amlzq.android.viewer.R;
import com.amlzq.android.viewer.material.complex.BottomNavigationFragmentActivity;

/**
 * Holo样式
 */
public class HoloThemeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holo_theme);
    }

    public void onBottomNavigationView(View view) {
        startActivity(new Intent(this, BottomNavigationFragmentActivity.class));
    }

}
