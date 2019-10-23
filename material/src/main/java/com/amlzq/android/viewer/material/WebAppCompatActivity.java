package com.amlzq.android.viewer.material;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 网页
 */
public class WebAppCompatActivity extends AppCompatActivity {
    public static final String TAG = "WebAppCompatActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_app_compat);
    }

}
