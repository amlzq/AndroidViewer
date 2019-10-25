package com.amlzq.android.viewer.material;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.SeekBar;
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
        // 事件处理方式
        bar.setOnMenuItemClickListener(this);
        bar.setNavigationOnClickListener(this);

        BottomAppBar bar2 = (BottomAppBar) findViewById(R.id.bar2);
        // 事件处理方式二
        // 与onCreateOptionsMenu和onOptionsItemSelected联动
        // NoActionBar
        // setSupportActionBar(bar2);

        BottomAppBar bar3 = (BottomAppBar) findViewById(R.id.bar3);

        RadioGroup radioGroup = findViewById(R.id.radios);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio) {
                    bar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
                } else {
                    bar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
                }
            }
        });
        SeekBar seekBar = findViewById(R.id.seek_fab_cradle_margin);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                bar.setFabCradleMargin(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_basic, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        // Handle actions based on the menu item
        String msg = "";
        if (item.getItemId() == R.id.navigation_home) {
            msg = "MenuItemClick navigation_home";
        } else if (item.getItemId() == R.id.navigation_dashboard) {
            msg = "MenuItemClick navigation_dashboard";
        } else if (item.getItemId() == R.id.navigation_notifications) {
            msg = "MenuItemClick navigation_notifications";
        }
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        return true;
    }

    @Override
    public void onClick(View v) {
        Toast toast = Toast.makeText(this, "Click Navigation Icon", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        if (item.getItemId() == R.id.navigation_home) {
            msg = "OptionsItemSelected navigation_home";
        } else if (item.getItemId() == R.id.navigation_dashboard) {
            msg = "OptionsItemSelected navigation_dashboard";
        } else if (item.getItemId() == R.id.navigation_notifications) {
            msg = "OptionsItemSelected navigation_notifications";
        } else if (item.getItemId() == android.R.id.home) {
            msg = "OptionsItemSelected home";
        }
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        return super.onOptionsItemSelected(item);
    }

}
