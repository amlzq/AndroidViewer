package com.amlzq.android.viewer.widget.thirdparty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.amlzq.android.viewer.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/**
 * SmartRefreshLayout demo
 */
public class SmartRefreshActivity extends AppCompatActivity {

    SmartRefreshLayout mSmartRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_refresh);
        mSmartRefreshLayout = findViewById(R.id.refreshLayout);
        
    }

}
