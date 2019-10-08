package com.amlzq.android.viewer;

import android.app.Application;

import com.amlzq.android.ApplicationConfig;
import com.amlzq.android.log.Log;
import com.amlzq.android.log.LogWrapper;
import com.amlzq.android.util.UtilConfig;

/**
 * 配置
 */
public class MyConfig extends ApplicationConfig {

    /**
     * 应用程序标识
     */
    public static String IDENTIFY = "AndroidViewer";
    /**
     * 调试开关
     */
    public static boolean DEBUG = false;

    public static void configApplication(Application application) {
        // 项目标识
        ApplicationConfig.IDENTIFY = IDENTIFY;
        // 调试开关
        ApplicationConfig.DEBUG = BuildConfig.DEBUG;
        // SharedPreferences File Name
        ApplicationConfig.SHARED_PREFERENCES_NAME = IDENTIFY + "Prefs";

        // 初始化工具库
        UtilConfig.DEBUG = DEBUG;
        UtilConfig.init(application, IDENTIFY);

        // 初始化日志库
        Log.TAG = IDENTIFY;
        Log.LEVEL = Log.VERBOSE;
        LogWrapper logWrapper = new LogWrapper();
        Log.setLogNode(logWrapper);
    }

}