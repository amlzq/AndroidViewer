package com.amlzq.android.viewer.expand.smartrefresh;

import android.app.Activity;
import android.os.Bundle;

import com.amlzq.android.viewer.expand.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/**
 * SmartRefreshLayout demo
 */
public class SmartRefreshActivity extends Activity {

    SmartRefreshLayout mSmartRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_refresh);
        mSmartRefreshLayout = findViewById(R.id.refreshLayout);

    }

}
