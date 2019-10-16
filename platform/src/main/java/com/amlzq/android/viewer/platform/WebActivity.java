package com.amlzq.android.viewer.platform;

import android.app.Activity;
import android.os.Bundle;

/**
 * 网页活动
 * 服务协议，隐私政策，关于我们，常见问题
 */
public class WebActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
    }


}
