package com.amlzq.android.viewer.material.templates;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.amlzq.android.viewer.material.R;
import com.amlzq.android.viewer.material.templates.activities.BasicActivity;
import com.amlzq.android.viewer.material.templates.activities.BottomNavigationActivity;
import com.amlzq.android.viewer.material.templates.activities.EmptyActivity;
import com.amlzq.android.viewer.material.templates.activities.FullscreenActivity;
import com.amlzq.android.viewer.material.templates.activities.LoginActivity;
import com.amlzq.android.viewer.material.templates.activities.MapsActivity;
import com.amlzq.android.viewer.material.templates.activities.NavigationDrawerActivity;
import com.amlzq.android.viewer.material.templates.activities.ScrollingActivity;
import com.amlzq.android.viewer.material.templates.activities.SettingsActivity;
import com.amlzq.android.viewer.material.templates.activities.TabbedActivity;
import com.amlzq.android.viewer.material.templates.activities.ViewModelActivity;

public class TemplatesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_templates);
    }

    public void onBasicActivity(View view) {
        startActivity(new Intent(this, BasicActivity.class));
    }

    public void onEmptyActivity(View view) {
        startActivity(new Intent(this, EmptyActivity.class));
    }

    public void onFullscreenActivity(View view) {
        startActivity(new Intent(this, FullscreenActivity.class));
    }

    public void onLoginActivity(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void onNavigationDrawerActivity(View view) {
        startActivity(new Intent(this, NavigationDrawerActivity.class));
    }

    public void onScrollActivity(View view) {
        startActivity(new Intent(this, ScrollingActivity.class));
    }

    public void onSettingsActivity(View view) {
        startActivity(new Intent(this, SettingsActivity.class));
    }

    public void onTabbedActivity(View view) {
        startActivity(new Intent(this, TabbedActivity.class));
    }

    public void onViewModelActivity(View view) {
        startActivity(new Intent(this, ViewModelActivity.class));
    }

    public void onBottomNavigationActivity(View view) {
        startActivity(new Intent(this, BottomNavigationActivity.class));
    }

    public void onBlankWearActivity(View view) {
    }

    public void onGoogleMapsActivity(View view) {
        startActivity(new Intent(this, MapsActivity.class));
    }

}
