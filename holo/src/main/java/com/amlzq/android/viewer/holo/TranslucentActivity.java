package com.amlzq.android.viewer.holo;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;

/**
 * 半透明活动
 * 显示对话框
 */
public class TranslucentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translucent);
        // 延时等窗口token可用后再弹出对话框
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showDialog();
            }
        }, 1000);
    }

    private void showDialog() {
        new AlertDialog.Builder(this).setTitle("提醒").setMessage("透明活动的对话框").show();
    }

}
