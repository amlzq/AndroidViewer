package com.amlzq.android.viewer.material;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 状态栏
 */
public class StatusBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusbar);
    }

    public void onTranslucentStatusBar(View view) {
        startActivity(new Intent(this, TranslucentStatusBarActivity.class));
    }

}
