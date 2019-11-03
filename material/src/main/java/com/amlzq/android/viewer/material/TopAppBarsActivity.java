package com.amlzq.android.viewer.material;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/**
 * 顶部应用条样例
 */
public class TopAppBarsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_app_bars);

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
