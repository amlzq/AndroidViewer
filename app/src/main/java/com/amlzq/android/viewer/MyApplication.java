package com.amlzq.android.viewer;

import android.app.Application;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatDelegate;

/**
 * <ul>
 * <li>{@link MyConfig#IDENTIFY}项目全局惟一Application</li>
 * </ul>
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        MyConfig.configApplication(this);

        // 开启一些源码的日志
        FragmentManager.enableDebugLogging(false);
    }

}
