package com.amlzq.android.viewer.guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amlzq.android.viewer.R;
import com.amlzq.android.viewer.templates_v320.TemplatesActivity;
import com.amlzq.android.viewer.widget.thirdparty.ThirdPartyWidgetActivity;

/**
 * 指南索引
 */
public class GuideIndexActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_index);
    }

    public void onThirdPartyWidget(View view) {
        startActivity(new Intent(this, ThirdPartyWidgetActivity.class));
    }

    public void onBottomNavigation(View view) {
        startActivity(new Intent(this, BottomNavigationOverviewActivity.class));
    }

    public void onRefreshLayout(View view) {
        startActivity(new Intent(this, RefreshLayoutOverviewActivity.class));
    }

    public void onDialog(View view) {
        startActivity(new Intent(this, DialogOverviewActivity.class));
    }

    public void onTemplates_v320(View view) {
        startActivity(new Intent(this, TemplatesActivity.class));
    }

}
