package com.amlzq.android.viewer.holo;

import android.app.Activity;
import android.os.Bundle;

/**
 * ActionBar样例
 */
public class ActionBarDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar_demo);
        getActionBar();
    }
}
