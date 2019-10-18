package com.amlzq.android.viewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.amlzq.android.viewer.droidux.DroidUXActivity;
import com.amlzq.android.viewer.expand.ThirdPartyWidgetActivity;
import com.amlzq.android.viewer.guide.GuideActivity;
import com.amlzq.android.viewer.holo.HoloThemeActivity;
import com.amlzq.android.viewer.material.MaterialDesignActivity;
import com.amlzq.android.viewer.platform.TargetAPIStyleActivity;
import com.amlzq.android.viewer.qmui.QMUIGuideActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 用来计算返回键的点击间隔时间
    private long mExitClickTime = 0;

    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - mExitClickTime) > 2000) {
            // 弹出提示，可以有多种方式
            Toast.makeText(this, "再次点击退出应用", Toast.LENGTH_SHORT).show();
            mExitClickTime = System.currentTimeMillis();
        } else {
            super.onBackPressed(); // finish this activity
            // No need to kill the application process
        }
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
    }

    public void onGuideIndex(View view) {
        startActivity(new Intent(this, GuideActivity.class));
    }

    public void onTargetAPI(View view) {
        startActivity(new Intent(this, TargetAPIStyleActivity.class));
    }

    public void onMaterialDesign(View view) {
        startActivity(new Intent(this, MaterialDesignActivity.class));
    }

    public void onHolo(View view) {
        startActivity(new Intent(this, HoloThemeActivity.class));
    }

    public void onQMUI(View view) {
        startActivity(new Intent(this, QMUIGuideActivity.class));
    }

    public void onIOS(View view) {
    }

    public void onDroidUX(View view) {
        startActivity(new Intent(this, DroidUXActivity.class));
    }

    public void onThirdPartyWidget(View view) {
        startActivity(new Intent(this, ThirdPartyWidgetActivity.class));
    }

}
