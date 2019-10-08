package com.amlzq.android.viewer.guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amlzq.android.viewer.R;
import com.amlzq.android.viewer.material.SnackbarDemoActivity;
import com.amlzq.android.viewer.widget.ToastDemoActivity;

/**
 * 提示控件演示指南
 * Toast
 * Snackbar
 */
public class PromptOverviewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt_overview);
    }

    public void onToast(View view) {
        startActivity(new Intent(this, ToastDemoActivity.class));
    }

    public void onSnackBar(View view) {
        startActivity(new Intent(this, SnackbarDemoActivity.class));
    }

}
