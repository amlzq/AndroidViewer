package com.amlzq.android.viewer.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.amlzq.android.util.SystemUtil;
import com.amlzq.android.viewer.R;
import com.amlzq.android.viewer.guide.PromptOverviewActivity;
import com.amlzq.android.viewer.widget.LayoutDemoActivity;
import com.amlzq.android.viewer.widget.PickerDemoActivity;
import com.amlzq.android.viewer.widget.PopupWindowDemoActivity;
import com.amlzq.android.viewer.widget.ProgressBarDemoActivity;
import com.amlzq.android.viewer.widget.ToastDemoActivity;
import com.amlzq.android.viewer.widget.WidgetDemoActivity;

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

    public void onPromptDemo(View view) {
        startActivity(new Intent(this, PromptOverviewActivity.class));
    }

    public void onBottomNavigation(View view) {
        startActivity(new Intent(this, BottomTabHostActivity.class));
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
