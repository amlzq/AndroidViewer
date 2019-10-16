package com.amlzq.android.viewer.guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amlzq.android.viewer.R;
import com.amlzq.android.viewer.platform.DialogDemoActivity;

/**
 * 对话框的演示样例引导
 */
public class DialogOverviewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_overview);
    }

    /**
     * android.app.AlertDialog
     *
     * @param view
     */
    public void onAppAlertDialog(View view) {
        startActivity(new Intent(this, DialogDemoActivity.class));
    }

    /**
     * Material Dialog
     *
     * @param view
     */
    public void onMaterialAlertDialog(View view) {
        startActivity(new Intent(this, com.amlzq.android.viewer.material.DialogDemoActivity.class));
    }

}
