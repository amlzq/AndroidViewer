package com.amlzq.android.viewer.platform;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

/**
 * 颜色资源
 */
public class ColorDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_demo);

        int color = 0;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            color = getColor(R.color.black);
        }

        color = ContextCompat.getColor(this, R.color.black);

        color = getResources().getColor(R.color.black);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            color = getResources().getColor(R.color.black, getTheme());
        }

        // 获取颜色资源，方式
        color = Color.parseColor(getString(R.color.black));

    }


}
