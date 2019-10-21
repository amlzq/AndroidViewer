package com.amlzq.android.viewer.platform;

import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

public class ScreenDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_demo);

        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;

        // px to dip
        int widthDip = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, width, getResources().getDisplayMetrics());
        int heightDip = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, height, getResources().getDisplayMetrics());

        TextView widthText = findViewById(R.id.width);
        widthText.setText("width: " + width + "px, " + widthDip + "dip");

        TextView heightText = findViewById(R.id.height);
        heightText.setText("height: " + height + "px, " + heightDip + "dip");
    }

}