package com.amlzq.android.viewer.material;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

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
