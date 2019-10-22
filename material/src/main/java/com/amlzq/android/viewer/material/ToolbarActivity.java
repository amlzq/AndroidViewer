package com.amlzq.android.viewer.material;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Toolbar样例
 */
public class ToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("标题");
        toolbar.setSubtitle("副标题");
        // 设置左边按钮图片
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        // 设置标题与左边按钮之间图标
        toolbar.setLogo(android.R.drawable.sym_def_app_icon);

    }

}
