package com.amlzq.android.viewer.material;

import android.os.Bundle;

import com.amlzq.android.viewer.MyBaseAppCompatActivity;
import com.amlzq.android.viewer.material.R;

/**
 * 网页
 */
public class WebAppCompatActivity extends MyBaseAppCompatActivity {
    public static final String TAG = "WebAppCompatActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_app_compat);
    }

    @Override
    public void onFragmentInteraction(Bundle bundle) {

    }

}
