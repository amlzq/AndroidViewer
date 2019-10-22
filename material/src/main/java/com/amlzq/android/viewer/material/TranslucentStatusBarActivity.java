package com.amlzq.android.viewer.material;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.amlzq.android.viewer.material.R;

/**
 * 半透明状态栏
 */
public class TranslucentStatusBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translucent_status_bar);
    }

}
