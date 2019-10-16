package com.amlzq.android.viewer.platform;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.amlzq.android.util.SystemUtil;

/**
 * 目标API样式
 * 在不同的API Level中查看演变过程
 */
public class TargetAPIStyleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_api_style);

        StringBuffer buffer = new StringBuffer();
        buffer.append("Platform Name: " + Build.PRODUCT + "\n");
        buffer.append("API Level: " + SystemUtil.getVersion() + "\n");
        buffer.append("Language: " + SystemUtil.getLanguage() + "\n");
        TextView message = findViewById(R.id.tv_message);
        message.setText(buffer.toString());
    }

    public void onLayoutDemo(View view) {
        startActivity(new Intent(this, LayoutDemoActivity.class));
    }

    public void onWidgetDemo(View view) {
        startActivity(new Intent(this, WidgetDemoActivity.class));
    }

    public void onDialogDemo(View view) {
        startActivity(new Intent(this, DialogDemoActivity.class));
    }

    public void onProgressBar(View view) {
        startActivity(new Intent(this, ProgressBarDemoActivity.class));
    }

    public void onToast(View view) {
        startActivity(new Intent(this, ToastDemoActivity.class));
    }

    public void onPicker(View view) {
        startActivity(new Intent(this, PickerDemoActivity.class));
    }

    public void onPopupWindow(View view) {
        startActivity(new Intent(this, PopupWindowDemoActivity.class));
    }

    public void onMenu(View view) {
        startActivity(new Intent(this, MenuDemoActivity.class));
    }

}
