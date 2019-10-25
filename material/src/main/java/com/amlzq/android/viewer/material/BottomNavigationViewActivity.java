package com.amlzq.android.viewer.material;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * BottomNavigationView样例
 */
public class BottomNavigationViewActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_view);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        // BadgeDrawable badge = navigation.showBadge(menuItemId);
        navigation.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        String msg = "";
        if (menuItem.getItemId() == R.id.navigation_home) {
            msg = "onNavigationItemSelected navigation_home";
        } else if (menuItem.getItemId() == R.id.navigation_dashboard) {
            msg = "onNavigationItemSelected navigation_dashboard";
        } else if (menuItem.getItemId() == R.id.navigation_notifications) {
            msg = "onNavigationItemSelected navigation_notifications";
        }
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        return false;
    }

}
