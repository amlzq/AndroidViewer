package com.amlzq.android.viewer.guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amlzq.android.viewer.R;
import com.amlzq.android.viewer.material.WidgetActivity;

/**
 * Widget小部件样例演示的引导
 */
public class WidgetOverviewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_overview);
    }

    public void onWidget(View view) {
        startActivity(new Intent(this, com.amlzq.android.viewer.platform.WidgetDemoActivity.class));
    }

    public void onV4Widget(View view) {

    }

    public void onV7Widget(View view) {

    }

    public void onMaterialWidget(View view) {
        startActivity(new Intent(this, WidgetActivity.class));
    }

}
