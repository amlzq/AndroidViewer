package com.amlzq.android.viewer.material;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomappbar.BottomAppBar;

/**
 * BottomAppBar样例
 */
public class BottomAppBarActivity extends AppCompatActivity
        implements Toolbar.OnMenuItemClickListener,
        View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_app_bar);

        BottomAppBar bar = (BottomAppBar) findViewById(R.id.bar);
        // 与onCreateOptionsMenu和onOptionsItemSelected联动
        setSupportActionBar(bar);

        BottomAppBar bar2 = (BottomAppBar) findViewById(R.id.bar2);
        // 第二种事件处理方式
        bar2.setOnMenuItemClickListener(this);
        bar2.setNavigationOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        // Handle actions based on the menu item
        String msg = "";
        if (item.getItemId() == R.id.navigation_home) {
            msg = "MenuItemClick navigation_home";
        } else if (item.getItemId() == android.R.id.home) {
            msg = "navigationIcon click";
        }
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        if (item.getItemId() == R.id.navigation_home) {
            msg = "MenuItemClick navigation_home";
        } else if (item.getItemId() == android.R.id.home) {
            msg = "navigationIcon click";
        }
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Toast toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }

}
